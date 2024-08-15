package com.datalake.datalake_subscriber_java.processors;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.datalake.datalake_subscriber_java.entities.DatalakeEntity;
import com.datalake.datalake_subscriber_java.extractors.VerdatDataExtractor;
import com.datalake.datalake_subscriber_java.repositories.DatalakeRepository;
import com.datalake.datalake_subscriber_java.utilities.JsonUtility;

@Component("test-datalake")
public class VerdatProcessor implements TopicProcessor {

    @Autowired
    private DatalakeRepository datalakeRepository;

    @Autowired
    private JsonUtility jsonUtility;

    @Autowired
    private VerdatDataExtractor verdatData;

    @Override
    @Transactional
    public void process(String message) {
        Map<String, Object> gsonMessage = jsonUtility.parseMessage(message);

        // Mengambil data dari JSON
        String order_id = verdatData.getOrderId(gsonMessage);
        String current_form_desc = verdatData.getCurrentFormDesc(gsonMessage);
        String appl_no = verdatData.getApplNo(gsonMessage);
        String appl_date = verdatData.getApplDate(gsonMessage);
        String order_date = verdatData.getOrderDate(gsonMessage);
        String appl_contract_no = verdatData.getApplContractNo(gsonMessage);
        String max_approval = verdatData.getMaxApproval(gsonMessage);
        String last_approval = verdatData.getLastApproval(gsonMessage);
        String max_deviasi = verdatData.getMaxDeviasi(gsonMessage);
        String appl_ppd_date = ("");
        String fin_type = verdatData.getFinType(gsonMessage);
        String finance_product = verdatData.getFinanceProduct(gsonMessage);
        String core_product = verdatData.getCoreProduct(gsonMessage);
        String bran_br_name = verdatData.getBranBrName(gsonMessage);
        String bran_br_id = verdatData.getBranBrId(gsonMessage);
        String outlet_channel_desc = verdatData.getOutletChannelDesc(gsonMessage);
        String appl_sales_through = verdatData.getApplSalesThrough(gsonMessage);
        String sales_throught = verdatData.getSalesThrought(gsonMessage);
        String initiall = ("");
        String internal_sales_force_code = verdatData.getInternalSalesForceCode(gsonMessage);
        String internal_sales_force_nik = verdatData.getInternalSalesForceNik(gsonMessage);
        String internal_sales_force_name = verdatData.getInternalSalesForceName(gsonMessage);
        String internal_sales_force_job = verdatData.getInternalSalesForceJob(gsonMessage);
        String interxt_sales_force1_name = verdatData.getInterxtSalesForce1Name(gsonMessage);
        String interxt_sales_force1_npk = verdatData.getInterxtSalesForce1Npk(gsonMessage);
        String interxt_sales_force1_job = verdatData.getInterxtSalesForce1Job(gsonMessage);
        String interxt_sales_force2_name = verdatData.getInterxtSalesForce2Name(gsonMessage);
        String interxt_sales_force2_npk = verdatData.getInterxtSalesForce2Npk(gsonMessage);
        String interxt_sales_force2_job = verdatData.getInterxtSalesForce2Job(gsonMessage);
        String id_empl_mitra = verdatData.getIdEmplMitra(gsonMessage);
        String company = verdatData.getCompany(gsonMessage);
        String empl_nik_bank = verdatData.getEmplNikBank(gsonMessage);
        String no_telephone = ("");
        String bank_branch_id = verdatData.getBankBranchId(gsonMessage);
        String bank_office_location = ("");
        String kode_pekerjaan = verdatData.getKodePekerjaan(gsonMessage);

        if (order_id != null && !order_id.isEmpty()) {
            boolean exists = datalakeRepository.existsByOrder_id(order_id);

            if (!exists) {

                DatalakeEntity datalakeEntity = new DatalakeEntity();
                datalakeEntity.setOrder_id(order_id);
                datalakeEntity.setCurrent_form_desc(current_form_desc);
                datalakeEntity.setAppl_no(appl_no);
                datalakeEntity.setAppl_date(appl_date);
                datalakeEntity.setOrder_date(order_date);
                datalakeEntity.setAppl_contract_no(appl_contract_no);
                datalakeEntity.setMax_approval(max_approval);
                datalakeEntity.setLast_approval(last_approval);
                datalakeEntity.setMax_deviasi(max_deviasi);
                datalakeEntity.setAppl_ppd_date(appl_ppd_date); // KOSONG
                datalakeEntity.setFin_type(fin_type);
                datalakeEntity.setFinance_product(finance_product);
                datalakeEntity.setCore_product(core_product);
                datalakeEntity.setBran_br_name(bran_br_name);
                datalakeEntity.setBran_br_id(bran_br_id);
                datalakeEntity.setOutlet_channel_desc(outlet_channel_desc);
                datalakeEntity.setAppl_sales_through(appl_sales_through);
                datalakeEntity.setSales_throught(sales_throught);
                datalakeEntity.setInitiall(initiall);
                datalakeEntity.setInternal_sales_force_code(internal_sales_force_code);
                datalakeEntity.setInternal_sales_force_nik(internal_sales_force_nik);
                datalakeEntity.setInternal_sales_force_name(internal_sales_force_name);
                datalakeEntity.setInternal_sales_force_job(internal_sales_force_job);
                datalakeEntity.setInterxt_sales_force1_name(interxt_sales_force1_name);
                datalakeEntity.setInterxt_sales_force1_npk(interxt_sales_force1_npk);
                datalakeEntity.setInterxt_sales_force1_job(interxt_sales_force1_job);
                datalakeEntity.setInterxt_sales_force2_name(interxt_sales_force2_name);
                datalakeEntity.setInterxt_sales_force2_npk(interxt_sales_force2_npk);
                datalakeEntity.setInterxt_sales_force2_job(interxt_sales_force2_job);
                datalakeEntity.setId_empl_mitra(id_empl_mitra);
                datalakeEntity.setCompany(company);
                datalakeEntity.setEmpl_nik_bank(empl_nik_bank);
                datalakeEntity.setNo_telephone(no_telephone);
                datalakeEntity.setBank_branch_id(bank_branch_id);
                datalakeEntity.setBank_office_location(bank_office_location);
                datalakeEntity.setKode_pekerjaan(kode_pekerjaan);

                datalakeRepository.save(datalakeEntity);

                System.out.println("Entity saved: " + datalakeEntity);
            } else {
                System.out.println("Order ID already exists: " + order_id);
            }
        } else {
            System.out.println("Order ID is null or empty.");
        }

    }

}
