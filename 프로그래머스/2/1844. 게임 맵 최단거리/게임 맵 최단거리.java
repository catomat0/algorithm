import java.util.*;

class Solution {
   static class Position {
        final int x;
        final int y;
        final int distance;

        public Position(int y, int x, int distance) {
            this.y = y;
            this.x = x;
            this.distance = distance;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getDistance() {
            return distance;
        }
    }

    Queue<Position> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance));

    public void findPath(int y, int x, int distance, int[][] maps) {

        if (y >= 0 && y < maps.length && x >= 0 && x < maps[0].length && maps[y][x] != 0) {
            maps[y][x] = 0; // 지나온 경로를 0으로 설정 - 재탐색 xx
            pq.add(new Position(y, x, distance + 1));
        }
    }

    public int solution(int[][] maps) {

        // 출발지
        pq.add(new Position(0, 0, 1));
        Map<Integer, Position> dist = new LinkedHashMap<>();

        while (!pq.isEmpty()) {
            // 거리가 가장 짧은 값 추출
            Position cur = pq.poll();

            // 아직 계산하지 않은 지점 -> 결과 삽입
            // map이라서 키 : y * 1000 + x로 설정 -> x, y 값 제한 1-100 사이 정수
            if (!dist.containsKey(cur.getY() * 1000 + cur.getX())) {
                dist.put(cur.getY() * 1000 + cur.getX(), cur);

                // 동서남북 탐색
                findPath(cur.getY(), cur.getX() + 1, cur.getDistance(), maps);
                findPath(cur.getY(), cur.getX() - 1, cur.getDistance(), maps);
                findPath(cur.getY() + 1, cur.getX(), cur.getDistance(), maps);
                findPath(cur.getY() - 1, cur.getX(), cur.getDistance(), maps);
            }
        }

        // 목표 도달 성공 -> 도달하기까지 걸린 거리
        if (dist.containsKey((maps.length - 1) * 1000 + (maps[0].length - 1))) {
            return dist.get((maps.length - 1) * 1000 + (maps[0].length - 1)).getDistance();
        }

        // 목표 도달 x
        return -1;
    }
}