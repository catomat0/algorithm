import java.util.*;

class Solution {

    public String mostCommonWord(String paragraph, String[] banned) {
        // 문자열 나누어 단어 출현 횟수 카운팅 하기 위한 Map
        Map<String, Integer> map = new HashMap<>();
        // 금지 단어 내역 저장 - Set (contains())
        Set<String> ban = new HashSet<>(List.of(banned));

        // 특수 문자 제거, 소문자 처리 후 배열 저장
        String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");
        
        for (String w : words) {
            // 금지 단어가 아닌 것 만 map 저장
            if (!ban.contains(w)) {
                map.put(w, map.getOrDefault(w, 0) + 1);
            }
        }
        
        // 최다 빈도 문자열(키) 반환
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}