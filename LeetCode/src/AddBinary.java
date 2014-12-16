
public class AddBinary {
	public String addBinary(String a, String b) {
        int la = a.length();
        int lb = b.length();
        if (la == 0) {
        	return b;
        }
        if (lb == 0) {
        	return a;
        }
        String temp;
        if (la > lb) {
        	temp = b;
        	b = a;
        	a = temp;
        }
        la = a.length();
        lb = b.length();
        boolean carry = false;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (; i < lb; i++) {
        	char ca;
        	if (i >= la) {
        		ca = '0';
        	}
        	else {
        		ca = a.charAt(la - 1 - i);
        	}
        	char cb = b.charAt(lb - 1 - i);
        	if (carry) {
        		if (ca == '1' && cb == '1') {
        			sb.append('1');
        		}
        		else if (ca == '0' && cb == '0') {
        			sb.append('1');
        			carry = false;
        		}
        		else {
        			sb.append('0');
        		}
        	}
        	else {
        		if (ca == '1' && cb == '1') {
        			sb.append('0');
        			carry = true;
        		}
        		else if (ca == '0' && cb == '0') {
        			sb.append('0');
        		}
        		else {
        			sb.append('1');
        		}
        	}
        }
        if (carry) {
        	sb.append('1');
        }
        return sb.reverse().toString();
    }
}
