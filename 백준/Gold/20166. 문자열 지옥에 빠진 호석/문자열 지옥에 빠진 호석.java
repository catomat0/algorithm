
import java.io.*;
import java.util.*;

/**
 * 일종의 마스킹 기법 - 2차원 캐릭터 배열 순회를 통해서 경로값 저장과 타겟 값 일치를 통한 경우의 수
 */

public class Main {

    static int N, M, K;
    static char[][] map;
    static int[] dx = {-1,-1,-1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1,-1, 0, 1};
    static Map<String, Integer> cache;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray(); // 격자
        }

        for (int i = 0; i < K; i++) {
            String target = br.readLine();
            cache = new HashMap<>();

            int totalCount = 0;

            // 2. 모든 격자에서 target 시작 가능한 위치 탐색
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    if (map[x][y] == target.charAt(0)) {
                        totalCount += dfs(x, y, 1, target);
                    }
                }
            }

            bw.write(totalCount + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // DFS
    public static int dfs(int x, int y, int depth, String target) {
        if (depth == target.length()) return 1; // 문자열 완성

        // 캐시 키: "x,y,depth"
        String key = x + "," + y + "," + depth;
        if (cache.containsKey(key)) return cache.get(key);

        int count = 0;
        for (int d = 0; d < 8; d++) {
            int nx = (x + dx[d] + N) % N;
            int ny = (y + dy[d] + M) % M;

            if (map[nx][ny] == target.charAt(depth)) {
                count += dfs(nx, ny, depth + 1, target);
            }
        }

        cache.put(key, count);
        return count;
    }
}