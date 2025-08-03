import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static boolean solution(String input) {

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {

            char target = input.charAt(i);

            if (target == '(') {
                stack.push(target);
            } else if (target == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            bw.write(solution(line) ? "YES" : "NO");
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
