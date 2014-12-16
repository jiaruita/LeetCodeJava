
public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
        int height = grid.length;
        if (height == 0) {
        	return 0;
        }
        int width = grid[0].length;
        int[][] sums = new int[height][width];
        sums[0][0] = grid[0][0];
        for (int i = 1; i < height; i++) {
        	sums[i][0] = sums[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < width; i++) {
        	sums[0][i] = sums[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < height; i++) {
        	for (int j = 1; j < width; j ++) {
        		int up = sums[i - 1][j];
        		int left = sums[i][j - 1];
        		sums[i][j] = up < left ? up + grid[i][j] : left + grid[i][j];
        	}
        }
        return sums[height - 1][width - 1];
    }
}
