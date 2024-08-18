package com.datalake.datalake_subscriber_java.services.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.datalake.datalake_subscriber_java.utilities.JsonUtility;

@Component
public class VerdatMapper {

    @Autowired
    private JsonUtility jsonUtility;

    private Map<String, Object> message;
    private Map<String, Object> detail; // message.detail
    private Map<String, Object> identitas_order; // message.detail.identitas_order
    private Map<String, Object> object_pembiayaan; // detail.object_pembiayaan
    private Map<String, Object> calculation_structure_credit; // detail.object_pembiayaan.calculation_structure_credit
    private Map<String, Object> debitur; // detail.debitur
    private Map<String, Object> personal; /// detail.debitur.personal
    private Map<String, Object> data_entry_completion; // detail.data_entry_completion
    private Map<String, Object> aplikasi; // detail.data_entry_completion.aplikasi
    private Map<String, Object> informasi_aplikasi; // detail.data_entry_completion.aplikasi.informasi_aplikasi
    private Map<String, Object> first_internal_sales_force; // detail.data_entry_completion.aplikasi.informasi_aplikasi.internal_sales_force[0]
    private Map<String, Object> first_external_sales_force; // detail.data_entry_completion.aplikasi.informasi_aplikasi.external_sales_force[0]
    private Map<String, Object> second_external_sales_force; // detail.data_entry_completion.aplikasi.informasi_aplikasi.external_sales_force[1]
    private String appl_sales_through; // channel_code
    private String channel_desc; // channel_desc
    private Map<String, Object> supplier; // detail.object_pembiayaan.supplier
    private Map<String, Object> first_objek_jaminan; // detail.data_entry_completion.aplikasi.objek_jaminan[0]
    private Map<String, Object> detail_objek_jaminan; // detail.data_entry_completion.aplikasi.objek_jaminan[0].detail_objek_jaminan
    private Map<String, Object> automotive; // detail.data_entry_completion.aplikasi.objek_jaminan[0].detail_objek_jaminan.automotive
    private Map<String, Object> informasi_object_pembiayaan; // detail.reguler_survey.personal.informasi_object_pembiayaan
    private Map<String, Object> refund; // detail.data_entry_completion.aplikasi.objek_jaminan[0].refund
    private Map<String, Object> struktur_kredit; // detail.data_entry_completion.aplikasi.objek_jaminan[0].struktur_kredit
    private Map<String, Object> calculation_insurance; // detail.object_pembiayaan.calculation_insurance
    private Map<String, Object> calculation_additional_insurance; // detail.object_pembiayaan.calculation_additional_insurance
    private Map<String, Object> alamat_ktp; // detail.debitur.personal.alamat_debitur.alamat_ktp
    private Map<String, Object> occupation; // detail.debitur.personal.occupation
    private Map<String, Object> occupationDebitur; // detail.debitur.personal.occupation.debitur
    private String occupation_type_code; // detail.debitur.personal.occupation.occupation_type_code
    private Map<String, Object> approval; // detail.approval
    private Map<String, Object> cetakan_po_sipbpkb_cl; // detail.cetakan_po_sipbpkb_cl
    private Map<String, Object> first_approval_history; // detail.aprroval.approval_history[0]
    private Map<String, Object> first_identitas_order_internal_sales_force; // detail.identitas_order.internal_sales_force[0]
    private Map<String, Object> reguler_survey; // detail.reguler_survey
    private String job_code_mca; // detail.approval.approval_history[0].jobCode AS JOB_CODE_MCA
    private Map<String, Object> reguler_survey_personal; // detail.reguler_survey.personal
    private String source_order_desc; // source_order_desc
    private String obj_code; // 'detail' -> 'object_pembiayaan' ->> 'obj_code' AS PORTFOLIO_CODE,
    private String obj_pembiayaan; // 'detail' -> 'identitas_order' ->> 'obj_pembiayaan' AS obj_pembiayaan,
    private String jenis_channel_code; // 'detail' -> 'identitas_order' ->> 'jenis_channel_code' AS jenis_channel_code,
    private String internal_sales_force_type_code; // 'detail' -> 'identitas_order' -> 'internal_sales_force' -> 0
                                                   // ->>'internal_sales_type_code' as internal_sales_force_type_code
    private String CSC_total_principal_amount; // detail.object_pembiayaan.calculation_structure_credit.total_principal_amount
    private String CSC_total_interest_amount; // detail.object_pembiayaan.calculation_structure_credit.total_interest_amount
    private String CAI_additional_insurance_credit_fee; // detail.object_pembiayaan.calculation_additional_insurance.additional_insurance_credit_fee
    private String CAI_additional_insurance_fee; // detail.object_pembiayaan.calculation_additional_insurance.additional_insurance_fee
    private String CAI_provisi_fee; // detail.object_pembiayaan.calculation_structure_credit.provisi_fee AS
                                    // provisi_paid
    private String CAI_provisi_credit_fee; // detail.object_pembiayaan.calculation_structure_credit.provisi_credit_fee
                                           // AS PROVISI_FIN
    private Map<String, Object> DEC_occupation_debitur; // detail.data_entry_completion.customer.occupation.debitur
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
        if (external_sales_force != null && external_sales_force.size() > 1) {
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
    public String getDlc(Map<String, Object> map) {
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
            this.detail_objek_jaminan = jsonUtility.getNestedMap(first_objek_jaminan,
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

    // objt_obj_mfg_year ("")
    public String getObjtObjMfgYear(Map<String, Object> map) {
        return "";
    }

    // detail.data_entry_completion.aplikasi.objek_jaminan[0].detail_objek_jaminan.automotive.obj_color
    public String getObjtColor(Map<String, Object> map) {
        return jsonUtility.getStringValue(automotive, "obj_color");
    }

    // detail.data_entry_completion.aplikasi.objek_jaminan[0].detail_objek_jaminan.automotive.no_mesin
    public String getObjtFrameNo(Map<String, Object> map) {
        return jsonUtility.getStringValue(automotive, "no_mesin");
    }

    // detail.data_entry_completion.aplikasi.objek_jaminan[0].detail_objek_jaminan.automotive.no_rangka
    public String getObjtEngineNo(Map<String, Object> map) {
        return jsonUtility.getStringValue(automotive, "no_rangka");
    }

    // detail.data_entry_completion.aplikasi.informasi_aplikasi.obj_purpose_desc
    public String getPurposeDesc(Map<String, Object> map) {
        return jsonUtility.getStringValue(informasi_aplikasi, "obj_purpose_desc");
    }

    // detail.reguler_survey.personal.informasi_object_pembiayaan.bayar_angsuran_desc
    public String getPaymTypeDesc(Map<String, Object> map) {
        this.informasi_object_pembiayaan = jsonUtility.getNestedMap(personal, "informasi_object_pembiayaan");
        return jsonUtility.getStringValue(informasi_object_pembiayaan, "bayar_angsuran_desc");
    }

    // detail.reguler_survey.personal.informasi_object_pembiayaan.bank_desc
    public String getBankName(Map<String, Object> map) {
        return jsonUtility.getStringValue(informasi_object_pembiayaan, "bank_desc");
    }

    // appl_autodebit_acc_no
    public String getApplAutodebitAccNo(Map<String, Object> map) {
        return "";
    }

    // appl_autodebit_acc_name
    public String getApplAutodebitAccName(Map<String, Object> map) {
        return "";
    }

    // detail.object_pembiayaan.mkt_scheme_desc
    public String getApplMkppId(Map<String, Object> map) {
        return jsonUtility.getStringValue(object_pembiayaan, "mkt_scheme_desc");
    }

    // mkpp_desc
    public String getMkppDesc(Map<String, Object> map) {
        return "";
    }

    // detail.data_entry_completion.aplikasi.objek_jaminan[0].refund.refund_komisi_langsung
    // ! BASE IAIR
    public String getSubsidiDp(Map<String, Object> map) {
        Map<String, Object> refund = jsonUtility.getNestedMap(first_objek_jaminan, "refund");
        return jsonUtility.getStringValue(refund, "refund_komisi_langsung");
    }

    // joint_promo
    public String getJointPromo(Map<String, Object> map) {
        return "";
    }

    // adm_from_deal
    public String getAdmFromDeal(Map<String, Object> map) {
        return "";
    }

    // bbm_from_deal
    public String getBbmFromDeal(Map<String, Object> map) {
        return "";
    }

    // subs_potong_pelunasan
    public String getSubsPotongPelunasan(Map<String, Object> map) {
        return "";
    }

    // subsidi_klaim
    public String getSubsidiKlaim(Map<String, Object> map) {
        return "";
    }

    // disc_kom
    public String getDiscKom(Map<String, Object> map) {
        return "";
    }

    // detail.object_pembiayaan.refund.refund_discount
    public String getDiscount(Map<String, Object> map) {
        this.refund = jsonUtility.getNestedMap(object_pembiayaan, "refund");
        return jsonUtility.getStringValue(refund, "refund_discount");
    }

    // komisi_langsung
    public String getKomisiLangsung(Map<String, Object> map) {
        return "";
    }

    // detail.object_pembiayaan.refund.refund_admin_fee
    public String getAdmFromMu(Map<String, Object> map) {
        return jsonUtility.getStringValue(refund, "refund_admin_fee");
    }

    // detail.object_pembiayaan.refund.refund_biaya_balik_nama
    public String getBbmFromMu(Map<String, Object> map) {
        return jsonUtility.getStringValue(refund, "refund_biaya_balik_nama");
    }

    // detail.data_entry_completion.aplikasi.objek_jaminan[0].struktur_kredit.total_principal_amount
    public String getApplPrincipalAmt(Map<String, Object> map) {
        this.struktur_kredit = jsonUtility.getNestedMap(first_objek_jaminan, "struktur_kredit");
        return jsonUtility.getStringValue(struktur_kredit, "total_principal_amount");
    }

    // prin_plus_intr_amount (perhitungan)
    public String getPrinPlusIntrAmount(Map<String, Object> map) {
        // detail.object_pembiayaan.calculation_structure_credit.total_principal_amount
        this.CSC_total_principal_amount = jsonUtility.getStringValue(calculation_structure_credit,
                "total_principal_amount");
        // detail.object_pembiayaan.calculation_structure_credit.total_interest_amount
        this.CSC_total_interest_amount = jsonUtility.getStringValue(calculation_structure_credit,
                "total_interest_amount");
        Long appl_principal_amt = jsonUtility.parseLongOrNull(CSC_total_principal_amount);
        Long total_interest_amount = jsonUtility.parseLongOrNull(CSC_total_interest_amount);
        Long safePrincipalAmt = (appl_principal_amt != null) ? appl_principal_amt : 0L;
        Long safeInterestAmt = (total_interest_amount != null) ? total_interest_amount : 0L;
        Long result = safePrincipalAmt + safeInterestAmt;
        return Long.toString(result);
    }

    // detail.data_entry_completion.aplikasi.objek_jaminan[0].struktur_kredit.tenor
    public String getApplTop(Map<String, Object> map) {
        return jsonUtility.getStringValue(struktur_kredit, "tenor");
    }

    // detail.object_pembiayaan.calculation_structure_credit.admin_total_fee
    public String getTotAdmFee(Map<String, Object> map) {
        return jsonUtility.getStringValue(calculation_structure_credit, "admin_total_fee");
    }

    // detail.object_pembiayaan.calculation_structure_credit.admin_credit_fee
    public String getAdmFin(Map<String, Object> map) {
        return jsonUtility.getStringValue(calculation_structure_credit, "admin_credit_fee");
    }

    // detail.object_pembiayaan.calculation_structure_credit.admin_fee
    public String getAdmFee(Map<String, Object> map) {
        return jsonUtility.getStringValue(calculation_structure_credit, "admin_fee");
    }

    // detail.data_entry_completion.aplikasi.objek_jaminan[0].detail_objek_jaminan.automotive.obj_price
    public String getOtr(Map<String, Object> map) {
        return jsonUtility.getStringValue(automotive, "obj_price");
    }

    // detail.object_pembiayaan.calculation_structure_credit.admin_fee
    public String getApplAdmFee(Map<String, Object> map) {
        return jsonUtility.getStringValue(calculation_structure_credit, "admin_fee");
    }

    // detail.data_entry_completion.aplikasi.objek_jaminan[0].struktur_kredit.gross_dp
    public String getApplGrossDp(Map<String, Object> map) {
        return jsonUtility.getStringValue(struktur_kredit, "gross_dp");
    }

    // detail.data_entry_completion.aplikasi.objek_jaminan[0].struktru_kredit.nett_dp
    public String getApplNetDp(Map<String, Object> map) {
        return jsonUtility.getStringValue(struktur_kredit, "nett_dp");
    }

    // detail.data_entry_completion.aplikasi.objek_jaminan[0].struktur_kredit.resiko_jaminan_cabang
    public String getDpBranch(Map<String, Object> map) {
        return jsonUtility.getStringValue(struktur_kredit, "resiko_jaminan_cabang");
    }

    // detail.data_entry_completion.aplikasi.objek_jaminan[0].struktur_kredit.flat_rate
    public String getApplIntFlatRate(Map<String, Object> map) {
        return jsonUtility.getStringValue(struktur_kredit, "flat_rate");
    }

    // detail.data_entry_completion.aplikasi.objek_jaminan[0].struktur_kredit.eff_rate
    public String getApplIntEffRate(Map<String, Object> map) {
        return jsonUtility.getStringValue(struktur_kredit, "eff_rate");
    }

    // detail.object_pembiayaan.calculation_insurance.insurance_total_fee
    public String getApplTotInsFee(Map<String, Object> map) {
        this.calculation_insurance = jsonUtility.getNestedMap(object_pembiayaan, "calculation_insurance");
        return jsonUtility.getStringValue(calculation_insurance, "insurance_total_fee");
    }

    // detail.object_pembiayaan.calculation_insurance.insurance_credit_fee
    public String getApplInsrFinanced(Map<String, Object> map) {
        return jsonUtility.getStringValue(calculation_insurance, "insurance_credit_fee");
    }

    // detail.object_pembiayaan.calculation_insurance.insurance_fee
    public String getPaidInsFee(Map<String, Object> map) {
        return jsonUtility.getStringValue(calculation_insurance, "insurance_fee");
    }

    // detail.object_pembiayaan.calculation_insurance.nett_rate_insurance
    public String getApplInsrBuyRate(Map<String, Object> map) {
        return jsonUtility.getStringValue(calculation_insurance, "nett_rate_insurance");
    }

    // detail.data_entry_completion.aplikasi.objek_jaminan[0].struktur_kredit.installment_amount
    public String getApplInstAmt(Map<String, Object> map) {
        return jsonUtility.getStringValue(struktur_kredit, "installment_amount");
    }

    // tot_ins_fee2 (perhitungan)
    public String getTotInsFee2(Map<String, Object> map) {
        // 'detail' -> 'object_pembiayaan' -> 'calculation_additional_insurance' ->>
        // 'additional_insurance_credit_fee' )
        this.calculation_additional_insurance = jsonUtility.getNestedMap(object_pembiayaan,
                "calculation_additional_insurance");
        this.CAI_additional_insurance_credit_fee = jsonUtility.getStringValue(calculation_additional_insurance,
                "additional_insurance_credit_fee");
        String objtInsrFinancing2Str = CAI_additional_insurance_credit_fee;
        // 'detail' -> 'object_pembiayaan' -> 'calculation_additional_insurance' ->>
        // 'additional_insurance_fee' AS PAID_INSR_FEE2
        this.CAI_additional_insurance_fee = jsonUtility.getStringValue(calculation_additional_insurance,
                "additional_insurance_fee");
        String additionalInsuranceFeeStr = CAI_additional_insurance_fee;

        Long objtInsrFinancing2 = jsonUtility.parseLongOrNull(objtInsrFinancing2Str);
        Long additionalInsuranceFee = jsonUtility.parseLongOrNull(additionalInsuranceFeeStr);

        Long safeInsurance1 = (objtInsrFinancing2 != null) ? objtInsrFinancing2 : 0L;
        Long safeInsurance2 = (additionalInsuranceFee != null) ? additionalInsuranceFee : 0L;

        Long result = safeInsurance1 + safeInsurance2;
        return Long.toString(result);
    }

    // detail.object_pembiayaan.calculation_additional_insurance.additional_insurance_credit_fee
    public String getObjtInsrFinancing2(Map<String, Object> map) {
        return CAI_additional_insurance_credit_fee;
    }

    // detail.object_pembiayaan.calculation_additional_insurance.additional_insurance_fee
    public String getPaidInsrFee2(Map<String, Object> map) {
        return CAI_additional_insurance_fee;
    }

    // total_provisi (perhitungan)
    public String getTotalProvisi(Map<String, Object> map) {
        // detail.object_pembiayaan.calculation_structure_credit.provisi_fee AS
        // provisi_paid
        this.CAI_provisi_fee = jsonUtility.getStringValue(calculation_structure_credit, "provisi_fee");
        String provisi_paid = CAI_provisi_fee;
        // detail.object_pembiayaan.calculation_structure_credit.provisi_credit_fee AS
        // PROVISI_FIN
        this.CAI_provisi_credit_fee = jsonUtility.getStringValue(calculation_structure_credit, "provisi_credit_fee");
        String provisi_fin = CAI_provisi_credit_fee;

        Long provisiPaid = jsonUtility.parseLongOrNull(provisi_paid);
        Long provisiFin = jsonUtility.parseLongOrNull(provisi_fin);

        Long safeProvisiPaid = (provisiPaid != null) ? provisiPaid : 0L;
        Long safeProvisiFin = (provisiFin != null) ? provisiFin : 0L;

        Long result = safeProvisiPaid + safeProvisiFin;
        return Long.toString(result);
    }

    // detail.object_pembiayaan.calculation_structure_credit.provisi_fee
    public String getProvisiPaid(Map<String, Object> map) {
        return CAI_provisi_fee;
    }

    // detail.object_pembiayaan.calculation_structure_credit.provisi_credit_fee
    public String getProvisiFin(Map<String, Object> map) {
        return CAI_provisi_credit_fee;
    }

    // detail.data_entry_completion.aplikasi.objek_jaminan[0].struktur_kredit.installment_amount
    public String getInstalmentAmount(Map<String, Object> map) {
        return jsonUtility.getStringValue(struktur_kredit, "installment_amount");
    }

    // cust_type
    public String getCustType(Map<String, Object> map) {
        return jsonUtility.getStringValue(message, "applicant_type_desc");
    }

    // cust_no
    public String getCustNo(Map<String, Object> map) {
        return jsonUtility.getStringValue(message, "customer_no");
    }

    // cust_sid_name
    public String getCustSidName(Map<String, Object> map) {
        return jsonUtility.getStringValue(message, "customer_name");
    }

    // detail.debitur.personal.debitur_jenis_kelamin
    public String getSex(Map<String, Object> map) {
        return jsonUtility.getStringValue(personal, "debitur_jenis_kelamin");
    }

    // phone_no
    public String getPhoneNo(Map<String, Object> map) {
        return "";
    }

    // debitur_no_hp_1
    public String getDebiturNoHp1(Map<String, Object> map) {
        return "";
    }

    // cust_id_no
    public String getCustIdNo(Map<String, Object> map) {
        return "";
    }

    // mother_name
    public String getMotherName(Map<String, Object> map) {
        return "";
    }

    // cust_birth_date
    public String getCustBirthDate(Map<String, Object> map) {
        return "";
    }

    // cust_birth_place
    public String getCustBirthPlace(Map<String, Object> map) {
        return "";
    }

    // cust_monthly_income
    public String getCustMonthlyIncome(Map<String, Object> map) {
        return "";
    }

    // detail.debitur.personal.alamat_debitur.alamat_ktp.alamat
    public String getCustAddress(Map<String, Object> map) {
        Map<String, Object> alamat_debitur = jsonUtility.getNestedMap(personal, "alamat_debitur");
        this.alamat_ktp = jsonUtility.getNestedMap(alamat_debitur, "alamat_ktp");
        String alamat = jsonUtility.getStringValue(alamat_ktp, "alamat");
        return jsonUtility.regexCleaner(alamat);

    }

    // detail.debitur.personal.alamat_debitur.alamat_ktp.rt
    public String getRt(Map<String, Object> map) {
        return jsonUtility.getStringValue(alamat_ktp, "rt");
    }

    // detail.debitur.personal.alamat_debitur.alamat_ktp.rw
    public String getRw(Map<String, Object> map) {
        return jsonUtility.getStringValue(alamat_ktp, "rw");
    }

    // detail.debitur.personal.alamat_debitur.alamat_ktp.kode_pos
    public String getCustZipCode(Map<String, Object> map) {
        return jsonUtility.getStringValue(alamat_ktp, "kode_pos");
    }

    // detail.debitur.personal.alamat_debitur.alamat_ktp.desc_kelurahan
    public String getCustKelurahan(Map<String, Object> map) {
        return jsonUtility.getStringValue(alamat_ktp, "desc_kelurahan");
    }

    // detail.debitur.personal.alamat_debitur.alamat_ktp.desc_kecamatan
    public String getCustKecamatan(Map<String, Object> map) {
        return jsonUtility.getStringValue(alamat_ktp, "desc_kecamatan");
    }

    // detail.debitur.personal.alamat_debitur.alamat_ktp.desc_kab_kot
    public String getCustKabKota(Map<String, Object> map) {
        return jsonUtility.getStringValue(alamat_ktp, "desc_kab_kot");
    }

    // detail.debitur.personal.alamat_debitur.alamat_ktp.desc_provinsi
    public String getCustProvinsi(Map<String, Object> map) {
        return jsonUtility.getStringValue(alamat_ktp, "desc_provinsi");
    }

    // detail.debitur.personal.occupation.debitur.debitur_name_of_workplace
    public String getCompName(Map<String, Object> map) {
        this.occupation = jsonUtility.getNestedMap(personal, "occupation");
        this.occupationDebitur = jsonUtility.getNestedMap(occupation, "debitur");
        return jsonUtility.getStringValue(occupationDebitur, "debitur_name_of_workplace");
    }

    // detail.debitur.personal.occupation.debitur.debitur_company_type_desc
    public String getCompType(Map<String, Object> map) {
        return jsonUtility.getStringValue(occupationDebitur, "debitur_company_type_desc");
    }

    // detail.debitur.personal.occupation.debitur.debitur_economic_sector_one_desc
    public String getEconomicSec1(Map<String, Object> map) {
        return jsonUtility.getStringValue(occupationDebitur, "debitur_economic_sector_one_desc");
    }

    // detail.debitur.personal.occupation.debitur.debitur_economic_sector_two_desc
    public String getEconomicSec2(Map<String, Object> map) {
        return jsonUtility.getStringValue(occupationDebitur, "debitur_economic_sector_two_desc");
    }

    // detail.debitur.personal.occupation.debitur.debitur_economic_sector_three_desc
    public String getEconomicSec3(Map<String, Object> map) {
        return jsonUtility.getStringValue(occupationDebitur, "debitur_economic_sector_three_desc");
    }

    // nature_buss
    public String getNatureBuss(Map<String, Object> map) {
        return "";
    }

    // occupation_type : detail.debitur.personal.occupation.occupation_type_code
    public String getCustCurrYearOfWork(Map<String, Object> map) {
        this.occupation_type_code = jsonUtility.getStringValue(occupation, "occupation_type_code");
        if (occupation_type_code.equals("01")) {
            // detail.data_entry_completion.customer.occupation.debitur.debitur_total_working_time_year
            Map<String, Object> customer = jsonUtility.getNestedMap(data_entry_completion, "customer");
            Map<String, Object> occupation = jsonUtility.getNestedMap(customer, "occupation");
            this.DEC_occupation_debitur = jsonUtility.getNestedMap(occupation, "debitur");
            return jsonUtility.getStringValue(DEC_occupation_debitur, "debitur_total_working_time_year");
        } else {
            return "";
        }
    }

    // detail.data_entry_completion.customer.occupation.debitur.debitur_employee_status_desc
    public String getComStatusTempat(Map<String, Object> map) {
        return jsonUtility.getStringValue(DEC_occupation_debitur, "debitur_employee_status_desc");
    }

    // detail.data_entry_completion.customer.occupation.debitur.debitur_location_desc
    public String getComLokasiUsaha(Map<String, Object> map) {
        return jsonUtility.getStringValue(DEC_occupation_debitur, "debitur_location_desc");
    }

    // detail.data_entry_completion.customer.occupation.debitur.debitur_total_pegawai
    public String getComTotalEmployee(Map<String, Object> map) {
        return jsonUtility.getStringValue(DEC_occupation_debitur, "debitur_total_pegawai");
    }

    // occupation_type : detail.debitur.personal.occupation.occupation_type_code
    public String getComNoOfYearBuss(Map<String, Object> map) {
        if (occupation_type_code.equals("02")) {
            // detail.data_entry_completion.customer.occupation.debitur.debitur_total_working_time_year
            return jsonUtility.getStringValue(DEC_occupation_debitur, "debitur_total_working_time_year");
        } else {
            return "";
        }
    }

    // cust_pro_lama_profesi
    public String getCustProLamaProfesi(Map<String, Object> map) {
        return "";
    }

    // jenis_profesi
    public String getJenisProfesi(Map<String, Object> map) {
        return "";
    }

    // detail.approval.last_approval_date
    public String getApprovedDate(Map<String, Object> map) {
        this.approval = jsonUtility.getNestedMap(detail, "approval");
        return jsonUtility.getStringValue(approval, "last_approval_date");
    }

    // detail.approval.approval_status
    public String getStatusAppr(Map<String, Object> map) {
        return jsonUtility.getStringValue(approval, "approval_status");
    }

    // detail.cetakan_po_sipbpkb_cl.print_date
    public String getTanggalCetakPo(Map<String, Object> map) {
        this.cetakan_po_sipbpkb_cl = jsonUtility.getNestedMap(detail, "cetakan_po_sipbpkb_cl");
        return jsonUtility.getStringValue(cetakan_po_sipbpkb_cl, "print_date");
    }

    // detail.approval.approval_history[0].note
    @SuppressWarnings("unchecked")
    public String getApproveNote(Map<String, Object> map) {
        this.approval = jsonUtility.getNestedMap(detail, "approval");
        List<Map<String, Object>> approval_history = (List<Map<String, Object>>) approval.get("approval_history");
        if (approval_history != null && !approval_history.isEmpty()) {
            this.first_approval_history = approval_history.get(0);
            return jsonUtility.getStringValue(first_approval_history, "note");
        }
        return "";
    }

    // tanggal_fpd
    public String getTanggalFpd(Map<String, Object> map) {
        return "";
    }

    // no_fpd
    public String getNoFpd(Map<String, Object> map) {
        return "";
    }

    // detail.identitas_order.internal_sales_force[0].internal_sales_head_id
    @SuppressWarnings("unchecked")
    public String getNpkCmh(Map<String, Object> map) {
        List<Map<String, Object>> internal_sales_force = (List<Map<String, Object>>) identitas_order
                .get("internal_sales_force");
        if (internal_sales_force != null && !internal_sales_force.isEmpty()) {
            this.first_identitas_order_internal_sales_force = internal_sales_force.get(0);
            return jsonUtility.getStringValue(first_identitas_order_internal_sales_force, "internal_sales_head_id");
        }
        return "";
    }

    // detail.identitas_order.internal_sales_force[0].internal_sales_head_name
    public String getNamaCmh(Map<String, Object> map) {
        return jsonUtility.getStringValue(first_identitas_order_internal_sales_force, "internal_sales_head_name");
    }

    // detail.object_pembiayaan.calculation_structure_credit.type_installment_desc
    public String getInstallmentType(Map<String, Object> map) {
        return jsonUtility.getStringValue(calculation_structure_credit, "type_installment_desc");
    }

    // detail.object_pembiayaan.calculation_structure_credit.advance_arrear_desc
    public String getAdvanceArrear(Map<String, Object> map) {
        return jsonUtility.getStringValue(calculation_structure_credit, "advance_arrear_desc");
    }

    // detail.object_pembiayaan.obj_year
    public String getTahunKendaraan(Map<String, Object> map) {
        return jsonUtility.getStringValue(object_pembiayaan, "obj_year");
    }

    // detail.object_pembiayaan.calculation_insurance.insurance_total_fee
    public String getInsuranceFee(Map<String, Object> map) {
        return jsonUtility.getStringValue(calculation_insurance, "insurance_total_fee");
    }

    // appl_admf_komisi_amt
    public String getApplAdmfKomisiAmt(Map<String, Object> map) {
        return "";
    }

    // status_cancel
    public String getStatusCancel(Map<String, Object> map) {
        // 'detail'->'cetakan_po_sipbpkb_cl'->>'flag_cancel' as CANCEL_POCL
        String cancelPocl = jsonUtility.getStringValue(cetakan_po_sipbpkb_cl, "flag_cancel");
        // 'detail'->'reguler_survey'->>'flag_reguler_survey' as CANCEL_REGULER,
        this.reguler_survey = jsonUtility.getNestedMap(detail, "reguler_survey");
        String cancelReguler = jsonUtility.getStringValue(reguler_survey, "flag_reguler_survey");
        // 'detail' -> 'cancelation_status' ->> 'cancel_date' AS CANCEL_TODOLIST,
        Map<String, Object> cancelation_status = jsonUtility.getNestedMap(detail, "cancelation_status");
        String cancelTodolist = jsonUtility.getStringValue(cancelation_status, "cancel_date");
        // 'flag_kyc' as CANCEL_KYC,
        String cancelKyc = jsonUtility.getStringValue(message, "flag_kyc");
        if (cancelPocl.equals("Y")) {
            return "CANCEL PO";
        } else if (cancelPocl.equals("N")) {
            return "";
        } else if (cancelReguler.equals("CACN")) {
            return "CANCEL REGULER";
        } else if (cancelReguler.equals("SBMT")) {
            return "";
        } else if (cancelTodolist != null) {
            return "CANCEL TODO LIST";
        } else if (cancelKyc.equals("CANCEL KYC")) {
            return "CANCEL KYC";
        } else if (cancelKyc.equals("SUBMIT KYC")) {
            return "";
        } else {
            return "";
        }
    }

    // detail.cetakan_po_sipbpkb_cl.flag_cancel
    public String getCancelPocl(Map<String, Object> map) {
        return jsonUtility.getStringValue(cetakan_po_sipbpkb_cl, "flag_cancel");
    }

    // mufnet
    public String getMufnet(Map<String, Object> map) {
        return "";
    }

    // penggolongan_product
    public String getPenggolonganProduct(Map<String, Object> map) {
        return "";
    }

    // bank_wilayah_mdr
    public String getBankWilayahMdr(Map<String, Object> map) {
        return "";
    }

    // bank_area_mdr
    public String getBankAreaMdr(Map<String, Object> map) {
        return "";
    }

    // flag_cancel
    public String getFlagCancel(Map<String, Object> map) {
        return "";
    }

    // cancel_ppd_date
    public String getCancelPpdDate(Map<String, Object> map) {
        return "";
    }

    // status_repo
    public String getStatusRepo(Map<String, Object> map) {
        return "";
    }

    // Case when job_code_mca = 121
    // job_code_mca : 'detail' -> 'approval'-> 'approval_history' -> 0->> 'jobCode'
    // AS JOB_CODE_MCA
    public String getNikMca(Map<String, Object> map) {
        this.job_code_mca = jsonUtility.getStringValue(first_approval_history, "jobCode");
        if (job_code_mca.equals("121")) {
            // detail.approval.approval_history[0].nik
            return jsonUtility.getStringValue(first_approval_history, "nik");
        } else {
            return "";
        }
    }

    public String getNamaMca(Map<String, Object> map) {
        if (job_code_mca.equals("121")) {
            // detail.approval.approval_history[0].name
            return jsonUtility.getStringValue(first_approval_history, "name");
        } else {
            return "";
        }
    }

    // first_name
    public String getFirstName(Map<String, Object> map) {
        return "";
    }

    // detail.debitur.personal.debitur_nama_sesuai_ktp
    public String getLastName(Map<String, Object> map) {
        return jsonUtility.getStringValue(personal, "debitur_nama_sesuai_ktp");
    }

    // detail.object_pembiayaan.calculation_insurance.insurance_type_code
    public String getInsuranceTypeCode(Map<String, Object> map) {
        return jsonUtility.getStringValue(calculation_insurance, "insurance_type_code");
    }

    // detail.object_pembiayaan.calculation_insurance.insurance_type_desc
    public String getInsuranceType(Map<String, Object> map) {
        return jsonUtility.getStringValue(calculation_insurance, "insurance_type_desc");
    }

    // detail.data_entry_completion.aplikasi.objek_jaminan[0].detal_objek_jaminan.automotive.nama_bpkb
    public String getNamaBpkb(Map<String, Object> map) {
        return jsonUtility.getStringValue(automotive, "nama_bpkb");
    }

    // detail.debitur.personal.occupation.occupation_type_desc
    public String getOccupation(Map<String, Object> map) {
        return jsonUtility.getStringValue(occupation, "occupation_type_desc");
    }

    // detail.object_pembiayaan.unit_availability_desc
    public String getStatusIndent(Map<String, Object> map) {
        return jsonUtility.getStringValue(object_pembiayaan, "unit_availability_desc");
    }

    // cancel_reject_date_ca
    public String getCancelRejectDateCa(Map<String, Object> map) {
        return "";
    }

    // cancel_reject_date_mkt
    public String getCancelRejectDateMkt(Map<String, Object> map) {
        return "";
    }

    // 'detail' -> 'object_pembiayaan' -> 'calculation_structure_credit' ->>
    // 'total_principal_amount' ) :: FLOAT AS APPL_PRINCIPAL_AMT
    // contoh value : "total_principal_amount": "16819968",,
    // 'detail' -> 'object_pembiayaan' ->> 'obj_price' ) :: FLOAT AS OTR,
    // contoh value : "obj_price": "19118000",
    public String getLtv(Map<String, Object> map) {
        String appl_principal_amt = jsonUtility.getStringValue(calculation_structure_credit,
                "total_principal_amount");
        String otr = jsonUtility.getStringValue(object_pembiayaan, "obj_price");
        System.out.println("appl_principal_amt: " + appl_principal_amt);
        System.out.println("otr: " + otr);
        Long safePrincipalAmt = null;
        Long safeOtr = null;
        try {
            if (appl_principal_amt != null && !appl_principal_amt.trim().isEmpty()) {
                safePrincipalAmt = Long.valueOf(appl_principal_amt);
            }
        } catch (NumberFormatException e) {
            safePrincipalAmt = null;
        }
        try {
            if (otr != null && !otr.trim().isEmpty()) {
                safeOtr = Long.valueOf(otr);
            }
        } catch (NumberFormatException e) {
            safeOtr = null;
        }
        if (safeOtr == null || safeOtr == 0) {
            return "0";
        }
        if (safePrincipalAmt == null) {
            return "0";
        }
        Long ltv = safePrincipalAmt / safeOtr;
        return Long.toString(ltv);
    }

    // detail.reguler_survey.personal.informasi_nasabah.inf_debitur.inf_marital_desc
    public String getMarital(Map<String, Object> map) {
        this.reguler_survey_personal = jsonUtility.getNestedMap(reguler_survey, "personal");
        Map<String, Object> informasi_nasabah = jsonUtility.getNestedMap(reguler_survey_personal, "informasi_nasabah");
        Map<String, Object> inf_debitur = jsonUtility.getNestedMap(informasi_nasabah, "inf_debitur");
        return jsonUtility.getStringValue(inf_debitur, "inf_marital_desc");
    }

    // detail.debitur.personal.debitur_education_desc

    public String getEducation(Map<String, Object> map) {
        return jsonUtility.getStringValue(personal, "debitur_education_desc");
    }

    // status_jf_bmri
    public String getStatusJfBmri(Map<String, Object> map) {
        return "";
    }

    // prin_jf_bmri
    public String getPrinJfBmri(Map<String, Object> map) {
        return "";
    }

    // intr_jf_bmri
    public String getIntrJfBmri(Map<String, Object> map) {
        return "";
    }

    // detail.reguler_survey.personal.informasi_object_pembiayaan.product_marketing_desc
    public String getMktProd(Map<String, Object> map) {
        return jsonUtility.getStringValue(informasi_object_pembiayaan, "product_marketing_desc");
    }

    // detail.identitas_order.sumber_nasabah_desc
    public String getSumberNasabah(Map<String, Object> map) {
        return jsonUtility.getStringValue(identitas_order, "sumber_nasabah_desc");
    }

    // mkt_program_desc
    public String getProgramm(Map<String, Object> map) {
        return jsonUtility.getStringValue(message, "mkt_program_desc");
    }

    // detail.debitur.personal.debitur_education_id
    public String getEducationCode(Map<String, Object> map) {
        return jsonUtility.getStringValue(personal, "debitur_education_id");
    }

    // detail.debitur.personal.occupation.occupation_type_code
    public String getOccupationCode(Map<String, Object> map) {
        return jsonUtility.getStringValue(occupation, "occupation_type_code");
    }

    // detail.debitur.personal.occupation.debitur.debitur_economic_sector_one_id
    public String getEconomicSectorCode1(Map<String, Object> map) {
        return jsonUtility.getStringValue(occupationDebitur, "debitur_economic_sector_one_id");
    }

    // detail.debitur.personal.occupation.debitur.debitur_economic_sector_two_id
    public String getEconomicSectorCode2(Map<String, Object> map) {
        return jsonUtility.getStringValue(occupationDebitur, "debitur_economic_sector_two_id");
    }

    // detail.debitur.personal.occupation.debitur.debitur_economic_sector_three_id
    public String getEconomicSectorCode3(Map<String, Object> map) {
        return jsonUtility.getStringValue(occupationDebitur, "debitur_economic_sector_three_id");
    }

    // grading_customer_category
    public String getRoAo(Map<String, Object> map) {
        return jsonUtility.getStringValue(message, "grading_customer_category");
    }

    // detail.debitur.personal.income.debitur.debitur_dbr
    public String getDsr(Map<String, Object> map) {
        Map<String, Object> income = jsonUtility.getNestedMap(personal, "income");
        Map<String, Object> debitur = jsonUtility.getNestedMap(income, "debitur");
        return jsonUtility.getStringValue(debitur, "debitur_dbr");
    }

    // detail.object_pembiayaan.obj_insr_group_desc
    public String getVehicleType(Map<String, Object> map) {
        return jsonUtility.getStringValue(object_pembiayaan, "obj_insr_group_desc");
    }

    // detail.debitur.personal.debitur_number_of_dependent
    public String getDependent(Map<String, Object> map) {
        return jsonUtility.getStringValue(personal, "debitur_number_of_dependent");
    }

    // detail.data_entry_completion.survey.data_kepemilikan.detail_rumah.year_of_living
    // (VERDAT)
    // detail.reguler_survey.personal.informasi_survey.data_informan.[0].deb_tinggal_tahun
    @SuppressWarnings("unchecked")
    public String getLamaTinggal(Map<String, Object> map) {
        Map<String, Object> informasi_survey = jsonUtility.getNestedMap(personal, "informasi_survey");
        List<Map<String, Object>> data_informan = (List<Map<String, Object>>) informasi_survey
                .get("data_informan");
        if (data_informan != null && !data_informan.isEmpty()) {
            Map<String, Object> first_data_informan = data_informan.get(0);
            return jsonUtility.getStringValue(first_data_informan, "deb_tinggal_tahun");
        }
        return "";
    }

    // bal_prin
    public String getBalPrin(Map<String, Object> map) {
        return "";
    }

    // ovd
    public String getOvd(Map<String, Object> map) {
        return "";
    }

    // first_installment_method
    public String getFirstInstallmentMethod(Map<String, Object> map) {
        return "";
    }

    // status_aging
    public String getStatusAging(Map<String, Object> map) {
        return "";
    }

    // source_order_desc
    public String getSumberDataDesc(Map<String, Object> map) {
        this.source_order_desc = jsonUtility.getStringValue(message, "source_order_desc");
        return source_order_desc;
    }

    // source_order_desc
    public String getSumberOrderDesc(Map<String, Object> map) {
        return source_order_desc;
    }

    // object_pembiayaan; // detail.object_pembiayaan
    // 'detail' -> 'object_pembiayaan' ->> 'obj_code' AS PORTFOLIO_CODE,
    // 'detail' -> 'identitas_order' ->> 'jenis_channel_code' AS jenis_channel_code,
    // 'detail' -> 'identitas_order' ->> 'obj_pembiayaan' AS obj_pembiayaan,
    public String getPortfolioCode(Map<String, Object> map) {
        this.obj_code = jsonUtility.getStringValue(object_pembiayaan, "obj_code");
        String portfolio_code = obj_code;
        this.jenis_channel_code = jsonUtility.getStringValue(identitas_order, "jenis_channel_code");
        this.obj_pembiayaan = jsonUtility.getStringValue(identitas_order, "obj_pembiayaan");

        if (jenis_channel_code.equals("02")) {
            if (portfolio_code.equals("001") || portfolio_code.equals("002")) {
                return "CMCY";
            } else if (portfolio_code.equals("003") || portfolio_code.equals("004")) {
                return "CCAR";
            }
        } else if (!jenis_channel_code.equals("02")) {
            if (obj_pembiayaan.equals("FO02")) {
                if (portfolio_code.equals("001") || portfolio_code.equals("002")) {
                    return "MMCY";
                } else if (portfolio_code.equals("003") || portfolio_code.equals("004")) {
                    return "MCAR";
                }
            }
        }
        switch (portfolio_code) {
            case "001":
                return "NMCY";
            case "002":
                return "UMCY";
            case "003":
                return "NCAR";
            case "004":
                return "UCAR";
            default:
                return "UNKNOWN";
        }

    }

    public String getPortfolioDesc(Map<String, Object> map) {
        String portfolio_code = obj_code;
        if (jenis_channel_code.equals("02")) {
            if (portfolio_code.equals("001") || portfolio_code.equals("002")) {
                return "CAPTIVE MOTORCYCLE";
            } else if (portfolio_code.equals("003") || portfolio_code.equals("004")) {
                return "CAPTIVE CAR";
            }
        } else if (!jenis_channel_code.equals("02")) {
            if (obj_pembiayaan.equals("FO02")) {
                if (portfolio_code.equals("001") || portfolio_code.equals("002")) {
                    return "MULTIGUNA MOTORCYCLE";
                } else if (portfolio_code.equals("003") || portfolio_code.equals("004")) {
                    return "MULTIGUNA CAR";
                }
            }
        }
        switch (portfolio_code) {
            case "001":
                return "NMCY";
            case "002":
                return "UMCY";
            case "003":
                return "NCAR";
            case "004":
                return "UCAR";
            default:
                return "UNKNOWN";
        }

    }

    // detail.object_pembiayaan.obj_model_group_code
    public String getMogrCode(Map<String, Object> map) {
        return jsonUtility.getStringValue(object_pembiayaan, "obj_model_group_code");
    }

    // detail.object_pembiayaan.obj_model_group_desc
    public String getMogrDesc(Map<String, Object> map) {
        return jsonUtility.getStringValue(object_pembiayaan, "obj_model_group_desc");
    }

    // detail.object_pembiayaan.type_genre_desc
    public String getObmoGenre(Map<String, Object> map) {
        return jsonUtility.getStringValue(object_pembiayaan, "type_genre_desc");
    }

    // npk_cmh_2
    public String getNpkCmh2(Map<String, Object> map) {
        return "";
    }

    // nama_cmh_2
    public String getNamaCmh2(Map<String, Object> map) {
        return "";
    }

    // tipe_restructuring
    public String getTipeRestructuring(Map<String, Object> map) {
        return "";
    }

    // detail.identitas_order.old_contract_no
    public String getNoContractOld(Map<String, Object> map) {
        return jsonUtility.getStringValue(identitas_order, "old_contract_no");
    }

    // screening_1_date
    public String getScreening1Date(Map<String, Object> map) {
        return jsonUtility.getStringValue(message, "screening_1_date");
    }

    // screening_2_date
    public String getScreening2Date(Map<String, Object> map) {
        return jsonUtility.getStringValue(message, "screening_2_date");
    }

    // detail.reguler_survey.created_date
    public String getInsertDateRegulerSurvey(Map<String, Object> map) {
        return jsonUtility.getStringValue(reguler_survey, "created_date");
    }

    // screening_3_date
    public String getScreening3Date(Map<String, Object> map) {
        return jsonUtility.getStringValue(message, "screening_3_date");
    }

    // nik_1
    public String getNik1(Map<String, Object> map) {
        return "";
    }

    // nama_1
    public String getNama1(Map<String, Object> map) {
        return "";
    }

    // jobcode_1
    public String getJobcode1(Map<String, Object> map) {
        return "";
    }

    // result_1
    public String getResult1(Map<String, Object> map) {
        return "";
    }

    // date_1
    public String getDate1(Map<String, Object> map) {
        return "";
    }

    // nik_2
    public String getNik2(Map<String, Object> map) {
        return "";
    }

    // nama_2
    public String getNama2(Map<String, Object> map) {
        return "";
    }

    // jobcode_2
    public String getJobcode2(Map<String, Object> map) {
        return "";
    }

    // result_2
    public String getResult2(Map<String, Object> map) {
        return "";
    }

    // date_2
    public String getDate2(Map<String, Object> map) {
        return "";
    }

    // nik_3
    public String getNik3(Map<String, Object> map) {
        return "";
    }

    // nama_3
    public String getNama3(Map<String, Object> map) {
        return "";
    }

    // jobcode_3
    public String getJobcode3(Map<String, Object> map) {
        return "";
    }

    // result_3
    public String getResult3(Map<String, Object> map) {
        return "";
    }

    // date_3
    public String getDate3(Map<String, Object> map) {
        return "";
    }

    // nik_4
    public String getNik4(Map<String, Object> map) {
        return "";
    }

    // nama_4
    public String getNama4(Map<String, Object> map) {
        return "";
    }

    // jobcode_4
    public String getJobcode4(Map<String, Object> map) {
        return "";
    }

    // result_4
    public String getResult4(Map<String, Object> map) {
        return "";
    }

    // date_4
    public String getDate4(Map<String, Object> map) {
        return "";
    }

    // nik_5
    public String getNik5(Map<String, Object> map) {
        return "";
    }

    // nama_5
    public String getNama5(Map<String, Object> map) {
        return "";
    }

    // jobcode_5
    public String getJobcode5(Map<String, Object> map) {
        return "";
    }

    // result_5
    public String getResult5(Map<String, Object> map) {
        return "";
    }

    // date_5
    public String getDate5(Map<String, Object> map) {
        return "";
    }

    // nik_6
    public String getNik6(Map<String, Object> map) {
        return "";
    }

    // nama_6
    public String getNama6(Map<String, Object> map) {
        return "";
    }

    // jobcode_6
    public String getJobcode6(Map<String, Object> map) {
        return "";
    }

    // result_6
    public String getResult6(Map<String, Object> map) {
        return "";
    }

    // date_6
    public String getDate6(Map<String, Object> map) {
        return "";
    }

    // nik_7
    public String getNik7(Map<String, Object> map) {
        return "";
    }

    // nama_7
    public String getNama7(Map<String, Object> map) {
        return "";
    }

    // jobcode_7
    public String getJobcode7(Map<String, Object> map) {
        return "";
    }

    // result_7
    public String getResult7(Map<String, Object> map) {
        return "";
    }

    // date_7
    public String getDate7(Map<String, Object> map) {
        return "";
    }

    // nik_8
    public String getNik8(Map<String, Object> map) {
        return "";
    }

    // nama_8
    public String getNama8(Map<String, Object> map) {
        return "";
    }

    // jobcode_8
    public String getJobcode8(Map<String, Object> map) {
        return "";
    }

    // result_8
    public String getResult8(Map<String, Object> map) {
        return "";
    }

    // date_8
    public String getDate8(Map<String, Object> map) {
        return "";
    }

    // nik_9
    public String getNik9(Map<String, Object> map) {
        return "";
    }

    // nama_9
    public String getNama9(Map<String, Object> map) {
        return "";
    }

    // jobcode_9
    public String getJobcode9(Map<String, Object> map) {
        return "";
    }

    // result_9
    public String getResult9(Map<String, Object> map) {
        return "";
    }

    // date_9
    public String getDate9(Map<String, Object> map) {
        return "";
    }

    // nik_10
    public String getNik10(Map<String, Object> map) {
        return "";
    }

    // nama_10
    public String getNama10(Map<String, Object> map) {
        return "";
    }

    // jobcode_10
    public String getJobcode10(Map<String, Object> map) {
        return "";
    }

    // result_10
    public String getResult10(Map<String, Object> map) {
        return "";
    }

    // date_10
    public String getDate10(Map<String, Object> map) {
        return "";
    }

    // nik_11
    public String getNik11(Map<String, Object> map) {
        return "";
    }

    // nama_11
    public String getNama11(Map<String, Object> map) {
        return "";
    }

    // jobcode_11
    public String getJobcode11(Map<String, Object> map) {
        return "";
    }

    // result_11
    public String getResult11(Map<String, Object> map) {
        return "";
    }

    // date_11
    public String getDate11(Map<String, Object> map) {
        return "";
    }

    // nik_12
    public String getNik12(Map<String, Object> map) {
        return "";
    }

    // nama_12
    public String getNama12(Map<String, Object> map) {
        return "";
    }

    // jobcode_12
    public String getJobcode12(Map<String, Object> map) {
        return "";
    }

    // result_12
    public String getResult12(Map<String, Object> map) {
        return "";
    }

    // date_12
    public String getDate12(Map<String, Object> map) {
        return "";
    }

    // nik_13
    public String getNik13(Map<String, Object> map) {
        return "";
    }

    // nama_13
    public String getNama13(Map<String, Object> map) {
        return "";
    }

    // jobcode_13
    public String getJobcode13(Map<String, Object> map) {
        return "";
    }

    // result_13
    public String getResult13(Map<String, Object> map) {
        return "";
    }

    // date_13
    public String getDate13(Map<String, Object> map) {
        return "";
    }

    // nik_14
    public String getNik14(Map<String, Object> map) {
        return "";
    }

    // nama_14
    public String getNama14(Map<String, Object> map) {
        return "";
    }

    // jobcode_14
    public String getJobcode14(Map<String, Object> map) {
        return "";
    }

    // result_14
    public String getResult14(Map<String, Object> map) {
        return "";
    }

    // date_14
    public String getDate14(Map<String, Object> map) {
        return "";
    }

    // nik_15
    public String getNik15(Map<String, Object> map) {
        return "";
    }

    // nama_15
    public String getNama15(Map<String, Object> map) {
        return "";
    }

    // jobcode_15
    public String getJobcode15(Map<String, Object> map) {
        return "";
    }

    // result_15
    public String getResult15(Map<String, Object> map) {
        return "";
    }

    // date_15
    public String getDate15(Map<String, Object> map) {
        return "";
    }

    // date_cancel_reguler
    public String getDateCancelReguler(Map<String, Object> map) {
        // 'detail'->'reguler_survey'->>'flag_reguler_survey' as CANCEL_REGULER,
        String cancel_reguler = jsonUtility.getStringValue(reguler_survey, "flag_reguler_survey");
        if (cancel_reguler.equals("CACN")) {
            // 'detail'->'reguler_survey'->>'created_date' as DATE_CANCEL_REGULER,
            return jsonUtility.getStringValue(reguler_survey, "created_date");
        } else if (cancel_reguler.equals("SBMT")) {
            return "";
        } else {
            return "";
        }
    }

    // 'detail'->'cetakan_po_sipbpkb_cl'->'data_cancel'->>'cancel_date' as
    // DATE_CANCEL_POCL
    public String getDateCancelPocl(Map<String, Object> map) {
        Map<String, Object> data_cancel = jsonUtility.getNestedMap(cetakan_po_sipbpkb_cl, "data_cancel");
        return jsonUtility.getStringValue(data_cancel, "cancel_date");
    }

    // detail.cetakan_po_sipbpkb_cl.insert_date
    public String getInsertDatePocl(Map<String, Object> map) {
        return jsonUtility.getStringValue(cetakan_po_sipbpkb_cl, "insert_date");
    }

    // detail.cetakan_po_sipbpkb_cl.print_date
    public String getPrintDatePocl(Map<String, Object> map) {
        return jsonUtility.getStringValue(cetakan_po_sipbpkb_cl, "print_date");
    }

    // date_full_data_entry
    public String getDateFullDataEntry(Map<String, Object> map) {
        return "";
    }

    // cancel_todolist
    public String getCancelTodolist(Map<String, Object> map) {
        return "";
    }

    // date_cancel_kyc
    public String getDateCancelKyc(Map<String, Object> map) {
        return "";
    }

    // detail.identitas_order.fin_scheme_desc
    public String getFinProdDesc(Map<String, Object> map) {
        return jsonUtility.getStringValue(identitas_order, "fin_scheme_desc");
    }

    // detail.identitas_order.type_of_financing_desc
    public String getFinPurposeDesc(Map<String, Object> map) {
        return jsonUtility.getStringValue(identitas_order, "type_of_financing_desc");
    }

    // detail.object_pembiayaan.nature_of_financing_desc
    public String getNatureOfFinancing(Map<String, Object> map) {
        return jsonUtility.getStringValue(object_pembiayaan, "nature_of_financing_desc");
    }

    // screening_1
    public String getInitial1(Map<String, Object> map) {
        return jsonUtility.getStringValue(message, "screening_1");
    }

    // outlet
    // 'detail'->'identitas_order' ->> 'outlet_code' as outlet_code,
    // 'detail' -> 'identitas_order' ->> 'outlet_desc' as outlet_desc
    // ff.outlet_code || ' - ' || ff.outlet_desc as outlet,
    public String getOutlet(Map<String, Object> map) {
        String outlet_code = jsonUtility.getStringValue(identitas_order, "outlet_code");
        String outlet_desc = jsonUtility.getStringValue(identitas_order, "outlet_desc");
        return outlet_code + " - " + outlet_desc;
    }

    public String getInternalSalesForce2Code(Map<String, Object> map) {
        // 'detail' -> 'identitas_order' -> 'internal_sales_force' -> 0
        // ->>'internal_sales_type_code' as internal_sales_force_type_code
        this.internal_sales_force_type_code = jsonUtility.getStringValue(first_identitas_order_internal_sales_force,
                "internal_sales_type_code");
        if (internal_sales_force_type_code.equals("6")) {
            // 'detail' -> 'identitas_order' -> 'internal_sales_force' -> 0->>
            // 'internal_sales_force_npk' AS INTERNAL_SALES_FORCE_CODE,
            return jsonUtility.getStringValue(first_identitas_order_internal_sales_force, "internal_sales_force_npk");
        } else {
            return "";
        }
    }

    public String getInternalSalesForce2Nik(Map<String, Object> map) {
        if (internal_sales_force_type_code.equals("6")) {
            // detail.identitas_order.internal_sales_force[0].internal_sales_force_id
            return jsonUtility.getStringValue(first_identitas_order_internal_sales_force, "internal_sales_force_id");
        } else {
            return "";
        }
    }

    public String getInternalSalesForce2Name(Map<String, Object> map) {
        if (internal_sales_force_type_code.equals("6")) {
            // detail.identitas_order.internal_sales_force[0].internal_sales_force_desc
            return jsonUtility.getStringValue(first_identitas_order_internal_sales_force, "internal_sales_force_desc");
        } else {
            return "";
        }
    }

    public String getInternalSalesForce2Job(Map<String, Object> map) {
        if (internal_sales_force_type_code.equals("6")) {
            // detail.identitas_order.internal_sales_force[0].internal_sales_job_desc
            return jsonUtility.getStringValue(first_identitas_order_internal_sales_force, "internal_sales_job_desc");
        } else {
            return "";
        }
    }

    // screening_2
    public String getInitial2(Map<String, Object> map) {
        return jsonUtility.getStringValue(message, "screening_2");
    }

    // pengajuan_telesurvey
    public String getPengajuanTelesurvey(Map<String, Object> map) {
        return "";
    }

    // proses_pembiayaan_telesurvey
    public String getProsesPembiayaanTelesurvey(Map<String, Object> map) {
        return "";
    }

    // date_telesurvey
    public String getDateTelesurvey(Map<String, Object> map) {
        return "";
    }

    // insert_by_telesurvey
    public String getInsertByTelesurvey(Map<String, Object> map) {
        return "";
    }

    // status_kyc
    public String getStatusKyc(Map<String, Object> map) {
        return "";
    }

    // date_kyc
    public String getDateKyc(Map<String, Object> map) {
        return "";
    }

    // insert_by_kyc
    public String getInsertByKyc(Map<String, Object> map) {
        return "";
    }

    // hasil_kyc
    public String getHasilKyc(Map<String, Object> map) {
        return "";
    }

    // detail.debitur.personal.debitur_area_branch_id
    public String getAreaId(Map<String, Object> map) {
        return jsonUtility.getStringValue(personal, "debitur_area_branch_id");
    }

    // insert_date
    public String getInsertDate(Map<String, Object> map) {
        return "";
    }

    // update_date
    public String getUpdateDate(Map<String, Object> map) {
        return "";
    }

    // detail.object_pembiayaan.calculation_insurance.insurance_company_desc
    public String getAsuransiKendaraan(Map<String, Object> map) {
        return jsonUtility.getStringValue(calculation_insurance, "insurance_company_desc");
    }

    // detail.object_pembiayaan.calculation_additional_insurance.additional_insurance_company_desc
    public String getAsuransiTambahan(Map<String, Object> map) {
        return jsonUtility.getStringValue(calculation_additional_insurance, "additional_insurance_company_desc");
    }

    // detail.data_entry_completion.aplikasi.objek_jaminan[0].detail_objek_jaminan.automotive.kapasitas
    public String getEngCapacity(Map<String, Object> map) {
        return jsonUtility.getStringValue(automotive, "kapasitas");
    }

    // detail.identitas_order.fin_scheme_desc
    public String getSkemaPembiayaan(Map<String, Object> map) {
        return jsonUtility.getStringValue(identitas_order, "fin_scheme_desc");
    }

    // detail.object_pembiayaan.calculation_structure_credit.total_interest_amount
    public String getTotalInterestAmount(Map<String, Object> map) {
        return CSC_total_interest_amount;
    }

    // detail.object_pembiayaan.calculation_insurance.insurance_credit_fee
    public String getInsuranceCreditFee(Map<String, Object> map) {
        return jsonUtility.getStringValue(calculation_insurance, "insurance_credit_fee");
    }

    // jatuh_tempo
    public String getJatuhTempo(Map<String, Object> map) {
        return "";
    }

    // detail.identitas_order.obj_pembiayaan
    public String getObjPembiayaan(Map<String, Object> map) {
        return jsonUtility.getStringValue(identitas_order, "obj_pembiayaan");
    }

    // detail.identitas_order.internal_sales_force[0].internal_sales_head_name
    public String getInternalSalesHead(Map<String, Object> map) {
        return jsonUtility.getStringValue(first_identitas_order_internal_sales_force, "internal_sales_head_name");
    }

    // detail.data_entry_completion.aplikasi.informasi_aplikasi.financing_scheme_code
    public String getFinSchemeCode(Map<String, Object> map) {
        return jsonUtility.getStringValue(informasi_aplikasi, "financing_scheme_code");
    }

    // no_obligor_id
    public String getNoObligorId(Map<String, Object> map) {
        return "";
    }

    // no_po_cl
    public String getNoPoCl(Map<String, Object> map) {
        return "";
    }

    // interest_amount
    public String getInterestAmount(Map<String, Object> map) {
        return "";
    }

    // biaya_asuransi_tambahan
    public String getBiayaAsuransiTambahan(Map<String, Object> map) {
        return "";
    }

    // job_internal_sales_forced
    public String getJobInternalSalesForced(Map<String, Object> map) {
        return "";
    }

    // nama_internal_sales_forced
    public String getNamaInternalSalesForced(Map<String, Object> map) {
        return "";
    }

    // keterangan_po
    public String getKeteranganPo(Map<String, Object> map) {
        return "";
    }

    // nilai_pelunasan
    public String getNilaiPelunasan(Map<String, Object> map) {
        return "";
    }

    // alasan_cancel_po_cl
    public String getAlasanCancelPoCl(Map<String, Object> map) {
        return "";
    }

    // notes_cancel_po_cl
    public String getNotesCancelPoCl(Map<String, Object> map) {
        return "";
    }

    // nik_reject_cancel_marketing
    public String getNikRejectCancelMarketing(Map<String, Object> map) {
        return "";
    }

    // user_reject_cancel_marketing
    public String getUserRejectCancelMarketing(Map<String, Object> map) {
        return "";
    }

    // pic_dealer
    public String getPicDealer(Map<String, Object> map) {
        return "";
    }

    // flagging_reject_cancel_mkt
    public String getFlaggingRejectCancelMkt(Map<String, Object> map) {
        return "";
    }

    // deskripsi_reject_cancel_mkt
    public String getDeskripsiRejectCancelMkt(Map<String, Object> map) {
        return "";
    }

    // alasan_reject_cancel_mkt
    public String getAlasanRejectCancelMkt(Map<String, Object> map) {
        return "";
    }

    // reject_cancel_source_app
    public String getRejectCancelSourceApp(Map<String, Object> map) {
        return "";
    }

    // deskripsi_source_aplikasi
    public String getDeskripsiSourceAplikasi(Map<String, Object> map) {
        return "";
    }

    // alasan_koreksi_po
    public String getAlasanKoreksiPo(Map<String, Object> map) {
        return "";
    }

    // nik_koreksi_po
    public String getNikKoreksiPo(Map<String, Object> map) {
        return "";
    }

    // tanggal_koreksi_po
    public String getTanggalKoreksiPo(Map<String, Object> map) {
        return "";
    }

    // total_koreksi_po
    public String getTotalKoreksiPo(Map<String, Object> map) {
        return "";
    }

    // cara_bayar_angsuran
    public String getCaraBayarAngsuran(Map<String, Object> map) {
        return "";
    }

    // status_aplikasi
    public String getStatusAplikasi(Map<String, Object> map) {
        return "";
    }

    // jumlah_nasabah_ditolak
    public String getJumlahNasabahDitolak(Map<String, Object> map) {
        return "";
    }

    // jumlah_cetak_po_cl
    public String getJumlahCetakPoCl(Map<String, Object> map) {
        return "";
    }

    // jumlah_po_cl_belum_cetak
    public String getJumlahPoClBelumCetak(Map<String, Object> map) {
        return "";
    }

    // jumlah_cancel_po_cl
    public String getJumlahCancelPoCl(Map<String, Object> map) {
        return "";
    }

    // jumlah_koreksi_po_cl
    public String getJumlahKoreksiPoCl(Map<String, Object> map) {
        return "";
    }

    // jumlah_po_cl_pending
    public String getJumlahPoClPending(Map<String, Object> map) {
        return "";
    }

    // jumlah_nasabah_cancel_ppd
    public String getJumlahNasabahCancelPpd(Map<String, Object> map) {
        return "";
    }

    // jumlah_tagihan_belum_ppd
    public String getJumlahTagihanBelumPpd(Map<String, Object> map) {
        return "";
    }

    // jumlah_reject_cancel_marketing
    public String getJumlahRejectCancelMarketing(Map<String, Object> map) {
        return "";
    }

    // tipe_debitur
    public String getTipeDebitur(Map<String, Object> map) {
        return "";
    }

    // tanggal_entry
    public String getTanggalEntry(Map<String, Object> map) {
        return "";
    }

    // tanggal_approval
    public String getTanggalApproval(Map<String, Object> map) {
        return "";
    }

    // tanggal_cetak
    public String getTanggalCetak(Map<String, Object> map) {
        return "";
    }

    // tanggal_cancel
    public String getTanggalCancel(Map<String, Object> map) {
        return "";
    }

    // tanggal_koreksi
    public String getTanggalKoreksi(Map<String, Object> map) {
        return "";
    }

}
