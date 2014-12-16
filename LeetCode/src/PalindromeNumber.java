
public class PalindromeNumber {
	public boolean isPalindrome(int x) {
        if (x < 0) {
        	return false;
        }
        if (x < 10) {
        	return true;
        }
        int digits = 1;
        int num = x;
        while (num / 10 > 0) {
        	digits++;
        	num = num / 10;
        }
        //System.out.println("digits = " + digits);
        for (int i = 1; i <= digits / 2; i++) {
        	
        	int r = x % 10;
        	int ten = 1;
        	for (int j = 1; j <= digits - 1; j++) {
        		ten *= 10;
        	}
        	int l = x / ten;
        	System.out.println("x = " + x + "; ten = " + ten + "; l = " + l + "; r = " + r);
        	if (r != l) {
        		return false;
        	}
        	digits -= 2;
        	
        	x = x - l * ten;
        	x = x / 10;
        }
        return true;
    }
    
    public void test() {
    	int x = 2222222;
    	System.out.println(isPalindrome(x));
    }
}
