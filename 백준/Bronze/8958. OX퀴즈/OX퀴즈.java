import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 0; i < num; i++) {
            String line = br.readLine();

            int plus = 0;

            for (int j = 0; j < line.length(); j++) {
                if (j == 0) { // j == 0
                    if (line.charAt(j) == 'O') { // j == 0 && 'O'
                        plus = 1;
                        answer += plus;
                    } else {                     // j == 0 && 'X'
                        plus = 0;
                        answer += plus;
                    }
                } else { // j != 0
                    if (line.charAt(j) == 'O') { // j != 0 && 'O'
                        if (line.charAt(j - 1) == 'O') {
                            plus++;
                            answer += plus;
                        } else { // 'XO'
                            plus = 1;
                            answer += plus;
                        }
                    } else {                    // j != 0 && 'X'
                        if (line.charAt(j - 1) == 'O') {
                            plus = 0;
                            answer += plus;
                        } else {
                            plus = 0;
                            answer += plus;
                        }
                    }
                }
            }

            // print
            if (i != num - 1) {
                bw.write(answer +"\n");
            } else {
                bw.write(answer +"");
            }
            answer = 0;
        }

        bw.flush();
        bw.close();
    }
}
