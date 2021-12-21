package kr.co.landfuture.ads.landrule.data;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "land_rule_cd_v3")
@IdClass(LandRuleId.class)
public class LandRuleModel implements Serializable {
    @Id
    private String sido;
    @Id
    private String sgg;
    @Id
    private String umd;
    @Id
    private String li;
    @Id
    private String st_nm;
    @Column(name = "sido_s")
    private String sido_s;

    public LandRuleModel() {
    }

    public LandRuleModel(String sido, String sgg, String umd, String li, String st_nm) {
        this.sido = sido;
        this.sgg = sgg;
        this.umd = umd;
        this.li = li;
        this.st_nm = st_nm;
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

    public String getli() {
        return this.li;
    }

    public String getst_nm() {
        return this.st_nm;
    }

    public String toString() {
        return "Tutorial [sido=" + this.sido + ", sgg=" + this.sgg + "]";
    }
}
