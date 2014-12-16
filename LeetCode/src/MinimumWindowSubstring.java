import java.util.HashMap;


public class MinimumWindowSubstring {
	public String minWindow(String S, String T) {
        int len1 = S.length();
        int len2 = T.length();
        char[] s1 = S.toCharArray();
        char[] s2 = T.toCharArray();
        if (len1 == 0 || len2 == 0 || len1 < len2) {
        	return "";
        }
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        String result = "";
        int count = 0;
        HashMap<Character, Integer> total = new HashMap<Character, Integer>();
        HashMap<Character, Integer> found = new HashMap<Character, Integer>();
        for (int i = 0; i < len2; i++) {
        	if (total.containsKey(s2[i])) {
        		total.put(s2[i], total.get(s2[i]) + 1);
        	}
        	else {
        		total.put(s2[i], 1);
        		found.put(s2[i], 0);
        	}
        }
        for (; end < len1; end++) {
        	if (!total.containsKey(s1[end])) {
        		continue;
        	}
        	else {
        		found.put(s1[end], found.get(s1[end]) + 1);
        		if (found.get(s1[end]) <= total.get(s1[end])) {
        			count++;
        		}
        		if (count >= len2) {
        			while (!total.containsKey(s1[start]) || found.get(s1[start]) > total.get(s1[start])) {
        				if (total.containsKey(s1[start])) {
        					found.put(s1[start], found.get(s1[start]) - 1);
        				}
        				start++;
        			}
        			int window = end - start + 1;
        			if (window < min) {
        				min = window;
        				result = S.substring(start, end + 1);
        			}
        		}
        	}
        }
        return result;
    }
	
	public void test() {
		String s1 = "bba";
		String s2 = "ab";
		System.out.println(minWindow(s1, s2));
	}
}
