
public class EditDistance {
	public int minDistance(String word1, String word2) {
        int x = word1.length();
        int y = word2.length();
        if (x == 0) {
        	return y;
        }
        if (y == 0) {
        	return x;
        }
        int [][] mat = new int[x + 1][y + 1];
        for (int i = 0; i <= x; i++) {
        	mat[i][0] = i;
        }
        for (int i = 0; i <= y; i++) {
        	mat[0][i] = i;
        }
        for (int i = 1; i <= x; i++) {
        	for (int j = 1; j <= y; j++) {
        		int insert = mat[i][j - 1] + 1;
        		int delete = mat[i - 1][j] + 1;
        		int replace = mat[i - 1][j - 1];
        		//System.out.println("replace = " + replace);
        		if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
        			//System.out.println("if");
        			replace++;
        		}
        		//System.out.println(i + ", " + j + ": " + word1.charAt(i - 1) + ", " + word2.charAt(j - 1) + "; insert = " + insert + "; delete = " + delete + "; replace = "+ replace);
        		mat[i][j] = Math.min(insert, Math.min(delete, replace));
        	}
        }
        printMat(mat);
        return mat[x][y];
    }
	
	public void printMat(int[][] mat) {
		int x = mat.length;
		int y = mat[0].length;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println(" ");
		}
		System.out.println(" ");
	}
	
	public void test() {
		String word1 = "ab";
		String word2 = "bc";
		System.out.println(minDistance(word1, word2));
	}
}
