class Solution {
    public boolean isValid(String s) {
        // () -> 40,41 | {} -> 123,125 | [] -> 91,93 //

        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (int i = 0; i < s.length(); i++) {

            if (!map.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if (stack.isEmpty() || map.get(s.charAt(i)) != stack.pop()) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}