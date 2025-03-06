import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int solution(int roomNumber){

        int answer = 0;
        int upDownCnt = (int) String.valueOf(roomNumber).chars().filter(c -> c == '6' || c == '9').count();

        // 0 ~ 5, 7, 8 Int -> String []
        String[] processed = String.valueOf(roomNumber).replaceAll("[69]", "").split("");

        // 0 ~ 5, 7, 8 Processing
        int[] cnt = new int[10]; // Counting Array
        for (String s : processed) {
            if (!s.isBlank()) {
                cnt[Integer.parseInt(s)]++; // Checking Numbers and Save into Counting Array
            }
        }

        int max = 0;
        for (int i = 0; i < cnt.length; i++) {
            max = Math.max(max, cnt[i]);
        }

        answer += Math.max(max, (upDownCnt + 1) / 2);


        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        System.out.println(solution(input));

    }
}