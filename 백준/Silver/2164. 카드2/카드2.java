
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static int solution(int num) {

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= num; i++) {
            queue.offer(i);
        }

        while (queue.size() > 1) {

            queue.poll();
            queue.offer(queue.poll());
        }

        return queue.peek();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        System.out.println(solution(num));

    }
}
