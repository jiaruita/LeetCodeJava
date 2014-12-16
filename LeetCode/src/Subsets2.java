import java.util.ArrayList;
import java.util.Arrays;


public class Subsets2 {
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int len = num.length;
        if (len == 0) {
        	return result;
        }
        Arrays.sort(num);
        result.add(new ArrayList<Integer>());
        int start = 0;
        for (int j = 0; j < num.length; j++) {
        	int size = result.size();
        	for (int i = start; i < size; i++) {
        		ArrayList<Integer> temp = new ArrayList<Integer>(result.get(i));
        		temp.add(num[j]);
        		result.add(temp);
        	}
        	if (j + 1 < num.length && num[j + 1] == num[j]) {
        		start = size;
        	}
        	else {
        		start = 0;
        	}
        }
        return result;
    }
}
