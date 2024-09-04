package com.datalake.datalake_subscriber_java.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
public class KafkaTopicCustomer {

    @Autowired
    private DatalakeService datalakeService;

    @KafkaListener(topics = {
            "${spring.kafka.topic.test-datalake}",
            "${spring.kafka.topic.test-preppd}",
            "${spring.kafka.topic.test-regsur}",
            "${spring.kafka.topic.test-verdat}" }, groupId = "${spring.kafka.consumer.group-id}")
    public void listenToTopics(String message, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        datalakeService.processMessage(topic, message);
    }

}
