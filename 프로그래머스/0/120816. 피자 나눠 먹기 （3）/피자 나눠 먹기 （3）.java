class Solution {
    public int solution(int slice, int n) {
        if (slice >= n) {
            return 1;
        } else {
            int p = 1;
            while (p * slice < n) {
                p++;
            }
            return p;
        }
    }
}