import java.util.ArrayList;
import java.util.Arrays;


public class Subsets {
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		int len = S.length;
		if (len == 0) {
			return result;
		}
        Arrays.sort(S);
        ArrayList<Integer> arr0 = new ArrayList<Integer>();
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        arr1.add(S[0]);
        result.add(arr0);
        result.add(arr1);
        for (int i = 1;i < len; i++) {
        	ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
        	for (ArrayList<Integer> arr: result) {
        		ArrayList<Integer> a = (ArrayList<Integer>) arr.clone();
        		a.add(S[i]);
        		temp.add(a);
        	}
        	for (ArrayList<Integer> arr: temp) {
        		result.add(arr);
        	}
        	temp = null;
        }
        return result;
    }
	
	public void testSubsets() {
		int[] S = {1,2};
		ArrayList<ArrayList<Integer>> result = subsets(S);
		for (ArrayList<Integer> arr: result) {
			for (Integer x: arr) {
				System.out.print(x + " ");
			}
			System.out.print("\n");
		}
	}
}
