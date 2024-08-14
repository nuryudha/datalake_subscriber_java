package com.datalake.datalake_subscriber_java.extractors;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.datalake.datalake_subscriber_java.utils.JsonParserUtility;

@Component
public class VerdatDataExtractor {

    @Autowired
    private JsonParserUtility jsonParser;

    public String getOrderId(Map<String, Object> map) {
        Map<String, Object> message = jsonParser.getNestedMap(map, "Message");
        return jsonParser.getStringValue(message, "order_id");
    }

    public String getCurrentFormDesc(Map<String, Object> map) {
        Map<String, Object> message = jsonParser.getNestedMap(map, "Message");
        return jsonParser.getStringValue(message, "current_form_desc");
    }

    public String getApplNo(Map<String, Object> map) {
        Map<String, Object> message = jsonParser.getNestedMap(map, "Message");
        return jsonParser.getStringValue(message, "application_id");
    }

    public String getApplDate(Map<String, Object> map) {
        Map<String, Object> message = jsonParser.getNestedMap(map, "Message");
        return jsonParser.getStringValue(message, "application_date");
    }

    public String getOrderDate(Map<String, Object> map) {
        Map<String, Object> message = jsonParser.getNestedMap(map, "Message");
        return jsonParser.getStringValue(message, "order_created_date");
    }

    @SuppressWarnings("unchecked")
    public String getApplContractNo(Map<String, Object> map) {
        Map<String, Object> message = jsonParser.getNestedMap(map, "Message");
        List<Map<String, Object>> contractId = (List<Map<String, Object>>) message.get("contract_id");
        if (contractId != null && !contractId.isEmpty()) {
            Map<String, Object> firstContractId = contractId.get(0);
            return jsonParser.getStringValue(firstContractId, "contract_id");
        }
        return "";
    }

    public String getMaxApproval(Map<String, Object> map) {
        Map<String, Object> message = jsonParser.getNestedMap(map, "Message");
        return jsonParser.getStringValue(message, "approval_max_level");
    }

    public String getLastApproval(Map<String, Object> map) {
        Map<String, Object> message = jsonParser.getNestedMap(map, "Message");
        return jsonParser.getStringValue(message, "approval_last_level");
    }

    public String getMaxDeviasi(Map<String, Object> map) {
        Map<String, Object> message = jsonParser.getNestedMap(map, "Message");
        Map<String, Object> deviasi = jsonParser.getNestedMap(message, "deviasi");
        return jsonParser.getStringValue(deviasi, "max_deviasi");
    }

    public String getFinType(Map<String, Object> map) {
        Map<String, Object> message = jsonParser.getNestedMap(map, "Message");
        Map<String, Object> detail = jsonParser.getNestedMap(message, "detail");
        Map<String, Object> identitas_order = jsonParser.getNestedMap(detail, "identitas_order");
        return jsonParser.getStringValue(identitas_order, "financing_type_desc");
    }

    @SuppressWarnings("unchecked")
    public String getFinanceProduct(Map<String, Object> map) {
        Map<String, Object> message = jsonParser.getNestedMap(map, "Message");
        Map<String, Object> detail = jsonParser.getNestedMap(message, "detail");
        Map<String, Object> data_entry_completion = jsonParser.getNestedMap(detail, "data_entry_completion");
        Map<String, Object> aplikasi = jsonParser.getNestedMap(data_entry_completion, "aplikasi");
        List<Map<String, Object>> objek_jaminan = (List<Map<String, Object>>) aplikasi.get("objek_jaminan");
        if (objek_jaminan != null && !objek_jaminan.isEmpty()) {
            Map<String, Object> firstObjekJaminan = objek_jaminan.get(0);
            Map<String, Object> struktur_kredit = jsonParser.getNestedMap(firstObjekJaminan, "struktur_kredit");
            return jsonParser.getStringValue(struktur_kredit, "type_installment_code");
        }
        return "";
    }

    public String getCoreProduct(Map<String, Object> map) {
        Map<String, Object> message = jsonParser.getNestedMap(map, "Message");
        Map<String, Object> detail = jsonParser.getNestedMap(message, "detail");
        Map<String, Object> identitas_order = jsonParser.getNestedMap(detail, "identitas_order");
        return jsonParser.getStringValue(identitas_order, "mkt_product_desc");
    }

    public String getArea(Map<String, Object> map) {
        Map<String, Object> message = jsonParser.getNestedMap(map, "Message");
        Map<String, Object> detail = jsonParser.getNestedMap(message, "detail");
        Map<String, Object> debitur = jsonParser.getNestedMap(detail, "debitur");
        Map<String, Object> personal = jsonParser.getNestedMap(debitur, "personal");
        return jsonParser.getStringValue(personal, "debitur_area_branch_desc");
    }

}
