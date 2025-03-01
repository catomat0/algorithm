class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] answers = new int[len];
        int p = 1;

        for (int i = 0; i < len; i++) {
            answers[i] = p;
            p *= nums[i];
        }
        
        p = 1;
        for (int i = len - 1; i >= 0; i--) {
            answers[i] *= p;
            p *= nums[i];
        }

        return answers;
    }
}