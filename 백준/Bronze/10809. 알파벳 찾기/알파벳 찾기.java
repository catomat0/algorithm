import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        // a - 65 b - 66
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] alphas = new int[26];
        Arrays.fill(alphas, -1);

        String line = br.readLine();
        char[] array = line.toCharArray();
        // alphas 0 1 2 3 ... 25
        // alphas 65 66 67... 90

        for (int i = 0; i < array.length; i++) {

            if (alphas[array[i] - 'a'] == -1) {
                alphas[array[i] - 'a'] = i;
            }
        }

        for (int alpha : alphas) {
            bw.write(alpha + " ");
        }
        bw.flush();
    }
}