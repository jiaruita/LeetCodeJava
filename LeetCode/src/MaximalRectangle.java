
public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
        int height = matrix.length;
        if (height == 0) {
        	return 0;
        }
        int width = matrix[0].length;
        int[][] high = new int[height][width];
        int[][] left = new int[height][width];
        int[][] right = new int[height][width];
        for (int i = 0; i < width; i++) {
        	if (matrix[0][i] == '1') {
        		high[0][i] = 1;
        	}
        	else {
        		high[0][i] = 0;
        	}
        }
        for (int i = 1; i < height; i++) {
        	for (int j = 0; j < width; j++) {
        		if (matrix[i][j] == '1') {
        			if (high[i - 1][j] > 0) {
        				high[i][j] = high[i - 1][j] + 1;
        			}
        			else {
        				high[i][j] = 1;
        			}
        		}
        		else {
        			high[i][j] = 0;
        		}
        	}
        }
        for (int i = 0; i < height; i++) {
        	left[i][0] = -1;
        	right[i][width - 1] = width;
        }
        for (int i = 0; i < height; i++) {
        	for (int j = 1; j < width; j++) {
        		if (matrix[i][j] == '0') {
        			continue;
        		}
        		if (high[i][j] > high[i][j - 1]) {
        			left[i][j] = j - 1;
        		}
        		else {
        			left[i][j] = -1;
        			for (int k = left[i][j - 1]; k >= 0; k--) {
        				if (high[i][k] < high[i][j]) {
        					left[i][j] = k;
        					break;
        				}
        			}
        		}
        	}
        }
        
        for (int i = 0; i < height; i++) {
        	for (int j = width - 2; j >= 0; j--) {
        		if (matrix[i][j] == '0') {
        			continue;
        		}
        		if (high[i][j] > high[i][j + 1]) {
        			right[i][j] = j + 1;
        		}
        		else {
        			right[i][j] = width;
        			for (int k = right[i][j + 1]; k < width; k++) {
        				if (high[i][k] < high[i][j]) {
        					right[i][j] = k;
        					break;
        				}
        			}
        		}
        	}
        }
        
        int max = 0;
        for (int i = 0; i < height; i++) {
        	for (int j = 0; j < width; j++) {
        		int temp = high[i][j] * (right[i][j] - left[i][j] - 1);
        		if (temp > max) {
        			max = temp;
        		}
        	}
        }
        return max;
    }
}
