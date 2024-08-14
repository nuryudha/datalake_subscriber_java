package com.datalake.datalake_subscriber_java.processors;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.datalake.datalake_subscriber_java.entities.DatalakeEntity;
import com.datalake.datalake_subscriber_java.extractors.VerdatDataExtractor;
import com.datalake.datalake_subscriber_java.repositories.DatalakeRepository;
import com.datalake.datalake_subscriber_java.utils.JsonParserUtility;

@Component("test-datalake")
public class VerdatProcessor implements TopicProcessor {

    @Autowired
    private DatalakeRepository datalakeRepository;

    @Autowired
    private JsonParserUtility jsonParser;

    @Autowired
    private VerdatDataExtractor verdatData;

    @Override
    @Transactional
    public void process(String message) {
        Map<String, Object> gsonMessage = jsonParser.parseMessage(message);

        String order_id = verdatData.getOrderId(gsonMessage);
        String current_form_desc = verdatData.getCurrentFormDesc(gsonMessage);
        String appl_no = verdatData.getApplNo(gsonMessage);
        String appl_date = verdatData.getApplDate(gsonMessage);
        String order_date = verdatData.getOrderDate(gsonMessage);
        String appl_contract_no = verdatData.getApplContractNo(gsonMessage);
        String max_approval = verdatData.getMaxApproval(gsonMessage);
        String last_approval = verdatData.getLastApproval(gsonMessage);
        String max_deviasi = verdatData.getMaxDeviasi(gsonMessage);
        // appl_ppd_date
        String fin_type = verdatData.getFinType(gsonMessage);
        String finance_product = verdatData.getFinanceProduct(gsonMessage);
        String core_product = verdatData.getCoreProduct(gsonMessage);
        String area = verdatData.getArea(gsonMessage);

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
                datalakeEntity.setAppl_ppd_date(""); // ? KOSONG
                datalakeEntity.setFin_type(fin_type);
                datalakeEntity.setFinance_product(finance_product);
                datalakeEntity.setCore_product(core_product);
                datalakeEntity.setArea(area);

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
