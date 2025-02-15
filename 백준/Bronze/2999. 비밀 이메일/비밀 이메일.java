import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static String solution(String str) {
        String answer = "";

        int r = 0, c = 0;
        int n = str.length();
        int cnt = 0;

        // 행열 개수 정하기 -> a * b
        for (int i = 1; i <= n; i++) {
            if (n % i == 0 && i <= (n / i)) {
                r = i;
                c = n / i;
            }
        }

        // 행열 -> 열행 배열 뒤집어서 저장
        char[][] chars = new char[r][c];
        char[] strToChar = str.toCharArray();

        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                chars[j][i] = strToChar[cnt];
                cnt++;
            }
        }

        // 행열대로 string 저장 후 리턴
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                answer += chars[i][j];
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        System.out.println(solution(s));
    }
}
