
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void solution(String[] inputs) {
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (String input : inputs) {
            
            String[] strings;
            if (input.contains("push")) {
                strings = input.split(" ");
                queue.offer(Integer.parseInt(strings[1]));

            } else {

                if (input.equals("pop")) {

                    sb.append((!queue.isEmpty()) ? queue.poll() : -1).append("\n");

                } else if (input.equals("size")) {

                    sb.append(queue.size()).append("\n");

                } else if (input.equals("empty")) {

                    sb.append((queue.isEmpty()) ? 1 : 0).append("\n");

                } else if (input.equals("front")) {

                    sb.append((!queue.isEmpty()) ? queue.peek() : -1).append("\n");

                } else if (input.equals("back")) {

                    sb.append((!queue.isEmpty()) ? ((LinkedList<Integer>) queue).getLast() : -1)
                            .append("\n");

                }

            }

        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        String[] strings = new String[num];
        for (int i = 0; i < num; i++) {
            strings[i] = br.readLine();
        }
        solution(strings);
    }
}
