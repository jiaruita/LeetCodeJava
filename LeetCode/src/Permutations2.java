import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;


public class Permutations2 {
	/*
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int len = num.length;
        if (len == 0) {
        	return result;
        }
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        Arrays.sort(num);
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(num[0]);
        result.add(arr);
        printResult(result);
        for (int i = 1; i < len; i++) {
        	result = insert(result, num[i]);
        }
        for (ArrayList<Integer> a: result) {
    		set.add(a);
    	}
        result = new ArrayList<ArrayList<Integer>>();
        for (ArrayList<Integer> a : set) {
        	result.add(a);
        }
        return result;
    }
	
	public ArrayList<ArrayList<Integer>> insert(ArrayList<ArrayList<Integer>> result, int num) {
		System.out.println("insert : " + num);
		ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
		for (ArrayList<Integer> arr: result) {
			ArrayList<Integer> tempArr = (ArrayList<Integer>) arr.clone();
			tempArr.add(0, num);
			temp.add(tempArr);
			//printResult(temp);
			for (int i = 1; i <= arr.size(); i++) {
				tempArr = (ArrayList<Integer>) arr.clone();
				if (tempArr.get(i - 1) != num) {
					System.out.println("insert to: " + i);
					tempArr.add(i, num);
					temp.add(tempArr);
				}
			}
		}
		printResult(temp);
		return temp;
	}
	*/
	
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		int len = num.length;
		if (len == 0) {
			return result;
		}
		Arrays.sort(num);
		boolean[] visited = new boolean[len];
		recur(num, result, visited, new ArrayList<Integer>());
		return result;
	}
	
	public void recur(int[] num, ArrayList<ArrayList<Integer>> result, boolean[] visited, ArrayList<Integer> path) {
		System.out.print("\npath: ");
		printArr(path);
		System.out.print("visited:");
		printArr(visited);
		if (path.size() == num.length) {
			System.out.println("result.add path, return");
			result.add((ArrayList<Integer>) path.clone());
			return;
		}
		for (int i = 0; i < num.length; i++) {
			System.out.println("for i = " + i + "; num[i] = " + num[i]);
			if (visited[i]) {
				System.out.println("visited, continue");
				continue;
			}
			if (i > 0 && num[i - 1] == num[i] && visited[i - 1]) {
				System.out.println("equal, continue");
				continue;
			}
			path.add(num[i]);
			visited[i] = true;
			recur(num, result, visited, path);
			visited[i] = false;
			path.remove(path.size() - 1);
		}
		System.out.println("return");
	}
	
	public void printArr(ArrayList<Integer> arr) {
		for(Integer x: arr) {
			System.out.print(x + " ");
			
		}
		System.out.println("");
	}
	
	public void printArr(boolean[] arr) {
		for(boolean x: arr) {
			if (x) {
				System.out.print("" + 1 + " ");
			}
			else {
				System.out.print("" + 0 + " ");
			}
			
		}
		System.out.println("");
	}
	
	public void printResult(ArrayList<ArrayList<Integer>> result) {
	    System.out.println("result:");
		for (ArrayList<Integer> arr: result) {
			for (Integer x : arr) {
				System.out.print(x + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
	public void test() {
		int[] num = new int[]{2,2,1,1};
		printResult(permuteUnique(num));
	}
}
