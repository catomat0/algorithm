class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answers = new int[2];
        int len = nums.length;

        // 예외 처리
        if (nums.length == 2) {
            answers[0] = 0;
            answers[1] = 1;
            return answers;
        }
        // front-idx        
        for (int i = 0; i < len - 1; i++) {
            // back-idx
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    answers[0] = i;
                    answers[1] = j;
                }
            }
        }
        return answers;
    }
}