import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void solution(String test, Set<String> say) {
        StringBuilder answer = new StringBuilder();  // 배열 대신 단일 StringBuilder 사용

        // 테스트 문자열을 단어 단위로 분리
        String[] words = test.split(" ");

        // 울음소리를 제거하고 여우의 울음소리 부분만 추가
        for (String word : words) {
            if (!say.contains(word)) {
                answer.append(word).append(" ");
            }
        }

        // 결과 출력 (마지막 공백 제거)
        System.out.println(answer.toString().stripTrailing());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = 0;
        int n = Integer.parseInt(br.readLine());
        
        while (i < n) {
            String test = br.readLine();
            Set<String> say = new HashSet<>(); // 각 테스트 케이스마다 새로운 Set 생성

            String line;
            while (!(line = br.readLine()).equals("what does the fox say?")) {
                say.add(line.split(" goes ")[1]);  // 동물 울음소리만 저장
            }

            solution(test, say);
            i++;
        }
    }
}
