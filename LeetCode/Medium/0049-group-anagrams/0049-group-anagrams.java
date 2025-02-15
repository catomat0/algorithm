import java.util.*;
import java.io.*;


class Solution {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new ConcurrentHashMap<>();

        // strs 원소의 철자 정렬하면 대표 문자열 생성

        // 대표 문자열과 매칭
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);

            // 매칭 실패 시 리스트 생성 후 추가
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }
            // 매칭 성공 시 리스트업
            map.get(s).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }
}