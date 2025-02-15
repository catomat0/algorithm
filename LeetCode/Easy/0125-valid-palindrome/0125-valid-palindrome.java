class Solution {
    
    public boolean isPalindrome(String s) {
        StringBuilder answer = new StringBuilder();
        StringBuilder reverse = new StringBuilder();

        String str = s.toLowerCase();
        // 소문자로 만들기, 문자만 남기기(특수문자, 공백 제거) -> answer 저장
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i)) ||Character.isDigit(str.charAt(i))) {
                answer.append(str.charAt(i));
            }
        }

        if (answer.length() == 1) {
            return true;
        }
        if (answer.length() == 2) {
            if (answer.charAt(0) != answer.charAt(1)) {
                return false;
            }
        }

        // 뒤집기 -> 원본 answer 과 비교(equals())하여 동일하면 true 리턴
        for (int i = 0; i < answer.length(); i++) {
            reverse.append(answer.charAt(answer.length() - 1 - i));
        }

        return answer.toString().contentEquals(reverse);
    }
        
}