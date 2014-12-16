import java.util.ArrayList;


public class SpiralMatrix {
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		final int RIGHT = 0;
		final int DOWN = 1;
		final int LEFT = 2;
		final int UP = 3;
        ArrayList<Integer> result = new ArrayList<Integer>();
        int height = matrix.length;
        if (height == 0) {
        	return result;
        }
        int width = matrix[0].length;
        boolean[][] mat = new boolean[height][width];
        int direction = RIGHT;
        int count = 0;
        int x = 0;
        int y = 0;
        int max = height * width;
        while (count < max) {
        	result.add(matrix[x][y]);
        	mat[x][y] = true;
        	if (direction == RIGHT) {
        		y++;
        		if (y >= width || mat[x][y]) {
        			direction = DOWN;
        			y--;
        			x++;
        		}
        	}
        	else if (direction == DOWN) {
        		x++;
        		if (x >= height || mat[x][y]) {
        			direction = LEFT;
        			x--;
        			y--;
        		}
        	}
        	else if (direction == LEFT) {
        		y--;
        		if (y < 0 || mat[x][y]) {
        			direction = UP;
        			y++;
        			x--;
        		}
        	}
        	else {
        		x--;
        		if (x < 1 || mat[x][y]) {
        			direction = RIGHT;
        			x++;
        			y++;
        		}
        	}
        	count++;
        }
        return result;
    }
	
	public int[][] input(int[] num, int width) {
		int index = 0;
		int height = num.length / width;
		int[][] mat = new int[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				mat[i][j] = num[index++];
			}
		}
		return mat;
	}
	
	public void test() {
		int[] num = new int[]{3,2};
		int[][] matrix = input(num, 1);
		ArrayList<Integer> result = spiralOrder(matrix);
		System.out.println(result.toString());
	}
}
