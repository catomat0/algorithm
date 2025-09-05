class Solution {
    public int numIslands(char[][] grid) {

        int cnt = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    cnt++;
                }

            }
        }
        return cnt;
    }

    public static void dfs(int i, int j, char[][] grid) {

        // 재귀 정지 부분
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        // 탐색이 완료된 (섬이라고 체크한) 영역은 0으로 초기화해서 중복 탐색 방지
        grid[i][j] = '0';

        // + 모양
        dfs(i, (j - 1), grid); // 좌
        dfs(i, (j + 1), grid); // 우
        dfs((i - 1), j, grid); // 상
        dfs((i + 1), j, grid); // 하
    }
}