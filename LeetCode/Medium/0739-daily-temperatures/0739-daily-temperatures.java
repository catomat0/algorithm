class Solution {
    public static int[] dailyTemperatures(int[] temperatures) {

        int[] answers = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && (temperatures[i] > temperatures[stack.peek()])) {
                int last = stack.pop();
                answers[last] = i - last;
            }

            stack.push(i);
        }

        return answers;
    }
}