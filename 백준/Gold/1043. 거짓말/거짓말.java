import java.io.*;
import java.util.*;

/**
 * 첫째 줄에 사람의 수 N과 파티의 수 M이 주어진다.
 * 둘째 줄에는 이야기의 진실을 아는 사람의 수와 번호가 주어진다. 진실을 아는 사람의 수가 먼저 주어지고 그 개수만큼 사람들의 번호가 주어진다. 사람들의 번호는 1부터 N까지의 수로 주어진다.
 * 셋째 줄부터 M개의 줄에는 각 파티마다 오는 사람의 수와 번호가 같은 방식으로 주어진다.
 *
 * 첫째 줄에 문제의 정답을 출력한다.
 */

public class Main {

    public static void bfs(int start, List<Integer>[] graph, boolean[] truth) {
        
        Queue<Integer> queue = new ArrayDeque<>();
        truth[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            
            int cur = queue.poll();
            for (Integer i : graph[cur]) {
                
                if (!truth[i]) {
                    truth[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());

        int truthCnt = Integer.parseInt(st.nextToken());
        int[] truthPeople = new int[truthCnt];
        for (int i = 0; i < truthCnt; i++) {

            truthPeople[i] = Integer.parseInt(st.nextToken());
        }


        List<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {

            graph[i] = new ArrayList<>();
        }

        List<Integer>[] parties = new ArrayList[M];
        for (int i = 0; i < M; i++) {

            parties[i] = new ArrayList<>();
        }

        // 입력
        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {

                int person = Integer.parseInt(st.nextToken());
                parties[i].add(person);
            }

            int a = parties[i].get(0);
            for (int j = 1; j < k; j++) {

                int b = parties[i].get(j);
                graph[a].add(b);
                graph[b].add(a);
            }
        }

        // 로직
        boolean[] truth = new boolean[N + 1];
        for (int p : truthPeople) {

            if (!truth[p]) {
                bfs(p, graph, truth);
            }
        }

        // 파티 검사 - 파티 개수 x 해당 파티 인원 수
        int answer = 0;
        for (int i = 0; i < M; i++) {
            boolean lie = true;
            for (int person : parties[i]) {

                if (truth[person]) {
                    lie = false;
                    break;
                }
            }

            if (lie) {
                answer++;
            }

        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}
