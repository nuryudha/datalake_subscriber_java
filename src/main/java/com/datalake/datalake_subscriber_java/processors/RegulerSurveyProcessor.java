package com.datalake.datalake_subscriber_java.processors;

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.datalake.datalake_subscriber_java.entities.DatalakeEntity;
import com.datalake.datalake_subscriber_java.repositories.DatalakeRepository;
import com.datalake.datalake_subscriber_java.services.binding.RegulerSurveyBinder;
import com.datalake.datalake_subscriber_java.services.mapper.RegulerSurveyMapper;
import com.datalake.datalake_subscriber_java.utilities.JsonUtility;

@Component("test-regsur")
public class RegulerSurveyProcessor implements TopicProcessor {

    @Autowired
    private static Logger logger = LoggerFactory.getLogger(VerdatProcessor.class);

    @Autowired
    private DatalakeRepository datalakeRepository;

    @Autowired
    private JsonUtility jsonUtility;

    @Autowired
    private RegulerSurveyMapper regulerSurveyMapper;

    @Autowired
    private RegulerSurveyBinder regulerSurveyBinder;

    private static final String currentForm = "REGULER SURVEY";
    private static final String topic = "test-regsur";

    @Override
    // @Transactional
    public void process(String message) {
        Map<String, Object> messageData = jsonUtility.parseMessage(message);
        String order_id = regulerSurveyMapper.getOrderId(messageData);
        if (order_id == null || order_id.isEmpty()) {
            logger.warn("Order ID is null or empty.");
            return;
        }
        DatalakeEntity entity = createOrUpdateEntity(messageData, order_id);
        saveEntity(entity);
        ;

    }

    private DatalakeEntity createOrUpdateEntity(Map<String, Object> messageData, String order_id) {
        DatalakeEntity entity = datalakeRepository.findByOrder_id(order_id);
        Date now = new Date();
        if (entity == null) {
            entity = new DatalakeEntity();
            entity.setOrder_id(order_id);
            entity.setInsert_date(now);
            logger.info("Created: Order ID = {}, Topic = {} , Current Form = {}", order_id, topic, currentForm);
        } else {
            entity.setUpdate_date(now);
            logger.info("Updated: Order ID = {}, Topic = {} , Current Form = {}", order_id, topic, currentForm);
        }

        regulerSurveyBinder.updateEntityFromMessage(entity, messageData);
        return entity;
    }

    private void saveEntity(DatalakeEntity entity) {
        datalakeRepository.save(entity);
        logger.info("Saved: Order ID = {}, Topic = {}, Current Form = {}", entity.getOrder_id(), topic, currentForm);
    }

}
