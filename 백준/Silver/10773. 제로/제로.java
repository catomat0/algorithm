import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

    public static int solution(int[] inputs) {
        int sum = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < inputs.length; i++) {

            if (inputs[i] == 0) {
                stack.pop();
            } else {
                stack.push(inputs[i]);
            }
        }

        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int[] inputs = new int[num];
        for (int i = 0; i < num; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solution(inputs));
    }
}
