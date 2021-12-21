package kr.co.landfuture.api.model;

import java.lang.reflect.Field;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import kr.co.landfuture.ads.datainout.AddressOut;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class OutAbi {

    String ad;
    String st;
    String tn;
    String court_name;
    String court_code;

    String sa_num;
    String r;
    String ba;
    String b_u;
    String b_s;

    String l_n_right;
    String la;
    String l_u;
    String l_s;
    String b_i2;

    String l_i2;
    String sp;

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }

    public String getTn() {
        return tn;
    }

    public void setTn(String tn) {
        this.tn = tn;
    }

    public String getCourt_name() {
        return court_name;
    }

    public void setCourt_name(String court_name) {
        this.court_name = court_name;
    }

    public String getCourt_code() {
        return court_code;
    }

    public void setCourt_code(String court_code) {
        this.court_code = court_code;
    }

    public String getSa_num() {
        return sa_num;
    }

    public void setSa_num(String sa_num) {
        this.sa_num = sa_num;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }

    public String getBa() {
        return ba;
    }

    public void setBa(String ba) {
        this.ba = ba;
    }

    public String getB_u() {
        return b_u;
    }

    public void setB_u(String b_u) {
        this.b_u = b_u;
    }

    public String getB_s() {
        return b_s;
    }

    public void setB_s(String b_s) {
        this.b_s = b_s;
    }

    public String getL_n_right() {
        return l_n_right;
    }

    public void setL_n_right(String l_n_right) {
        this.l_n_right = l_n_right;
    }

    public String getLa() {
        return la;
    }

    public void setLa(String la) {
        this.la = la;
    }

    public String getL_u() {
        return l_u;
    }

    public void setL_u(String l_u) {
        this.l_u = l_u;
    }

    public String getL_s() {
        return l_s;
    }

    public void setL_s(String l_s) {
        this.l_s = l_s;
    }

    public String getB_i2() {
        return b_i2;
    }

    public void setB_i2(String b_i2) {
        this.b_i2 = b_i2;
    }

    public String getL_i2() {
        return l_i2;
    }

    public void setL_i2(String l_i2) {
        this.l_i2 = l_i2;
    }

    public String getSp() {
        return sp;
    }

    public void setSp(String sp) {
        this.sp = sp;
    }

    @Override
    public String toString() {
        return "OutAbi [ad=" + ad + ", b_i2=" + b_i2 + ", b_s=" + b_s + ", b_u=" + b_u + ", ba=" + ba + ", court_code="
                + court_code + ", court_name=" + court_name + ", l_i2=" + l_i2 + ", l_n_right=" + l_n_right + ", l_s="
                + l_s + ", l_u=" + l_u + ", la=" + la + ", r=" + r + ", sa_num=" + sa_num + ", sp=" + sp + ", st=" + st
                + ", tn=" + tn + "]";
    }

    public OutAbi() {
    }

    public OutAbi(OutAbi employee) throws IllegalArgumentException, IllegalAccessException {
        for (Field aaa : getClass().getDeclaredFields()) {
            aaa.set(this, aaa.get(employee));
        }
    }

    public OutAbi copy() throws IllegalArgumentException, IllegalAccessException {
        return new OutAbi(this);
    }

    public OutAbi(String ad, String st, String tn, String court_name, String court_code, String sa_num, String r,
            String ba, String b_u, String b_s, String l_n_right, String la, String l_u, String l_s, String b_i2,
            String l_i2, String sp) {
        this.ad = ad;
        this.st = st;
        this.tn = tn;
        this.court_name = court_name;
        this.court_code = court_code;
        this.sa_num = sa_num;
        this.r = r;
        this.ba = ba;
        this.b_u = b_u;
        this.b_s = b_s;
        this.l_n_right = l_n_right;
        this.la = la;
        this.l_u = l_u;
        this.l_s = l_s;
        this.b_i2 = b_i2;
        this.l_i2 = l_i2;
        this.sp = sp;
    }
}
