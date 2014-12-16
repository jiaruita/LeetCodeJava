import java.util.Arrays;


public class InterleavingString {
	
	public boolean isInterleave(String s1, String s2, String s3) {
		int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3) {
        	return false;
        }
        if (len1 == 0) {
        	return s2.equals(s3);
        }
        if (len2 == 0) {
        	return s1.equals(s3);
        }
        char[] a1 = s1.toCharArray();
        char[] a2 = s2.toCharArray();
        char[] a3 = s3.toCharArray();
        boolean[][] mat = new boolean[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
        	if (a1[i - 1] == a3[i - 1]) {
        		mat[i][0] = true;
        	}
        	else {
        		break;
        	}
        }
        for (int i = 1; i <= len2; i++) {
        	if (a2[i - 1] == a3[i - 1]) {
        		mat[0][i] = true;
        	}
        	else {
        		break;
        	}
        }
        for (int i = 1; i <= len1; i++) {
        	for (int j = 1; j <= len2; j++) {
        		int index3 = i + j - 1;
        		System.out.println("a1:" + a1[i - 1] + "; a2:" + a2[j - 1] + "; a3:" + a3[index3]);
        		if (mat[i - 1][j] && a1[i - 1] == a3[index3]) {
        			mat[i][j] = true;
        			continue;
        		}
        		if (mat[i][j - 1] && a2[j - 1] == a3[index3]) {
        			mat[i][j] = true;
        			continue;
        		}
        		mat[i][j] = false;
        	}
        }
        for (int i = 0; i <= len1; i++) {
        	for (int j = 0; j <= len2; j++) {
        		System.out.print(mat[i][j] + " ");
        	}
        	System.out.println("");
        }
        return mat[len1][len2];
	}
	/*
	public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3) {
        	return false;
        }
        char[] a1 = s1.toCharArray();
        char[] a2 = s2.toCharArray();
        char[] a3 = s3.toCharArray();
        //count = 0;
        boolean result = dfs(a1, a2, a3, 0, len1 - 1, 0, len2 - 1, 0, len3 - 1);
       // System.out.println(count);
        return result;
    }*/
	
	/*
	public boolean dfs(char[] a1, char[] a2, char[] a3, int i1, int i2, int i3) {
		count++;
		if (i1 == a1.length && i2 == a2.length && i3 == a3.length) {
			return true;
		}
		if (i1 == a1.length) {
			int temp2 = i2;
			int temp3 = i3;
			while (temp2 < a2.length) {
				if (a2[temp2++] != a3[temp3++]) {
					return false;
				}
			}
			return true;
		}
		if (i2 == a2.length) {
			int temp1 = i1;
			int temp3 = i3;
			while (temp1 < a1.length) {
				if (a1[temp1++] != a3[temp3++]) {
					return false;
				}
			}
			return true;
		}
		
		if (a1[i1] == a3[i3] && dfs(a1,a2,a3, i1 + 1, i2, i3 + 1)) {
			return true;
		}
		if (a2[i2] == a3[i3] && dfs(a1,a2,a3, i1, i2 + 1, i3 + 1)) {
			return true;
		}
		return false;
	}
	*/
	
	public boolean dfs(char[] a1, char[] a2, char[] a3, int i1, int j1, int i2, int j2, int i3, int j3) {
		//count++;
		if (i1 > j1 && i2 > j2) {
			return true;
		}
		if (i1 > j1) {
			int temp2 = i2;
			int temp3 = j3;
			while (temp2 <= temp3) {
				if (a2[temp2++] != a3[temp3]) {
					return false;
				}
			}
			return true;
		}
		if (i2 > j2) {
			int temp1 = i1;
			int temp3 = j3;
			while (temp1 <= temp3) {
				if (a1[temp1++] != a3[temp3]) {
					return false;
				}
			}
			return true;
		}
		
		if (a1[i1] == a3[i3]) {
			if (a1[j1] == a3[j3] && dfs(a1, a2, a3, i1 + 1, j1- 1, i2, j2, i3 + 1, j3 - 1)) {
				return true;
			}
			if (a2[j2] == a3[j3] && dfs(a1, a2, a3, i1 + 1, j1, i2, j2 - 1, i3 + 1, j3 - 1)) {
				return true;
			}
		}
		if (a2[i2] == a3[i3]) {
			if (a1[j1] == a3[j3] && dfs(a1, a2, a3, i1, j1- 1, i2 + 1, j2, i3 + 1, j3 - 1)) {
				return true;
			}
			if (a2[j2] == a3[j3] && dfs(a1, a2, a3, i1, j1, i2 + 1, j2 - 1, i3 + 1, j3 - 1)) {
				return true;
			}
		}
		return false;
	}
	
	public void test() {
		String s1 = "a";
		String s2 = "b";
		String s3 = "ab";
		System.out.println(isInterleave(s1,s2,s3));
	}
}
