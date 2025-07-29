import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    /**
     3 2 1 -3 -1 ->
     1 2 3 4 5
     1 4 5 3 2
     */
    public static String solution(int num, StringTokenizer str) {
        StringBuilder sb = new StringBuilder();
        List<int[]> circle = new LinkedList<>();
        int idx = 0, i = 0;

        // 풍선 종이 값으로 초기화
        while (str.hasMoreTokens()) {
            circle.add(new int[]{i++, Integer.parseInt(str.nextToken())});
        }

        // 연산
        while (!circle.isEmpty()) {
            int next = circle.get(idx)[1];
            sb.append(circle.get(idx)[0] + 1).append(" ");
            circle.remove(idx);

            // size = 0 예외 처리
            if (circle.isEmpty()) break;

            if (next > 0) {
                idx = (idx + (next - 1)) % circle.size();
            } else {
                idx = (idx + next) % circle.size();
                if (idx < 0) {
                    idx += circle.size();
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        StringTokenizer str = new StringTokenizer(br.readLine());

        bw.write(solution(num, str));

        bw.flush();
        bw.close();
    }
}