import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

    // String -> 불변객체라서 원소 추가 시 메모리를 많이 잡아먹어서 Timeout -> 어차피 한글자로 나누어 저장하기에 Char로 저장하여 메모리 줄이기
    
    // br 통하여 입력받으면 노드화된 상태로 입력받음
    // list(0) ->  < < B P < A > > C d -
    // list(1) ->  T h I s I s S 3 C r 3 t

    public static StringBuilder[] Solution(LinkedList<LinkedList<Character>> list) {

        StringBuilder[] answers = new StringBuilder[list.size()];

        for (int i = 0; i < list.size(); i++) {
            LinkedList<Character> currentList = new LinkedList<>(); // 결과 리스트
            ListIterator<Character> cursor = currentList.listIterator(); // 커서 초기화

            for (char ch : list.get(i)) {
                if (ch == '<') {
                    if (cursor.hasPrevious()) {
                        cursor.previous(); // 왼쪽으로 이동
                    }
                } else if (ch == '>') {
                    if (cursor.hasNext()) {
                        cursor.next(); // 오른쪽으로 이동
                    }
                } else if (ch == '-') {
                    if (cursor.hasPrevious()) {
                        cursor.previous(); // 커서 왼쪽 이동 후 삭제
                        cursor.remove();
                    }
                } else {
                    cursor.add(ch); // 일반 문자 추가
                }
            }

            // 문자열 합성
            answers[i] = new StringBuilder();
            for (char s : currentList) {
                answers[i].append(s);
            }
        }
        return answers;
    }


    public static void main(String[] args) throws IOException {

        LinkedList<LinkedList<Character>> list = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // List 로 받는 이유는? 커서 동작을 해주는 ListIterator 사용하기 위해서
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            list.add(new LinkedList<>());
            String password = br.readLine();

            // 내부 리스트에 쪼개진 문자열 추가
            for (int j = 0; j < password.length(); j++) {
                list.get(i).add(password.charAt(j));
            }
        }

        StringBuilder[] answer = Solution(list);
        for (StringBuilder string : answer) {
            System.out.println(string.toString());
        }
    }
}
