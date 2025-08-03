import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    /**
     * (종류 + 1) * (종류 + 1) * (종류 + 1) ... -1 -> 해당 케이스의 경우의 수
     */
    public static String solution(String[] list) {
        int answer = 1;

        Map<String, Integer> map = new HashMap<>();
        for (String s : list) {
            String[] strs = s.split(" ");
            map.put(strs[1], map.getOrDefault(strs[1], 0) + 1);
        }
        // map 의 모든 키의 밸류를 뽑는 방법
        for (Integer value : map.values()) {
            answer *= (value + 1);
        }

        return (answer - 1) + "";
    }

    public static void main(String[] args) throws IOException {


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {

            int T = Integer.parseInt(br.readLine());
            String[] inputs = new String[T];
            for (int j = 0; j < T; j++) {
                inputs[j] = br.readLine();
            }
            if (i != N - 1) {
                bw.write(solution(inputs));
                bw.write("\n");
            } else {
                bw.write(solution(inputs));
            }

        }

        bw.flush();
        bw.close();
        br.close();
    }
}
