import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
  
        for (int cnt : solution(a, b, c)) {
            System.out.println(cnt);
        }
    }

    public static int[] solution(int a, int b, int c) {
        Map<String, Integer> cntMap = initCountMap();
        int[] answers = new int[10];

        String product = "" + a * b * c;
        String[] nums = product.split("");
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            cntMap.put(nums[i], cntMap.get(nums[i]) + 1);
        }

        for (int i = 0; i < answers.length; i++) {
            answers[i] = cntMap.get(String.valueOf(i));
        }

        return answers;
    }

    private static Map<String, Integer> initCountMap() {
        Map<String, Integer> cnt = new HashMap<>();

        cnt.put("0", 0);
        cnt.put("1", 0);
        cnt.put("2", 0);
        cnt.put("3", 0);
        cnt.put("4", 0);
        cnt.put("5", 0);
        cnt.put("6", 0);
        cnt.put("7", 0);
        cnt.put("8", 0);
        cnt.put("9", 0);
        return cnt;
    }
}
