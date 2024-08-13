package com.datalake.datalake_subscriber_java.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import com.datalake.datalake_subscriber_java.repositories.DatalakeRepository;

@Service
public class ConsumerRegulerSurvey {

    @Autowired
    DatalakeRepository datalakeRepository;

    @Value("${spring.kafka.topic.test-datalake}")
    private String topicName;

    @Value("${spring.kafka.consumer.group-id}")
    private String groupIdName;

    @KafkaListener(topics = "#{@topicName}", groupId = "#{@groupIdName}")
    public void listen(String message, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {

    }

}
