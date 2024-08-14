package com.datalake.datalake_subscriber_java.processors;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.google.gson.Gson;
import com.datalake.datalake_subscriber_java.entities.DatalakeEntity;
import com.datalake.datalake_subscriber_java.repositories.DatalakeRepository;

@Component("test-datalake")
public class RegulerSurveyProcessor implements TopicProcessor {

    @Autowired
    private DatalakeRepository datalakeRepository;

    @Override
    @Transactional
    public void process(String message) {
        System.out.println("INI MESSAGENYA =  " + message);
        Map<String, Object> gsonMessage = parseMessage(message);
        System.out.println("INI MESSAGE yang sudah di parse =  " + gsonMessage);

        // Mengambil data dari JSON
        String order_id = getOrderId(gsonMessage);
        String debitur_area_branch_desc = getDebiturAreaBranchDesc(gsonMessage);
        Long jumlah_debitur = getJumlahDebitur(gsonMessage);
        String external_sales_no = getExternalSalesNo(gsonMessage);
        String internal_sales_head_name = getInternalSalesHeadName(gsonMessage);

        if (order_id != null && !order_id.isEmpty()) {
            boolean exists = datalakeRepository.existsByOrder_id(order_id);

            if (!exists) {

                // Membungkus dalam datalake entity / tabelnya
                DatalakeEntity datalakeEntity = new DatalakeEntity();
                datalakeEntity.setOrder_id(order_id);
                datalakeEntity.setDebitur_area_branch_desc(debitur_area_branch_desc);
                datalakeEntity.setJumlah_debitur(jumlah_debitur);
                datalakeEntity.setExternal_sales_no(external_sales_no);
                datalakeEntity.setInternal_sales_head_name(internal_sales_head_name);

                datalakeRepository.save(datalakeEntity);

                System.out.println("Entity saved: " + datalakeEntity);
            } else {
                System.out.println("Order ID already exists: " + order_id);
            }
        } else {
            System.out.println("Order ID is null or empty.");
        }

    }

    private String getOrderId(Map<String, Object> map) {
        Map<String, Object> message = getNestedMap(map, "Message");

        return getStringValue(message, "order_id");
    }

    private String getDebiturAreaBranchDesc(Map<String, Object> map) {
        Map<String, Object> message = getNestedMap(map, "Message");
        Map<String, Object> detail = getNestedMap(message, "detail");
        Map<String, Object> debitur = getNestedMap(detail, "debitur");
        Map<String, Object> personal = getNestedMap(debitur, "personal");

        return getStringValue(personal, "debitur_area_branch_desc");
    }

    private Long getJumlahDebitur(Map<String, Object> map) {
        Map<String, Object> message = getNestedMap(map, "Message");
        Map<String, Object> detail = getNestedMap(message, "detail");
        Map<String, Object> debitur = getNestedMap(detail, "debitur");

        return getLongValue(debitur, "jumlah_debitur");
    }

    @SuppressWarnings("unchecked")
    private String getExternalSalesNo(Map<String, Object> map) {
        Map<String, Object> message = getNestedMap(map, "Message");
        Map<String, Object> detail = getNestedMap(message, "detail");
        Map<String, Object> debitur = getNestedMap(detail, "debitur");
        List<Map<String, Object>> externalSalesForce = (List<Map<String, Object>>) debitur.get("external_sales_force");

        if (externalSalesForce != null && !externalSalesForce.isEmpty()) {
            Map<String, Object> firstExternalSales = externalSalesForce.get(0);

            return getStringValue(firstExternalSales, "external_sales_no");
        }

        return "";

    }

    @SuppressWarnings("unchecked")
    private String getInternalSalesHeadName(Map<String, Object> map) {
        Map<String, Object> message = getNestedMap(map, "Message");
        Map<String, Object> detail = getNestedMap(message, "detail");
        Map<String, Object> debitur = getNestedMap(detail, "debitur");
        List<Map<String, Object>> internalSalesForce = (List<Map<String, Object>>) debitur.get("internal_sales_force");

        if (internalSalesForce != null && !internalSalesForce.isEmpty()) {
            Map<String, Object> firstInternalSales = internalSalesForce.get(0);

            return getStringValue(firstInternalSales, "internal_sales_head_name");
        }

        return "";

    }

    // HISTORY1

    // Untuk merubah data ke dalam bentuk json
    @SuppressWarnings("unchecked")
    private Map<String, Object> parseMessage(String message) {
        Gson gson = new Gson();
        return gson.fromJson(message, Map.class);
    }

    // Untuk mengambil data yang bersarang (SUPERPOWER)
    @SuppressWarnings("unchecked")
    private Map<String, Object> getNestedMap(Map<String, Object> map, String key) {
        if (map == null) {
            return null;
        }
        Object value = map.get(key);
        return value instanceof Map ? (Map<String, Object>) value : null;
    }

    // Untuk Mendeclare data tersebut jadi STRING dan mengatasi data yang null atau
    // kosong
    private String getStringValue(Map<String, Object> map, String key) {
        return map != null ? (String) map.getOrDefault(key, "") : "";

    }

    // Untuk Mendeclare data tersebut jadi LONG dan mengatasi data yang null atau
    // kosong
    private Long getLongValue(Map<String, Object> map, String key) {
        if (map != null && map.containsKey(key)) {
            Object value = map.get(key);
            if (value instanceof Long) {
                return (Long) value;
            } else if (value instanceof Number) {
                return ((Number) value).longValue();
            }
        }
        return null;
    }

}
