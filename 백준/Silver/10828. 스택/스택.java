import java.io.*;
import java.util.*;

public class Main {

    public static String solution(StringTokenizer[] sts) {

        StringBuilder answer = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();

        for (StringTokenizer st : sts) {
            String cmd = st.nextToken();

            if (cmd.equals("push")) {
                int value = Integer.parseInt(st.nextToken());
                stack.addLast(value);
            } else if (cmd.equals("pop")) {
                if (!stack.isEmpty()) {
                    answer.append(stack.removeLast()).append("\n");
                } else {
                    answer.append("-1").append("\n");
                }
            } else if (cmd.equals("size")) {
                answer.append(stack.size()).append("\n");
            } else if (cmd.equals("empty")) {
                if (!stack.isEmpty()) {
                    answer.append("0").append("\n");
                } else {
                    answer.append("1").append("\n");
                }
            } else if (cmd.equals("top")) {
                if (!stack.isEmpty()) {
                    answer.append(stack.getLast()).append("\n");
                } else {
                    answer.append("-1").append("\n");
                }
            }
        }
        
        return answer.toString();
    }


    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer[] sts = new StringTokenizer[N];
        for (int i = 0; i < N; i++) {
            sts[i] = new StringTokenizer(br.readLine());
        }
        bw.write(solution(sts));

        bw.flush();
        bw.close();
        br.close();
    }
}
