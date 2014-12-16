
public class Search2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
        int height = matrix.length;
        if (height == 0) {
        	return false;
        }
        int width = matrix[0].length;
        
        int start = 0;
        int end = height * width - 1;
        while (start <= end) {
        	int mid = (start + end) / 2;
        	if (matrix[mid / width][mid % width] == target) {
        		return true;
        	}
        	if (matrix[mid / width][mid % width] > target) {
        		end = mid - 1;
        	}
        	else {
        		start = mid + 1;
        	}
        }
        return false;
    }
	
}
