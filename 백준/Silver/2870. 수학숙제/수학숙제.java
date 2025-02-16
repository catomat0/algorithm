import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void solution(int size, String[] arr) {

        List<BigInteger> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        // 입력 라인에서 숫자 검출
        for (int i = 0; i < size; i++) {
            String[] strings = arr[i].split("[a-zA-Z]");
            for (String string : strings) {
                if (!string.isBlank()) {
                    list.add(new BigInteger(string));
                }
            }
        }

        // 정렬 및 출력
        Collections.sort(list);
        for (BigInteger l : list) {
            System.out.println(l);
        }
    }

    public static void main(String[] args) throws IOException {

//        String[] arr = {"01bond", "02james007", "03bond", "04austinpowers000"};
//        String[] arr = {"43silos0", "zita002", "le2sim", "231233"};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        solution(n, arr);
    }
}