public class _200NumIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;
        int numIslands = 0;
        for (int r = 0; r < m; r++){
            for (int c = 0; c < n; c++){
                if (grid[r][c] == '1'){
                    numIslands++;
                    dfs(grid, r, c);
                }
            }
        }
        return numIslands;
    }

    private void dfs(char[][] grid, int r, int c){
        int m = grid.length;
        int n = grid[0].length;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        if (r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == '0'){
            return;
        }

        for (int[] d : directions){
            grid[r][c] = '0';
            int row = r + d[0];
            int col = c + d[1];
            dfs(grid, row, col);
        }
    }
}
