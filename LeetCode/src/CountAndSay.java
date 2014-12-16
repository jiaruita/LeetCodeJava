
public class CountAndSay {
	public String countAndSay(int n) {
        if (n <= 0) {
        	return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('1');
        for (int i = 2; i <= n; i++) {
        	StringBuilder temp = new StringBuilder();
        	int count = 1;
        	for (int j = 1; j < sb.length(); j++) {
        		if (sb.charAt(j) == sb.charAt(j - 1)) {
        			count++;
        		}
        		else {
        			temp.append(count);
        			temp.append(sb.charAt(j - 1));
        			count = 1;
        		}
        	}
        	temp.append(count);
        	temp.append(sb.charAt(sb.length() - 1));
        	sb = temp;
        }
        return sb.toString();
    }
	
	public void test() {
		System.out.println(countAndSay(25));
	}
}
