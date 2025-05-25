class Solution {
    static class Point {
        double distance;
        int[] point;

        public Point(double distance, int[] point) {
            this.distance = distance;
            this.point = point;
        }
    }

    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> a.distance));

        for (int[] point : points) {
            double distance = Math.sqrt((long) point[0] * point[0] + (long) point[1] * point[1]);
            pq.add(new Point(distance, point));
        }

        int[][] results = new int[k][];
        for (int i = 0; i < k; i++) {
            results[i] = pq.poll().point;
        }
        return results;
    }
}