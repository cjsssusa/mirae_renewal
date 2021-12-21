package kr.co.landfuture.ads.landrule.data;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

@Embeddable
public class LandRuleId implements Serializable {
    private String sido;
    private String sgg;
    private String umd;
    private String li;
    private String st_nm;

    public LandRuleId() {
    }

    public LandRuleId(String sido, String sgg, String umd, String li, String st_nm) {
        this.sido = sido;
        this.sgg = sgg;
        this.umd = umd;
        this.li = li;
        this.st_nm = st_nm;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        LandRuleId accountId = (LandRuleId) o;
        return (this.sido.equals(accountId.sido) && this.sgg.equals(accountId.sgg) && this.sgg.equals(accountId.umd)
                && this.sgg.equals(accountId.li) && this.sgg.equals(accountId.st_nm));
    }

    public int hashCode() {
        return Objects.hash(new Object[] { this.sido, this.sgg, this.umd, this.li, this.st_nm });
    }
}
