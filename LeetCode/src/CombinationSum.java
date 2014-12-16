import java.util.ArrayList;
import java.util.Arrays;


public class CombinationSum {
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int len = candidates.length;
        if (len == 0) {
        	return result;
        }
        Arrays.sort(candidates);
        System.out.println("len = " + len);
        dfs(candidates, target, 0, result, new ArrayList<Integer>());
        return result;
    }
	
	public void dfs(int[] candidates, int target, int start, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> arr) {
		System.out.println("target = " + target + "; start = " + start);
		if (0 == target) {
			System.out.println("add");
			result.add((ArrayList<Integer>) arr.clone());
			return;
		}
		else if (candidates[start] > target) {
			System.out.println(">");
			return;
		}
		else {
			for (int i = start; i < candidates.length; i++) {
				/*
				if (candidates[i] > target) {
					continue;
				}*/
				arr.add(candidates[i]);
				System.out.println("arr.add");
				dfs(candidates, target - candidates[i], i, result, arr);
				arr.remove(arr.size() - 1);
			}
		}
	}
	
	public void test() {
		int[] c = new int[]{1};
		ArrayList<ArrayList<Integer>> result;
		result = combinationSum(c, 1);
		
		for (ArrayList<Integer> arr: result) {
			for (Integer x: arr) {
				System.out.print(x + " ");
			}
			System.out.println(" ");
		}
		
	}
}
