package kr.co.landfuture.ads.pattern;

public class PatternStreet {
        public static String st_nm_first = PCommon.ADDS_first;
        public static String um_in_st_nm = "( *[^ 0-9]+(?:읍|면) +){0,1}";

        public static String st_nm = // 전라북도 군산시 구암3.1로 30, 상가에이동 1층107호 (대명동,현대메트로타워2차)
                        " *(" + //
                                        "[0-9]*[^ 0-9]*[0-9.]*" + //
                                        "(?:" + //
                                        "(?:대)?로|거리|(?:" + PCommon.Ga_A + ")?(?:안)?길" + //
                                        ")" + //
                                        "(?:" + //
                                        " *[^ ]+(?:(?:안|번)?길)" + //
                                        "){0,1}" + //
                                        ") *"; //

        public static String bldg_num_in_st_nm = //
                        "(지하){0,1} *" + //
                                        "([0-9]+)" + //
                                        "(?: *\\- *([0-9]+)){0,1}"; //

        public static String comma_in_st_nm = "( *" + PCommon.COMMAS + "){0,1}";

        public static String A_ST_STD = //
                        st_nm_first + //
                                        um_in_st_nm + //
                                        st_nm + //
                                        " +" + //
                                        bldg_num_in_st_nm + //
                                        comma_in_st_nm + //
                                        "(?:" + //
                                        "( *[^\\(]+){0,1}?" + //
                                        "( +[^ ]+동){0,1}?" + //
                                        "( +[^ ]+층){0,1}" + //
                                        "( *[^ ]+호){0,1} *" + //
                                        "(?:" + //
                                        "\\(" + //
                                        "(?: *" + //
                                        "([^ 0-9" + PCommon.COMMAS + "]+[0-9]{0,2}" + PCommon.umd_a + "(?: *[0-9]가)?)" + //
                                        "(?: +| *" + PCommon.COMMAS + " *)" + //
                                        "){0,1}" + //
                                        " *(?:(.+) *){0,1}" + //
                                        "\\)" + //
                                        "){0,1}$" + //
                                        "){0,1}"; //
}
