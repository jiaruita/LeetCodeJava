
public class Sqrt {
	public int sqrt(int x) {
		if (x == 0) {
			return 0;
		}
        if (x == 1) {
        	return 1;
        }
        long left = 1;
        long right = (long)(x / 2 + 1);
        //int count = 0;
        while (left < right) {
        	//System.out.println("left = " + left + "; right = " + right + "; count = " + count);
        	//count++;
        	long mid = (left + right) / 2;
        	//System.out.println("mid = " + mid);
        	if (mid * mid < x) {
        		left = mid + 1;
        	}
        	else if (mid * mid == x) {
        		return (int)mid;
        	}
        	else {
        		right = mid;
        	}
        }
        
        return (int)right - 1;
    }
	
	public void test() {
		System.out.println(sqrt(1579205274));
	}
}
