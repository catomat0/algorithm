class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        // Sort Input Array
        Arrays.sort(nums);
        List<List<Integer>> answer = new LinkedList<>(); // 중복 제거에 용이한 연결형 자료형 선언

        // 예외 -> 모든 원소가 0 인 경우
        boolean isZero = isOnlyZero(nums);

        if (isZero) { // 모든 원소가 0, 세 합이 0인 리스트 반환
            answer.add(new ArrayList<>());
            for (int i = 0; i < 3; i++) {
                answer.get(0).add(0);
            }
        } else {
            find3SumV2(nums, answer);
            if (answer.isEmpty()) { // 조건 불충족 시 빈 리스트 반환
                return answer;
            }
        }

        // 리스트 내부의 값들의 중복 제거
        return removeDuplicates(answer);
    }

    private static void find3SumV1(int[] nums, List<List<Integer>> answer) {
        int len = nums.length;

        for (int p1 = 0; p1 < len - 2; p1++) {
            for (int p2 = p1 + 1; p2 < len - 1; p2++) {
                for (int p3 = p2 + 1; p3 < len; p3++) {
                    if (nums[p1] + nums[p2] + nums[p3] == 0) {
                        answer.add(new ArrayList<>(List.of(nums[p1], nums[p2], nums[p3])));
                    }
                }
            }
        }
    }

    private static void find3SumV2(int[] nums, List<List<Integer>> answer) {
        Arrays.sort(nums);
        int len = nums.length;

        for (int p1 = 0; p1 < len - 2; p1++) {
            if (p1 > 0 && nums[p1] == nums[p1 - 1]) continue; // 중복된 값 건너뛰기

            int p2 = p1 + 1;
            int p3 = len - 1;

            while (p2 < p3) {
                int sum = nums[p1] + nums[p2] + nums[p3];

                if (sum == 0) {
                    answer.add(Arrays.asList(nums[p1], nums[p2], nums[p3]));

                    // 중복 값 건너뛰기
                    while (p2 < p3 && nums[p2] == nums[p2 + 1]) p2++;
                    while (p2 < p3 && nums[p3] == nums[p3 - 1]) p3--;

                    // 확장
                    p2++;
                    p3--;
                } else if (sum < 0) {
                    p2++; // 합이 작으면 왼쪽 포인터 이동
                } else {
                    p3--; // 합이 크면 오른쪽 포인터 이동
                }
            }
        }
    }


    private static List<List<Integer>> removeDuplicates(List<List<Integer>> answer) {

        // Compare Inner List and Remove Duplicates
        Set<List<Integer>> comparedSet = new HashSet<>(answer);
        return new ArrayList<>(comparedSet);
    }

    private static boolean isOnlyZero(int[] nums) {
        // 배열 내부의 원소가 모두 0인지?
        int cnt = 0;
        for (int num : nums) {
            if (num != 0) {
                cnt++;
            }
        }
        return cnt == 0;
    }
}