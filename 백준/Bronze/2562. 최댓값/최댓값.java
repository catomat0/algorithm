import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int idx = 0, max = 0;


        for (int i = 0; i < 9; i++) {
            int target = Integer.parseInt(br.readLine());
            int past = max;
            max = Math.max(max, target);
            if (max != past) {
                idx = i;
            }
        }


        bw.write(max + "\n");
        bw.write((idx + 1) + "\n");
        bw.flush();
        bw.close();
    }
}