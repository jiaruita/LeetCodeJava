import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;


public class LetterCombPhoneNumber {
	public ArrayList<String> letterCombinations(String digits) {
		ArrayList<String> result = new ArrayList<String>();
		int len = digits.length();
		if (len == 0) {
			result.add("");
			return result;
		}
        HashMap<Character, String> dict = new HashMap<Character, String>();
        dict.put('1', "");
        dict.put('2', "abc");
        dict.put('3', "def");
        dict.put('4', "ghi");
        dict.put('5', "jkl");
        dict.put('6', "mno");
        dict.put('7', "pqrs");
        dict.put('8', "tuv");
        dict.put('9', "wxyz");
        dict.put('*', "+");
        dict.put('0', " ");
        dict.put('#', "");
        dfs(dict, result, new StringBuilder(), digits, 0);
        return result;
    }
	
	public void dfs(HashMap<Character, String> dict, ArrayList<String> result, StringBuilder temp, String input, int start) {
		if (start >= input.length()) {
			result.add(temp.toString());
			return;
		}
		String set = dict.get(input.charAt(start));
		for (int i = 0; i < set.length(); i++) {
			temp.append(set.charAt(i));
			dfs(dict, result, temp, input, start + 1);
			temp.deleteCharAt(temp.length() - 1);
		}
	}
}
