import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _286WallsAndGates {
    private int empty = Integer.MAX_VALUE;
    private int gate = 0;
    private List<int[]> directions = Arrays.asList(
            new int[] {1, 0},
            new int[] {-1, 0},
            new int[] {0, 1},
            new int[] {0, -1}
    );
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        if (m == 0) return;
        int n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int row = 0; row < m; row++){
            for (int col = 0; col < n; col++){
                if (rooms[row][col] == gate){
                    queue.add(new int[] {row, col});
                }
            }
        }
        while (!queue.isEmpty()){
            int[] position = queue.poll();
            int row = position[0];
            int col = position[1];
            for (int[] d : directions){
                int r = row + d[0];
                int c = col + d[1];
                if (r < 0 || c < 0 || r >= m || c >= n||
                        rooms[r][c] != empty){
                    continue;
                }
                rooms[r][c] = rooms[row][col] + 1;
                queue.add(new int[] {r, c});
            }
        }
    }
}
