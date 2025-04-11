import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    /**
     * 3 5 2 7
     * ->
     * 5 7 7 -1
     */

    public static String solution1(int[] input) {

        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        // logic
        for (int i = 0; i < input.length; i++) {
            boolean valid = false;
            int target = input[i];
            for (int j = i; j < input.length; j++) {

                if (target < input[j]) {
                    sb.append(input[j]).append(" ");
                    valid = true;
                    break;
                }
            }

            if (!valid) {
                sb.append(-1).append(" ");
            }
            stack.push(input[i]);
        }

        return sb.toString().trim();
    }

    public static String solution2(int[] input) {

        int[] result = new int[input.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length; i++) {

            while (!stack.isEmpty() && input[stack.peek()] < input[i]) {
                result[stack.pop()] = input[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }

        for (int i : result) {
            sb.append(i).append(" ");
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int[] input = new int[num];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

//        System.out.println(solution1(input));
        System.out.println(solution2(input));
    }
}
