package kr.co.landfuture.ads.landrule.repo;

import java.sql.SQLSyntaxErrorException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.co.landfuture.ads.datainout.AddressOut;
import kr.co.landfuture.ads.landrule.data.LandRuleModel;
import kr.co.landfuture.util.Def;

@Repository
public class LandRuleDynamicRepository {
    @Autowired
    private NamedParameterJdbcOperations jdbcOperations;

    @Transactional("landruleTransactionManager")
    public List<String> t1() {
        String query = "select \tb.sido from c_ads.bd_011 b";
        query = query + " left join cjs_collection_6.zipcode_nsdi_20200329 z ";
        query = query + " on b.sido = z.sido ";
        query = query + " limit 1 ";

        return this.jdbcOperations.query(query, (rs, rowNum) -> new String(rs.getString("sido")));
    }

    @Transactional("landruleTransactionManager")
    public List<LandRuleModel> selectSidoSgg(String sgg, String st_nm) {
        String query = "select \tsido, sgg, umd, li, st_nm from \tc_ads.land_rule_cd_v3 where\t1 = 1";
        if (!sgg.equals(""))
            query = query + " and sgg = '" + sgg + "' ";
        if (!st_nm.equals(""))
            query = query + " and st_nm like '" + st_nm + "%' ";
        query = query + " limit 1 ";

        return this.jdbcOperations.query(query, (rs, rowNum) -> new LandRuleModel(rs.getString("sido"),
                rs.getString("sgg"), rs.getString("umd"), rs.getString("li"), rs.getString("st_nm")));
    }

    @Transactional("landruleTransactionManager")
    public List<LandRuleModel> selectSgg(String sido, String umd) {
        String query = "select \tsido, sgg, umd, li, umd from \tc_ads.land_rule_cd_v3 where\t1 = 1";
        if (!sido.equals(""))
            query = query + " and sido = '" + sido + "'";
        if (!umd.equals("")) {
            query = query + " and umd = '" + umd + "' ";
        }
        return this.jdbcOperations.query(query, (rs, rowNum) -> new LandRuleModel(rs.getString("sido"),
                rs.getString("sgg"), rs.getString("umd"), rs.getString("li"), rs.getString("umd")));
    }

    @Transactional("landruleTransactionManager")
    public List<AddressOut> srchStreet(AddressOut aOut) {
        String sgg_4_n;
        if (aOut.getSgg().equals("세종")) {
            sgg_4_n = "";
        } else {
            sgg_4_n = aOut.getSgg();
        }
        String query = "SELECT  bd.st_nm, bd.b_n bs, bd.b_bon, bd.b_bu, bd.b_nm_sgg, bd.b_usage, bd.c_lat lat, bd.c_lng lng, bd.e_lat, bd.e_lng";

        query = query + "         FROM c_ads.navi_bd_0" + Def.SL_2_Num(aOut.getSido())
                + " bd  LEFT JOIN c_ads.navi_jb_0" + Def.SL_2_Num(aOut.getSido())
                + " jb      ON bd.b_mgnt_num = jb.b_mgnt_num      WHERE          jb.sido  = '" + aOut.getSido()
                + "'      AND jb.sgg   = '" + sgg_4_n + "'      AND jb.umd   like '" + aOut.getUmd().substring(0, 2)
                + "%'      AND jb.bon   = '" + aOut.getBon() + "'      AND jb.bu    = '" + aOut.getBu() + "' ";

        query = query + "  AND jb.sido IS NOT null limit 1 ";

        return this.jdbcOperations.query(query, (rs, rowNum) -> {
            aOut.setSt_nm(rs.getString("st_nm"));

            aOut.setBs(rs.getString("bs"));

            aOut.setB_bon(rs.getString("b_bon"));
            aOut.setB_bu(rs.getString("b_bu"));
            aOut.setB_nm_sgg(rs.getString("b_nm_sgg"));
            aOut.setB_usage(rs.getString("b_usage"));
            aOut.setLat(rs.getString("lat"));
            aOut.setLng(rs.getString("lng"));
            aOut.setE_lat(rs.getString("e_lat"));
            aOut.setE_lng(rs.getString("e_lng"));
            try {
                return aOut.copy();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return aOut;
        });
    }

    @Transactional("landruleTransactionManager")
    public List<AddressOut> srchJibun(AddressOut aOut) throws SQLSyntaxErrorException {
        String sgg_4_n;
        if (aOut.getSido().equals("세종")) {
            sgg_4_n = "";
        } else {
            sgg_4_n = aOut.getSgg();
        }
        String query = "SELECT  jb.umd, jb.li, jb.san, jb.bon, jb.bu, bd.c_lat lat, bd.c_lng lng, bd.e_lat, bd.e_lng ";

        query = query + "         FROM c_ads.navi_bd_0" + Def.SL_2_Num(aOut.getSido())
                + " bd  LEFT JOIN c_ads.navi_jb_0" + Def.SL_2_Num(aOut.getSido())
                + " jb      ON bd.b_mgnt_num = jb.b_mgnt_num      WHERE          bd.sido  = '" + aOut.getSido()
                + "'      AND bd.sgg   = '" + sgg_4_n + "'      AND bd.st_nm   = '" + aOut.getSt_nm()
                + "'      AND bd.b_bon   = '" + aOut.getB_bon() + "'      AND bd.b_bu    = '" + aOut.getB_bu() + "' ";
        query = query + "  AND jb.sido IS NOT null ";
        query = query + "  ORDER BY jb.jb_se ";
        query = query + "  desc limit 1 ";

        return this.jdbcOperations.query(query, (rs, rowNum) -> {
            aOut.setUmd(rs.getString("umd"));
            aOut.setLi(rs.getString("li"));
            aOut.setSan(rs.getString("san"));
            aOut.setBon(rs.getString("bon"));
            aOut.setBu(rs.getString("bu"));
            aOut.setLat(rs.getString("lat"));
            aOut.setLng(rs.getString("lng"));
            aOut.setE_lat(rs.getString("e_lat"));
            aOut.setE_lng(rs.getString("e_lng"));
            try {
                return aOut.copy();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return aOut;
        });
    }
}
