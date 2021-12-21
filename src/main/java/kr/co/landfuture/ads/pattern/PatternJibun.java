package kr.co.landfuture.ads.pattern;

public class PatternJibun {
        public static String JB_umd = //
                        "(" + //
                                        "(?:" + //
                                        "[^ 0-9]+[0-9]{0,2}" + //
                                        PCommon.umd_a //
                                        + "(?: *[0-9]가)?" + //
                                        ")" + //
                                        "|" + //
                                        "(?:" + //
                                        "[^ 0-9]+로[0-9]{1,2}가" + //
                                        ")" + //
                                        "|세종로|남성로|시장북로" + //
                                        ")"; //
        public static String JB_li = //
                        "(?:" + //
                                        " +([^ 0-9]+[0-9]?리) *" + //
                                        ")?"; //
        public static String JB_bunzi_1 = //
                        " *(산){0,1}" + //
                                        "(?:" + //
                                        " *([0-9]+)(?:번지){0,1}" + //
                                        "(?:" + //
                                        " *(?:\\-|－) *([0-9]+)(?:번지){0,1}" + //
                                        "){0,1}" + //
                                        "(?:" + PCommon.COMMAS + " *){0,1}" + //
                                        "){0,1}"; //
        public static String JB_bunzi_2 = //
                        " *(?:" + //
                                        "(?:" + //
                                        "(?:" + //
                                        "(?:번지|의) *" + //
                                        "([0-9]+)(?:호 *)?" + //
                                        "){0,1}?" + //
                                        ")" + //
                                        "|" + //
                                        "(?:" + //
                                        "([0-9]+)" + //
                                        "(?:호 *)" + //
                                        ")" + //
                                        ")"; //
        public static String JB_oi = //
                        "(" + //
                                        " *외 *" + //
                                        "[0-9]+" + //
                                        "(?:필지|건)" + //
                                        "){0,1}" + //
                                        "( *[^ ]*? *[^ ]*? *[^ ]*?){0,1}?"; //
        public static String JB_ho = //
                        "( *" + //
                                        "(?:" + PCommon.AB_A + "|[0-9]+)동" + //
                                        "){0,1}?" + //
                                        "( +[^ ]+층){0,1}" + //
                                        "( *[^ ]+ *호){0,1}" + //
                                        "( +[^0-9]+){0,1} *$"; //
        public static String A_JB_STD = //
                        PCommon.ADDS_first + //
                                        JB_umd + //
                                        JB_li + //
                                        JB_bunzi_1 + //
                                        JB_bunzi_2 + //
                                        JB_oi + //
                                        JB_ho; //
        public static String Umd_Li = //
                        "([^ 0-9]+[0-9]{0,2}" + //
                                        PCommon.umd_a + //
                                        "(?: *[0-9]가){0,1})" + //
                                        "( *[^ 0-9]+[0-9]?리 *){0,1}"; //
        public static String ADDS_Whole = //
                        PCommon.Sd_Sgg_Or + //
                                        Umd_Li + //
                                        JB_bunzi_1 + //
                                        JB_bunzi_2 + //
                                        JB_oi + //
                                        JB_ho; //
        // ===================================== 주소 분절 하나 인식
        // public static String Umd_Li_Ea = " *([^ 0-9]+[0-9]{0,2}" +
        // PatternCommon.umd_a
        // + "(?: *[0-9]가){0,1}?){0,1}( +[^ 0-9]+[0-9]?리 *){0,1}? *";
        public static String A_JB_BSC = //
                        PCommon.Sd_Sgg_Or + //
                                        JB_umd + //
                                        JB_li + //
                                        JB_bunzi_1 + //
                                        JB_bunzi_2 + //
                                        "{0,1}(+*)?"; //
}
