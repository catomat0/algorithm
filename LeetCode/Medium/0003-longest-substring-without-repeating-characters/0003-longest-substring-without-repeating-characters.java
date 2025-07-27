class Solution {
    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> used = new HashMap<>();
        int maxLen = 0, left = 0, right = 0;

        for (char c : s.toCharArray()) {

            if (used.containsKey(c) && left <= used.get(c)) {
                left = used.get(c) + 1;
            } else {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            used.put(c, right);
            right++;
        }

        return maxLen;
    }
}