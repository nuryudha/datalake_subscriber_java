package com.datalake.datalake_subscriber_java.extractors;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.datalake.datalake_subscriber_java.utilities.JsonUtility;

@Component
public class VerdatDataExtractor {

    @Autowired
    private JsonUtility jsonUtility;

    private Map<String, Object> message;
    private Map<String, Object> detail; // message.detail
    private Map<String, Object> identitas_order; // message.detail.identitas_order
    private Map<String, Object> object_pembiayaan; // detail.object_pembiayaan
    private Map<String, Object> calculation_structure_credit; // 'detail' -> 'object_pembiayaan' ->
                                                              // 'calculation_structure_credit'
    private Map<String, Object> debitur; // detail.debitur
    private Map<String, Object> personal; // detail.debitur.personal
    private Map<String, Object> data_entry_completion; // detail.data_entry_completion
    private Map<String, Object> aplikasi; // detail.data_entry_completion.aplikasi
    private Map<String, Object> informasi_aplikasi; // detail.data_entry_completion.aplikasi.informasi_aplikasi
    private Map<String, Object> first_internal_sales_force; // detail.data_entry_completion.aplikasi.informasi_aplikasi.internal_sales_force[0]
    private Map<String, Object> first_external_sales_force; // detail.data_entry_completion.aplikasi.informasi_aplikasi.external_sales_force[0]
    private Map<String, Object> second_external_sales_force; // detail.data_entry_completion.aplikasi.informasi_aplikasi.external_sales_force[1]
    private String appl_sales_through; // channel_code
    private String channel_desc; // channel_desc
    private Map<String, Object> supplier; // detail.object_pembiayaan.supplier
    private Map<String, Object> first_objek_jaminan; // detail.data_entry_completion.aplikasi.objek_jaminan[0].detail_objek_jaminan
    private Map<String, Object> automotive; // detail.data_entry_completion.aplikasi.objek_jaminan[0].detail_objek_jaminan.automotive

    // ? NEW

    // order_id = order_id
    public String getOrderId(Map<String, Object> map) {
        Map<String, Object> mapNested = new HashMap<>();
        mapNested.put("jumlahNested", "1");
        mapNested.put("keyNested_1", "Message");
        this.message = jsonUtility.getNestedMap(map, "Message");
        return jsonUtility.getStringValue(message, "order_id");
    }

    // current_form_desc = current_form_desc
    public String getCurrentFormDesc(Map<String, Object> map) {
        return jsonUtility.getStringValue(message, "current_form_desc");
    }

    // appl_no = application_id
    public String getApplNo(Map<String, Object> map) {
        return jsonUtility.getStringValue(message, "application_id");
    }

    // appl_date = application_date
    public String getApplDate(Map<String, Object> map) {
        return jsonUtility.getStringValue(message, "application_date");
    }

    // order_created_date = order_created_date
    public String getOrderDate(Map<String, Object> map) {
        return jsonUtility.getStringValue(message, "order_created_date");
    }

    // appl_contract_no = contract_id[0].contract_id
    @SuppressWarnings("unchecked")
    public String getApplContractNo(Map<String, Object> map) {
        List<Map<String, Object>> contract_id = (List<Map<String, Object>>) message.get("contract_id");
        if (contract_id != null && !contract_id.isEmpty()) {
            Map<String, Object> firstItem = contract_id.get(0);
            return jsonUtility.getStringValue(firstItem, "contract_id");
        }
        return "";
    }

    // approval_max_level
    public String getMaxApproval(Map<String, Object> map) {
        return jsonUtility.getStringValue(message, "approval_max_level");
    }

    // approval_last_level
    public String getLastApproval(Map<String, Object> map) {
        return jsonUtility.getStringValue(message, "approval_last_level");
    }

    // deviasi.max_deviasi
    public Long getMaxDeviasi(Map<String, Object> map) {
        Map<String, Object> deviasi = jsonUtility.getNestedMap(message, "deviasi");
        return jsonUtility.getLongValue(deviasi, "max_deviasi");
    }

    // appl_ppd_date
    public String getApplPpdDate(Map<String, Object> map) {
        return "";
    }

    // detail.identitas_order.financing_type_desc
    public String getFinType(Map<String, Object> map) {
        this.detail = jsonUtility.getNestedMap(message, "detail");
        this.identitas_order = jsonUtility.getNestedMap(detail, "identitas_order");
        return jsonUtility.getStringValue(identitas_order, "financing_type_desc");
    }

    // ! case when
    public String getFinanceProduct(Map<String, Object> map) {
        this.object_pembiayaan = jsonUtility.getNestedMap(detail, "object_pembiayaan"); // detail.object_pembiayaan
        this.calculation_structure_credit = jsonUtility.getNestedMap(object_pembiayaan, "calculation_structure_credit");
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

    // detail.identitas_order.mkt_product_desc (core_product)
    public String getCoreProduct(Map<String, Object> map) {
        return jsonUtility.getStringValue(identitas_order, "mkt_product_desc");
    }

    // detail.debitur.personal.debitur_area_branch_desc
    public String getArea(Map<String, Object> map) {
        this.debitur = jsonUtility.getNestedMap(detail, "debitur");
        this.personal = jsonUtility.getNestedMap(debitur, "personal");
        return jsonUtility.getStringValue(personal, "debitur_area_branch_desc");
    }

    // branch_desc
    public String getBranBrName(Map<String, Object> map) {
        return jsonUtility.getStringValue(message, "branch_desc");
    }

    // branch_code
    public String getBranBrId(Map<String, Object> map) {
        return jsonUtility.getStringValue(message, "branch_code");
    }

    // detail.identitas_order.outlet_desc
    public String getOutletChannelDesc(Map<String, Object> map) {
        return jsonUtility.getStringValue(identitas_order, "outlet_desc");
    }

    // channel_code
    public String getApplSalesThrough(Map<String, Object> map) {
        String appl_sales_through = jsonUtility.getStringValue(message, "channel_code");
        return appl_sales_through;
    }

    // channel_desc
    public String getSalesThrought(Map<String, Object> map) {
        this.channel_desc = jsonUtility.getStringValue(message, "channel_desc");
        String sales_throught = channel_desc;
        return sales_throught;
    }

    // initiall
    public String getInitiall(Map<String, Object> map) {
        return "";
    }

    // detail.data_entry_completion.aplikasi.informasi_aplikasi.internal_sales_force[0].internal_sales_force_npk
    @SuppressWarnings("unchecked")
    public String getInternalSalesForceCode(Map<String, Object> map) {
        this.data_entry_completion = jsonUtility.getNestedMap(detail, "data_entry_completion");
        this.aplikasi = jsonUtility.getNestedMap(data_entry_completion, "aplikasi");
        this.informasi_aplikasi = jsonUtility.getNestedMap(aplikasi, "informasi_aplikasi");
        List<Map<String, Object>> internal_sales_force = (List<Map<String, Object>>) informasi_aplikasi
                .get("internal_sales_force");
        if (internal_sales_force != null && !internal_sales_force.isEmpty()) {
            this.first_internal_sales_force = internal_sales_force.get(0);
            return jsonUtility.getStringValue(first_internal_sales_force, "internal_sales_force_npk");
        }
        return "";
    }

    // detail.data_entry_completion.aplikasi.informasi_aplikasi.internal_sales_force[0].internal_sales_force_id
    public String getInternalSalesForceNik(Map<String, Object> map) {
        return jsonUtility.getStringValue(first_internal_sales_force, "internal_sales_force_id");
    }

    // detail.data_entry_completion.aplikasi.informasi_aplikasi.internal_sales_force[0].internal_sales_force_desc
    public String getInternalSalesForceName(Map<String, Object> map) {
        return jsonUtility.getStringValue(first_internal_sales_force, "internal_sales_force_desc");
    }

    // detail.data_entry_completion.aplikasi.informasi_aplikasi.internal_sales_force[0].internal_sales_job_desc
    public String getInternalSalesForceJob(Map<String, Object> map) {
        return jsonUtility.getStringValue(first_internal_sales_force, "internal_sales_job_desc");
    }

    // detail.data_entry_completion.aplikasi.informasi_aplikasi.external_sales_force[0].external_sales_name
    @SuppressWarnings("unchecked")
    public String getInterxtSalesForce1Name(Map<String, Object> map) {
        List<Map<String, Object>> external_sales_force = (List<Map<String, Object>>) informasi_aplikasi
                .get("external_sales_force");
        if (external_sales_force != null && !external_sales_force.isEmpty()) {
            this.first_external_sales_force = external_sales_force.get(0);
            return jsonUtility.getStringValue(first_external_sales_force, "external_sales_name");
        }
        return "";
    }

    // detail.data_entry_completion.aplikasi.informasi_aplikasi.external_sales_force[0].external_sales_npk
    public String getInterxtSalesForce1Npk(Map<String, Object> map) {
        return jsonUtility.getStringValue(first_external_sales_force, "external_sales_npk");
    }

    // detail.data_entry_completion.aplikasi.informasi_aplikasi.external_sales_force[0].external_sales_job_desc
    public String getInterxtSalesForce1Job(Map<String, Object> map) {
        return jsonUtility.getStringValue(first_external_sales_force, "external_sales_job_desc");
    }

    // detail.data_entry_completion.aplikasi.informasi_aplikasi.external_sales_force[1].external_sales_name
    @SuppressWarnings("unchecked")
    public String getInterxtSalesForce2Name(Map<String, Object> map) {
        List<Map<String, Object>> external_sales_force = (List<Map<String, Object>>) informasi_aplikasi
                .get("external_sales_force");
        if (external_sales_force != null && !external_sales_force.isEmpty()) {
            this.second_external_sales_force = external_sales_force.get(1);
            return jsonUtility.getStringValue(second_external_sales_force, "external_sales_name");
        }
        return "";
    }

    // detail.data_entry_completion.aplikasi.informasi_aplikasi.external_sales_force[1].external_sales_npk
    public String getInterxtSalesForce2Npk(Map<String, Object> map) {
        return jsonUtility.getStringValue(second_external_sales_force, "external_sales_npk");
    }

    // detail.data_entry_completion.aplikasi.informasi_aplikasi.external_sales_force[1].external_sales_job_desc
    public String getInterxtSalesForce2Job(Map<String, Object> map) {
        return jsonUtility.getStringValue(second_external_sales_force, "external_sales_job_desc");
    }

    // 'detail' -> 'identitas_order' -> 'external_sales_force' -> 0->>
    // 'external_sales_no'
    public String getIdEmplMitra(Map<String, Object> map) {
        if (appl_sales_through == "03") {
            return jsonUtility.getStringValue(first_external_sales_force, "external_sales_no");
        } else {
            return "";
        }
    }

    // channel_desc
    public String getCompany(Map<String, Object> map) {
        String company = channel_desc;
        return company;
    }

    // 'detail' -> 'identitas_order' -> 'external_sales_force' -> 0->>
    // 'external_sales_no'
    public String getEmplNikBank(Map<String, Object> map) {
        if (appl_sales_through == "02") {
            return jsonUtility.getStringValue(first_external_sales_force, "external_sales_no");
        } else {
            return "";
        }
    }

    // no_telephone
    public String getNoTelephone(Map<String, Object> map) {
        return "";
    }

    // outlet_channel_code
    public String getBankBranchId(Map<String, Object> map) {
        if (appl_sales_through == "02") {
            return jsonUtility.getStringValue(message, "outlet_channel_code");
        } else {
            return "";
        }
    }

    // bank_office_location ("")
    public String getBankOfficeLocation(Map<String, Object> map) {
        return "";
    }

    // detail.data_entry_completion.aplikasi.informasi_aplikasi.external_sales_force[0].external_sales_job_code
    // detail.data_entry_completion.aplikasi.informasi_aplikasi.external_sales_force[0].external_sales_job_desc
    public String getKodePekerjaan(Map<String, Object> map) {
        String external_sales_job_code = jsonUtility.getStringValue(first_external_sales_force,
                "external_sales_job_code");
        String external_sales_job_desc = jsonUtility.getStringValue(first_external_sales_force,
                "external_sales_job_desc");
        return external_sales_job_code + external_sales_job_desc;

    }

    // debitur_no_npwp ("")
    public String getDebiturNoNpwp(Map<String, Object> map) {
        return "";
    }

    // npwp_type ("")
    public String getNpwpType(Map<String, Object> map) {
        return "";
    }

    // bank_deal_empl ("")
    public String getBankDealEmpl(Map<String, Object> map) {
        return "";
    }

    // detail.data_entry_completion.aplikasi.informasi_aplikasi.internal_sales_force[0].internal_sales_bank_acc_no
    public String getEmplAccNo(Map<String, Object> map) {
        return jsonUtility.getStringValue(first_internal_sales_force, "internal_sales_bank_acc_no");
    }

    // empl_addr ("")
    public String getEmplAddr(Map<String, Object> map) {
        return "";
    }

    // detail.object_pembiayaan.supplier.unit_provider_code
    public String getDlcgetDlc(Map<String, Object> map) {
        this.supplier = jsonUtility.getNestedMap(object_pembiayaan, "supplier");
        return jsonUtility.getStringValue(supplier, "unit_provider_code");
    }

    // detail.object_pembiayaan.supplier.unit_provider_desc
    public String getCredDealName(Map<String, Object> map) {
        return jsonUtility.getStringValue(supplier, "unit_provider_desc");
    }

    // detail.object_pembiayaan.supplier.rekening_package_code
    public String getApplApplTag1(Map<String, Object> map) {
        return jsonUtility.getStringValue(supplier, "rekening_package_code");
    }

    // detail.object_pembiayaan.supplier.rekening_package_desc
    public String getAplicationTag1Desc(Map<String, Object> map) {
        return jsonUtility.getStringValue(supplier, "rekening_package_desc");
    }

    // appl_appl_tag2 ("")
    public String getApplApplTag2(Map<String, Object> map) {
        return "";
    }

    // aplication_tax2_desc ("")
    public String getAplicationTax2Desc(Map<String, Object> map) {
        return "";
    }

    // appl_appl_tag3 ("")
    public String getApplApplTag3(Map<String, Object> map) {
        return "";
    }

    // aplication_tax3_desc ("")
    public String getAplicationTax3Desc(Map<String, Object> map) {
        return "";
    }

    // status ("")
    public String getStatus(Map<String, Object> map) {
        return "";
    }

    // detail.data_entry_completion.aplikasi.objek_jaminan[0].detail_objek_jaminan.automotive.obj_code
    @SuppressWarnings("unchecked")
    public String getApplObjtCode(Map<String, Object> map) {
        List<Map<String, Object>> objek_jaminan = (List<Map<String, Object>>) aplikasi.get("objek_jaminan");
        if (objek_jaminan != null && !objek_jaminan.isEmpty()) {
            this.first_objek_jaminan = objek_jaminan.get(0);
            Map<String, Object> detail_objek_jaminan = jsonUtility.getNestedMap(first_objek_jaminan,
                    "detail_objek_jaminan");
            this.automotive = jsonUtility.getNestedMap(detail_objek_jaminan, "automotive");
            return jsonUtility.getStringValue(automotive, "obj_code");
        }
        return "";
    }

    // detail.data_entry_completion.aplikasi.objek_jaminan[0].detail_objek_jaminan.automotive.obj_desc
    public String getObjtDesc(Map<String, Object> map) {
        return jsonUtility.getStringValue(automotive, "obj_desc");
    }

    // detail.data_entry_completion.aplikasi.objek_jaminan[0].detail_objek_jaminan.automotive.obj_brand_code
    public String getObbrCode(Map<String, Object> map) {
        return jsonUtility.getStringValue(automotive, "obj_brand_code");
    }

    // detail.data_entry_completion.aplikasi.objek_jaminan[0].detail_objek_jaminan.automotive.obj_brand_desc
    public String getObbrDesc(Map<String, Object> map) {
        return jsonUtility.getStringValue(automotive, "obj_brand_desc");
    }

    // detail.object_pembiayaan.obj_fuel_desc
    public String getBahanBakar(Map<String, Object> map) {
        return jsonUtility.getStringValue(object_pembiayaan, "obj_fuel_desc");
    }

    // detail.data_entry_completion.aplikasi.objek_jaminan[0].detail_objek_jaminan.automotive.obj_type_code
    public String getObtyCode(Map<String, Object> map) {
        return jsonUtility.getStringValue(automotive, "obj_type_code");
    }

    // detail.data_entry_completion.aplikasi.objek_jaminan[0].detail_objek_jaminan.automotive.obj_type_desc
    public String getObtyDesc(Map<String, Object> map) {
        return jsonUtility.getStringValue(automotive, "obj_type_desc");
    }

    // detail.data_entry_completion.aplikasi.objek_jaminan[0].detail_objek_jaminan.automotive.obj_model_code
    public String getObmoCode(Map<String, Object> map) {
        return jsonUtility.getStringValue(automotive, "obj_model_code");
    }

    // detail.data_entry_completion.aplikasi.objek_jaminan[0].detail_objek_jaminan.automotive.obj_model_desc
    public String getObmoDesc(Map<String, Object> map) {
        return jsonUtility.getStringValue(automotive, "obj_model_desc");
    }

    // detail.data_entry_completion.aplikasi.objek_jaminan[0].detail_objek_jaminan.automotive.obj_year
    public String getObjtObjYear(Map<String, Object> map) {
        return jsonUtility.getStringValue(automotive, "obj_year");
    }
}
