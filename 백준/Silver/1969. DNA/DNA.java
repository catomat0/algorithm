import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void solution(int num, int len, String[] arr) {
        // 받은 DNA 쪼개서 각 인덱스위치의 원소가 가장많이 나온 문자로 스트링 합쳐서 반환
        StringBuilder answer = new StringBuilder();
        int distance = 0;
        Map<Character, Integer> map = new LinkedHashMap<>();
        map.put('A', 0);
        map.put('C', 0);
        map.put('G', 0);
        map.put('T', 0);

        // 모든 DNA 각 자리의 글자의 출현 빈도에 따른 str 결정 - (중복 빈도수의 글자 - 사전 순으로 배치)
        for (int i = 0; i < len; i++) {
            map.replace('A', 0);
            map.replace('C', 0);
            map.replace('G', 0);
            map.replace('T', 0);
            for (int j = 0; j < num; j++) {
                map.replace(arr[j].charAt(i), map.get(arr[j].charAt(i)) + 1);
            }
            Character key = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
            answer.append(key);
        }

        System.out.println(answer);

        // 결정된 str 과 각 DNA 의 차이를 통한 distance 에 추가 (++)
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < len; j++) {
                if (arr[i].charAt(j) != answer.charAt(j)) {
                    distance++;
                }
            }
        }

        System.out.println(distance);
    }

    public static void main(String[] args) throws IOException {
//        String[] arr = {"ATGTTACCAT", "AAGTTACGAT", "AACAAAGCAA",
//                "AAGTTACCTT", "AAGTTACCAA", "TACTTACCAA"};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int num = Integer.parseInt(input[0]);
        int len = Integer.parseInt(input[1]);

        String[] arr = new String[num];
        for (int i = 0; i < num; i++) {
            arr[i] = br.readLine();
        }
        solution(num, len, arr);
    }
}