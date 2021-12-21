package kr.co.landfuture.util;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;

public class UtilFunc {
    public static void pnt_cp() {
    }

    public static boolean isJsonValid(final String json) throws IOException {
        return isJsonValid(new StringReader(json));
    }

    public static boolean isJsonValid(final Reader reader) throws IOException {
        return isJsonValid(new JsonReader(reader));
    }

    public static boolean isJsonValid(final JsonReader jsonReader) throws IOException {
        try {
            JsonToken token;
            loop: while ((token = jsonReader.peek()) != JsonToken.END_DOCUMENT && token != null) {
                switch (token) {
                    case BEGIN_ARRAY:
                        jsonReader.beginArray();
                        break;
                    case END_ARRAY:
                        jsonReader.endArray();
                        break;
                    case BEGIN_OBJECT:
                        jsonReader.beginObject();
                        break;
                    case END_OBJECT:
                        jsonReader.endObject();
                        break;
                    case NAME:
                        jsonReader.nextName();
                        break;
                    case STRING:
                    case NUMBER:
                    case BOOLEAN:
                    case NULL:
                        jsonReader.skipValue();
                        break;
                    case END_DOCUMENT:
                        break loop;
                    default:
                        throw new AssertionError(token);
                }
            }
            return true;
        } catch (final MalformedJsonException ignored) {
            return false;
        }
    }

    // Get fields and values from an Object
    public static Map<String, Object> getFieldNamesAndValues(Object obj, boolean publicOnly)
            throws IllegalArgumentException, IllegalAccessException {
        Class<? extends Object> c1 = (Class<? extends Object>) obj.getClass();
        Map<String, Object> map = new HashMap<>();
        Field[] fields = c1.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            String name = fields[i].getName();
            if (publicOnly) {
                if (Modifier.isPublic(fields[i].getModifiers())) {
                    Object value = fields[i].get(obj);
                    if (value == null)
                        value = "";
                    map.put(name, value);
                }
            } else {
                fields[i].setAccessible(true);
                Object value = fields[i].get(obj);
                if (value == null)
                    value = "";
                map.put(name, value);
            }
        }
        return map;
    }

    public static void print_map(Map<String, Object> m) {// map을 이쁘게 프린트
        for (Map.Entry<String, Object> entry : m.entrySet()) {
            System.out.println((String) entry.getKey()
                    + (!is_empty_null((String) entry.getValue()) ? (" ------> " + entry.getValue()) : ""));
        }
    }

    public static String str_or_not(String s) {// String이 값이 있으면 '값'을 없으면 ""
        return !is_empty_null(s) ? s : "";
    }

    public static String str_space_or_not(String s) {
        return !is_empty_null(s) ? (s + " ") : "";
    }

    public static boolean is_empty_null(String s) {// String이 공백이거나 null인지 확인
        if (s == null || s.isEmpty() || s.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    public static String remove_head(String a) {// 분석전 주소 정리 - 사용본거지: 제거
        if (a != null) {
            String[] stringarray = a.split("(광구소재지:|본거지:|소재지:|어장의위치:|대한민국|선적항:|사용본거지:|보관장소:|보관장소-|<보관장소>)");
            return stringarray[0];
        }
        return a;
    }

    public static String remove_jae(String s) {
        if (is_empty_null(s))
            return s;
        Stream<String> r_stream = Pattern.compile("(제)(.+)").matcher(s).results().map(m2 -> m2.group(1));
        if (!is_empty_null(r_stream.findFirst().orElse(null)))
            s = r_stream.iterator().next();
        return s;
    }

    public static String cjs_trim_dong(String dong) {
        return dong.replaceAll("1가|2가|3가|4가|5가|6가|7가|8가|9가|0|1|2|3|4|5|6|7|8|9", "");
    }

    public static String Cjs_City_2_Short(String sido) { // 서울특별시 ---> 서울
        sido = sido.trim();
        if (sido.equals("전라북도")) {
            sido = "전북";
        } else if (sido.equals("충청북도")) {
            sido = "충북";
        } else if (sido.equals("전라남도")) {
            sido = "전남";
        } else if (sido.equals("경상남도")) {
            sido = "경남";
        } else if (sido.equals("경상북도")) {
            sido = "경북";
        } else if (sido.equals("경기도")) {
            sido = "경기";
        } else if (sido.equals("충청남도")) {
            sido = "충남";
        } else if (sido.equals("강원도")) {
            sido = "강원";
        } else if (sido.contains("대구")) {
            sido = "대구";
        } else if (sido.contains("세종")) {
            sido = "세종";
        } else if (sido.contains("광주")) {
            sido = "광주";
        } else if (sido.contains("대전")) {
            sido = "대전";
        } else if (sido.contains("서울")) {
            sido = "서울";
        } else if (sido.contains("제주")) {
            sido = "제주";
        } else if (sido.contains("인천")) {
            sido = "인천";
        } else if (sido.contains("부산")) {
            sido = "부산";
        } else if (sido.contains("울산")) {
            sido = "울산";
        }
        return sido;
    }

    public static String Cjs_State_2_Long(String sido) {
        sido = sido.trim();
        if (sido.equals("강원")) {
            sido = "강원도";
        } else if (sido.equals("경기")) {
            sido = "경기도";
        } else if (sido.equals("경남")) {
            sido = "경상남도";
        } else if (sido.equals("경북")) {
            sido = "경상북도";
        } else if (sido.equals("광주")) {
            sido = "광주광역시";
        } else if (sido.equals("대구")) {
            sido = "대구광역시";
        } else if (sido.equals("대전")) {
            sido = "대전광역시";
        } else if (sido.equals("부산")) {
            sido = "부산광역시";
        } else if (sido.equals("서울")) {
            sido = "서울특별시";
        } else if (sido.equals("울산")) {
            sido = "울산광역시";
        } else if (sido.equals("인천")) {
            sido = "인천광역시";
        } else if (sido.equals("전남")) {
            sido = "전라남도";
        } else if (sido.equals("전북")) {
            sido = "전라북도";
        } else if (sido.equals("제주")) {
            sido = "제주특별자치도";
        } else if (sido.equals("충남")) {
            sido = "충청남도";
        } else if (sido.equals("충북")) {
            sido = "충청북도";
        } else if (sido.equals("세종")) {
            sido = "세종특별자치시";
        }
        return sido;
    }

    public static String sgg_2_normal(String sgg) { // sgg가 시구가 붙은 것들 정식 명칭으로
        if (Pattern.compile(".*고양.*덕양.*").matcher(sgg).find()) {
            sgg = "고양시 덕양구";
        } else if (Pattern.compile(".*고양.*일산동.*").matcher(sgg).find()) {
            sgg = "고양시 일산동구";
        } else if (Pattern.compile(".*고양.*일산서.*").matcher(sgg).find()) {
            sgg = "고양시 일산서구";
        } else if (Pattern.compile(".*성남.*분당.*").matcher(sgg).find()) {
            sgg = "성남시 분당구";
        } else if (Pattern.compile(".*성남.*수정.*").matcher(sgg).find()) {
            sgg = "성남시 수정구";
        } else if (Pattern.compile(".*성남.*중원.*").matcher(sgg).find()) {
            sgg = "성남시 중원구";
        } else if (Pattern.compile(".*수원.*권선.*").matcher(sgg).find()) {
            sgg = "수원시 권선구";
        } else if (Pattern.compile(".*수원.*영통.*").matcher(sgg).find()) {
            sgg = "수원시 영통구";
        } else if (Pattern.compile(".*수원.*장안.*").matcher(sgg).find()) {
            sgg = "수원시 장안구";
        } else if (Pattern.compile(".*수원.*팔달.*").matcher(sgg).find()) {
            sgg = "수원시 팔달구";
        } else if (Pattern.compile(".*안산.*단원.*").matcher(sgg).find()) {
            sgg = "안산시 단원구";
        } else if (Pattern.compile(".*안산.*상록.*").matcher(sgg).find()) {
            sgg = "안산시 상록구";
        } else if (Pattern.compile(".*안양.*동안.*").matcher(sgg).find()) {
            sgg = "안양시 동안구";
        } else if (Pattern.compile(".*안양.*만안.*").matcher(sgg).find()) {
            sgg = "안양시 만안구";
        } else if (Pattern.compile(".*용인.*기흥.*").matcher(sgg).find()) {
            sgg = "용인시 기흥구";
        } else if (Pattern.compile(".*용인.*수지.*").matcher(sgg).find()) {
            sgg = "용인시 수지구";
        } else if (Pattern.compile(".*용인.*처인.*").matcher(sgg).find()) {
            sgg = "용인시 처인구";
        } else if (Pattern.compile(".*청주.*상당.*").matcher(sgg).find()) {
            sgg = "청주시 상당구";
        } else if (Pattern.compile(".*청주.*서원.*").matcher(sgg).find()) {
            sgg = "청주시 서원구";
        } else if (Pattern.compile(".*청주.*청원.*").matcher(sgg).find()) {
            sgg = "청주시 청원구";
        } else if (Pattern.compile(".*청주.*흥덕.*").matcher(sgg).find()) {
            sgg = "청주시 흥덕구";
        } else if (Pattern.compile(".*천안.*동남.*").matcher(sgg).find()) {
            sgg = "천안시 동남구";
        } else if (Pattern.compile(".*천안.*서북.*").matcher(sgg).find()) {
            sgg = "천안시 서북구";
        } else if (Pattern.compile(".*전주.*덕진.*").matcher(sgg).find()) {
            sgg = "전주시 덕진구";
        } else if (Pattern.compile(".*전주.*완산.*").matcher(sgg).find()) {
            sgg = "전주시 완산구";
        } else if (Pattern.compile(".*포항.*남.*").matcher(sgg).find()) {
            sgg = "포항시 남구";
        } else if (Pattern.compile(".*포항.*북.*").matcher(sgg).find()) {
            sgg = "포항시 북구";
        } else if (Pattern.compile(".*창원.*마산합포.*").matcher(sgg).find()) {
            sgg = "창원시 마산합포구";
        } else if (Pattern.compile(".*창원.*마산회원.*").matcher(sgg).find()) {
            sgg = "창원시 마산회원구";
        } else if (Pattern.compile(".*창원.*성산.*").matcher(sgg).find()) {
            sgg = "창원시 성산구";
        } else if (Pattern.compile(".*창원.*의창.*").matcher(sgg).find()) {
            sgg = "창원시 의창구";
        } else if (Pattern.compile(".*창원.*진해.*").matcher(sgg).find()) {
            sgg = "창원시 진해구";
        }
        return sgg;
    }
}
