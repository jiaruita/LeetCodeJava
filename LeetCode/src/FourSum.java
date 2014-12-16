import java.util.ArrayList;
import java.util.Arrays;


public class FourSum {
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        int len = num.length;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (len < 4) {
        	return result;
        }
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> threeResult = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> four;
        for (int i = 0; i < len - 3; i++) {
        	if (i > 0 && num[i] == num[ i - 1]) {
        		continue;
        	}
        	threeSum(num, i + 1, len - 1, target - num[i], threeResult);
            for (ArrayList<Integer> arr: threeResult) {
            	four = (ArrayList<Integer>) arr.clone();
            	four.add(0, num[i]);
            	result.add(four);
            }
        }
        return result;
    }
	
	public void twoSum(int[] num, int start, int end, int target, ArrayList<ArrayList<Integer>> result) {
		result.clear();
		int len = num.length;
		if (end <= start) {
			return;
		}
		int left = start;
		int right = end;
		while (left < right) {
			//System.out.println("left = " + left + "; right = " + right);
			int sum = num[left] + num[right];
			if (sum == target) {
				ArrayList<Integer> arr = new ArrayList<Integer>();
				arr.add(num[left]);
				arr.add(num[right]);
				result.add(arr);
				do {left++;} while (left < right && num[left] == num[left - 1]);
				do {right--;} while (left < right && num[right] == num[right + 1]);
			}
			else if (sum < target) {
				do {left++;} while (left < right && num[left] == num[left - 1]);
			}
			else {
				do {right--;} while(left < right && num[right] == num[right + 1]);
			}
		}
	}
	
	public void threeSum(int[] num, int start, int end, int target, ArrayList<ArrayList<Integer>> result) {
		result.clear();
		int len = num.length;
		if (start + 2 > end) {
			return;
		}
		int cur = start;
		ArrayList<ArrayList<Integer>> twoResult = new ArrayList<ArrayList<Integer>>();
		for (; cur <= end - 2; cur++) {
			/*
			if (cur > 0 && num[cur] == num[cur - 1]) {
				continue;
			}*/
			twoSum(num, cur + 1, len - 1, target - num[cur], twoResult);
			ArrayList<Integer> three;
			for (ArrayList<Integer> arr: twoResult) {
				three = (ArrayList<Integer>) arr.clone();
				three.add(0, num[cur]);
				result.add(three);
			}
		}
	}
	
	public void printResult(ArrayList<ArrayList<Integer>> result) {
		for (ArrayList<Integer> arr: result) {
			for (Integer x: arr) {
				System.out.print(x +" ");
			}
			System.out.println(" ");
		}
		System.out.println(" ");
	}
	
	public void test() {
		int[] num = new int[]{0,0,0,0};
		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		printResult(fourSum(num, 0));
	}
}
