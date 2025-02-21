class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder answer = new StringBuilder();
        
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int len = Math.max(word1.length(), word2.length());
        
        int i = 0;
        while (i < len) { // 두 단어를 모두 배치해야하므로 더 긴 길이의 문자열의 길이만큼 반복
            // word1 보다 작거나 같은 인덱스 i 입력 시 answer 에 배치
            if (i < chars1.length) {
                answer.append(chars1[i]);
            }
            
            // word2 보다 작거나 같은 인덱스 i 입력 시 answer 에 배치
            if (i < chars2.length) {
                answer.append(chars2[i]);
            }
            
            i++;
        }
        
        return answer.toString();
    }
}