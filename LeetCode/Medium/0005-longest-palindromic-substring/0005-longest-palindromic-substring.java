class Solution {
    public String longestPalindrome(String s) {
        
    int len = s.length();
        if (len < 2) {
            return s;
        }

        int left = 0;
        int maxLen = 0;

        // size = 2, size = 3 윈도우
        for (int i = 0; i < len - 1; i++) {
            int[] res1 = isPalindrome(s, i, i + 1, left, maxLen);
            int[] res2 = isPalindrome(s, i, i + 2, left, maxLen);

            // 가장 긴 팰린드롬 업데이트
            if (res1[1] > maxLen) {
                left = res1[0];
                maxLen = res1[1];
            }
            if (res2[1] > maxLen) {
                left = res2[0];
                maxLen = res2[1];
            }
        }

        return s.substring(left, left + maxLen);
    }

    private static int[] isPalindrome(String s, int j, int k, int left, int maxLen) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }

        int len = k - j - 1;
        if (maxLen < len) {
            left = j + 1;
            maxLen = len;
        }

        return new int[]{left, maxLen};
    }
}