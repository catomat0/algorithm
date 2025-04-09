import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    
    /**
     * 5
     *
     * 6 <- 9 <- 5 <- 7 <- 4
     * 0    0    2    2    4
     */

    public static void solution1(int [] inputs) {

        int[] answers = new int[inputs.length];


        // init -stack
        ArrayDeque<Integer> originalStack = new ArrayDeque<>();
        for (int i = 0; i < inputs.length; i++) {
            originalStack.push(inputs[i]);
        }

        // logic
        for (int i = 0; i < inputs.length; i++) {

            ArrayDeque<Integer> stack = originalStack.clone();
            int target = 0;
            int targetIndex = inputs.length;

            for (int j = 0; j <= i; j++) {
                target = stack.pop();
                targetIndex--;
            }

            int cnt = 1;
            while (!stack.isEmpty()) {

                if (target <= stack.pop()) {
                    answers[i] = targetIndex - cnt + 1;
                    break;
                }
                cnt++;
            }
            // answers[i] 값이 정해지지 않으면 자바의 배열 기본 값 0 입력
        }

        // 출력부
        for (int i = answers.length - 1; i >= 0; i--) {

            if (i > 0) {
                System.out.print(answers[i] + " ");
            } else {
                System.out.print(answers[i]);
            }
        }

    }

    public static void solution2(int [] inputs) {

        int[] answers = new int[inputs.length];
        ArrayDeque<int[]> stack = new ArrayDeque<>();  // [탑 높이, 인덱스]
        // int[2] -> for : i = 0 -> while, if 조건 불충족하여 new int[]{height, i} 로 size : 2 
        
        for (int i = 0; i < inputs.length; i++) {
            int height = inputs[i];

            // 현재 탑보다 낮은 탑들은 수신 불가 → 제거
            while (!stack.isEmpty() && stack.peek()[0] < height) {
                stack.pop();
            }

            // 수신 가능한 탑이 있다면, 그 인덱스를 기록
            if (!stack.isEmpty()) {
                answers[i] = stack.peek()[1] + 1;  // idx 와 순서는 다름
            }

            // 현재 탑 push
            stack.push(new int[]{height, i});
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int ans : answers) {
            sb.append(ans).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] inputs = new int[num];
        for (int i = 0; i < num; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }

//        solution1(inputs);
        solution2(inputs);
    }
}
