
public class LongestSubWORepeat {
	public int lengthOfLongestSubstring(String s) {
		int len = s.length();
		if (len == 0) {
			return 0;
		}
		int max = 1;
		int[] prev = new int[len];
		prev[0] = 1;
		for (int i = 1; i < len; i++) {
			char c = s.charAt(i);
			prev[i] = 1;
			for (int j = i - 1; j > i - 1 - prev[i - 1]; j--) {
				if (c != s.charAt(j)) {
					prev[i]++;
				}
				else {
					break;
				}
			}
		}
		for (Integer x:prev) {
			if (x > max) {
				max = x;
			}
		}
		return max;
    }
	
	public void testLength() {
		String s = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
		System.out.println(lengthOfLongestSubstring(s));
	}
}
