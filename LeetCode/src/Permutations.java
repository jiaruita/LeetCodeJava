import java.util.ArrayList;


public class Permutations {
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int len = num.length;
        if (len == 0) {
        	return result;
        }
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(num[0]);
        result.add(arr);
        for(int i = 1; i < len; i++) {
        	//printMat(result);
        	ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
        	for (int j = 0; j < result.size(); j++) {
        		for (int k = 0; k <= result.get(j).size(); k++) {
        			ArrayList<Integer> cur = (ArrayList<Integer>) result.get(j).clone();
        			
        			cur.add(k, num[i]);
        			temp.add(cur);
        			//printMat(temp);
        		}
        	}
        	result = temp;
        }
        return result;
    }
	
	public void printMat(ArrayList<ArrayList<Integer>> result) {
		for (ArrayList<Integer> arr: result) {
			for (Integer x: arr) {
				System.out.print(x + " ");
			}
			System.out.print("\n");
		}
	}
	public void testPermute() {
		int[] num = {1,2,3};
		ArrayList<ArrayList<Integer>> result = permute(num);
		printMat(result);
	}
}
