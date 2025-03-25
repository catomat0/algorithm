import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void Solution(int num, int turn) {
        // init
        List<Integer> circle = new LinkedList<>();
        List<Integer> answers = new ArrayList<>();
        // num 초기화
        for (int i = 1; i <= num; i++) {
            circle.add(i);
        }

        // Logic
        ListIterator<Integer> pointer = circle.listIterator(0);
        while (!circle.isEmpty()) {
            // turn 의 횟수만큼 반복
            for (int i = 0; i < turn; i++) {
                if (!pointer.hasNext()) {
                    pointer = circle.listIterator(); // 현재 사이즈 내에서 turn 만큼 돌 때 넘어가면 앞부터 시작
                }
                pointer.next(); 
            }

            // 원소 출력
            pointer.previous();
            int value = pointer.next(); // 현재 요소 얻기
            answers.add(value);
            pointer.remove(); // 삭제

            // 리스트가 비면 예외 발생하기에 로직 중단을 위한 예외 처리
            if (circle.isEmpty()) {
                break;
            }
        }


        // 출력부
        System.out.print("<");
        for (int i = 0; i < num; i++) {
            if (i != (num - 1)) {
                System.out.print(answers.get(i) + ", ");
            } else {
                System.out.print(answers.get(i));
            }
        }
        System.out.print(">");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int turn = Integer.parseInt(st.nextToken());

        Solution(num, turn);

        // 7 , 3

        // 3  6  2  7  5  1  4
        // 2  5  1  6  4  0  3

        // 3  6  9 12 15 18 21

        // 1 2 3 4 5 6 7 -   size: 7
        // 1 2   4 5 6 7 - 3 size: 6
        // 1 2   4 5   7 - 6 size: 5
        // 1     4 5   7 - 2 size: 4
        // 1     4 5     - 7 size: 3
        // 1     4       - 5 size: 2
        //       4       - 1 size: 1
        // Done          - 4
    }
}