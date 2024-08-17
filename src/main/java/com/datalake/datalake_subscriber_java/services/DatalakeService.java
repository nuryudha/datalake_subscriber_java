package com.datalake.datalake_subscriber_java.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datalake.datalake_subscriber_java.entities.DatalakeEntity;
import com.datalake.datalake_subscriber_java.processors.TopicProcessor;
import com.datalake.datalake_subscriber_java.repositories.DatalakeRepository;

@Service
public class DatalakeService {

    @Autowired
    private Map<String, TopicProcessor> interfaceTopicProcessors;

    @Autowired
    private DatalakeRepository datalakeRepository;

    @Autowired
    public DatalakeService(Map<String, TopicProcessor> topicProcessors) {
        this.interfaceTopicProcessors = topicProcessors;
    }

    public void processMessage(String topic, String message) {
        TopicProcessor processorMessage = interfaceTopicProcessors.get(topic);
        if (processorMessage != null) {
            processorMessage.process(message);
        } else {
            System.out.println("No processor found for topic: " + topic);
        }
    }

    public DatalakeEntity findByOrder_id(String order_id) {
        return datalakeRepository.findByOrder_id(order_id);
    }

}
