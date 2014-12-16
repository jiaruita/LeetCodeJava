import java.util.ArrayList;


public class GenerateParentheses {
	/*
	 public ArrayList<String> generateParenthesis(int n) {
	        ArrayList<String> result = new ArrayList<String>();
	        if (n == 0) {
	        	return result;
	        }
	        result.add("()");
	        for (int i = 2; i <= n; i++) {
	        	ArrayList<String> temp = new ArrayList<String>();
	        	for (String cur : result) {
	        		String pre = "()" + cur;
	        		String post = cur + "()";
	        		temp.add(pre);
	        		if (!pre.equals(post)) {
	        			temp.add(post);
	        		}
	        		temp.add("(" + cur + ")");
	        	}
	        	result = temp;
	        }
	        return result;
	 }
	 */
	
	public ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> result = new ArrayList<String>();
		if (n == 0) {
			return result;
		}
		recur(result, "", 0, 0 , n);
		return result;
	}
	
	public void recur(ArrayList<String> result, String s, int leftUsed, int rightUsed, int n) {
		if (leftUsed == n) {
			for ( int i = 0; i < n - rightUsed; i++) {
				s = s + ")";
			}
			result.add(s);
			return;
		}
		if (leftUsed < n) {
			recur(result, (s + "("), leftUsed + 1, rightUsed, n);
		}
		if (rightUsed < leftUsed) {
			recur(result, (s + ")"), leftUsed, rightUsed + 1, n);
		}
	}
	
	 public void test() {
		 ArrayList<String> result = generateParenthesis(4);
		 for (String s: result) {
			 System.out.println(s);
		 }
	 }
}
