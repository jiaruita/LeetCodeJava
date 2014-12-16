import java.util.ArrayList;


public class PermutationSequence {
	public String getPermutation(int n, int k) {
		ArrayList<Integer> cand = new ArrayList<Integer>(n);
		if (n == 1) {
			return "1";
		}
		int[] num = new int[n];
		num[0] = 0;
		num[1] = 1;
		for (int i = 2; i < n; i++) {
			num[i] = num[i - 1] * i;
		}
		for (int i = 1; i <= n; i++) {
			cand.add(i);
		}
        int[] arr = new int[n];
        k--;
        for (int i = 0; i < n - 1; i++) {
        	int remain = n - 1 - i;
        	
        	arr[i] = cand.get(k / num[remain]);
        	//System.out.println("remain = " + remain + "; arr[i] = " + arr[i]);
        	cand.remove(k / num[remain]);
        	k = k % num[remain];
        }
        arr[n - 1] = cand.get(0);
        char[] c = new char[n];
        int index = 0;
        for(Integer x: arr) {
        	//System.out.print(x);
        	c[index++] = (char)('0' + x);
        }
        return new String(c);
    }
	
	public void test() {
		System.out.println(getPermutation(5, 2));
	}
}
