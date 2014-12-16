
public class DecodeWays {
	public int numDecodings(String s) {
		int len = s.length();
		if (len == 0) {
			return 0;
		}
		if (s.charAt(0) == '0') {
			return 0;
		}
		if (len == 1) {
			if (s.charAt(0) == '0') {
				return 0;
			}
			return 1;
		}
		int[] arr = new int[len];
		arr[0] = 1;
		boolean flag = false;
		for (int i = 1; i < len; i++) {
			if (s.charAt(i) == '0') {
				if (s.charAt(i - 1) > '2' || s.charAt(i - 1) < '1') {
					return 0;
				}
				else {
					/*
					if (arr[i - 1] > 1) {
				    	arr[i - 1] -= 1;
				    }*/
					arr[i] = (i > 1?arr[i - 2] : 1);
					continue;
				}
			}
			if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) <= '6') {
				arr[i] = arr[i - 1] + (i > 1?arr[i - 2]:1);
			}
			else {
				arr[i] = arr[i - 1];
			}
		}
		return arr[len - 1];
	}
	
	public void test() {
		String s = "16205";
		System.out.println(numDecodings(s));
	}
}
