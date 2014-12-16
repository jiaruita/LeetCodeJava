import java.util.Arrays;


public class PalindromePartitioning2 {
	public int minCut(String s) {
		int len = s.length();
		if (len <= 1) {
			return 0;
		}
		boolean[][] isPalin = new boolean[len][len];
		for (int i = 0; i < len; i++) {
			isPalin[i][i] = true;
		}
		int[] cuts = new int[len];
		for (int i = 0; i < len; i++) {
			cuts[i] = i;
		}
		for (int i = 1; i < len; i++) {
			for (int j = i; j >= 0; j--) {
				if (s.charAt(i) == s.charAt(j) && (i <= j + 1 || isPalin[j + 1][i - 1])) {
					isPalin[j][i] = true;
					if (j == 0) {
						cuts[i] = 0;
					}
					else { 
						//System.out.println("cuts[j - 1] = " + cuts[j - 1]);
						cuts[i] = Math.min(cuts[i], cuts[j - 1] + 1); 
					}
				}
				//System.out.println("j = " + j + "; i = " + i + "; " + Arrays.toString(cuts));
			}
			
		} 
		//printMat(isPalin);
		return cuts[len - 1];
	}
		 /*
		 for (int i = 1; i < len; i++) {
			 boolean temp = s.charAt(i - 1) == s.charAt(i); 
			 isPalin[i - 1][i] = temp;
			 if (temp) {
				 cuts[i] = cuts[i - 1];
			 }
			 else {
				 cuts[i] = cuts[i - 1] + 1;
			 }
		 }
		 */
		 
		 /*
		 for (int gap = 2; gap < len; gap++) {
			 for (int i = 0; i < len - gap; i++) {
				 int j = i + gap;
				 if (s.charAt(i) == s.charAt(j) && isPalin[i + 1][j -1]) {
					 isPalin[i][j] = true;
					 cuts[j] = cuts[i];
				 }
			 }
			 System.out.println(Arrays.toString(cuts));
		 }
		 */
		 /*
		 for (int i = 0; i < len - 2; i++) {
			 for (int j = i + 2; j < len; j++) {
				 if (s.charAt(i) == s.charAt(j) && isPalin[i + 1][j -1]) {
					 isPalin[i][j] = true;
					 cuts[j] = cuts[i];
				 }
			 }
		 }*/
		// printMat(isPalin);
	
	 
	 public void printMat(boolean[][] mat) {
		 int len = mat.length;
		 for (int i = 0; i < len; i++) {
			 for (int j = 0; j < len; j++) {
				 System.out.print(mat[i][j] + "\t");
			 }
			 System.out.println("");
		 }
		 System.out.println("");
	 }
	 
	 public void test() {
		 String s = "dde";
		 System.out.println(minCut(s));
	 }
}
