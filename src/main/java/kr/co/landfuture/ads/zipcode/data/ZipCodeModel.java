package kr.co.landfuture.ads.zipcode.data;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "zipcode_nsdi_20200329")
public class ZipCodeModel implements Serializable {
    @Id
    private String sido;
    @Id
    private String sgg;
    @Id
    private String umd;
    @Id
    private String sgg2;

    public ZipCodeModel() {
    }

    public ZipCodeModel(String sido, String sgg, String umd, String sgg2) {
        this.sido = sido;
        this.sgg = sgg;
        this.umd = umd;
        this.sgg2 = sgg2;
    }

    public String getsido() {
        return this.sido;
    }

    public String getsgg() {
        return this.sgg;
    }

    public String getumd() {
        return this.umd;
    }

    public String getsgg2() {
        return this.sgg2;
    }

    public String toString() {
        return "Tutorial [sido=" + this.sido + ", sgg=" + this.sgg + "]";
    }
}
