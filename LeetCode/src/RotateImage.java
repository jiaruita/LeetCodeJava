
public class RotateImage {
	 public void rotate(int[][] matrix) {
	      int len = matrix.length;
	      if (len == 0) {
	    	  return;
	      }
	      for (int i = 0; i < len / 2; i++) {
	    	  for (int j = i; j < len - 1 - i; j++) {
	    		  swap(matrix, i, j);
	    	  }
	      }
	      
	 }
	 
	 public void swap(int[][] mat, int row, int col) {
		 int len = mat.length;
		 int temp = mat[row][col];
		 mat[row][col] = mat[len - 1 - col][row];
		 mat[len - 1 - col][row] = mat[len - 1 - row][len - 1 - col];
		 mat[len - 1 - row][len - 1 - col] = mat[col][len - 1 - row];
		 mat[col][len - 1 - row] = temp;
	 }
	 
	 public void test() {
		 int[][] matrix = {{0,1,2}, {3,4,5}, {6,7,8}};
		 rotate(matrix);
		 for(int i = 0; i < matrix.length; i++) {
			 for (int j = 0; j < matrix.length; j++) {
				 System.out.print(matrix[i][j] + " ");
			 }
			 System.out.print("\n");
		 }
	 }
}
