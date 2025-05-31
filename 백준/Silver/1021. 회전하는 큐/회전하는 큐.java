import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    
    public static int solution(Deque<Integer> deque, int[] targets) {
        int cnt = 0;

        for (int i = 0; i < targets.length; i++) {
            int target = targets[i];

            int idx = 0;
            for (int val : deque) {
                if (val == target) break;
                idx++;
            }

            int left = idx;
            int right = deque.size() - idx;

            if (left <= right) {
                // 왼쪽으로 회전
                for (int j = 0; j < left; j++) {
                    deque.addLast(deque.removeFirst());
                    cnt++;
                }
            } else {
                // 오른쪽으로 회전
                for (int j = 0; j < right; j++) {
                    deque.addFirst(deque.removeLast());
                    cnt++;
                }
            }

            // target 제거
            deque.removeFirst();
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {

        ArrayDeque<Integer> deque = new ArrayDeque<>();


        int N, M;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer firstLine = new StringTokenizer(br.readLine());
        StringTokenizer secondLine = new StringTokenizer(br.readLine());

        N = Integer.parseInt(firstLine.nextToken());
        M = Integer.parseInt(firstLine.nextToken());

        for (int i = 0; i < N; i++) {
            deque.add(i + 1);
        }

        int[] targets = new int[M];
        for (int i = 0; i < targets.length; i++) {
            targets[i] = Integer.parseInt(secondLine.nextToken());
        }

        System.out.println(solution(deque, targets));
        // 10 3 -> 1 2 3 4 5 6 7 8 9 10 ~ 3개 뽑을 예정
        // 2 9 5 ->

        // 0 '2'3456789101
        // 1 3456789101
        // 2 1345678910
        // 3 1013456789
        // 4 '9' 101345678
        // 5 810134567
        // 6 781013456
        // 7 678101345
        // 8 '5' 67810134
    }
}
