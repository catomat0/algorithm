import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();

            int time = Integer.parseInt(st.nextToken());
            char[] chars = st.nextToken().toCharArray();
            for (int j = 0; j < chars.length; j++) {
                for (int k = 0; k < time; k++) {
                    sb.append(chars[j]);
                }
            }

            sb.append("\n");
            bw.write(sb.toString());
        }
        bw.flush();
    }
}