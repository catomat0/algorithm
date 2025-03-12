class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[2];
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < num_list.length; i++) {
            if (num_list[i] % 2 == 0) {
                cnt2++;
            } else {
                cnt1++;
            }
        }
        answer[0] = cnt2;
        answer[1] = cnt1;
        return answer;
    }
}