import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static String solution(int[] inputs) {
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int[] arr = new int[inputs.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        int idx = 0;
        for (int t : inputs) {

            while (idx < arr.length && (stack.isEmpty() || stack.peek() < t)) {
                stack.push(arr[idx++]);
                sb.append("+\n");
            }

            if (stack.isEmpty() || stack.peek() != t) {
                return "NO";
            }

            stack.pop();
            sb.append("-\n");
        }

        return sb.toString();
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int num = Integer.parseInt(br.readLine());
        
        int[] inputs = new int[num];
        for (int i = 0; i < num; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
        }

        // 출력
        System.out.println(solution(inputs));
    }
}
