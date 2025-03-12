import java.util.*;


class Solution {
    public int[] solution(String[] strlist) {
        int[] answers;
        List<Integer> arr = new ArrayList<>();
        for (String s : strlist) {
            arr.add(s.length());
        }
        answers = arr.stream().mapToInt(i ->i).toArray();
        return answers;
    }
}