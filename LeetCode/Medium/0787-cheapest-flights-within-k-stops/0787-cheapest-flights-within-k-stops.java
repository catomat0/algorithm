class Solution {
    
//    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//
//        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
//        for (int[] flight : flights) {
//            graph.putIfAbsent(flight[0], new HashMap<>());
//            graph.get(flight[0]).put(flight[1], flight[2]); // 출발지 (도착지, 비용)
//        }
//
//        // 비용으로 정렬
//        Queue<List<Integer>> pq = new PriorityQueue<>(
//                Comparator.comparing(a -> a.get(1))
//        );
//        pq.add(Arrays.asList(src, 0, 0));
//
//        while (!pq.isEmpty()) {
//            // 가장 저렴한 값부터 추출
//            List<Integer> cur = pq.poll();
//
//            int u = cur.get(0); // 도착지
//            int price_u = cur.get(1); // 비용
//            int k_visited = cur.get(2); // 경로
//
//            // 추출 값이 도착지면 종료
//            if (u == dst) {
//                return price_u;
//            }
//
//            // 경로 횟수가 k만큼보다 남았을 시
//            if (k_visited <= k) {
//                k_visited++; // 진행 시 경로 횟수 추가
//                if (graph.containsKey(u)) {
//                    // 경로 순회
//                    for (Map.Entry<Integer, Integer> v : graph.get(u).entrySet()) {
//                        // 현재 지점의 비용 + 현재 지점까지 올 때까지 쓰인 비용
//                        int alt = price_u + v.getValue();
//                        pq.add(Arrays.asList(v.getKey(), alt, k_visited));
//                    }
//                }
//            }
//        }
//
//        return -1;
//    }


    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.putIfAbsent(flight[0], new HashMap<>());
            graph.get(flight[0]).put(flight[1], flight[2]);
        }
        // 비용으로 정렬
        Queue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.get(1)));
        pq.add(Arrays.asList(src, 0, 0));

        Map<Integer, Integer> visited = new HashMap<>(); // 타임 아웃 방지 - 방문 경로 저장 Map

        while (!pq.isEmpty()) {

            // pq의 List<Integer> -> 도착지, 비용, 진행경로
            List<Integer> cur = pq.poll();
            int u = cur.get(0);
            int price_u = cur.get(1);
            int k_visited = cur.get(2);

            // 추출 값이 도착지면 종료
            if (u == dst) {
                return price_u;
            }

            // u 까지의 진행경로 저장 / 비용이 가장 저렴한 경로
            visited.put(u, k_visited);

            // k 횟수 이내에 진행 경로 횟수가 남았으면 진행
            if (k_visited <= k) {
                // 진행하였기 때문에 횟수 증가
                k_visited++;
                // u가 출발지인 경로 존재 시 작업
                if (graph.containsKey(u)) {
                    for (Map.Entry<Integer, Integer> v : graph.get(u).entrySet()) {
                        // 이미 계산한 경로는 큐에 넣지 않음으로 타임 아웃 방지
                        if (!visited.containsKey(v.getKey()) || k_visited < visited.get(v.getKey())) {
                            // u 까지의 비용 + u -> 도착지까지의 비용
                            int alt = price_u + v.getValue();
                            // 큐에 등록
                            pq.add(Arrays.asList(v.getKey(), alt, k_visited));
                        }
                    }
                }
            }
        }
        return -1;
    }
}