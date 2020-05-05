public class _733FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor)
            dfs(image, sr, sc, color, newColor);
        return image;
    }

    private void dfs(int[][] image, int r, int c, int color, int newColor){
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        if (image[r][c] == color){
            image[r][c] = newColor;
            for (int[] d : directions){
                int row = r + d[0];
                int col = c + d[1];
                if (row >= 0 && col >= 0 && row < image.length && col < image[0].length)
                    dfs(image, row, col, color, newColor);
            }
        }
    }
}
