
public class ReverseInteger {
	public int reverse(int x) {
		int result = 0;
        int neg = 0;
        if (x < 0) {
        	x = 0 - x;
        	neg = 1;
        }
        int digit = 10;
        while (true) {
        	if (x == 0) {
        		break;
        	}
        	int q = x / 10;
        	int r = x % 10;
        	x = q;
        	result = result * 10 + r;
        }
        if (neg == 1) {
        	result = 0 - result;
        }
        return result;
    }
	
	public void testReverse() {
		System.out.println(reverse(23));
	}
}
