import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

//    public static void solution(int[] arr) {
//
//        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
//        ArrayList<Integer> list = new ArrayList<>();
//
//        // loop
//        for (int i = 0; i < arr.length; i++) {
//
//            pq.add(arr[i]);
//
//            // find
//            if (pq.size() % 2 == 0) { // 짝수
//
//                for (int j = 0; j < (pq.size() / 2 - 1); j++) {
//                    list.add(pq.poll());
//                }
//            } else { // 홀수
//
//                for (int j = 0; j < (pq.size() / 2); j++) {
//                    list.add(pq.poll());
//                }
//            }
//
//            System.out.println(pq.peek());
//
//            // reset
//            for (int j = 0; j < list.size(); j++) {
//                pq.add(list.remove(j));
//            }
//        }
//    }

    public static void solution(int[] arr) {

        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];

            
            if (max.isEmpty() || num <= max.peek()) {
                max.offer(num);
            } else {
                min.offer(num);
            }

            
            if (max.size() > min.size() + 1) {
                min.offer(max.poll());
            } else if (min.size() > max.size()) {
                max.offer(min.poll());
            }

            
            System.out.println(max.peek());
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        solution(arr);
    }
}