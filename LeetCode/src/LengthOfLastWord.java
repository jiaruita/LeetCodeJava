
public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
        int len = s.length();
        if (len == 0) {
        	return 0;
        }
        s = s.trim();
        len = s.length();
        char[] chars = s.toCharArray();
        int lastSpace = -1;
        for (int i = 0; i < len; i++) {
        	if (chars[i] == ' ') {
        		lastSpace = i;
        	}
        }
        return len - 1 - lastSpace;
    }
}
