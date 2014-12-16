import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;


public class ThreeSum {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        int len = num.length;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (len == 0) {
        	return result;
        }
        Arrays.sort(num);
        for (int i = 0; i < len - 2; i++) {
        	if (i > 0 && num[i] == num[i - 1]) {
        		continue;
        	}
        	int target = 0 - num[i];
        	int start = i + 1;
            int end = len - 1;
            while (start < end) {
            	if (num[start] + num[end] == target) {
            		ArrayList<Integer> arr = new ArrayList<Integer>();
            		arr.add(num[i]);
            		arr.add(num[start]);
            		arr.add(num[end]);
            		result.add(arr);
            		start++;
            		end--;
            		while (start < end && num[start] == num[start - 1]) {
            			start++;
            		}
            		while (start < end && num[end] == num[end + 1]) {
            			end--;
            		}
            	}
            	else if (num[start] + num[end] < target) {
            		start++;
            	}
            	else {
            		end--;
            	}
            }
        }
        System.out.println(result.size());
        return result;
	}
	/*
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        int len = num.length;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (len == 0) {
        	return result;
        }
        Arrays.sort(num);
        dfs(result, new ArrayList<Integer>(), num, 0, 0, 1);
        System.out.println(result.size());
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        for (ArrayList<Integer> arr: result) {
        	set.add(arr);
        }
        System.out.println(set.size());
        result.clear();
        for (ArrayList<Integer> arr: set) {
        	result.add(arr);
        }
        return result;
    }
	
	public void dfs(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> arr, int[] num, int start, int target, int level) {
		if (start >= num.length || num[start] > target) {
			return;
		}
		if (level < 5) {
			for (int i = start; i < num.length; i++) {
				arr.add(num[i]);
				dfs(result, arr, num, start + 1, target - num[i], level + 1);
				arr.remove(arr.size() - 1);
			}
		}
		else {
			if (target == 0) {
				result.add((ArrayList<Integer>) arr.clone());
			}
		}
	}
	*/
	
	public void printResult(ArrayList<ArrayList<Integer>> result) {
		for (ArrayList<Integer> arr : result) {
			for (Integer x : arr) {
				System.out.print(x + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
	public void test() {
		int[] num = new int[]{1,2,-2,-1};
		printResult(threeSum(num));
	}
}
