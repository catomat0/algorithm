class Solution {
    public int numJewelsInStones(String J, String S) {

        int count = 0;
        Set<Character> freqs = new HashSet<>();

        for (char j : J.toCharArray()) {
            freqs.add(j);
        }

        for (char s : S.toCharArray()) {
            if (freqs.contains(s)) {
                count++;
            }
        }
        return count;
    }
}