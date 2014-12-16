
public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		int result;
		if (divisor == 0) {
			return 0;
		}
		result = (int)helper((long)Math.abs((long)dividend), (long)Math.abs((long)divisor));
		if(((dividend ^ divisor) >>> 31) == 1) {
			result = 0 - result;
		}
        return result;
    }
	
	public long helper(long dividend, long divisor) {
		//System.out.println("dividend = " + dividend + "; divisor = " + divisor);
		if (dividend < divisor) {
			return 0;
		}
		long x = 1;
        long sum = 0;
        long temp = divisor;
       // int out = 0;
       // int in = 0;
        while (dividend >= divisor) {
        	//out++;
        	while (true) {
        		//in++;
            	temp = temp << 1;
            	if (temp > dividend) {
            		temp = temp >> 1;
            		break;
            	}
            	else if (temp == dividend) {
            		x = x + x;
            		return sum + x;
            	}
            	else {
            		x = x + x;
            	}
            }
        	dividend = dividend - temp;
        	temp = divisor;
        	sum += x;
        	x = 1;
        }
        //System.out.println("out = " + out + "; in = " + in);
        return sum;
	}
	
	public void test() {
		int a = -1010369383;
		int b = -2147483648;
		System.out.println(Math.abs((long)b));
		System.out.println((long)b);
		System.out.println((long)Math.abs(b));
		System.out.println((long)Math.abs((long)b));
		System.out.println(divide(a,b));
	}
}
