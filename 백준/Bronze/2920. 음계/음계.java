import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int answer = 0; // 체크하기 위한 변수 선언

        // String -> int 변환 방법 (Stream 이용)
        int[] arr = Arrays.stream(inputs).mapToInt(Integer::parseInt).toArray();
        int[] clones = arr.clone();

        Arrays.sort(clones);

        if (arr[0] == 1) { // ascending
            for (int i = 0; i < arr.length; i++) {
                if (clones[i] != arr[i]) {
                    answer = 2;
                    break;
                }
                answer = 0;
            }

        } else if (arr[0] == 8) { // descending
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != clones[7 - i]) {
                    answer = 2;
                    break;
                }
                answer = 1;
            }

        } else {
            answer = 2;
        }

        // check
        if (answer == 0) {
            bw.write("ascending");
        } else if (answer == 1) {
            bw.write("descending");
        } else if (answer == 2) {
            bw.write("mixed");
        }

        bw.flush();
        bw.close();
    }
}
