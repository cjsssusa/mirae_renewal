package kr.co.landfuture.ads.temp;

import kr.co.landfuture.ads.datainout.AddressIn;
import kr.co.landfuture.ads.datainout.AddressOut;
import kr.co.landfuture.util.UtilFunc;

public class AddressParsingMain {
    public AddressIn aIn;
    public AddressOut aOut;

    public AddressOut parseing_address(AddressIn addressin) {
        this.aIn = addressin;
        this.aIn.address = UtilFunc.remove_head(this.aIn.address_org);
        this.aIn.address = this.aIn.address.trim();

        return this.aOut;
    }
}
