class Solution {
    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> results = new ArrayList<>();
        List<Integer> lst = Arrays.stream(nums).boxed().collect(Collectors.toList());
        dfs(results, new ArrayList<>(), lst);

        return results;
    }

    public static void dfs(List<List<Integer>> results, List<Integer> prevElements,
                           List<Integer> elements) {

        if (elements.isEmpty()) {
            results.add(prevElements.stream().collect(Collectors.toList()));
        }

        for (Integer e : elements) {

            List<Integer> nextElements = new ArrayList<>(elements);
            nextElements.remove(e);

            prevElements.add(e);
            dfs(results, prevElements, nextElements);
            prevElements.remove(e);
        }
    }
}