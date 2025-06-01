import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class problem {

        int deadLine;
        int quantity;

        public problem(int deadLine, int quantity) {
            this.deadLine = deadLine;
            this.quantity = quantity;
        }
    }

    public static void solution(int[][] arr) {

        int answer = 0;
        List<problem> problems = new ArrayList<>();

        // int[][] -> problems ( problem )
        for (int[] ints : arr) {
            problems.add(new problem(ints[0], ints[1]));
        }
        problems.sort(Comparator.comparingInt(p -> p.deadLine));

        // logic
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (problem problem : problems) {
            pq.offer(problem.quantity);

            if (pq.size() > problem.deadLine) {
                pq.poll();
            }
        }

        // calc
        while (!pq.isEmpty()) {
            answer += pq.poll();
        }

        // output
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        solution(arr);
    }
}
