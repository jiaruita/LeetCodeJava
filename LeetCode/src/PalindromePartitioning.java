import java.util.ArrayList;


public class PalindromePartitioning {
	public ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		int len = s.length();
		if (len == 0) {
			return result;
		}
		boolean mat[][] = new boolean[len][len];
		for (int i = 0; i < len; i++) {
			mat[i][i] = true;
		}
		
		for (int i = len - 2; i >= 0; i--) {
			if (s.charAt(i + 1) == s.charAt(i)) {
				mat[i][i + 1] = true;
			}
		}
		for (int i = len - 2; i >= 0; i--) {
			for (int j = i + 2; j < len; j++) {
				if (s.charAt(j) == s.charAt(i) && mat[i + 1][j - 1]) {
					mat[i][j] = true;
				}
			}
		}
		printMat(mat);
		getResult(result, new ArrayList<String>(), 0, mat, s);
		return result;
	}
	
	public void getResult(ArrayList<ArrayList<String>> result, ArrayList<String> cur, int start, boolean[][] mat, String s) {
		if (start == s.length()) {
			result.add((ArrayList<String>) cur.clone());
			return;
		}
		for (int i = start; i < s.length(); i++) {
			if (mat[start][i]) {
				cur.add(s.substring(start, i + 1));
				getResult(result, cur, i + 1, mat, s);
				cur.remove(cur.size() - 1);
			}
		}
	}
	
	public void printMat(boolean[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				System.out.print(mat[i][j] + "\t");
			}
			System.out.println(" ");
		}
		System.out.println(" ");
	}
	
	public void printResult(ArrayList<ArrayList<String>> result) {
		for (ArrayList<String> arr : result) {
			for (String s : arr) {
				System.out.print(s + ", ");
			}
			System.out.println(" ");
		}
		System.out.println(" ");
	}
	
	public void test() {
		String s = "aab";
		ArrayList<ArrayList<String>> result = partition(s);
		printResult(result);
	}
}
