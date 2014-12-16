
public class SingleNumber2 {
	public int singleNumber(int[] A) {
		int result = 0;
        int bit = 0;
        for (; bit < 32; bit++) {
        	int sum = 0;
        	for (int i = 0; i < A.length; i++) {
        		sum += (A[i] >> bit) & 1;
        	}
        	System.out.println("sum = " + sum);
        	if (sum % 3 == 1) {
        	    result = result | (1 << bit);
        	}
        	/*
        	int thisBit = sum % 3 == 0?0:1;
        	result = result | (thisBit << bit);
        	*/
        }
        return result;
    }
	
	public void test() {
		int A[] = {2,2,2,3};
		int result = singleNumber(A);
	}
}
