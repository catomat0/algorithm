import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int i = 0, max = 0;
        double sum = 0, avg;

        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        double[] scores = new double[num];

        // max 구하기
        while (st.hasMoreTokens()) {
            int target = Integer.parseInt(st.nextToken());
            scores[i] = target; // 배열에 일단 추가
            max = Math.max(max, target);
            i++;
        }

        // 모든 값 변경
        for (int j = 0; j < scores.length; j++) {
            scores[j] /= max;
            scores[j] *= 100;
            sum += scores[j];
        }
        // avg 구하기
        avg = sum / num;

        bw.write(avg + "");
        bw.flush();
        bw.close();
    }
}
