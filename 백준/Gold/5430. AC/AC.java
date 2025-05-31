import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.List;

public class Main {

    public static String solution(String cmd, int cmdLen, String[] arr) {
        StringBuilder sb = new StringBuilder();
        ArrayDeque<String> deque = new ArrayDeque<>(List.of(arr));
        boolean rvs = false;

        for (int i = 0; i < cmdLen; i++) {
            char c = cmd.charAt(i);
            if (c == 'R') {
                rvs = !rvs;
            } else if (c == 'D') {
                if (deque.isEmpty()) {
                    return "error";
                }
                if (!rvs) {
                    deque.removeFirst();
                } else {
                    deque.removeLast();
                }
            }
        }

        sb.append("[");
        while (!deque.isEmpty()) {
            
            if (!rvs) {
                sb.append(deque.removeFirst());
            } else {
                sb.append(deque.removeLast());
            }
            
            if (!deque.isEmpty()) {
                sb.append(",");
            }
        }
        sb.append("]");

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String cmd = br.readLine();
            int cmdLen = cmd.length();
            int size = Integer.parseInt(br.readLine());
            String arrLine = br.readLine();
            String[] arr;

            if (arrLine.equals("[]")) {
                arr = new String[0];
            } else {
                arr = arrLine.substring(1, arrLine.length() - 1).split(",");
            }

            System.out.println(solution(cmd, cmdLen, arr));
        }
    }
}
