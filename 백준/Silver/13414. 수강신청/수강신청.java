import java.io.*;
import java.util.*;

public class Main {

    public static String solution(String arr[], int K) {

        LinkedHashSet<String> set = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder();
        for (String j : arr) {
            if (set.contains(j)) {
                set.remove(j);
            }
            set.add(j);
        }

        // java 11 - xx
//        for (int i = 0; i < K; i++) {
//            sb.append(set.getFirst()).append("\n");
//            set.removeFirst();
//        }

        Iterator<String> iter = set.iterator();
        for (int i = 0; i < K && iter.hasNext(); i++) {
            if (i > 0) sb.append("\n");
            sb.append(iter.next());
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        String[] list = new String[L];
        for (int i = 0; i < L; i++) {
            list[i] = br.readLine();
        }

        bw.write(solution(list, K));
        bw.flush();
        bw.close();
        br.close();
    }
}
