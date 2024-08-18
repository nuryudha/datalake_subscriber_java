package com.datalake.datalake_subscriber_java.services.binding;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.datalake.datalake_subscriber_java.entities.DatalakeEntity;
import com.datalake.datalake_subscriber_java.services.mapper.RegulerSurveyMapper;

@Component
public class RegulerSurveyBinder {

    @Autowired
    private RegulerSurveyMapper regulerSurveyMapper;

    public void updateEntityFromMessage(DatalakeEntity entity, Map<String, Object> messageData) {
        entity.setOrder_id(regulerSurveyMapper.getOrderId(messageData));
        entity.setCurrent_form_desc(regulerSurveyMapper.getCurrentFormDesc(messageData));
        entity.setAppl_no(regulerSurveyMapper.getApplNo(messageData));
        entity.setAppl_date(regulerSurveyMapper.getApplDate(messageData));
        entity.setOrder_date(regulerSurveyMapper.getOrderDate(messageData));
        entity.setAppl_contract_no(regulerSurveyMapper.getApplContractNo(messageData));
        entity.setMax_approval(regulerSurveyMapper.getMaxApproval(messageData));
        entity.setLast_approval(regulerSurveyMapper.getLastApproval(messageData));
        entity.setMax_deviasi(regulerSurveyMapper.getMaxDeviasi(messageData));
        entity.setAppl_ppd_date(regulerSurveyMapper.getApplPpdDate(messageData));
        entity.setFin_type(regulerSurveyMapper.getFinType(messageData));
        entity.setFinance_product(regulerSurveyMapper.getFinanceProduct(messageData));
        entity.setCore_product(regulerSurveyMapper.getCoreProduct(messageData));
        entity.setArea(regulerSurveyMapper.getArea(messageData));
        entity.setBran_br_name(regulerSurveyMapper.getBranBrName(messageData));
        entity.setBran_br_id(regulerSurveyMapper.getBranBrId(messageData));
        entity.setOutlet_channel_desc(regulerSurveyMapper.getOutletChannelDesc(messageData));
        entity.setAppl_sales_through(regulerSurveyMapper.getApplSalesThrough(messageData));
        entity.setSales_throught(regulerSurveyMapper.getSalesThrought(messageData));
        entity.setInitiall(regulerSurveyMapper.getInitiall(messageData));
        entity.setInternal_sales_force_code(regulerSurveyMapper.getInternalSalesForceCode(messageData));
        entity.setInternal_sales_force_nik(regulerSurveyMapper.getInternalSalesForceNik(messageData));
        entity.setInternal_sales_force_name(regulerSurveyMapper.getInternalSalesForceName(messageData));
        entity.setInternal_sales_force_job(regulerSurveyMapper.getInternalSalesForceJob(messageData));
        entity.setInterxt_sales_force1_name(regulerSurveyMapper.getInterxtSalesForce1Name(messageData));
        entity.setInterxt_sales_force1_npk(regulerSurveyMapper.getInterxtSalesForce1Npk(messageData));
        entity.setInterxt_sales_force1_job(regulerSurveyMapper.getInterxtSalesForce1Job(messageData));
        entity.setInterxt_sales_force2_name(regulerSurveyMapper.getInterxtSalesForce2Name(messageData));
        entity.setInterxt_sales_force2_npk(regulerSurveyMapper.getInterxtSalesForce2Npk(messageData));
        entity.setInterxt_sales_force2_job(regulerSurveyMapper.getInterxtSalesForce2Job(messageData));
        entity.setId_empl_mitra(regulerSurveyMapper.getIdEmplMitra(messageData));
        entity.setCompany(regulerSurveyMapper.getCompany(messageData));
        entity.setEmpl_nik_bank(regulerSurveyMapper.getEmplNikBank(messageData));
        entity.setNo_telephone(regulerSurveyMapper.getNoTelephone(messageData));
        entity.setBank_branch_id(regulerSurveyMapper.getBankBranchId(messageData));
        entity.setBank_office_location(regulerSurveyMapper.getBankOfficeLocation(messageData));
        entity.setKode_pekerjaan(regulerSurveyMapper.getKodePekerjaan(messageData));
        entity.setDebitur_no_npwp(regulerSurveyMapper.getDebiturNoNpwp(messageData));
        entity.setNpwp_type(regulerSurveyMapper.getNpwpType(messageData));
        entity.setBank_deal_empl(regulerSurveyMapper.getBankDealEmpl(messageData));
        entity.setEmpl_acc_no(regulerSurveyMapper.getEmplAccNo(messageData));
        entity.setEmpl_addr(regulerSurveyMapper.getEmplAddr(messageData));
        entity.setDlc(regulerSurveyMapper.getDlc(messageData));
        entity.setCred_deal_name(regulerSurveyMapper.getCredDealName(messageData));
        entity.setAppl_appl_tag1(regulerSurveyMapper.getApplApplTag1(messageData));
        entity.setAplication_tag1_desc(regulerSurveyMapper.getAplicationTag1Desc(messageData));
        entity.setAppl_appl_tag2(regulerSurveyMapper.getApplApplTag2(messageData));
        entity.setAplication_tax2_desc(regulerSurveyMapper.getAplicationTax2Desc(messageData));
        entity.setAppl_appl_tag3(regulerSurveyMapper.getApplApplTag3(messageData));
        entity.setAplication_tax3_desc(regulerSurveyMapper.getAplicationTax3Desc(messageData));
        entity.setStatus(regulerSurveyMapper.getStatus(messageData));
        entity.setAppl_objt_code(regulerSurveyMapper.getApplObjtCode(messageData));
        entity.setObjt_desc(regulerSurveyMapper.getObjtDesc(messageData));
        entity.setObbr_code(regulerSurveyMapper.getObbrCode(messageData));
        entity.setObbr_desc(regulerSurveyMapper.getObbrDesc(messageData));
        entity.setBahan_bakar(regulerSurveyMapper.getBahanBakar(messageData));
        entity.setObty_code(regulerSurveyMapper.getObtyCode(messageData));
        entity.setObty_desc(regulerSurveyMapper.getObtyDesc(messageData));
        entity.setObmo_code(regulerSurveyMapper.getObmoCode(messageData));
        entity.setObmo_desc(regulerSurveyMapper.getObmoDesc(messageData));
        entity.setObjt_obj_year(regulerSurveyMapper.getObjtObjYear(messageData));
        entity.setObjt_obj_mfg_year(regulerSurveyMapper.getObjtObjMfgYear(messageData));
        entity.setObjt_color(regulerSurveyMapper.getObjtColor(messageData));
        entity.setObjt_frame_no(regulerSurveyMapper.getObjtFrameNo(messageData));
        entity.setObjt_engine_no(regulerSurveyMapper.getObjtEngineNo(messageData));
        entity.setPurpose_desc(regulerSurveyMapper.getPurposeDesc(messageData));
        entity.setPaym_type_desc(regulerSurveyMapper.getPaymTypeDesc(messageData));
        entity.setBank_name(regulerSurveyMapper.getBankName(messageData));
        entity.setAppl_autodebit_acc_no(regulerSurveyMapper.getApplAutodebitAccNo(messageData));
        entity.setAppl_autodebit_acc_name(regulerSurveyMapper.getApplAutodebitAccName(messageData));
        entity.setAppl_mkpp_id(regulerSurveyMapper.getApplMkppId(messageData));
        entity.setMkpp_desc(regulerSurveyMapper.getMkppDesc(messageData));
        entity.setSubsidi_dp(regulerSurveyMapper.getSubsidiDp(messageData));
        entity.setJoint_promo(regulerSurveyMapper.getJointPromo(messageData));
        entity.setAdm_from_deal(regulerSurveyMapper.getAdmFromDeal(messageData));
        entity.setBbm_from_deal(regulerSurveyMapper.getBbmFromDeal(messageData));
        entity.setSubs_potong_pelunasan(regulerSurveyMapper.getSubsPotongPelunasan(messageData));
        entity.setSubsidi_klaim(regulerSurveyMapper.getSubsidiKlaim(messageData));
        entity.setDisc_kom(regulerSurveyMapper.getDiscKom(messageData));
        entity.setDiscount(regulerSurveyMapper.getDiscount(messageData));
        entity.setKomisi_langsung(regulerSurveyMapper.getKomisiLangsung(messageData));
        entity.setAdm_from_mu(regulerSurveyMapper.getAdmFromMu(messageData));
        entity.setBbm_from_mu(regulerSurveyMapper.getBbmFromMu(messageData));
        entity.setAppl_principal_amt(regulerSurveyMapper.getApplPrincipalAmt(messageData));
        entity.setPrin_plus_intr_amount(regulerSurveyMapper.getPrinPlusIntrAmount(messageData));
        entity.setAppl_top(regulerSurveyMapper.getApplTop(messageData));
        entity.setTot_adm_fee(regulerSurveyMapper.getTotAdmFee(messageData));
        entity.setAdm_fin(regulerSurveyMapper.getAdmFin(messageData));
        entity.setAdm_fee(regulerSurveyMapper.getAdmFee(messageData));
        entity.setOtr(regulerSurveyMapper.getOtr(messageData));
        entity.setAppl_adm_fee(regulerSurveyMapper.getApplAdmFee(messageData));
        entity.setAppl_gross_dp(regulerSurveyMapper.getApplGrossDp(messageData));
        entity.setAppl_net_dp(regulerSurveyMapper.getApplNetDp(messageData));
        entity.setDp_branch(regulerSurveyMapper.getDpBranch(messageData));
        entity.setAppl_int_flat_rate(regulerSurveyMapper.getApplIntFlatRate(messageData));
        entity.setAppl_int_eff_rate(regulerSurveyMapper.getApplIntEffRate(messageData));
        entity.setAppl_tot_ins_fee(regulerSurveyMapper.getApplTotInsFee(messageData));
        entity.setAppl_insr_financed(regulerSurveyMapper.getApplInsrFinanced(messageData));
        entity.setPaid_ins_fee(regulerSurveyMapper.getPaidInsFee(messageData));
        entity.setAppl_insr_buy_rate(regulerSurveyMapper.getApplInsrBuyRate(messageData));
        entity.setAppl_inst_amt(regulerSurveyMapper.getApplInstAmt(messageData));
        entity.setTot_ins_fee2(regulerSurveyMapper.getTotInsFee2(messageData));
        entity.setObjt_insr_financing_2(regulerSurveyMapper.getObjtInsrFinancing2(messageData));
        entity.setPaid_insr_fee2(regulerSurveyMapper.getPaidInsrFee2(messageData));
        entity.setTotal_provisi(regulerSurveyMapper.getTotalProvisi(messageData));
        entity.setProvisi_paid(regulerSurveyMapper.getProvisiPaid(messageData));
        entity.setProvisi_fin(regulerSurveyMapper.getProvisiFin(messageData));
        entity.setInstalment_amount(regulerSurveyMapper.getInstalmentAmount(messageData));
        entity.setCust_type(regulerSurveyMapper.getCustType(messageData));
        entity.setCust_no(regulerSurveyMapper.getCustNo(messageData));
        entity.setCust_sid_name(regulerSurveyMapper.getCustSidName(messageData));
        entity.setSex(regulerSurveyMapper.getSex(messageData));
        entity.setPhone_no(regulerSurveyMapper.getPhoneNo(messageData));
        entity.setDebitur_no_hp_1(regulerSurveyMapper.getDebiturNoHp1(messageData));
        entity.setCust_id_no(regulerSurveyMapper.getCustIdNo(messageData));
        entity.setMother_name(regulerSurveyMapper.getMotherName(messageData));
        entity.setCust_birth_date(regulerSurveyMapper.getCustBirthDate(messageData));
        entity.setCust_birth_place(regulerSurveyMapper.getCustBirthPlace(messageData));
        entity.setCust_monthly_income(regulerSurveyMapper.getCustMonthlyIncome(messageData));
        entity.setCust_address(regulerSurveyMapper.getCustAddress(messageData));
        entity.setRt(regulerSurveyMapper.getRt(messageData));
        entity.setRw(regulerSurveyMapper.getRw(messageData));
        entity.setCust_zip_code(regulerSurveyMapper.getCustZipCode(messageData));
        entity.setCust_kelurahan(regulerSurveyMapper.getCustKelurahan(messageData));
        entity.setCust_kecamatan(regulerSurveyMapper.getCustKecamatan(messageData));
        entity.setCust_kab_kota(regulerSurveyMapper.getCustKabKota(messageData));
        entity.setCust_provinsi(regulerSurveyMapper.getCustProvinsi(messageData));
        entity.setComp_name(regulerSurveyMapper.getCompName(messageData));
        entity.setComp_type(regulerSurveyMapper.getCompType(messageData));
        entity.setEconomic_sec1(regulerSurveyMapper.getEconomicSec1(messageData));
        entity.setEconomic_sec2(regulerSurveyMapper.getEconomicSec2(messageData));
        entity.setEconomic_sec3(regulerSurveyMapper.getEconomicSec3(messageData));
        entity.setNature_buss(regulerSurveyMapper.getNatureBuss(messageData));
        entity.setCust_curr_year_of_work(regulerSurveyMapper.getCustCurrYearOfWork(messageData));
        entity.setCom_status_tempat(regulerSurveyMapper.getComStatusTempat(messageData));
        entity.setCom_lokasi_usaha(regulerSurveyMapper.getComLokasiUsaha(messageData));
        entity.setCom_total_employee(regulerSurveyMapper.getComTotalEmployee(messageData));
        entity.setCom_no_of_year_buss(regulerSurveyMapper.getComNoOfYearBuss(messageData));
        entity.setCust_pro_lama_profesi(regulerSurveyMapper.getCustProLamaProfesi(messageData));
        entity.setJenis_profesi(regulerSurveyMapper.getJenisProfesi(messageData));
        entity.setApproved_date(regulerSurveyMapper.getApprovedDate(messageData));
        entity.setStatus_appr(regulerSurveyMapper.getStatusAppr(messageData));
        entity.setTanggal_cetak_po(regulerSurveyMapper.getTanggalCetakPo(messageData));
        entity.setApprove_note(regulerSurveyMapper.getApproveNote(messageData));
        entity.setTanggal_fpd(regulerSurveyMapper.getTanggalFpd(messageData));
        entity.setNo_fpd(regulerSurveyMapper.getNoFpd(messageData));
        entity.setNpk_cmh(regulerSurveyMapper.getNpkCmh(messageData));
        entity.setNama_cmh(regulerSurveyMapper.getNamaCmh(messageData));
        entity.setInstallment_type(regulerSurveyMapper.getInstallmentType(messageData));
        entity.setAdvance_arrear(regulerSurveyMapper.getAdvanceArrear(messageData));
        entity.setTahun_kendaraan(regulerSurveyMapper.getTahunKendaraan(messageData));
        entity.setInsurance_fee(regulerSurveyMapper.getInsuranceFee(messageData));
        entity.setAppl_admf_komisi_amt(regulerSurveyMapper.getApplAdmfKomisiAmt(messageData));
        entity.setStatus_cancel(regulerSurveyMapper.getStatusCancel(messageData));
        entity.setCancel_pocl(regulerSurveyMapper.getCancelPocl(messageData));
        entity.setMufnet(regulerSurveyMapper.getMufnet(messageData));
        entity.setPenggolongan_product(regulerSurveyMapper.getPenggolonganProduct(messageData));
        entity.setBank_wilayah_mdr(regulerSurveyMapper.getBankWilayahMdr(messageData));
        entity.setBank_area_mdr(regulerSurveyMapper.getBankAreaMdr(messageData));
        entity.setFlag_cancel(regulerSurveyMapper.getFlagCancel(messageData));
        entity.setCancel_ppd_date(regulerSurveyMapper.getCancelPpdDate(messageData));
        entity.setStatus_repo(regulerSurveyMapper.getStatusRepo(messageData));
        entity.setNik_mca(regulerSurveyMapper.getNikMca(messageData));
        entity.setNama_mca(regulerSurveyMapper.getNamaMca(messageData));
        entity.setFirst_name(regulerSurveyMapper.getFirstName(messageData));
        entity.setLast_name(regulerSurveyMapper.getLastName(messageData));
        entity.setInsurance_type_code(regulerSurveyMapper.getInsuranceTypeCode(messageData));
        entity.setInsurance_type(regulerSurveyMapper.getInsuranceType(messageData));
        entity.setNama_bpkb(regulerSurveyMapper.getNamaBpkb(messageData));
        entity.setOccupation(regulerSurveyMapper.getOccupation(messageData));
        entity.setStatus_indent(regulerSurveyMapper.getStatusIndent(messageData));
        entity.setCancel_reject_date_ca(regulerSurveyMapper.getCancelRejectDateCa(messageData));
        entity.setCancel_reject_date_mkt(regulerSurveyMapper.getCancelRejectDateMkt(messageData));
        entity.setLtv(regulerSurveyMapper.getLtv(messageData));
        entity.setMarital(regulerSurveyMapper.getMarital(messageData));
        entity.setEducation(regulerSurveyMapper.getEducation(messageData));
        entity.setStatus_jf_bmri(regulerSurveyMapper.getStatusJfBmri(messageData));
        entity.setPrin_jf_bmri(regulerSurveyMapper.getPrinJfBmri(messageData));
        entity.setIntr_jf_bmri(regulerSurveyMapper.getIntrJfBmri(messageData));
        entity.setMkt_prod(regulerSurveyMapper.getMktProd(messageData));
        entity.setSumber_nasabah(regulerSurveyMapper.getSumberNasabah(messageData));
        entity.setProgramm(regulerSurveyMapper.getProgramm(messageData));
        entity.setEducation_code(regulerSurveyMapper.getEducationCode(messageData));
        entity.setOccupation_code(regulerSurveyMapper.getOccupationCode(messageData));
        entity.setEconomic_sector_code1(regulerSurveyMapper.getEconomicSectorCode1(messageData));
        entity.setEconomic_sector_code2(regulerSurveyMapper.getEconomicSectorCode2(messageData));
        entity.setEconomic_sector_code3(regulerSurveyMapper.getEconomicSectorCode3(messageData));
        entity.setRo_ao(regulerSurveyMapper.getRoAo(messageData));
        entity.setDsr(regulerSurveyMapper.getDsr(messageData));
        entity.setVehicle_type(regulerSurveyMapper.getVehicleType(messageData));
        entity.setDependent(regulerSurveyMapper.getDependent(messageData));
        entity.setLama_tinggal(regulerSurveyMapper.getLamaTinggal(messageData));
        entity.setBal_prin(regulerSurveyMapper.getBalPrin(messageData));
        entity.setOvd(regulerSurveyMapper.getOvd(messageData));
        entity.setFirst_installment_method(regulerSurveyMapper.getFirstInstallmentMethod(messageData));
        entity.setStatus_aging(regulerSurveyMapper.getStatusAging(messageData));
        entity.setSumber_data_desc(regulerSurveyMapper.getSumberDataDesc(messageData));
        entity.setSumber_order_desc(regulerSurveyMapper.getSumberOrderDesc(messageData));
        entity.setPortfolio_code(regulerSurveyMapper.getPortfolioCode(messageData));
        entity.setPortfolio_desc(regulerSurveyMapper.getPortfolioDesc(messageData));
        entity.setMogr_code(regulerSurveyMapper.getMogrCode(messageData));
        entity.setMogr_desc(regulerSurveyMapper.getMogrDesc(messageData));
        entity.setObmo_genre(regulerSurveyMapper.getObmoGenre(messageData));
        entity.setNpk_cmh_2(regulerSurveyMapper.getNpkCmh2(messageData));
        entity.setNama_cmh_2(regulerSurveyMapper.getNamaCmh2(messageData));
        entity.setTipe_restructuring(regulerSurveyMapper.getTipeRestructuring(messageData));
        entity.setNo_contract_old(regulerSurveyMapper.getNoContractOld(messageData));
        entity.setScreening_1_date(regulerSurveyMapper.getScreening1Date(messageData));
        entity.setScreening_2_date(regulerSurveyMapper.getScreening2Date(messageData));
        entity.setInsert_date_reguler_survey(regulerSurveyMapper.getInsertDateRegulerSurvey(messageData));
        entity.setScreening_3_date(regulerSurveyMapper.getScreening3Date(messageData));
        entity.setNik_1(regulerSurveyMapper.getNik1(messageData));
        entity.setNama_1(regulerSurveyMapper.getNama1(messageData));
        entity.setJobcode_1(regulerSurveyMapper.getJobcode1(messageData));
        entity.setResult_1(regulerSurveyMapper.getResult1(messageData));
        entity.setDate_1(regulerSurveyMapper.getDate1(messageData));
        entity.setNik_2(regulerSurveyMapper.getNik2(messageData));
        entity.setNama_2(regulerSurveyMapper.getNama2(messageData));
        entity.setJobcode_2(regulerSurveyMapper.getJobcode2(messageData));
        entity.setResult_2(regulerSurveyMapper.getResult2(messageData));
        entity.setDate_2(regulerSurveyMapper.getDate2(messageData));
        entity.setNik_3(regulerSurveyMapper.getNik3(messageData));
        entity.setNama_3(regulerSurveyMapper.getNama3(messageData));
        entity.setJobcode_3(regulerSurveyMapper.getJobcode3(messageData));
        entity.setResult_3(regulerSurveyMapper.getResult3(messageData));
        entity.setDate_3(regulerSurveyMapper.getDate3(messageData));
        entity.setNik_4(regulerSurveyMapper.getNik4(messageData));
        entity.setNama_4(regulerSurveyMapper.getNama4(messageData));
        entity.setJobcode_4(regulerSurveyMapper.getJobcode4(messageData));
        entity.setResult_4(regulerSurveyMapper.getResult4(messageData));
        entity.setDate_4(regulerSurveyMapper.getDate4(messageData));
        entity.setNik_5(regulerSurveyMapper.getNik5(messageData));
        entity.setNama_5(regulerSurveyMapper.getNama5(messageData));
        entity.setJobcode_5(regulerSurveyMapper.getJobcode5(messageData));
        entity.setResult_5(regulerSurveyMapper.getResult5(messageData));
        entity.setDate_5(regulerSurveyMapper.getDate5(messageData));
        entity.setNik_6(regulerSurveyMapper.getNik6(messageData));
        entity.setNama_6(regulerSurveyMapper.getNama6(messageData));
        entity.setJobcode_6(regulerSurveyMapper.getJobcode6(messageData));
        entity.setResult_6(regulerSurveyMapper.getResult6(messageData));
        entity.setDate_6(regulerSurveyMapper.getDate6(messageData));
        entity.setNik_7(regulerSurveyMapper.getNik7(messageData));
        entity.setNama_7(regulerSurveyMapper.getNama7(messageData));
        entity.setJobcode_7(regulerSurveyMapper.getJobcode7(messageData));
        entity.setResult_7(regulerSurveyMapper.getResult7(messageData));
        entity.setDate_7(regulerSurveyMapper.getDate7(messageData));
        entity.setNik_8(regulerSurveyMapper.getNik8(messageData));
        entity.setNama_8(regulerSurveyMapper.getNama8(messageData));
        entity.setJobcode_8(regulerSurveyMapper.getJobcode8(messageData));
        entity.setResult_8(regulerSurveyMapper.getResult8(messageData));
        entity.setDate_8(regulerSurveyMapper.getDate8(messageData));
        entity.setNik_9(regulerSurveyMapper.getNik9(messageData));
        entity.setNama_9(regulerSurveyMapper.getNama9(messageData));
        entity.setJobcode_9(regulerSurveyMapper.getJobcode9(messageData));
        entity.setResult_9(regulerSurveyMapper.getResult9(messageData));
        entity.setDate_9(regulerSurveyMapper.getDate9(messageData));
        entity.setNik_10(regulerSurveyMapper.getNik10(messageData));
        entity.setNama_10(regulerSurveyMapper.getNama10(messageData));
        entity.setJobcode_10(regulerSurveyMapper.getJobcode10(messageData));
        entity.setResult_10(regulerSurveyMapper.getResult10(messageData));
        entity.setDate_10(regulerSurveyMapper.getDate10(messageData));
        entity.setNik_11(regulerSurveyMapper.getNik11(messageData));
        entity.setNama_11(regulerSurveyMapper.getNama11(messageData));
        entity.setJobcode_11(regulerSurveyMapper.getJobcode11(messageData));
        entity.setResult_11(regulerSurveyMapper.getResult11(messageData));
        entity.setDate_11(regulerSurveyMapper.getDate11(messageData));
        entity.setNik_12(regulerSurveyMapper.getNik12(messageData));
        entity.setNama_12(regulerSurveyMapper.getNama12(messageData));
        entity.setJobcode_12(regulerSurveyMapper.getJobcode12(messageData));
        entity.setResult_12(regulerSurveyMapper.getResult12(messageData));
        entity.setDate_12(regulerSurveyMapper.getDate12(messageData));
        entity.setNik_13(regulerSurveyMapper.getNik13(messageData));
        entity.setNama_13(regulerSurveyMapper.getNama13(messageData));
        entity.setJobcode_13(regulerSurveyMapper.getJobcode13(messageData));
        entity.setResult_13(regulerSurveyMapper.getResult13(messageData));
        entity.setDate_13(regulerSurveyMapper.getDate13(messageData));
        entity.setNik_14(regulerSurveyMapper.getNik14(messageData));
        entity.setNama_14(regulerSurveyMapper.getNama14(messageData));
        entity.setJobcode_14(regulerSurveyMapper.getJobcode14(messageData));
        entity.setResult_14(regulerSurveyMapper.getResult14(messageData));
        entity.setDate_14(regulerSurveyMapper.getDate14(messageData));
        entity.setNik_15(regulerSurveyMapper.getNik15(messageData));
        entity.setNama_15(regulerSurveyMapper.getNama15(messageData));
        entity.setJobcode_15(regulerSurveyMapper.getJobcode15(messageData));
        entity.setResult_15(regulerSurveyMapper.getResult15(messageData));
        entity.setDate_15(regulerSurveyMapper.getDate15(messageData));
        entity.setDate_cancel_reguler(regulerSurveyMapper.getDateCancelReguler(messageData));
        entity.setDate_cancel_pocl(regulerSurveyMapper.getDateCancelPocl(messageData));
        entity.setInsert_date_pocl(regulerSurveyMapper.getInsertDatePocl(messageData));
        entity.setPrint_date_pocl(regulerSurveyMapper.getPrintDatePocl(messageData));
        entity.setDate_full_data_entry(regulerSurveyMapper.getDateFullDataEntry(messageData));
        entity.setCancel_todolist(regulerSurveyMapper.getCancelTodolist(messageData));
        entity.setDate_cancel_kyc(regulerSurveyMapper.getDateCancelKyc(messageData));
        entity.setFin_prod_desc(regulerSurveyMapper.getFinProdDesc(messageData));
        entity.setFin_purpose_desc(regulerSurveyMapper.getFinPurposeDesc(messageData));
        entity.setNature_of_financing(regulerSurveyMapper.getNatureOfFinancing(messageData));
        entity.setInitial_1(regulerSurveyMapper.getInitial1(messageData));
        entity.setOutlet(regulerSurveyMapper.getOutlet(messageData));
        entity.setInternal_sales_force2_code(regulerSurveyMapper.getInternalSalesForce2Code(messageData));
        entity.setInternal_sales_force2_nik(regulerSurveyMapper.getInternalSalesForce2Nik(messageData));
        entity.setInternal_sales_force2_name(regulerSurveyMapper.getInternalSalesForce2Name(messageData));
        entity.setInternal_sales_force2_job(regulerSurveyMapper.getInternalSalesForce2Job(messageData));
        entity.setInitial_2(regulerSurveyMapper.getInitial2(messageData));
        entity.setPengajuan_telesurvey(regulerSurveyMapper.getPengajuanTelesurvey(messageData));
        entity.setProses_pembiayaan_telesurvey(regulerSurveyMapper.getProsesPembiayaanTelesurvey(messageData));
        entity.setDate_telesurvey(regulerSurveyMapper.getDateTelesurvey(messageData));
        entity.setInsert_by_telesurvey(regulerSurveyMapper.getInsertByTelesurvey(messageData));
        entity.setStatus_kyc(regulerSurveyMapper.getStatusKyc(messageData));
        entity.setDate_kyc(regulerSurveyMapper.getDateKyc(messageData));
        entity.setInsert_by_kyc(regulerSurveyMapper.getInsertByKyc(messageData));
        entity.setHasil_kyc(regulerSurveyMapper.getHasilKyc(messageData));
        entity.setArea_id(regulerSurveyMapper.getAreaId(messageData));
        entity.setInsert_date(regulerSurveyMapper.getInsertDate(messageData));
        entity.setUpdate_date(regulerSurveyMapper.getUpdateDate(messageData));
        entity.setAsuransi_kendaraan(regulerSurveyMapper.getAsuransiKendaraan(messageData));
        entity.setAsuransi_tambahan(regulerSurveyMapper.getAsuransiTambahan(messageData));
        entity.setEng_capacity(regulerSurveyMapper.getEngCapacity(messageData));
        entity.setSkema_pembiayaan(regulerSurveyMapper.getSkemaPembiayaan(messageData));
        entity.setTotal_interest_amount(regulerSurveyMapper.getTotalInterestAmount(messageData));
        entity.setInsurance_credit_fee(regulerSurveyMapper.getInsuranceCreditFee(messageData));
        entity.setJatuh_tempo(regulerSurveyMapper.getJatuhTempo(messageData));
        entity.setObj_pembiayaan(regulerSurveyMapper.getObjPembiayaan(messageData));
        entity.setInternal_sales_head(regulerSurveyMapper.getInternalSalesHead(messageData));
        entity.setFin_scheme_code(regulerSurveyMapper.getFinSchemeCode(messageData));
        entity.setNo_obligor_id(regulerSurveyMapper.getNoObligorId(messageData));
        entity.setNo_po_cl(regulerSurveyMapper.getNoPoCl(messageData));
        entity.setInterest_amount(regulerSurveyMapper.getInterestAmount(messageData));
        entity.setBiaya_asuransi_tambahan(regulerSurveyMapper.getBiayaAsuransiTambahan(messageData));
        entity.setJob_internal_sales_forced(regulerSurveyMapper.getJobInternalSalesForced(messageData));
        entity.setNama_internal_sales_forced(regulerSurveyMapper.getNamaInternalSalesForced(messageData));
        entity.setKeterangan_po(regulerSurveyMapper.getKeteranganPo(messageData));
        entity.setNilai_pelunasan(regulerSurveyMapper.getNilaiPelunasan(messageData));
        entity.setAlasan_cancel_po_cl(regulerSurveyMapper.getAlasanCancelPoCl(messageData));
        entity.setNotes_cancel_po_cl(regulerSurveyMapper.getNotesCancelPoCl(messageData));
        entity.setNik_reject_cancel_marketing(regulerSurveyMapper.getNikRejectCancelMarketing(messageData));
        entity.setUser_reject_cancel_marketing(regulerSurveyMapper.getUserRejectCancelMarketing(messageData));
        entity.setPic_dealer(regulerSurveyMapper.getPicDealer(messageData));
        entity.setFlagging_reject_cancel_mkt(regulerSurveyMapper.getFlaggingRejectCancelMkt(messageData));
        entity.setDeskripsi_reject_cancel_mkt(regulerSurveyMapper.getDeskripsiRejectCancelMkt(messageData));
        entity.setAlasan_reject_cancel_mkt(regulerSurveyMapper.getAlasanRejectCancelMkt(messageData));
        entity.setReject_cancel_source_app(regulerSurveyMapper.getRejectCancelSourceApp(messageData));
        entity.setDeskripsi_source_aplikasi(regulerSurveyMapper.getDeskripsiSourceAplikasi(messageData));
        entity.setAlasan_koreksi_po(regulerSurveyMapper.getAlasanKoreksiPo(messageData));
        entity.setNik_koreksi_po(regulerSurveyMapper.getNikKoreksiPo(messageData));
        entity.setTanggal_koreksi_po(regulerSurveyMapper.getTanggalKoreksiPo(messageData));
        entity.setTotal_koreksi_po(regulerSurveyMapper.getTotalKoreksiPo(messageData));
        entity.setCara_bayar_angsuran(regulerSurveyMapper.getCaraBayarAngsuran(messageData));
        entity.setStatus_aplikasi(regulerSurveyMapper.getStatusAplikasi(messageData));
        entity.setJumlah_nasabah_ditolak(regulerSurveyMapper.getJumlahNasabahDitolak(messageData));
        entity.setJumlah_cetak_po_cl(regulerSurveyMapper.getJumlahCetakPoCl(messageData));
        entity.setJumlah_po_cl_belum_cetak(regulerSurveyMapper.getJumlahPoClBelumCetak(messageData));
        entity.setJumlah_cancel_po_cl(regulerSurveyMapper.getJumlahCancelPoCl(messageData));
        entity.setJumlah_koreksi_po_cl(regulerSurveyMapper.getJumlahKoreksiPoCl(messageData));
        entity.setJumlah_po_cl_pending(regulerSurveyMapper.getJumlahPoClPending(messageData));
        entity.setJumlah_nasabah_cancel_ppd(regulerSurveyMapper.getJumlahNasabahCancelPpd(messageData));
        entity.setJumlah_tagihan_belum_ppd(regulerSurveyMapper.getJumlahTagihanBelumPpd(messageData));
        entity.setJumlah_reject_cancel_marketing(regulerSurveyMapper.getJumlahRejectCancelMarketing(messageData));
        entity.setTipe_debitur(regulerSurveyMapper.getTipeDebitur(messageData));
        entity.setTanggal_entry(regulerSurveyMapper.getTanggalEntry(messageData));
        entity.setTanggal_approval(regulerSurveyMapper.getTanggalApproval(messageData));
        entity.setTanggal_cetak(regulerSurveyMapper.getTanggalCetak(messageData));
        entity.setTanggal_cancel(regulerSurveyMapper.getTanggalCancel(messageData));
        entity.setTanggal_koreksi(regulerSurveyMapper.getTanggalKoreksi(messageData));
    }

}
