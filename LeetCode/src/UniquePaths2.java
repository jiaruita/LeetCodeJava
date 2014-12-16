
public class UniquePaths2 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int[][] grid = obstacleGrid;
        int height = obstacleGrid.length;
        if (height == 0) {
        	return 0;
        }
        int width = obstacleGrid[0].length;
        int[][] mat = new int[height][width];
        if (grid[0][0] == 1) {
        	mat[0][0] = 0;
        }
        else {
        	mat[0][0] = 1;
        }
        for (int i = 1; i < height; i++) {
        	if (grid[i][0] == 1) {
        		mat[i][0] = 0;
        	}
        	else {
        		if (mat[i - 1][0] == 0) {
        			mat[i][0] = 0;
        		}
        		else {
        			mat[i][0] = 1;
        		}
        	}
        }
        for (int i = 1; i < width; i++) {
        	if (grid[0][i] == 1) {
        		mat[0][i] = 0;
        	}
        	else {
        		if (mat[0][i - 1] == 0) {
        			mat[0][i] = 0;
        		}
        		else {
        			mat[0][i] = 1;
        		}
        	}
        }
        for (int i = 1; i < height; i++) {
        	for (int j = 1; j < width; j++) {
        		if (grid[i][j] == 1) {
        			mat[i][j] = 0;
        		}
        		else {
        			mat[i][j] = mat[i - 1][j] + mat[i][j - 1];
        		}
        	}
        }
        return mat[height - 1][width - 1];
    }
}
