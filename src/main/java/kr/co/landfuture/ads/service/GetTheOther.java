package kr.co.landfuture.ads.service;

import java.sql.SQLSyntaxErrorException;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Service;

import kr.co.landfuture.ads.datainout.AddressOut;
import kr.co.landfuture.ads.landrule.repo.LandRuleDynamicRepository;
import kr.co.landfuture.ads.zipcode.repo.ZipCodeRepository;
import kr.co.landfuture.util.UtilFunc;

@Service
public class GetTheOther {
  @Autowired
  ZipCodeRepository zipcodeRepository;
  @Autowired
  LandRuleDynamicRepository landRuleDynamicRepository;

  public AddressOut get_the_other(AddressOut ao) throws IllegalArgumentException, IllegalAccessException {
    AddressOut aOut = ao.copy();
    try {
      if (!aOut.getBon().equals("") && aOut.getB_bon().equals("")) {
        List<AddressOut> sidosggItems = this.landRuleDynamicRepository.srchStreet(aOut);
        Iterator<AddressOut> iterator = sidosggItems.iterator();
        if (iterator.hasNext()) {
          AddressOut r_sgg = iterator.next();
          aOut.setSt_nm(r_sgg.getSt_nm());
          aOut.setBs(r_sgg.getBs());
          aOut.setB_bon(r_sgg.getB_bon());
          aOut.setB_bu(r_sgg.getB_bu());
          aOut.setB_nm_sgg(r_sgg.getB_nm_sgg());
          aOut.setB_usage(r_sgg.getB_usage());

          aOut.setLat(r_sgg.getLat());
          aOut.setLng(r_sgg.getLng());
          aOut.setE_lat(r_sgg.getE_lat());
          aOut.setE_lng(r_sgg.getE_lng());
        }
      } else if (aOut.getBon().equals("") && !aOut.getB_bon().equals("")) {
        List<AddressOut> sidosggItems = this.landRuleDynamicRepository.srchJibun(aOut);
        Iterator<AddressOut> iterator = sidosggItems.iterator();
        if (iterator.hasNext()) {
          AddressOut r_sgg = iterator.next();

          aOut.setUmd(UtilFunc.cjs_trim_dong(r_sgg.getUmd()));
          aOut.setLi(r_sgg.getLi());
          aOut.setSan(r_sgg.getSan());
          aOut.setBon(r_sgg.getBon());
          aOut.setBu(r_sgg.getBu());

          aOut.setLat(r_sgg.getLat());
          aOut.setLng(r_sgg.getLng());
          aOut.setE_lat(r_sgg.getE_lat());
          aOut.setE_lng(r_sgg.getE_lng());
        }
      }
    } catch (SQLSyntaxErrorException ex) {
      System.out.println("cjsss -- SQLSyntaxErrorException");
      System.out.println(aOut.toString());
      ex.printStackTrace();
    } catch (BadSqlGrammarException ex) {
      System.out.println("cjsss -- BadSqlGrammarException");
      System.out.println(aOut.toString());
      ex.printStackTrace();
    } finally {
    }
    return aOut;
  }
}
