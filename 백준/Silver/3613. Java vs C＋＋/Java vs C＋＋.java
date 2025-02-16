import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static String solution(String str) {
        StringBuilder answer = new StringBuilder();

        // InvalidFormat
        isValidFormat(str, answer);
        if (answer.length() > 0) {
            return answer.toString();
        }

        // ValidFormat
        if (str.contains("_")) { // c++ -> java
            String[] strings = str.split("_");
            answer.append(strings[0]);
            for (int i = 1; i < strings.length; i++) {
                answer.append(strings[i].substring(0, 1).toUpperCase()).append(strings[i].substring(1));
            }
            return answer.toString();
        }
        else { // java -> c++
            char[] chars = str.toCharArray();
            answer.append(chars[0]);
            for (int i = 1; i < chars.length; i++) {
                if (Character.isUpperCase(chars[i])) {
                    answer.append("_").append(chars[i]);
                } else {
                    answer.append(chars[i]);
                }
            }
            return answer.toString().toLowerCase();
        }
    }

    /**
     * 첫 글자가 언더바 또는 대문자이면 에러 d
     * 마지막 글자가 언더바이면 에러 d
     * 언더바가 중복되어 나오면 에러
     * 대문자와 언더바가 동시에 나온다면 에러 d
     */
    private static void isValidFormat(String str, StringBuilder sb) {
        if (str.charAt(0) == '_' || Character.isUpperCase(str.charAt(0))) {
            sb.append("Error!");
            return;
        }

        if (str.charAt(str.length() - 1) == '_') {
            sb.append("Error!");
            return;
        }

        if (str.contains("_")) {
            for (int i = 0; i < str.length(); i++) {
                if (Character.isUpperCase(str.charAt(i))) {
                    sb.append("Error!");
                    return;
                }
            }
        }

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) =='_') {
                if (str.charAt(i + 1) == '_') {
                    sb.append("Error!");
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

//        System.out.println(solution("long_and_mnemonic_identifier"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(solution(str));

    }
}