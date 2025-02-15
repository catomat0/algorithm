class Solution {
    public void reverseString(char[] s) {
        char tmp;
        int start = 0;
        int end = s.length - 1;

        while(start < end) {
            tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }

}