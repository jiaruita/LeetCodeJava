
public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
        int height = matrix.length;
        if (height == 0) {
        	return;
        }
        int width = matrix[0].length;
        boolean row = false;
        boolean col = false;
        for (int i = 0; i < height; i++) {
        	if (matrix[i][0] == 0) {
        		col = true;
        		break;
        	}
        }
        for (int i = 0; i < width; i++) {
        	if (matrix[0][i] == 0) {
        		row = true;
        		break;
        	}
        }
        for (int i = 0; i < height; i++) {
        	for (int j = 0; j < width; j++) {
        		if (matrix[i][j] == 0) {
        			matrix[i][0] = 0;
        			matrix[0][j] = 0;
        		}
        	}
        }
        for (int i = 1; i < height; i++) {
        	for (int j = 1; j < width; j++) {
        		if (matrix[i][0] == 0 || matrix[0][j] == 0) {
        			matrix[i][j] = 0;
        		}
        	}
        }
        if (col) {
        	for (int i = 0; i < height; i++) {
        		matrix[i][0] = 0;
        	}
        }
        if (row) {
        	for (int i = 0; i < width; i++) {
        		matrix[0][i] = 0;
        	}
        }
        
    }
}
