class Solution {
    public String[] reorderLogFiles(String[] logs) {
        int size = logs.length;
        List<String> letters = new ArrayList<>();
        List<String> digits = new ArrayList<>();

        // 문자 - 숫자 분류 후 저장
        for (int i = 0; i < size; i++) {

            if (Character.isDigit(logs[i].split(" ")[1].charAt(0))) {
                digits.add(logs[i]);
            } else {
                letters.add(logs[i]);
            }
        }

        // 문자 리스트 정렬
        sortLetters(letters);

        // 문자, 숫자 배열 순으로 answer 에 삽입 후 리턴
        letters.addAll(digits);
        return letters.toArray(new String[0]);
    }

    private static void sortLetters(List<String> letters) {
        int n = letters.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) { 
                String[] s1 = letters.get(j).split(" ", 2);
                String[] s2 = letters.get(j + 1).split(" ", 2);

                int cmp = s1[1].compareTo(s2[1]); // 내용 비교
                if (cmp > 0 || (cmp == 0 && s1[0].compareTo(s2[0]) > 0)) {
                    
                    Collections.swap(letters, j, j + 1);
                }
            }
        }
    }
}