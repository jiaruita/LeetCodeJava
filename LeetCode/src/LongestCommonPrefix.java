
public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len == 0) {
        	return "";
        }
        for (int i = 0; ; i++) {
        	if (strs[0].length() <= i) {
        		return strs[0].substring(0, i);
        	}
        	char c = strs[0].charAt(i);
        	for (int j = 1; j < len; j++) {
        		if (strs[j].length() <= i) {
        			return strs[0].substring(0, i);
        		}
        		if (strs[j].charAt(i) != c) {
        			return strs[0].substring(0, i);
        		}
        	}
        }
    }
}
