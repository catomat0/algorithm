class Solution {
    public int solution(int n) {
        int p = 1;
        while (7 * p < n) {
            p++;
        }
        return p;
    }
}