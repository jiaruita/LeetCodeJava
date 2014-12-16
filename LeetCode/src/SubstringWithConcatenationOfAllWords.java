import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


public class SubstringWithConcatenationOfAllWords {
	public ArrayList<Integer> findSubstring(String S, String[] L) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int lens = S.length();
		int num = L.length;
		if (num == 0) {
			return result;
		}
		int lenw = L[0].length();
	
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		HashMap<String, Integer> found = new HashMap<String, Integer>();
		int count = 0;
		for (int i = 0; i < L.length; i++) {
			Integer value = map.get(L[i]);
			if (value != null) {
				map.put(L[i], value + 1);
			}
			else {
				map.put(L[i], 1);
			}
		}
		for (int i = 0; i + lenw * num <= lens; i++) {
			System.out.println("i = " + i);
			for (String s:L) {
				found.put(s, 0);
			}
			String word;
			for (count = 0; count < num; count++) {
				word = S.substring(i + count * lenw, i + (count + 1) * lenw);
				Integer value = found.get(word);
				if (value == null || value >= map.get(word)) {
					break;
				}
				found.put(word, value + 1);
			}
			if (count == num) {
				result.add(i);
			}
			
		}
		return result;
    }
	
	public void test() {
		String s = "barfoothefoobarman";
		String[] l = new String[]{"foo","bar"};
		ArrayList<Integer> result = findSubstring(s,l);
		System.out.println(result.toString());
	}
}
