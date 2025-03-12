class Solution {
    public int solution(int n) {
        int answer = 0;
        int i = 1;
        while (i <= 1000000) {
            if ((i * i) == n) {
                return 1;
            } else {
                i++;
            }
        }
        return 2;
    }
}