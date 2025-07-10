import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        int sum = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        char[] array = br.readLine().toCharArray();

        for (int i = 0; i < num; i++) {
            sum += array[i] - '0';
        }

        bw.write(String.valueOf(sum));
        bw.flush();
    }
}
