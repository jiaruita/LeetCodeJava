
public class ScrambleString {
	public boolean isScramble(String s1, String s2) {
		int len = s1.length();
		if (len != s2.length()) {
			return false;
		}
		boolean[][][] mat = new boolean[len][len][len + 1];
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				mat[i][j][1] = s1.charAt(i) == s2.charAt(j);
			}
		}
		for (int length = 2; length <= len; length++) {
			for (int i = 0; i <= len - length; i++) {
				for (int j = 0; j <= len - length; j++) {
					mat[i][j][length] = false;
					for (int k = 1; k < length; k++) {
						if (mat[i][j][k] && mat[i + k][j + k][length - k]) {
							mat[i][j][length] = true;
							break;
						}
						if (mat[i][j + length - k][k] && mat[i + k][j][length - k]) {
							mat[i][j][length] = true;
							break;
						}
					}
				}
			}
		}
		System.out.println("length == 1:");
		printMat(mat, 1);
		System.out.println("length == 2:");
		printMat(mat, 2);
		return mat[0][0][len];
	}
	/*
	public boolean isScramble(String s1, String s2) {
        int len = s1.length();
        if (len != s2.length()) {
        	return false;
        }
        return recur(s1, s2);
        
    }
	
	public boolean recur(String s1, String s2) {
		int len = s1.length();
		if (len != s2.length()) {
			return false;
		}
		if (len <= 2) {
			return check(s1, s2);
		}
		for (int i = 1; i < len; i++) {
			String l1 = s1.substring(0, i);
			String l2 = s2.substring(0, i);
			String r1 = s1.substring(i);
			String r2 = s2.substring(i);
			//String l11 = s1.substring(0, len - i);
			String l21 = s2.substring(0, len - i);
			//String r11 = s1.substring(len - i);
			String r21 = s2.substring(len - i);
			if (check(l1, l2) && check(r1, r2) && recur(l1, l2) && recur(r1, r2)) {
				return true;
			}
			if (check(l1, r21) && check(r1, l21) && recur(l1, r21) && recur(r1, l21)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean check(String s1, String s2) {
		int len = s1.length();
		if (len != s2.length()) {
			return false;
		}
		int[] voc = new int[256];
		for (int i = 0; i < len; i++) {
			voc[s1.charAt(i)]++;
		}
		for (int i = 0; i < len; i++) {
			if (voc[s2.charAt(i)]-- == 0) {
				return false;
			}
		}
		return true;
	}
	*/
	
	public void printMat(boolean[][][] mat, int len) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				System.out.print(mat[i][j][len] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
	public void test() {
		String s1 = "aa";
		String s2 = "aa";
		System.out.println(isScramble(s1, s2));
	}
}
