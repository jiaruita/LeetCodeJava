import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;


public class Anagrams {
	/*
	public ArrayList<String> anagrams(String[] strs) {
		ArrayList<String> result = new ArrayList<String>();
		//ArrayList<ArrayList<String>> all = new ArrayList<ArrayList<String>>();
        int len = strs.length;
        if (len == 0) {
        	return result;
        }
        if (len == 1) {
        	result.add(strs[0]);
        	return result;
        }
        boolean visited[] = new boolean[len];
        for (int i = 0; i < len; i++) {
        	if (visited[i]) {
    			continue;
    		}
        	for (int j = i + 1; j < len; j++) {
        		if (visited[j]) {
        			continue;
        		}
        		if (isAnagram(strs[i], strs[j])) {
        			result.add(strs[i]);
        			result.add(strs[j]);
        			visited[i] = true;
        			visited[j] = true;
        		}
        	}
        }
        return result;
    }
	
	public boolean isAnagram(String s1, String s2) {
		int[] voc = new int[26];
		if (s1.length() != s2.length()) {
			return false;
		}
		for (int i = 0; i < s1.length(); i++) {
			voc[(int)(s1.charAt(i) - 'a')]++;
		}
		for (int i = 0; i < s2.length(); i++) {
			voc[s2.charAt(i) - 'a']--;
		}
		for (Integer x: voc) {
			if (x != 0) {
				return false;
			}
		}
		return true;
	}
	*/
	
	public ArrayList<String> anagrams(String[] strs) {
		ArrayList<String> result = new ArrayList<String>();
		int len = strs.length;
		if (len <= 1) {
			return result;
		}
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < len; i++) {
			String sorted = sortString(strs[i]);
			System.out.println("sorted: " + sorted);
			if (!map.containsKey(sorted)) {
				map.put(sorted, i);
				System.out.println("not contains");
			}
			else {
				System.out.println("contains");
				int index = map.get(sorted);
				if (index != -1) {
					System.out.println("add: " + strs[index]);
					result.add(strs[index]);
					map.put(sorted, -1);
				}
				System.out.println("add: " + strs[i]);
				result.add(strs[i]);
			}
		}
		System.out.println("result.size = " + result.size());
		return result;
	}
	
	public String sortString(String s) {
		if (s == "") {
			System.out.println("null");
			return "";
		}
		char[] arr = s.toCharArray();
		Arrays.sort(arr);
		String result = Arrays.toString(arr);
		System.out.println(result);
		return result;
	}
	
	public void test() {
		String[] strs = new String[]{"c", "c"};
		ArrayList<String> result = anagrams(strs);
		for (String s: result) {
			System.out.println(s);
		}
	}
}
