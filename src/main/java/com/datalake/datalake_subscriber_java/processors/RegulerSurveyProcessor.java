package com.datalake.datalake_subscriber_java.processors;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.google.gson.Gson;
import com.datalake.datalake_subscriber_java.entities.DatalakeEntity;
import com.datalake.datalake_subscriber_java.repositories.DatalakeRepository;

@Component("REGULER_SURVEY")
public class RegulerSurveyProcessor implements TopicProcessor {

    @Autowired
    private DatalakeRepository datalakeRepository;

    @Override
    public void process(String message) {
        Map<String, Object> gsonMessage = parseMessage(message);

        String orderId = getStringValue(gsonMessage, "order_id");

        if(orderId != null && !datalakeRepository.existsByOrderId(orderId)){
            DatalakeEntity datalakeEntity = new DatalakeEntity();
            datalakeEntity.setOrder_id(orderId);

            data

        }
        

    
    }

    private Map<String, Object> parseMessage(String message) {
        Gson gson = new Gson();
        return gson.fromJson(message, Map.class);
    }

    private String getStringValue(Map<String, Object> map, String key) {
        return map.get(key) != null ? map.get(key).toString() : "";
    }

}
