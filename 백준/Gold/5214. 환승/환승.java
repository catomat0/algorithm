
import java.io.*;
import java.util.*;

// 처음 풀이 -> 입력 라인 전부 양방향으로 간선 저장 후 Math.min으로 최솟값 갱신 -> 메모리 / 시간 낭비 심함

// 모두 간선으로 엮으면 시간,메모리 낭비
// 해당 인덱스 = 해당 라인(튜브)인 배열을 생성해서 쓰면
// 거쳐가는 값이 생김 - 튜브(입력 라인) 기점으로 풀기

public class Main {

    public static int bfs(int N, int K, int M, List<Integer>[] stationToTubes, int[][] tubeToStations) {

        boolean[] visStation = new boolean[N + 1]; // 역 방문 여부
        boolean[] visTube = new boolean[M + 1]; // 튜브 방문 여부
        Deque<Integer> queue = new ArrayDeque<>();

        // 시작 역 -> 1
        queue.add(1);
        visStation[1] = true;
        int steps = 1;

        while (!queue.isEmpty()) {

            int sz = queue.size();

            while (sz > 0) {
                int s = queue.poll();

                // 해당 역에서 이용 가능한 모든 튜브로 탐색
                for (int t : stationToTubes[s]) {
                    // 같은 튜브 재방문 방지
                    if (visTube[t]){
                        continue;
                    }
                    // 재방문 제외 처리
                    visTube[t] = true;

                    // 튜브가 연결하는 모든 역 탐색
                    for (int i = 0; i < K; i++) {
                        int ns = tubeToStations[t][i];
                        if (visStation[ns]) continue;

                        if (ns == N) { // 다음 레벨에서 도착
                            return steps + 1;
                        }

                        visStation[ns] = true;
                        queue.add(ns);
                    }
                }
                sz--;
            }
            steps++; // 환승
        }

        return -1; // 도달 불가
    }


    public static void main(String[] args) throws Exception {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 1-N 역 수
        int K = Integer.parseInt(st.nextToken()); // 한 튜브의 할당 역 수 = 라인의 토큰 개수
        int M = Integer.parseInt(st.nextToken()); // 튜브 = 입력 라인

        // 예외처리
        if (N == 1) {
            bw.write("1");
            bw.flush();
            bw.close();
            br.close();
            return;
        }
        

        // 튜브 <-> 역
        List<Integer>[] stationToTubes = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            stationToTubes[i] = new ArrayList<>();
        }
        int[][] tubeToStations = new int[M + 1][K];

        // 튜브 <-> 해당 라인의 역
        for (int t = 1; t <= M; t++) {
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < K; i++) {
                int s = Integer.parseInt(st.nextToken());
                tubeToStations[t][i] = s; // 튜브 -> 역
                stationToTubes[s].add(t); // 역 -> 튜브
            }
        }


        bw.write(String.valueOf(bfs(N, K, M, stationToTubes, tubeToStations)));
        bw.flush();
        br.close();
        bw.close();
    }
}
