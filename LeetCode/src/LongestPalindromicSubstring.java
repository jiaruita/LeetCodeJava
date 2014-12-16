
public class LongestPalindromicSubstring {
	 public String longestPalindrome(String s) {
		 int len = s.length();
		 if (len == 0) {
			 return "";
		 }
		 if (len == 1) {
			 return s;
		 }
		 boolean[][] mat = new boolean[len][len];
		 for (int i = 0; i < len; i++) {
			 mat[i][i] = true;
		 }
		 int max = 1;
		 int start = -1;
		 for (int i = 0; i < len - 1; i++) {
			 if (i - 1 >= 0 && s.charAt(i - 1) == s.charAt(i + 1)) {
				 mat[i - 1][i + 1] = true;
				 if (3 > max) {
					 max = 3;
					 start = i - 1;
				 }
				 //continue;
			 }
			 if (s.charAt(i) == s.charAt(i + 1)) {
				 mat[i][i + 1] = true;
				 if (2 > max) {
					 max = 2;
					 start = i;
				 }
				 //continue;
			 }
		 }
		 printMat(mat);
		 for (int length = 2; length <= len / 2; length++) {
			 for (int i = 1; i < len - 2; i++) {
				 if (i - length >= 0 &&  i + length < len && mat[i - length + 1][i + length - 1] && s.charAt(i - length) == s.charAt(i + length)) {
					 mat[i - length][i + length] = true;
					 if (1+ 2 * length > max) {
						 max = 1 + 2 * length;
						 start = i - length;
					 }
					 //continue;
				 }
				 if (i - length + 1 >= 0 && i + length < len && mat[i - length + 2][i + length - 1] && s.charAt(i - length + 1) == s.charAt(i + length)) {
					 mat[i - length + 1][i + length] = true;
					 if (2 * length > max) {
						 max = 2 * length;
						 start = i - length + 1;
					 }
					 //continue;
				 }
			 }
		 }
		 printMat(mat);
		 if (max > 1) {
			 return s.substring(start, max + start);
		 }
		 else {
			 return s.substring(0,1);
		 }
	 }
	 
	 public void printMat(boolean[][] mat) {
		 int len = mat.length;
		 for (int i = 0; i < len; i++) {
			 for (int j = 0; j < len; j++) {
				 System.out.print(mat[i][j] + " ");
			 }
			 System.out.println(" ");
		 }
		 System.out.println("");
	 }
	 
	 public void test() {
		 String s = "aaaa";
		 System.out.println(longestPalindrome(s));
	 }
}
