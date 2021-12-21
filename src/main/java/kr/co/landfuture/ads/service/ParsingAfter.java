package kr.co.landfuture.ads.service;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.landfuture.ads.datainout.AddressOut;
import kr.co.landfuture.ads.landrule.data.LandRuleModel;
import kr.co.landfuture.ads.landrule.repo.LandRuleDynamicRepository;
import kr.co.landfuture.ads.pattern.PCommon;
import kr.co.landfuture.ads.zipcode.data.ZipCodeModel;
import kr.co.landfuture.ads.zipcode.repo.ZipCodeRepository;
import kr.co.landfuture.util.UtilFunc;

@Service
public class ParsingAfter {
  @Autowired
  ZipCodeRepository zipcodeRepository;
  @Autowired
  LandRuleDynamicRepository landRuleDynamicRepository;

  public AddressOut parsing_after(AddressOut ao)
      throws IllegalArgumentException, IllegalAccessException, NullPointerException {
    AddressOut aOut = ao.copy();

    if (aOut.getSido().equals("") && (Pattern.compile("세종").matcher(aOut.getSido()).find()
        || Pattern.compile("세종").matcher(aOut.getSgg()).find())) {
      aOut.setSido("세종");
      aOut.setSgg("세종");
    }
    if (aOut.getLi().equals("00")) {
      aOut.setLi("");
    }
    aOut.setUmd(UtilFunc.cjs_trim_dong(aOut.getUmd()));
    if (Pattern.compile(".*구$").matcher(aOut.getUmd()).find() && Pattern.compile(".*동$").matcher(aOut.getLi()).find()) {
      aOut.setSgg(aOut.getSgg() + " " + aOut.getUmd());
      aOut.setUmd(aOut.getLi());
      aOut.setLi("");
    }
    if (aOut.getA_dong().equals("")) {
      aOut.setIdx_1(StringUtils.replaceEach(aOut.getA_dong(), PCommon.AB_H, PCommon.AB_E));
      if (aOut.getIdx_1().equals(aOut.getA_dong()))
        aOut.setIdx_1("");
    }
    if (aOut.getA_ho().equals("")) {
      aOut.setIdx_2(StringUtils.replaceEach(aOut.getA_ho(), PCommon.AB_H, PCommon.AB_E));
      if (aOut.getIdx_2().equals(aOut.getA_ho()))
        aOut.setIdx_2("");
    }
    if (aOut.getA_floor().equals("지층"))
      aOut.setIdx_2("지층" + aOut.getA_ho());
    Matcher m = Pattern.compile("^제([0-9]*동) *").matcher(aOut.getA_dong());
    if (m.find())
      aOut.setA_dong(m.group(1));
    m = Pattern.compile("^제([0-9]*층) *").matcher(aOut.getA_floor());
    if (m.find())
      aOut.setA_floor(m.group(1));
    m = Pattern.compile("^제([0-9]*호) *").matcher(aOut.getA_ho());
    if (m.find()) {
      aOut.setA_ho(m.group(1));
    }
    // ------------------------------------------ sgg가 시구가 붙은 것들 정식 명칭으로
    aOut.setSgg(UtilFunc.sgg_2_normal(aOut.getSgg()));
    aOut.setSt_nm(aOut.getSt_nm().replaceAll(" ", ""));
    aOut.setA_place(aOut.getA_place().replaceAll("'", "`"));

    // ------------------------------------------ 시도 없는 경우 --> 찾기
    if (aOut.getSido().equals("") && (!aOut.getSgg().equals("") || !aOut.getUmd().equals(""))) {
      List<ZipCodeModel> sidoItems = this.zipcodeRepository.selectSido(aOut.getSgg(), aOut.getUmd());
      Iterator<ZipCodeModel> iterator = sidoItems.iterator();
      if (iterator.hasNext()) {
        ZipCodeModel r_sgg = iterator.next();
        aOut.setSido_s(r_sgg.getsido());
        aOut.setSido(r_sgg.getsido());
        aOut.setSgg(r_sgg.getsgg());
      }

    }

    if (aOut.getSido().equals("") && (!aOut.getSgg().equals("") || !aOut.getSt_nm().equals(""))) {
      List<LandRuleModel> sidosggItems = this.landRuleDynamicRepository.selectSidoSgg(aOut.getSgg(), aOut.getSt_nm());
      Iterator<LandRuleModel> iterator = sidosggItems.iterator();
      if (iterator.hasNext()) {
        LandRuleModel r_sgg = iterator.next();
        aOut.setSido_s(r_sgg.getsido());
        aOut.setSido(r_sgg.getsido());
        aOut.setSgg(r_sgg.getsgg());
      }

    }

    aOut.setSido(UtilFunc.Cjs_State_2_Long(aOut.getSido()));
    aOut.setSido_s(aOut.getSido());
    aOut.Field_2_Normalizing();
    aOut.setSido_s(UtilFunc.Cjs_City_2_Short(aOut.getSido_s()));
    aOut.setA_first(aOut.getSido() + " " + aOut.getSgg());
    aOut.setA_second(UtilFunc.str_space_or_not(aOut.getUmd()) + UtilFunc.str_space_or_not(aOut.getLi())
        + UtilFunc.str_space_or_not(aOut.getSan()) + UtilFunc.str_or_not(aOut.getBon())
        + (!aOut.getBu().equals("") ? ("-" + aOut.getBu()) : ""));
    if (aOut.getSgg().equals("")) {
      if (!aOut.getSido().equals("") && !aOut.getUmd().equals("")) {
        List<LandRuleModel> sggItems = this.landRuleDynamicRepository.selectSgg(aOut.getSido(), aOut.getSt_nm());
        if (sggItems.size() > 0) {
          Iterator<LandRuleModel> iterator = sggItems.iterator();
          if (iterator.hasNext()) {
            LandRuleModel r_sgg = iterator.next();
            aOut.setSgg(r_sgg.getsgg());
          }

        } else {

          aOut.setSgg("NA"); // 다른 프로세스에서 이것을 보고 진행했다는 것을 인지
          aOut.setEach_else(aOut.getUmd());
          aOut.setUmd("");
        }
      } else {
        aOut.setSgg("NA"); // 다른 프로세스에서 이것을 보고 진행했다는 것을 인지
      }
    }
    if (aOut.getEach_else().equals("")) // 주소가 아닌 것을 다른 곳에서 사용하기 위해
    {
      aOut.setEach_else(aOut.getA_place());
    }
    return aOut;
  }
}
