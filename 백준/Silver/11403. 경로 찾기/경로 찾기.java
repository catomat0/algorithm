import java.io.*;
import java.util.*;

public class Main {

    public static void bfs(StringBuilder sb, int N, boolean[] visited, String[][] graph) {

        for (int i = 0; i < N; i++) {
            Arrays.fill(visited, false);
            Deque<Integer> queue = new ArrayDeque<>();

            for (int j = 0; j < N; j++) {
                if (graph[i][j].equals("1") && !visited[j]) {
                    visited[j] = true;
                    queue.addLast(j);
                }
            }

            while (!queue.isEmpty()) {
                int idx = queue.poll();
                for (int j = 0; j < N; j++) {
                    if (graph[idx][j].equals("1") && !visited[j]) {
                        visited[j] = true;
                        queue.addLast(j);
                    }
                }
            }

            for (int j = 0; j < N; j++) {
                sb.append(visited[j] ? 1 : 0);
                if (j < N - 1) sb.append(" ");
            }
            sb.append("\n");

        }
    }


    public static void dfs(StringBuilder sb, int N, boolean[] visited, String[][] graph) {

        for (int i = 0; i < N; i++) {
            Arrays.fill(visited, false);
            Deque<Integer> stack = new ArrayDeque<>();

            for (int j = 0; j < N; j++) {
                if (graph[i][j].equals("1") && !visited[j]) {
                    visited[j] = true;
                    stack.push(j);
                }
            }

            while (!stack.isEmpty()) {
                int idx = stack.pop();
                for (int j = 0; j < N; j++) {
                    if (graph[idx][j].equals("1") && !visited[j]) {
                        visited[j] = true;
                        stack.push(j);
                    }
                }
            }

            for (int j = 0; j < N; j++) {
                sb.append(visited[j] ? 1 : 0);
                if (j < N - 1) sb.append(" ");
            }
            sb.append("\n");

        }
    }


    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[N];
        String[][] graph = new String[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = st.nextToken();
            }
        }

        bfs(sb, N, visited, graph);
//        dfs(sb, N, visited, graph);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
