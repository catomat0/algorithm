class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        String[] strings = my_string.split("");
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < n; j++) {
                answer += strings[i];
            }
        }
        return answer;
    }
}