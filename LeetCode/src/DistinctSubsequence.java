
public class DistinctSubsequence {
	public int numDistinct(String S, String T) {
		int s = S.length();
		int t = T.length();
		//System.out.println("s = " + s + "; t = " + t);
		if (s == 0 || t == 0 || s < t) {
			return 0;
		}
        int[][] mat = new int[t][s];
        int count = 0;
        for (int i = 0; i < s; i++) {
        	if (S.charAt(i) == T.charAt(0)) {
        		mat[0][i] = ++count;
        	}
        	else {
        		mat[0][i] = count;
        	}
        }
        printMat(mat);
        for (int i = 0; i < t - 1; i++) {
        	mat[i + 1][i] = 0;
        }
        printMat(mat);
        for (int i = 1; i < t; i++) {
        	for (int j = i; j < s; j++) {
        		mat[i][j] = mat[i][j - 1];
        		if (S.charAt(j) == T.charAt(i)) {
        			//System.out.println("if");
        			mat[i][j] += mat[i - 1][j - 1];
        		}
        	}
        }
        printMat(mat);
        return mat[t - 1][s - 1];
    }
	
	public void printMat(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
	public void testNum() {
		String S = "aabb";
		String T = "ab";
		System.out.println(numDistinct(S, T));
	}
}
