
public class SpiralMatrix2 {
	public int[][] generateMatrix(int n) {
		if (n <= 0) {
			return new int[0][0];
		}
		int[][] mat = new int[n][n];
		mat[0][0] = 1;
        int num = 1;
        int leftMost = 0;
        int rightMost = n - 1;
        int upMost = 1;
        int downMost = n - 1;
        int row = 0;
        int col = 0;
        final int RIGHT = 0;
        final int DOWN = 1;
        final int LEFT = 2;
        final int UP = 3;
        int direction = RIGHT;
        int end = n * n;
        
        while (num < end) {
        	//System.out.println("num = " + num);
        	if (direction == RIGHT) {
        		
        		if (col + 1 <= rightMost) {
        			//System.out.println("Right");
        			
        			mat[row][++col] = ++num;
        		}
        		else {
        			direction = DOWN;
        			rightMost--;
        		}
        	}
        	else if (direction == DOWN) {
        		if (row + 1 <= downMost) {
        			//System.out.println("Down");
        			mat[++row][col] = ++num;
        		}
        		else {
        			direction = LEFT;
        			downMost--;
        		}
        	}
        	else if (direction == LEFT) {
        		if (col - 1 >= leftMost) {
        			//System.out.println("Left");
        			mat[row][--col] = ++num;
        		}
        		else {
        			direction = UP;
        			leftMost++;
        		}
        	}
        	else {
        		if (row - 1 >= upMost) {
        			//System.out.println("Up");
        			mat[--row][col] = ++num;
        		}
        		else {
        			direction = RIGHT;
        			upMost++;
        		}
        	}
        	//printMat(mat, n, n);
        }
        return mat;
    }
	
	public void printMat(int[][] matrix, int height, int width) {
		//int height = matrix.length;
		//int width = matrix[0].length;
		for(int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
	
	public void test() {
		int n = 3;
		int[][] mat = generateMatrix(n);
		
	}
}
