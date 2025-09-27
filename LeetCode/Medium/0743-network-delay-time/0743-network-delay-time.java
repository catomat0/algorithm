class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.putIfAbsent(time[0], new HashMap<>());
            graph.get(time[0]).put(time[1], time[2]);
        }
        // 소요시간 기준 정렬
        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        pq.add(new AbstractMap.SimpleEntry<>(k, 0));
        
        // 도착지, 소요시간 저장
        Map<Integer, Integer> dist = new HashMap<>();
        while (!pq.isEmpty()) {

            // Entry 사용 - 바로 getKey, getValue -> 도착지 소요시간 리턴
            Map.Entry<Integer, Integer> cur = pq.poll();
            int u = cur.getKey();
            int dist_u = cur.getValue();

            // u지점까지의 소요시간 계산
            if (!dist.containsKey(u)) {
                // 결과 변수에 삽입
                dist.put(u, dist_u);
                // u지점이 출발지인 경로가 있으면 진행
                if (graph.containsKey(u)) {
                    // u지점이 출발지인 모든 경로 순회
                    for (Map.Entry<Integer, Integer> v : graph.get(u).entrySet()) {
                        // u 지점까지의 소요시간 + u지점이 출발지-도착지 소요시간
                        int alt = dist_u + v.getValue();
                        pq.add(new AbstractMap.SimpleEntry<>(v.getKey(), alt));
                    }    
                }
            }
        }
        
        // 모든 노드를 순회하면 ok
        if (dist.size() == n) {
            return Collections.max(dist.values());
        }
        // 순회 불가 시 -1
        return -1;
    }
}