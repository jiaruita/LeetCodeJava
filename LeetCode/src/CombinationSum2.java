import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;


public class CombinationSum2 {
	public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        int len = num.length;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (len == 0) {
        	return result;
        }
        Arrays.sort(num);
        dfs(result, new ArrayList<Integer>(), target, num, 0);
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        for (ArrayList<Integer> arr: result) {
        	set.add(arr);
        }
        result = new ArrayList<ArrayList<Integer>>();
        for (ArrayList<Integer> arr: set) {
        	result.add(arr);
        }
        return result;
    }
	
	public void dfs(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> arr, int target, int[] num, int start) {
		System.out.println("dfs start = " + start + "; target = " + target);
		if (target == 0) {
			result.add((ArrayList<Integer>) arr.clone());
			System.out.println("target == 0, return");
			return;
		}
		
		for (int i = start; i < num.length; i++) {
			System.out.println("for i = " + i);
			if (num[i] > target) {
				System.out.println("num[" + i + "] > target");
				return;
			}
			arr.add(num[i]);
			dfs(result, arr, target - num[i], num, i + 1);
			System.out.println("back dfs start = " + start);
			arr.remove(arr.size() - 1);
		}
		return;
	}
	
	public void test() {
		int[] num = new int[]{1,2};
		combinationSum2(num, 2);
	}
}
