package com.datalake.datalake_subscriber_java.extractors;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.datalake.datalake_subscriber_java.utilities.JsonUtility;

public class VerdatDataExtractor {

    @Autowired
    private JsonUtility jsonUtility;

    public String getOrderId(Map<String, Object> map) {
        Map<String, Object> message = jsonUtility.getNestedMap(map, "Message");
        return jsonUtility.getStringValue(message, "order_id");
    }

    public String getCurrentFormDesc(Map<String, Object> map) {
        Map<String, Object> message = jsonUtility.getNestedMap(map, "Message");
        return jsonUtility.getStringValue(message, "current_form_desc");
    }

    public String getApplNo(Map<String, Object> map) {
        Map<String, Object> message = jsonUtility.getNestedMap(map, "Message");
        return jsonUtility.getStringValue(message, "application_id");
    }

    public String getApplDate(Map<String, Object> map) {
        Map<String, Object> message = jsonUtility.getNestedMap(map, "Message");
        return jsonUtility.getStringValue(message, "application_date");
    }

    public String getOrderDate(Map<String, Object> map) {
        Map<String, Object> message = jsonUtility.getNestedMap(map, "Message");
        return jsonUtility.getStringValue(message, "order_created_date");
    }

    @SuppressWarnings("unchecked")
    public String getApplContractNo(Map<String, Object> map) {
        Map<String, Object> message = jsonUtility.getNestedMap(map, "Message");
        List<Map<String, Object>> contract_id = (List<Map<String, Object>>) message.get("contract_id");
        if (contract_id != null && !contract_id.isEmpty()) {
            Map<String, Object> firstItem = contract_id.get(0);
            return jsonUtility.getStringValue(firstItem, "contract_id");
        }
        return "";
    }

    public String getMaxApproval(Map<String, Object> map) {
        Map<String, Object> message = jsonUtility.getNestedMap(map, "Message");
        return jsonUtility.getStringValue(message, "approval_max_level");
    }

    public String getLastApproval(Map<String, Object> map) {
        Map<String, Object> message = jsonUtility.getNestedMap(map, "Message");
        return jsonUtility.getStringValue(message, "approval_last_level");
    }

    public String getMaxDeviasi(Map<String, Object> map) {
        Map<String, Object> message = jsonUtility.getNestedMap(map, "Message");
        Map<String, Object> deviasi = jsonUtility.getNestedMap(message, "deviasi");
        return jsonUtility.getStringValue(deviasi, "max_deviasi");
    }

    public String getFinType(Map<String, Object> map) {
        Map<String, Object> message = jsonUtility.getNestedMap(map, "Message");
        Map<String, Object> detail = jsonUtility.getNestedMap(message, "detail");
        Map<String, Object> identitas_order = jsonUtility.getNestedMap(detail, "identitas_order");
        return jsonUtility.getStringValue(identitas_order, "financing_type_desc");
    }

    public String getFinType(Map<String, Object> map) {
        Map<String, Object> mapNested = new HashMap<>();
        mapNested.put("jumlahNested", "3");
        mapNested.put("keyNested_1", "Message");
        mapNested.put("keyNested_2", "detail");
        mapNested.put("keyNested_3", "identitas_order");

        // Map<String, Object> identitas_order = jsonUtility.getNestedNestedMap(map,
        // mapNested);
        String identitas_order = jsonUtility.getNestedNestedMap(map, mapNested);

        if (identitas_order != null) {
            return jsonUtility.getStringValue(identitas_order, "financing_type_desc");
        } else {
            return ""; // Atau Anda bisa mengembalikan nilai default jika identitas_order tidak
                       // ditemukan
        }
    }

    public String getFinanceProduct(Map<String, Object> map) {
        Map<String, Object> message = jsonUtility.getNestedMap(map, "Message");
        Map<String, Object> detail = jsonUtility.getNestedMap(message, "detail");
        Map<String, Object> object_pembiayaan = jsonUtility.getNestedMap(detail, "object_pembiayaan");
        Map<String, Object> calculation_structure_credit = jsonUtility.getNestedMap(object_pembiayaan,
                "calculation_structure_credit");
        String finance_product = jsonUtility.getStringValue(calculation_structure_credit, "type_installment_code");
        if (finance_product != null && !finance_product.isEmpty()) {
            if (finance_product.equals("01")) {
                return "CONSUMER_FINANCE";
            } else if (finance_product.equals("02")) {
                return "CONSUMER_LEASE";
            } else {
                return "";
            }
        } else {
            return "";
        }

    }

    public String getCoreProduct(Map<String, Object> map) {
        Map<String, Object> message = jsonUtility.getNestedMap(map, "Message");
        Map<String, Object> detail = jsonUtility.getNestedMap(message, "detail");
        Map<String, Object> identitas_order = jsonUtility.getNestedMap(detail, "identitas_order");
        return jsonUtility.getStringValue(identitas_order, "mkt_product_desc");
    }

    public String getBranBrName(Map<String, Object> map) {
        Map<String, Object> message = jsonUtility.getNestedMap(map, "Message");
        return jsonUtility.getStringValue(message, "branch_desc");
    }

    public String getBranBrId(Map<String, Object> map) {
        Map<String, Object> message = jsonUtility.getNestedMap(map, "Message");
        return jsonUtility.getStringValue(message, "branch_code");
    }

    public String getOutletChannelDesc(Map<String, Object> map) {
        Map<String, Object> message = jsonUtility.getNestedMap(map, "Message");
        Map<String, Object> detail = jsonUtility.getNestedMap(message, "detail");
        Map<String, Object> identitas_order = jsonUtility.getNestedMap(detail, "identitas_order");
        return jsonUtility.getStringValue(identitas_order, "outlet_desc");
    }

    public String getApplSalesThrough(Map<String, Object> map) {
        Map<String, Object> message = jsonUtility.getNestedMap(map, "Message");
        return jsonUtility.getStringValue(message, "channel_code");
    }

    public String getSalesThrought(Map<String, Object> map) {
        Map<String, Object> message = jsonUtility.getNestedMap(map, "Message");
        return jsonUtility.getStringValue(message, "channel_desc");
    }

    @SuppressWarnings("unchecked")
    public String getInternalSalesForceCode(Map<String, Object> map) {
        Map<String, Object> message = jsonUtility.getNestedMap(map, "Message");
        Map<String, Object> detail = jsonUtility.getNestedMap(message, "detail");
        Map<String, Object> data_entry_completion = jsonUtility.getNestedMap(detail, "data_entry_completion");
        Map<String, Object> aplikasi = jsonUtility.getNestedMap(data_entry_completion, "aplikasi");
        List<Map<String, Object>> internal_sales_force = (List<Map<String, Object>>) aplikasi
                .get("internal_sales_force");
        if (internal_sales_force != null && !internal_sales_force.isEmpty()) {
            Map<String, Object> firstItem = internal_sales_force.get(0);
            return jsonUtility.getStringValue(firstItem, "internal_sales_force_npk");
        }
        return "";
    }

    @SuppressWarnings("unchecked")
    public String getInternalSalesForceNik(Map<String, Object> map) {
        Map<String, Object> message = jsonUtility.getNestedMap(map, "Message");
        Map<String, Object> detail = jsonUtility.getNestedMap(message, "detail");
        Map<String, Object> data_entry_completion = jsonUtility.getNestedMap(detail, "data_entry_completion");
        Map<String, Object> aplikasi = jsonUtility.getNestedMap(data_entry_completion, "aplikasi");
        List<Map<String, Object>> internal_sales_force = (List<Map<String, Object>>) aplikasi
                .get("internal_sales_force");
        if (internal_sales_force != null && !internal_sales_force.isEmpty()) {
            Map<String, Object> firstItem = internal_sales_force.get(0);
            return jsonUtility.getStringValue(firstItem, "internal_sales_force_id");
        }
        return "";
    }

    @SuppressWarnings("unchecked")
    public String getInternalSalesForceName(Map<String, Object> map) {
        Map<String, Object> message = jsonUtility.getNestedMap(map, "Message");
        Map<String, Object> detail = jsonUtility.getNestedMap(message, "detail");
        Map<String, Object> data_entry_completion = jsonUtility.getNestedMap(detail, "data_entry_completion");
        Map<String, Object> aplikasi = jsonUtility.getNestedMap(data_entry_completion, "aplikasi");
        List<Map<String, Object>> internal_sales_force = (List<Map<String, Object>>) aplikasi
                .get("internal_sales_force");
        if (internal_sales_force != null && !internal_sales_force.isEmpty()) {
            Map<String, Object> firstItem = internal_sales_force.get(0);
            return jsonUtility.getStringValue(firstItem, "internal_sales_force_desc");
        }
        return "";
    }

    @SuppressWarnings("unchecked")
    public String getInternalSalesForceJob(Map<String, Object> map) {
        Map<String, Object> message = jsonUtility.getNestedMap(map, "Message");
        Map<String, Object> detail = jsonUtility.getNestedMap(message, "detail");
        Map<String, Object> data_entry_completion = jsonUtility.getNestedMap(detail, "data_entry_completion");
        Map<String, Object> aplikasi = jsonUtility.getNestedMap(data_entry_completion, "aplikasi");
        List<Map<String, Object>> internal_sales_force = (List<Map<String, Object>>) aplikasi
                .get("internal_sales_force");
        if (internal_sales_force != null && !internal_sales_force.isEmpty()) {
            Map<String, Object> firstItem = internal_sales_force.get(0);
            return jsonUtility.getStringValue(firstItem, "internal_sales_job_desc");
        }
        return "";
    }

    @SuppressWarnings("unchecked")
    public String getInterxtSalesForce1Name(Map<String, Object> map) {
        Map<String, Object> message = jsonUtility.getNestedMap(map, "Message");
        Map<String, Object> detail = jsonUtility.getNestedMap(message, "detail");
        Map<String, Object> data_entry_completion = jsonUtility.getNestedMap(detail, "data_entry_completion");
        Map<String, Object> aplikasi = jsonUtility.getNestedMap(data_entry_completion, "aplikasi");
        List<Map<String, Object>> external_sales_force = (List<Map<String, Object>>) aplikasi
                .get("external_sales_force");
        if (external_sales_force != null && !external_sales_force.isEmpty()) {
            Map<String, Object> firstItem = external_sales_force.get(0);
            return jsonUtility.getStringValue(firstItem, "external_sales_name");
        }
        return "";
    }

    @SuppressWarnings("unchecked")
    public String getInterxtSalesForce1Npk(Map<String, Object> map) {
        Map<String, Object> message = jsonUtility.getNestedMap(map, "Message");
        Map<String, Object> detail = jsonUtility.getNestedMap(message, "detail");
        Map<String, Object> data_entry_completion = jsonUtility.getNestedMap(detail, "data_entry_completion");
        Map<String, Object> aplikasi = jsonUtility.getNestedMap(data_entry_completion, "aplikasi");
        List<Map<String, Object>> external_sales_force = (List<Map<String, Object>>) aplikasi
                .get("external_sales_force");
        if (external_sales_force != null && !external_sales_force.isEmpty()) {
            Map<String, Object> firstItem = external_sales_force.get(0);
            return jsonUtility.getStringValue(firstItem, "external_sales_npk");
        }
        return "";
    }

    @SuppressWarnings("unchecked")
    public String getInterxtSalesForce1Job(Map<String, Object> map) {
        Map<String, Object> message = jsonUtility.getNestedMap(map, "Message");
        Map<String, Object> detail = jsonUtility.getNestedMap(message, "detail");
        Map<String, Object> data_entry_completion = jsonUtility.getNestedMap(detail, "data_entry_completion");
        Map<String, Object> aplikasi = jsonUtility.getNestedMap(data_entry_completion, "aplikasi");
        List<Map<String, Object>> external_sales_force = (List<Map<String, Object>>) aplikasi
                .get("external_sales_force");
        if (external_sales_force != null && !external_sales_force.isEmpty()) {
            Map<String, Object> firstItem = external_sales_force.get(0);
            return jsonUtility.getStringValue(firstItem, "external_sales_job_desc");
        }
        return "";
    }

    @SuppressWarnings("unchecked")
    public String getInterxtSalesForce2Name(Map<String, Object> map) {
        Map<String, Object> message = jsonUtility.getNestedMap(map, "Message");
        Map<String, Object> detail = jsonUtility.getNestedMap(message, "detail");
        Map<String, Object> data_entry_completion = jsonUtility.getNestedMap(detail, "data_entry_completion");
        Map<String, Object> aplikasi = jsonUtility.getNestedMap(data_entry_completion, "aplikasi");
        List<Map<String, Object>> external_sales_force = (List<Map<String, Object>>) aplikasi
                .get("external_sales_force");
        if (external_sales_force != null && !external_sales_force.isEmpty()) {
            Map<String, Object> secondItem = external_sales_force.get(1);
            return jsonUtility.getStringValue(secondItem, "external_sales_name");
        }
        return "";
    }

    @SuppressWarnings("unchecked")
    public String getInterxtSalesForce2Npk(Map<String, Object> map) {
        Map<String, Object> message = jsonUtility.getNestedMap(map, "Message");
        Map<String, Object> detail = jsonUtility.getNestedMap(message, "detail");
        Map<String, Object> data_entry_completion = jsonUtility.getNestedMap(detail, "data_entry_completion");
        Map<String, Object> aplikasi = jsonUtility.getNestedMap(data_entry_completion, "aplikasi");
        List<Map<String, Object>> external_sales_force = (List<Map<String, Object>>) aplikasi
                .get("external_sales_force");
        if (external_sales_force != null && !external_sales_force.isEmpty()) {
            Map<String, Object> secondItem = external_sales_force.get(1);
            return jsonUtility.getStringValue(secondItem, "external_sales_npk");
        }
        return "";
    }

    @SuppressWarnings("unchecked")
    public String getInterxtSalesForce2Job(Map<String, Object> map) {
        Map<String, Object> message = jsonUtility.getNestedMap(map, "Message");
        Map<String, Object> detail = jsonUtility.getNestedMap(message, "detail");
        Map<String, Object> data_entry_completion = jsonUtility.getNestedMap(detail, "data_entry_completion");
        Map<String, Object> aplikasi = jsonUtility.getNestedMap(data_entry_completion, "aplikasi");
        List<Map<String, Object>> external_sales_force = (List<Map<String, Object>>) aplikasi
                .get("external_sales_force");
        if (external_sales_force != null && !external_sales_force.isEmpty()) {
            Map<String, Object> secondItem = external_sales_force.get(1);
            return jsonUtility.getStringValue(secondItem, "external_sales_job_desc");
        }
        return "";
    }

    public String getApplSalesThrogh(Map<String, Object> map) {
        Map<String, Object> message = jsonUtility.getNestedMap(map, "Message");
        return jsonUtility.getStringValue(message, "channel_code");
    }

    @SuppressWarnings("unchecked")
    public String getExternalSalesNo(Map<String, Object> map, String expectedChannelCode) {
        String appl_sales_through = getApplSalesThrogh(map);
        if (appl_sales_through != null && !appl_sales_through.isEmpty()
                && appl_sales_through.equals(expectedChannelCode)) {
            Map<String, Object> message = jsonUtility.getNestedMap(map, "Message");
            Map<String, Object> detail = jsonUtility.getNestedMap(message, "detail");
            Map<String, Object> identitas_order = jsonUtility.getNestedMap(detail, "identitas_order");
            List<Map<String, Object>> external_sales_force = (List<Map<String, Object>>) identitas_order
                    .get("external_sales_force");

            if (external_sales_force != null && !external_sales_force.isEmpty()) {
                Map<String, Object> firstItem = external_sales_force.get(0);
                return jsonUtility.getStringValue(firstItem, "external_sales_no");
            }
        }
        return "";
    }

    public String getIdEmplMitra(Map<String, Object> map) {
        return getExternalSalesNo(map, "02");
    }

    public String getEmplNikBank(Map<String, Object> map) {
        return getExternalSalesNo(map, "03");
    }

    public String getCompany(Map<String, Object> map) {
        Map<String, Object> message = jsonUtility.getNestedMap(map, "Message");
        return jsonUtility.getStringValue(message, "channel_desc");
    }

    public String getBankBranchId(Map<String, Object> map) {
        String appl_sales_through = getApplSalesThrogh(map);
        if (appl_sales_through != null && !appl_sales_through.isEmpty() && appl_sales_through.equals("02")) {
            Map<String, Object> message = jsonUtility.getNestedMap(map, "Message");
            String outlet_channel_code = jsonUtility.getStringValue(message, "outlet_channel_code ");
            if (outlet_channel_code != null && !outlet_channel_code.isEmpty()) {
                Map<String, Object> personal = jsonUtility.getNestedMap(message, "personal");
                return jsonUtility.getStringValue(personal, "debitur_bank_branch_code");

            } else {
                return "";
            }
        } else {
            return "";
        }

    }

    @SuppressWarnings("unchecked")
    public String getKodePekerjaan(Map<String, Object> map) {
        Map<String, Object> message = jsonUtility.getNestedMap(map, "Message");
        Map<String, Object> detail = jsonUtility.getNestedMap(message, "detail");
        Map<String, Object> data_entry_completion = jsonUtility.getNestedMap(detail, "data_entry_completion");
        Map<String, Object> aplikasi = jsonUtility.getNestedMap(data_entry_completion, "aplikasi");
        Map<String, Object> informasi_aplikasi = jsonUtility.getNestedMap(aplikasi, "informasi_aplikasi");
        List<Map<String, Object>> external_sales_force = (List<Map<String, Object>>) informasi_aplikasi
                .get("external_sales_force");
        if (external_sales_force != null && !external_sales_force.isEmpty()) {
            Map<String, Object> firstItem = external_sales_force.get(0);
            String external_sales_job_code = jsonUtility.getStringValue(firstItem, "external_sales_job_code");
            String external_sales_job_desc = jsonUtility.getStringValue(firstItem, "external_sales_job_desc");
            return external_sales_job_code + external_sales_job_desc;
        }
        return "";
    }

}
