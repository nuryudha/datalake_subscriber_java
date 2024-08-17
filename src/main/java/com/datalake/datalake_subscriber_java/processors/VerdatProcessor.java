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

@Component("test-datalake")
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
        String currentForm = "VERDAT";
        if (entity == null) {
            entity = new DatalakeEntity();
            entity.setOrder_id(order_id);
            logger.info("Entity created: Order ID = {}, Current Form = {}", order_id, currentForm);
        } else {
            logger.info("Entity found for update: Order ID = {}, Current Form = {}", order_id, currentForm);
        }

        verdatBinder.updateEntityFromMessage(entity, messageData);
        return entity;
    }

    private void saveEntity(DatalakeEntity entity) {
        String currentFormDesc = "VERDAT";
        datalakeRepository.save(entity);
        logger.info("Entity saved: Order ID = {}, Current Form = {}", entity.getOrder_id(), currentFormDesc);
    }

}
