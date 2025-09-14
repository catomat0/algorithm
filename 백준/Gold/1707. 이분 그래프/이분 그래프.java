import java.io.*;
import java.util.*;

public class Main {

    public static boolean bfs(int start, int[] direction, List<Integer>[] graph) {

        Queue<Integer> queue = new ArrayDeque<>();
        direction[start] = 1;
        queue.add(start);

        while (!queue.isEmpty()) {

            int cur = queue.poll();

            for (Integer i : graph[cur]) {

                // + / - 1 구분 짓기
                if (direction[i] == 0) {
                    direction[i] = -direction[cur];
                    queue.add(i);
                } else if (direction[i] == direction[cur]) { // ++ -- 동일 부호 판별 -> 거짓
                    return false;
                }
            }
        }

        return true;
    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer>[] graph;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            graph = new ArrayList[V + 1];
            for (int j = 1; j <= V; j++){
                graph[j] = new ArrayList<>();
            }

            // Java -> int[] 초기값 1 설정 되어 있음
            int[] direction = new int[V + 1];

            for (int j = 0; j < E; j++) {

                st = new StringTokenizer(br.readLine());
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());

                graph[left].add(right);
                graph[right].add(left);

            }

            boolean ok = true;
            for (int j = 1; j <= V && ok; j++) {
                if (direction[j] == 0) {
                    if (!bfs(j, direction, graph)) {
                        ok = false;
                    }
                }
            }
            if (i > 0) {
                bw.write("\n");
            }
            bw.write(ok ? "YES" : "NO");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
