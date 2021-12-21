package kr.co.landfuture.ads.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.landfuture.ads.datainout.AddressIn;
import kr.co.landfuture.ads.datainout.AddressOut;
import kr.co.landfuture.util.UtilFunc;

@Service
public class ParsingMain {
  @Autowired
  private ParsingAddress pAddress;
  @Autowired
  private ParsingAfter pAfter;
  @Autowired
  private GetTheOther getTheOthers;

  public AddressOut parsingMain(AddressIn aIn) throws IllegalArgumentException, IllegalAccessException {
    AddressOut aOut = new AddressOut();
    try {
      aIn.address = UtilFunc.remove_head(aIn.address_org);
      aIn.address = aIn.address.trim();
      UtilFunc.pnt_cp();

      aOut = this.pAddress.street_01(aIn);
      if (UtilFunc.is_empty_null(aOut.getSt_nm())) {

        aOut = this.pAddress.jibun_01(aIn);
        if (UtilFunc.is_empty_null(aOut.getBon())) {

          aOut = this.pAddress.jibun_02(aIn);
          if (UtilFunc.is_empty_null(aOut.getBon())) {
            aOut = this.pAddress.jibun_03(aIn);
          }
        }
      }
      aOut.Field_2_Normalizing();
      aOut.setAddress(aIn.address);
      aOut.setAddress_org(aIn.address_org);

      if (aOut.getAds_ps_tp().equals("jibun_else")) {
        aOut.setSido("NA");
      } else {
        aOut = this.pAfter.parsing_after(aOut);
        aOut = this.getTheOthers.get_the_other(aOut);
      }
      return aOut;
    } catch (NullPointerException e) {
      System.out.println("cjsss -- SQLSyntaxErrorException");
      System.out.println(aOut.toString());
      e.printStackTrace();

      return null;
    }
  }
}
