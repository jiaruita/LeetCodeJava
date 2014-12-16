import java.util.ArrayList;


public class Combinations {
	/*
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (n < k || k <= 0) {
			return result;
		}
        result.add(new ArrayList<Integer>());
        for (int i = 0; i < k; i++) {
        	ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
        	for (ArrayList<Integer> arr : result) {
        		int prevLen = arr.size();
        		int start = 0;
        		if (prevLen > 0) {
        			start = arr.get(prevLen - 1);
        		}
        		for (int j = start + 1; j <= n - k + 1 + i; j++) {
        			ArrayList<Integer> a = new ArrayList<Integer>(arr);
        			a.add(j);
        			temp.add(a);
        		}
        	}
        	result = temp;
        }
        return result;
    }
    */
    long count = 0;
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (n < k || k <= 0) {
			return result;
		}
		
		result = recur(1, n, k);
		System.out.println("leetcode : count = " + count);
		System.out.println("result.size = " + result.size());
		return result;
	}
	
	public ArrayList<ArrayList<Integer>> recur(int start, int n, int k) {
	    count++;
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (k == 1) {
			for (int i = start; i <= n; i++) {
				ArrayList<Integer> arr = new ArrayList<Integer>();
				arr.add(i);
				result.add(arr);
			}
			return result;
		}
		for (int i = start; i + k - 1 <= n; i++) {
			ArrayList<ArrayList<Integer>> temp = recur(i + 1, n, k - 1);
			for (ArrayList<Integer> arr: temp) {
				arr.add(0,i);
				result.add(arr);
			}
		}
		return result;
	}
	
	public void test() {
	    long startTime = System.currentTimeMillis();
	    combine(10,5);
	    long endTime   = System.currentTimeMillis();
	    long totalTime = endTime - startTime;
	    System.out.println(totalTime);
	    
	}
}

