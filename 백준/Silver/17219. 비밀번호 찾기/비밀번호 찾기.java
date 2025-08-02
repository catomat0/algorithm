import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static String solution(StringTokenizer[] list, String[] finds) {

        StringBuilder sb = new StringBuilder();
        Map<String, String> map = new HashMap<>();

        for (StringTokenizer stringTokenizer : list) {
            map.put(stringTokenizer.nextToken(), stringTokenizer.nextToken());
        }

        for (int i = 0; i < finds.length; i++) {
            if (i != finds.length - 1) {
                sb.append(map.get(finds[i])).append("\n");
            } else {
                sb.append(map.get(finds[i]));
            }
        }

        return sb.toString();
    }


    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringTokenizer[] list = new StringTokenizer[N];
        String[] finds = new String[M];

        for (int i = 0; i < N; i++) {
            list[i] = new StringTokenizer(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            finds[i] = br.readLine();
        }

        bw.write(solution(list, finds));
        bw.flush();
        bw.close();
        br.close();
    }
}
