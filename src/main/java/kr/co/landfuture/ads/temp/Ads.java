package kr.co.landfuture.ads.temp;

import kr.co.landfuture.ads.datainout.AddressIn;
import kr.co.landfuture.ads.datainout.AddressOut;
import kr.co.landfuture.util.UtilFunc;

public class Ads {
    public static void mainaaa(String[] args) throws IllegalArgumentException, IllegalAccessException {
        AddressParsingMain a = new AddressParsingMain();
        AddressOut aOut = new AddressOut();

        AddressIn addressin = new AddressIn("경기도 고양시 일산서구 탄중로101번길 33-43");

        aOut = a.parseing_address(addressin);

        UtilFunc.print_map(UtilFunc.getFieldNamesAndValues(aOut, false));
    }
}
