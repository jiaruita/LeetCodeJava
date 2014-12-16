
public class ImplementStrstr {
	public String strStr(String haystack, String needle) {
		int len1 = haystack.length();
		int len2 = needle.length();
		if (len1 < len2) {
			return null;
		}
        char[] str = haystack.toCharArray();
        char[] sub = needle.toCharArray();
        int i;
        int j;
        for (i = 0; i <= len1 - len2; i++) {
        	for (j = 0; j < len2; j++) {
        		if (str[i + j] != sub[j]) {
        			break;
        		}
        	}
        	if (j == len2) {
        		return haystack.substring(i);
        	}
        }
        return null;
    }
}
