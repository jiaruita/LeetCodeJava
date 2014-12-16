
public class StringToInteger {
	public int atoi(String str) {
		boolean overflow = false;
		str = str.trim();
		System.out.println("after trim: " + str);
		if (str.length() == 0) {
			 return 0;
		}
        boolean neg = false;
        if (str.charAt(0) == '-') {
        	neg = true;
        	str = str.substring(1);
        }
        else if(str.charAt(0) == '+') {
        	str = str.substring(1);
        }
        
        int result = 0;
        int length = str.length();
        for (int i = 0; i < length; i++) {
        	if (str.charAt(i) > '9' || str.charAt(i) < '0') {
        		System.out.println("non number");
        		 break;
        	}
        	int inter = result * 10;
        	System.out.println("inter = " + inter);
        	if (result != 0 && inter / result < 10) {
        		overflow = true;
        		break;
        	}
        	int newResult = inter + (str.charAt(i) - '0');
        	System.out.println("newResult = " + newResult);
        	/*
        	if (newResult < inter) {
        		overflow = true;
        		break;
        	}*/
        	result = newResult;
        }
        if (overflow == true) {
        	System.out.println("overflow");
        	return (neg == true)?Integer.MIN_VALUE:Integer.MAX_VALUE;
        }
        if (neg == true) {
        	System.out.println("neg");
        	result = 0 - result;
        }
        return result;
    }
	
	public void testAtoI() {
		System.out.println(atoi("         f11484849885"));
		
	}
}
