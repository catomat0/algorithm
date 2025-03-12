class Solution {
    public String solution(String my_string) {
        String str = "";
        String[] strings = my_string.split("");

        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals("a")) {
                strings[i] = "";
            }
            if (strings[i].equals("e")) {
                strings[i] = "";
            }
            if (strings[i].equals("i")) {
                strings[i] = "";
            }
            if (strings[i].equals("o")) {
                strings[i] = "";
            }
            if (strings[i].equals("u")) {
                strings[i] = "";
            }
            str += strings[i];
        }
        return str;
    }
}