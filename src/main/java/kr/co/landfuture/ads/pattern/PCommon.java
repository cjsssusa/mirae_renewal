package kr.co.landfuture.ads.pattern;

public class PCommon {
    public static String sd_c_do = "(?:(?:경남|경북|전남|전북|충남|충북)|(?:강원|경기|제주)(?:도){0,1}|(?:전라|충청|경상)(?:남|북|){0,1}(?:도))";

    public static String sd_c_si = "(?:광주|대구|대전|부산|서울|울산|인천|세종)(?:특별){0,1}(?:자치|광역){0,1}(?:시){0,1}";

    public static String sd_c_a = "(?:" + sd_c_do + "|" + sd_c_si + ")";

    public static String sd_a = "(?:" + sd_c_a + ")";

    public static String Ga_A = "가|나|다|라|마|바|사|아|차|카|타|파|하";
    public static String AB_A = "에이|비|시|씨|디|이|에프|지|쥐|A||B|C|C|D|E|F|G|G";
    public static String[] AB_H = new String[] { "에이", "비", "씨", "시", "디", "이", "에프", "지", "쥐" };
    public static String[] AB_E = new String[] { "A", "B", "C", "C", "D", "E", "F", "G", "G" };

    public static String sgg_a = "(?:시|군|구)";
    public static String umd_a = "(?:읍|면|동|가동|가[0-9]동|가)";

    // ------------------------------------- // 공통
    public static String sido_sgg_comm = "((?:" + sd_a + "|[^ \\(0-9]+시) *[^ 0-9]+구|[^ 0-9]+" + sgg_a + "|세종)";

    // ------------------------------------- // 시도 + 시군구
    public static String ADDS_first = " *(" + sd_a + " +){0,1}" + sido_sgg_comm + " +";

    // ------------------------------------- // 붙어있을 수 있고, 없을 수 도 있고
    public static String Sd_Sgg_Or = "(" + sd_a + " *){0,1}" + sido_sgg_comm + "{0,1}";

    // -------------------------------------
    public static String COMMAS = "(?:\\,|`| +|$)";
}
