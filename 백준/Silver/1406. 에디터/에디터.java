import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Ex1406 {

    /**
     * L	커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨) -> 현재 위치의 전 노드와 전전 노드 사이에 노드 생성
     * D	커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨) -> 현재 위치의 앞 노드와 앞앞 노드 사이에 노드 생성
     * B	커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨) -> 현재 위치의 전전 노드와 내 앞 노드 연결
     *      삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임
     * P $	$라는 문자를 커서 왼쪽에 추가함 -> 현재 위치에 노드 추가
     */

    /**
     * L -> prev 와 현재 노드 swap
     * D -> next 와 현재 노드 swap
     * B -> prev-prev 와 현재 노드 연결 (prev 노드 free)
     *
     * P -> prev 생성 후 값 삽입
     */

    public static String Solution(String string, String[][] inputs) {
        List<String> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        // init StringToLinkedList
        for (int i = 0; i < string.length(); i++) {
            list.add(String.valueOf(string.charAt(i)));
        }
        // Cursor - Node
        list.add("cursor");

        // input commands checking -> processing (methods)
        for (String[] input : inputs) {
            int cursorP = list.indexOf("cursor");

            if (!input[1].equals(" ")) { // input 'P $'
                list.set(cursorP, input[1]);
                list.add(cursorP + 1, "cursor");

            } else { // input 'L', 'D', 'B'

                if (input[0].equals("L") && cursorP != 0) { // "L"

                    String swap = list.get(cursorP - 1);
                    list.set(cursorP, swap);
                    list.set(cursorP - 1, "cursor");

                } else if (input[0].equals("D") && (cursorP != list.size() - 1)) { // "D"

                    String swap = list.get(cursorP + 1);
                    list.set(cursorP, swap);
                    list.set(cursorP + 1, "cursor");

                } else if (input[0].equals("B") && cursorP != 0) { // "B"
                    list.remove(cursorP - 1);
                }
            }
        }

        for (String s : list) {
            if (!s.equals("cursor")) {
                sb.append(s);
            }
        }

        return sb.toString();
    }

    public static String Solution2(String string, String[][] inputs) {

        List<String> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        // init StringToLinkedList
        for (int i = 0; i < string.length(); i++) {
            list.add(String.valueOf(string.charAt(i)));
        }

        ListIterator<String> cursor = list.listIterator(list.size());


        // input commands checking -> processing (methods)
        for (String[] input : inputs) {
            String command = input[0];

            if (command.equals("P")) {
                cursor.add(input[1]);
            } else if (command.equals("L") && cursor.hasPrevious()) {
                cursor.previous();
            } else if (command.equals("D") && cursor.hasNext()) {
                cursor.next();
            } else if (command.equals("B") && cursor.hasPrevious()) {
                 cursor.previous();
                 cursor.remove();
            }
        }

        for (String s : list) {
            sb.append(s);
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int num = Integer.parseInt(br.readLine());
        String[][] inputs = new String[num][2];

        for (int i = 0; i < num; i++) {
            String line = br.readLine();

            if (line.length() != 1) { // input 'P $'
                StringTokenizer st = new StringTokenizer(line);
                inputs[i][0] = st.nextToken();
                inputs[i][1] = st.nextToken();
            } else { // input 'L', 'D', 'B' + StringTokenizer 로 길이 1인 글자 나누려 시도할 시 예외 발생
                inputs[i][0] = line;
                inputs[i][1] = " ";
            }
        }

//        System.out.println(Solution(str, inputs)); -> 타임아웃
        System.out.println(Solution2(str, inputs));
    }
}
