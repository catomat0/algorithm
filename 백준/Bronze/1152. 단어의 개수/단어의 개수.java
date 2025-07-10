import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // split() array.length -> cnt
//        String line = br.readLine();
//        String[] strings = line.split(" ");
//        System.out.println(strings.length);

        // StringTokenizer.countTokens() -> cnt
        StringTokenizer st = new StringTokenizer(br.readLine());
        bw.write(String.valueOf(st.countTokens()));
        bw.flush();

    }
}