
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

    public static long solution(long[] inputs) {

        long answer = 0;
        ArrayDeque<Long> stack = new ArrayDeque<>();

        for (int i = 0; i < inputs.length; i++) {
            long target = inputs[i];

            while (!stack.isEmpty() && target >= stack.peek()) {
                stack.pop();
            }
            answer += stack.size();
            stack.push(inputs[i]);
        }
        

        return answer;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        long[] inputs = new long[num];
        for (int i = 0; i < num; i++) {
            inputs[i] = Long.parseLong(br.readLine());
        }

        System.out.println(solution(inputs));
    }
}
