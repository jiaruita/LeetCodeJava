import java.util.ArrayList;


public class GrayCode {
	public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (n == 0) {
        	result.add(0);
        	return result;
        }
        result.add(0);
        result.add(1);
        if (n == 1) {
        	return result;
        }
        for (int i = 2; i <= n; i++) {
        	//System.out.println("i = " + i);
        	int prev = (int) Math.pow(2, i - 1);
        	//System.out.println("prev = " + prev);
        	for (int j = prev - 1; j >= 0; j--) {
        		Integer x = result.get(j);
        		result.add(x);
        	}
        	
        	for (int j = 0; j < prev; j++) {
        		int temp = result.get(j);
        		temp = temp + (0 << (i - 1));
        		result.set(j, temp);
        	}
        	
        	for (int j = prev; j < prev + prev; j++) {
        		int temp = result.get(j);
        		temp = temp + (1 << (i - 1));
        		result.set(j, temp);
        	}
        	
        }
        return result;
    }
	
	public void testGray() {
		ArrayList<Integer> result = grayCode(3);
		for (Integer x: result) {
			System.out.println(x);
		}
	}
}
