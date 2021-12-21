package kr.co.landfuture.ads.datainout;

public class AddressIn {
    public String job_cate;
    public String address;
    public String address_org; // 태초에 client에서 날라온 주소

    public AddressIn(String address_org) {
        this.address = this.address_org = address_org;
    }

    public AddressIn(String address_org, String job_cate, String address) {
        this.address = this.address_org = address_org;
        this.job_cate = job_cate;
    }
}
