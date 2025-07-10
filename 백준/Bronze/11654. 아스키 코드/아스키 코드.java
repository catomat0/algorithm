import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int i = s.charAt(0);
        bw.write(String.valueOf(i)); // bw.write 는 문자열 단위 버퍼이므로 char->int -> 문자로 변환되어 출력됨.
        bw.flush();
    }
}