import java.util.ArrayList;


public class RestoreIPAddress {
	public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<String>();
        int len = s.length();
        if (len < 4 || len >12) {
        	return result;
        }
        String temp = "";
        dfs(s, 0, temp, result, 1);
        return result;
    }
	
	public void dfs(String s, int start, String temp, ArrayList<String> result, int part) {
		if (part > 4) {
			if (start == s.length()) {
				result.add(new String(temp.substring(1)));
			}
			return;
		}
		for (int i = 1; i <= 3; i++) {
			if (start + i > s.length()) {
				break;
			}
			if (valid(s.substring(start, start + i))) {
				int tempLen = temp.length();
				temp = temp + "." + s.substring(start, start + i);
				dfs(s, start + i, temp, result, part + 1);
				temp = temp.substring(0, tempLen);
			}
		}
	}
	
	public boolean valid(String s) {
		int len = s.length();
		if (len < 1 || len > 3) {
			return false;
		}
		if (s.charAt(0) == '0' && len > 1) {
			return false;
		}
		int num = 0;
		int ten = 1;
		for (int i = len - 1; i >= 0; i--) {
			num = num + ten * (s.charAt(i) - '0');
			ten = ten * 10;
		}
		if (num > 255 || num < 0) {
			return false;
		}
		return true;
	}
	
	public void test() {
		String s = "25525511135";
		ArrayList<String> result = restoreIpAddresses(s);
		System.out.println(result.toString());
	}
}
