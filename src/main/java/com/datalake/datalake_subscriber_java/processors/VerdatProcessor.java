package com.datalake.datalake_subscriber_java.processors;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.datalake.datalake_subscriber_java.entities.DatalakeEntity;
import com.datalake.datalake_subscriber_java.repositories.DatalakeRepository;
import com.datalake.datalake_subscriber_java.services.binding.VerdatBinder;
import com.datalake.datalake_subscriber_java.services.mapper.VerdatMapper;
import com.datalake.datalake_subscriber_java.utilities.JsonUtility;

@Component("test-verdat")
public class VerdatProcessor implements TopicProcessor {

    @Autowired
    private static Logger logger = LoggerFactory.getLogger(VerdatProcessor.class);

    @Autowired
    private DatalakeRepository datalakeRepository;

    @Autowired
    private JsonUtility jsonUtility;

    @Autowired
    private VerdatMapper verdatMapper;

    @Autowired
    private VerdatBinder verdatBinder;

    private static final String currentForm = "VERDAT";
    private static final String topic = "test-verdat";

    @Override
    // @Transactional
    public void process(String message) {
        Map<String, Object> messageData = jsonUtility.parseMessage(message);
        String order_id = verdatMapper.getOrderId(messageData);
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
        if (entity == null) {
            entity = new DatalakeEntity();
            entity.setOrder_id(order_id);
            logger.info("Created: Order ID = {}, Topic = {} , Current Form = {}", order_id, topic, currentForm);
        } else {
            logger.info("Updated: Order ID = {}, Topic = {} , Current Form = {}", order_id, topic, currentForm);
        }

        verdatBinder.updateEntityFromMessage(entity, messageData);
        return entity;
    }

    private void saveEntity(DatalakeEntity entity) {
        datalakeRepository.save(entity);
        logger.info("Saved: Order ID = {}, Topic = {}, Current Form = {}", entity.getOrder_id(), topic, currentForm);
    }

}
