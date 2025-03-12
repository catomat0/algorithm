class Solution {
    public int solution(int n) {
        String answer = n + "";
        int sum = 0;
        String[] strings = answer.split("");
        for (int i = 0; i < strings.length; i++) {
            sum += Integer.parseInt(strings[i]);
        }
        return sum;
    }
}