package kr.co.landfuture.ads.datainout;

import java.lang.reflect.Field;

public class AddressOut {
    private String address;
    private String address_org;
    private String ads_ps_tp;
    private String sido;
    private String sido_s;
    private String sgg;
    private String umd;
    private String li;
    private String san;
    private String bon;
    private String bu;
    private String um;
    private String st_nm;
    private String bs;
    private String b_bon;
    private String b_bu;
    private String b_nm_sgg;
    private String b_usage;
    private String lat;
    private String lng;
    private String e_lat;
    private String e_lng;
    private String a_dong;
    private String a_floor;
    private String a_ho;
    private String umd_st;
    private String o_land;
    private String a_place;
    private String each_else;
    private String a_first;
    private String a_second;
    private String idx_1;
    private String idx_2;

    public String getAddress() {
        return this.address;
    }

    public String setAddress(String address) {
        return this.address = address;
    }

    public String getAddress_org() {
        return this.address_org;
    }

    public String setAddress_org(String address_org) {
        return this.address_org = address_org;
    }

    public String getAds_ps_tp() {
        return this.ads_ps_tp;
    }

    public String setAds_ps_tp(String ads_ps_tp) {
        return this.ads_ps_tp = ads_ps_tp;
    }

    public String getSido() {
        return this.sido;
    }

    public String setSido(String sido) {
        return this.sido = sido;
    }

    public String getSido_s() {
        return this.sido_s;
    }

    public String setSido_s(String sido_s) {
        return this.sido_s = sido_s;
    }

    public String getSgg() {
        return this.sgg;
    }

    public String setSgg(String sgg) {
        return this.sgg = sgg;
    }

    public String getUmd() {
        return this.umd;
    }

    public String setUmd(String umd) {
        return this.umd = umd;
    }

    public String getLi() {
        return this.li;
    }

    public String setLi(String li) {
        return this.li = li;
    }

    public String getSan() {
        return this.san;
    }

    public String setSan(String san) {
        return this.san = san;
    }

    public String getBon() {
        return this.bon;
    }

    public String setBon(String bon) {
        return this.bon = bon;
    }

    public String getBu() {
        return this.bu;
    }

    public String setBu(String bu) {
        return this.bu = bu;
    }

    public String getUm() {
        return this.um;
    }

    public String setUm(String um) {
        return this.um = um;
    }

    public String getSt_nm() {
        return this.st_nm;
    }

    public String setSt_nm(String st_nm) {
        return this.st_nm = st_nm;
    }

    public String getBs() {
        return this.bs;
    }

    public String setBs(String bs) {
        return this.bs = bs;
    }

    public String getB_bon() {
        return this.b_bon;
    }

    public String setB_bon(String b_bon) {
        return this.b_bon = b_bon;
    }

    public String getB_bu() {
        return this.b_bu;
    }

    public String setB_bu(String b_bu) {
        return this.b_bu = b_bu;
    }

    public String getB_nm_sgg() {
        return this.b_nm_sgg;
    }

    public String setB_nm_sgg(String b_nm_sgg) {
        return this.b_nm_sgg = b_nm_sgg;
    }

    public String getB_usage() {
        return this.b_usage;
    }

    public String setB_usage(String b_usage) {
        return this.b_usage = b_usage;
    }

    public String getLat() {
        return this.lat;
    }

    public String setLat(String lat) {
        return this.lat = lat;
    }

    public String getLng() {
        return this.lng;
    }

    public String setLng(String lng) {
        return this.lng = lng;
    }

    public String getE_lat() {
        return this.e_lat;
    }

    public String setE_lat(String e_lat) {
        return this.e_lat = e_lat;
    }

    public String getE_lng() {
        return this.e_lng;
    }

    public String setE_lng(String e_lng) {
        return this.e_lng = e_lng;
    }

    public String getA_dong() {
        return this.a_dong;
    }

    public String setA_dong(String a_dong) {
        return this.a_dong = a_dong;
    }

    public String getA_floor() {
        return this.a_floor;
    }

    public String setA_floor(String a_floor) {
        return this.a_floor = a_floor;
    }

    public String getA_ho() {
        return this.a_ho;
    }

    public String setA_ho(String a_ho) {
        return this.a_ho = a_ho;
    }

    public String getUmd_st() {
        return this.umd_st;
    }

    public String setUmd_st(String umd_st) {
        return this.umd_st = umd_st;
    }

    public String getO_land() {
        return this.o_land;
    }

    public String setO_land(String o_land) {
        return this.o_land = o_land;
    }

    public String getA_place() {
        return this.a_place;
    }

    public String setA_place(String a_place) {
        return this.a_place = a_place;
    }

    public String getEach_else() {
        return this.each_else;
    }

    public String setEach_else(String each_else) {
        return this.each_else = each_else;
    }

    public String getA_first() {
        return this.a_first;
    }

    public String setA_first(String a_first) {
        return this.a_first = a_first;
    }

    public String getA_second() {
        return this.a_second;
    }

    public String setA_second(String a_second) {
        return this.a_second = a_second;
    }

    public String getIdx_1() {
        return this.idx_1;
    }

    public String setIdx_1(String idx_1) {
        return this.idx_1 = idx_1;
    }

    public String getIdx_2() {
        return this.idx_2;
    }

    public String setIdx_2(String idx_2) {
        return this.idx_2 = idx_2;
    }

    public AddressOut() {
    }

    public AddressOut(AddressOut employee) throws IllegalArgumentException, IllegalAccessException {
        for (Field aaa : getClass().getDeclaredFields()) {
            aaa.set(this, aaa.get(employee));
        }
    }

    public AddressOut copy() throws IllegalArgumentException, IllegalAccessException {
        return new AddressOut(this);
    }

    public void Field_2_Normalizing() throws IllegalArgumentException, IllegalAccessException {
        for (Field aaa : getClass().getDeclaredFields()) {
            if (aaa.get(this) == null)
                aaa.set(this, "");
            aaa.set(this, ((String) aaa.get(this)).trim());
        }
    }

    public void Field_2_Ini() throws IllegalArgumentException, IllegalAccessException {
        for (Field aaa : getClass().getDeclaredFields()) {
            aaa.set(this, "");
        }
    }

    public String toString() {
        String bbb = "\n\n";
        for (Field aaa : getClass().getDeclaredFields()) {
            try {
                bbb = bbb + "---" + aaa.getName() + " : " + aaa.get(this);
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return bbb;
    }
}
