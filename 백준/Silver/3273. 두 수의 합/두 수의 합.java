import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static int solution(int num, String input, int target) {
        int answer = 0;
        String[] strings = input.split(" ");
        int[] arr = Arrays.stream(strings)
                        .mapToInt(Integer::parseInt)
                                .toArray();
        Arrays.sort(arr);

        // 길이 : 2 -> 순서쌍 : 1
        if (input.length() == 2) {
            return 1;
        }

        // 투 포인터
        int left = 0;
        int right = num - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum < target) {
                left++;
            } else if (sum == target) {
                answer++;
                left++;
                right--;
            } else {
                right--;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int target = Integer.parseInt(br.readLine());

        br.close();

        System.out.println(solution(num, input, target));
    }
}
