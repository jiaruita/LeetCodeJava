import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class WordBreak2 {
	int count;
	/*
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		int max = 0;
		for (String str : dict) {
			if (str.length() > max) {
				max = str.length();
			}
		}
		ArrayList<String> result = new ArrayList<String>();
		dfs(result, new StringBuffer(), s, dict, 0, max);
		return result;
	}
	
	public void dfs(ArrayList<String> result, StringBuffer current, String s, Set<String> dict, int start, int max) {
		if (start >= s.length()) {
			result.add(current.toString());
			return;
		}
		for (int i = start; i <= (Math.min(s.length(),start + max)); i++) {
			if (dict.contains(s.substring(start, i))) {
				current.append(s.substring(start, i));
				current.append(" ");
				dfs(result, current, s, dict, i, max);
				current.delete(current.length() - (i - start + 1), current.length());
			}
		}
		return;
	}
	*/
	
	/*
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		count = 0;
		ArrayList<String> result = new ArrayList<String>();
		int len = s.length();
		boolean[][] mat = new boolean[len][len + 1];
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j <= len; j++) {
				if (dict.contains((s.substring(i, j)))){
					mat[i][j] = true;
				}
			}
		}
		//printMat(mat);
		dfs(mat, result, new StringBuffer(), s, dict, 0);
		//System.out.println(count);
		return result;
	}
	
	public void dfs(boolean[][] mat, ArrayList<String> result, StringBuffer current, String s, Set<String> dict, int start) {
		
		if (start >= s.length()) {
			result.add(current.toString().substring(0, current.length() - 1));
			return;
		}
		for (int end = start + 1; end <= s.length(); end++) {
			if (mat[start][end]) {
				System.out.println("start = " + start + "; end = " + end);
				current.append(s.substring(start, end));
				current.append(" ");
				dfs(mat, result, current, s, dict, end);
				current.deleteCharAt(current.length() - 1);
				current.delete(current.length() - (end - start), current.length());
			}
		}
		return;
	}
	*/
	
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		ArrayList<String> result = new ArrayList<String>();
		int len = s.length();
		boolean[] reach = new boolean[len + 1];
		reach[len] = true;
		for (int end = len; end > 0; end--) {
			for (int start = end - 1; start >= 0; start--) {
				if (reach[end] && dict.contains(s.substring(start, end))) {
					reach[start] = true;
				}
			}
		}
		dfs(result, dict, s, 0, new StringBuffer(), reach);
		return result;
	}
	
	public void dfs(ArrayList<String> result, Set<String> dict, String s, int start, StringBuffer current, boolean[] reach) {
		if (start >= s.length()) {
			result.add(current.toString().substring(0, current.length() - 1));
			return;
		}
		if (reach[start] == false) {
			return;
		}
		for (int end = start + 1; end <= s.length(); end++) {
			if (reach[end] && dict.contains(s.substring(start, end))) {
				current.append(s.substring(start, end));
				current.append(" ");
				dfs(result, dict, s, end, current, reach);
				current.deleteCharAt(current.length() - 1);
				current.delete(current.length() - (end - start), current.length());
			}
		}
		return;
	}
	
	public void printMat(boolean[][] mat) {
		int h = mat.length;
		int w = mat[0].length;
		for (int i = 0 ; i < h; i++) {
			for (int j = 0; j < w; j ++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
	public void test() {
		HashSet<String> dict = new HashSet<String>();
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		String[] arr = new String[]{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
		//String s = "a";
		//String[] arr = new String[]{"a"};
		for(String str : arr) {
			dict.add(str);
		}
		ArrayList<String> result = wordBreak(s, dict);
		System.out.println(result.toString());
	}
}
