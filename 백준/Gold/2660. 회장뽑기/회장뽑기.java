import java.io.*;
import java.util.*;

/**
 * 입력의 첫째 줄에는 회원의 수가 있다. 단, 회원의 수는 50명을 넘지 않는다.
 * 둘째 줄 이후로는 한 줄에 두 개의 회원번호가 있는데, 이것은 두 회원이 서로 친구임을 나타낸다.
 * 회원번호는 1부터 회원의 수만큼 붙어 있다. 마지막 줄에는 -1이 두 개 들어있다.
 * <p>
 * 첫째 줄에는 회장 후보의 점수와 후보의 수를 출력하고,
 * 두 번째 줄에는 회장 후보를 오름차순으로 모두 출력한다.
 */

public class Main {

    public static int bfs(List<Integer>[] graph, int target, int member) {

        Queue<Integer> queue = new ArrayDeque<>();
        int[] distance = new int[member + 1];
        Arrays.fill(distance, -1);

        distance[target] = 0;
        queue.add(target);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (Integer i : graph[cur]) {
                if (distance[i] == -1) {
                    distance[i] = distance[cur] + 1;
                    queue.add(i);
                }
            }

        }

        int max = 0;

        for (int i = 1; i <= member; i++) {
            if (distance[i] == -1) {
                return 50;
            }
            max = Math.max(max, distance[i]);
        }

        return max;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        int member = Integer.parseInt(br.readLine());

        // 1-> [2,3] 2-> [1] 3-> [1,2,4] ...
        List<Integer>[] graph = new ArrayList[member+1];
        for (int i = 1; i <= member; i++) {
            graph[i] = new ArrayList<>();
        }

        while (true) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (n == -1 && m == -1) {
                break;
            }

            graph[n].add(m);
            graph[m].add(n);
        }

        // 후보 리스트
        List<Integer> list = new ArrayList<>();
        int[] scores = new int[member + 1];
        int score = 50;

        // bfs 탐색
        for (int i = 1; i <= member; i++) {
            scores[i] = bfs(graph,i, member);
            score = Math.min(score, scores[i]);
        }

        // 후보
        for (int i = 1; i <= member; i++) {
            if (scores[i] == score) {
                list.add(i);
            }
        }

        // 출력
        bw.write(score + " " + list.size()+"\n");
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) bw.write(" ");
            bw.write(String.valueOf(list.get(i)));
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
