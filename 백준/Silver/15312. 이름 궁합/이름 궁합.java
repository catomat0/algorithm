import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static String solution(String str1, String str2) {

        int[] a = new int[str1.length()];
        int[] b = new int[str2.length()];

        int[] list = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
        List<Integer> answers = new ArrayList<>();

        // str1
        char[] chars1 = str1.toCharArray();
        for (int i = 0; i < str1.length(); i++) {
            a[i] = list[(int) chars1[i] - 65];
        }
        // str2
        char[] chars2 = str2.toCharArray();
        for (int i = 0; i < str2.length(); i++) {
            b[i] = list[(int) chars2[i] - 65];
        }

        for (int i = 0; i < str1.length(); i++) {
            answers.add(a[i]);
            answers.add(b[i]);
        }

        for (int i = 0; i < str1.length() * 2 - 2; i++) {
            for (int j = 0; j < str2.length() * 2 - 1 - i; j++) {
                answers.set(j, (answers.get(j) + answers.get(j + 1)) % 10);
            }
        }

        return String.valueOf(answers.get(0)) + String.valueOf(answers.get(1));
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        System.out.println(solution(s1, s2));

    }
}
