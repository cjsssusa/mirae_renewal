package kr.co.landfuture.ads.service;

import kr.co.landfuture.ads.datainout.AddressIn;
import kr.co.landfuture.ads.datainout.AddressOut;
import kr.co.landfuture.ads.landrule.data.LandRuleModel;
import kr.co.landfuture.ads.landrule.repo.LandRuleRepository;
import kr.co.landfuture.ads.pattern.PCommon;
import kr.co.landfuture.ads.pattern.PatternJibun;
import kr.co.landfuture.ads.pattern.PatternLocal;
import kr.co.landfuture.ads.pattern.PatternStreet;
import kr.co.landfuture.util.UtilFunc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

@Service
public class ParsingAddress {
    @Autowired
    LandRuleRepository landruleRepository;

    // while (m.find()) {
    // for (int i = 1; i <= m.groupCount(); i++) {
    // System.out.println(m.group(i));
    // }
    // }
    public AddressOut street_01(AddressIn aIn) throws IllegalArgumentException, IllegalAccessException {
        AddressOut ao = new AddressOut();
        Pattern r = Pattern.compile(PatternStreet.A_ST_STD);
        Matcher m = r.matcher(aIn.address);
        if (m.find()) {
            ao.setAds_ps_tp("street");
            int i = -1;
            ao.setSido(m.group(1));
            ao.setSgg(m.group(2));
            ao.setUm(m.group(i + 4));
            ao.setSt_nm(m.group(i + 5));
            ao.setBs(m.group(i + 6));
            ao.setB_bon(m.group(i + 7));
            ao.setB_bu(m.group(i + 8));
            ao.setA_dong(m.group(i + 11));
            ao.setA_floor(m.group(i + 12));
            ao.setA_ho(m.group(i + 13));
            ao.setUmd_st(m.group(i + 14));
            ao.setA_place(UtilFunc.str_space_or_not(m.group(i + 10)) + UtilFunc.str_or_not(m.group(i + 15)));
        }
        return ao;
    }

    public AddressOut jibun_01(AddressIn aIn) throws IllegalArgumentException, IllegalAccessException {
        AddressOut ao = new AddressOut();
        Pattern r = Pattern.compile(PatternJibun.A_JB_STD);
        Matcher m = r.matcher(aIn.address);
        if (m.find()) {
            ao.setAds_ps_tp("jibun_basic");
            int i = -1;
            ao.setSido(m.group(1));
            ao.setSgg(m.group(2));
            ao.setUmd(m.group(i + 4));
            ao.setLi(m.group(i + 5));
            ao.setSan(m.group(i + 6));
            ao.setBon(m.group(i + 7));
            if (!UtilFunc.is_empty_null(m.group(i + 9))) {
                ao.setBu(m.group(i + 9));
            } else if (!UtilFunc.is_empty_null(m.group(i + 10))) {
                ao.setBu(m.group(i + 10));
            } else {
                ao.setBu(m.group(i + 8));
            }
            ao.setO_land(m.group(i + 11));
            ao.setA_place(UtilFunc.str_or_not(m.group(i + 12)) + UtilFunc.str_or_not(m.group(i + 16)));
            ao.setA_dong(m.group(i + 13));
            ao.setA_floor(m.group(i + 14));
            ao.setA_ho(m.group(i + 15));

            if (UtilFunc.is_empty_null(ao.getA_dong())) {
                Pattern r2 = Pattern.compile("(?:^| +)([^ ]+)(동|동호)");
                Matcher m2 = r2.matcher(ao.getA_place());
                if (m.find()) {
                    ao.setA_dong(m2.group(1) + "동");
                    ao.setA_place("");
                }
            }

            if (UtilFunc.is_empty_null(ao.getA_dong()) && UtilFunc.is_empty_null(ao.getA_floor())
                    && 
                    
                        Pattern.compile("[^ ]층").matcher(ao.getA_place()).results().count() > 0L
                        
                        
                        ) {
                ao.setA_floor(ao.getA_place());
                ao.setA_place("");
            } else if (UtilFunc.is_empty_null(ao.getA_dong()) && UtilFunc.is_empty_null(ao.getA_ho())
                    && Pattern.compile("[^ ]층").matcher(ao.getA_place()).results().count() > 0L) {
                ao.setA_ho(ao.getA_place());
                ao.setA_place("");
            } else if (UtilFunc.is_empty_null(ao.getA_floor())) {

                Stream<String> r_stream = Pattern.compile("([^ ]+)층 *([^ ]+)호").matcher(ao.getA_place()).results()
                        .map(m2 -> m2.group(1));
                if (r_stream.count() > 0L) {
                    ao.setA_floor(r_stream.findFirst() + "층");
                    ao.setA_ho((String) r_stream.iterator().next() + "호");
                }
            }

            ao.setA_dong(UtilFunc.remove_head(ao.getA_dong()));
            ao.setA_floor(UtilFunc.remove_head(ao.getA_floor()));
            ao.setA_ho(UtilFunc.remove_head(ao.getA_ho()));
        }
        return ao;
    }

    public AddressOut jibun_02(AddressIn aIn) throws IllegalArgumentException, IllegalAccessException {
        AddressOut ao = new AddressOut();
        Pattern r = Pattern.compile(PatternJibun.ADDS_Whole);
        Matcher m = r.matcher(aIn.address);
        if (m.find()) {
            ao.setAds_ps_tp("jibun_whole");
            ao.setSido(m.group(1));
            ao.setSgg(m.group(2));
            ao.setUmd(m.group(3));
            ao.setLi(m.group(4));

            ao.setBon(m.group(6));
            if (!UtilFunc.is_empty_null(m.group(8))) {
                ao.setBu(m.group(8));
            } else if (!UtilFunc.is_empty_null(m.group(9))) {
                ao.setBu(m.group(9));
            } else {
                ao.setBu(m.group(7));
            }
        }
        return ao;
    }

    public AddressOut jibun_03(AddressIn aIn) throws IllegalArgumentException, IllegalAccessException {
        AddressOut ao = new AddressOut();
        ao.setAds_ps_tp("jibun_sd_sgg");
        boolean b_sd = false;
        boolean b_sgg = false;
        boolean b_umd = false;
        boolean b_sn = false;
        String[] words = aIn.address.split("\\s");
        int i = 0;
        for (String w : words) {
            i++;
            if (!b_sd && !b_sgg && !b_umd) {
                Matcher m = Pattern.compile("(" + PCommon.sd_a + ")").matcher(w);
                if (m.find()) {
                    b_sd = true;
                    ao.setSido(m.group(1));
                    continue;
                }
            }
            if (!b_sgg && !b_umd) {
                for (String val : PatternLocal.sgg_all_name) {

                    Matcher m = Pattern.compile(Pattern.quote(w)).matcher(val);
                    if (m.find()) {
                        b_sgg = true;
                        ao.setSgg(val);
                        break;
                    }
                }
                if (b_sgg)
                    continue;
            }
            if (!b_umd && !b_sn) {
                for (String val : PatternLocal.umd_all_name) {
                    Matcher m = Pattern.compile(Pattern.quote(w)).matcher(val); // 특수문자를 그대로 사용하도록
                    if (m.find()) {
                        b_umd = true;
                        ao.setUmd(val);
                        break;
                    }
                }
                if (b_umd)
                    continue;
            }
            if (!b_umd && !b_sn) {
                List<LandRuleModel> expensiveItems = this.landruleRepository.listAddressesLikeWord(w + "%");
                Iterator<LandRuleModel> iterator = expensiveItems.iterator();
                if (iterator.hasNext()) {
                    LandRuleModel r_sgg = iterator.next();
                    ao.setAds_ps_tp("street");
                    b_sn = true;
                    ao.setSido(r_sgg.getsido());
                    ao.setSgg(r_sgg.getsgg());
                    ao.setSt_nm(r_sgg.getst_nm());
                }

            } else {

                if (b_umd || b_sn) {
                    Matcher m = Pattern.compile("([0-9]+)(?:(?:\\-|－)([0-9]+)){0,1}").matcher(w);
                    if (m.find()) {
                        if (b_umd) {
                            ao.setBon(m.group(1));
                            ao.setBu(m.group(2));
                            break;
                        }
                        if (b_sn) {
                            ao.setB_bon(m.group(1));
                            ao.setB_bu(m.group(2));
                        }
                    }
                }
                break;
            }
            continue;
        }
        if (words.length > i) {
            ao.setEach_else("");
            for (int k = i; k < words.length; k++) {
                ao.setEach_else(ao.getEach_else() + " " + words[k]);
            }
        }
        if (!b_sd && !b_sgg && !b_umd && !b_sn) {
            ao.setAds_ps_tp("jibun_else");
            ao.setA_first(ao.getAddress());
            ao.setEach_else(ao.getAddress());
        }
        return ao;
    }
}
