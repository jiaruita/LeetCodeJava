import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class MergeIntervals {
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		ArrayList<Interval> result = new ArrayList<Interval>();
		int len = intervals.size();
		if (len == 0) {
			return result;
		}
        HashMap<Integer, Interval> map = new HashMap<Integer, Interval>();
        int[] starts = new int[len];
        int index = 0;
        for (Interval i: intervals) {
        	starts[index++] = i.start;
        	if (!map.containsKey(i.start)) {
        		map.put(i.start, i);
        	}
        	else {
        		int end = map.get(i.start).end;
        		if (i.end > end ) {
        			map.put(i.start, new Interval(i.start, i.end));
        		}
        	}
        }
        Arrays.sort(starts);
        System.out.println(Arrays.toString(starts));
       
        int start = starts[0];
        int end = map.get(starts[0]).end;
        for (int i = 1; i < len; i++) {
        	
        	if (starts[i] == starts[i - 1]) {
        		continue;
        	}
        	System.out.println("i = " + i + "; start = " + start + "; end = " + end);
        	System.out.println("\tstarts[i] = " + starts[i] + "; map.get[starts[i]].end = " + map.get(starts[i]).end);
        	if (starts[i] <= end) {
        	    int e1 = end;
        	    int e2 = map.get(starts[i]).end;
        		end = e1 > e2 ? e1 : e2;
        	}
        	else {
        		result.add(new Interval(start, end));
        		start = starts[i];
        		end = map.get(starts[i]).end;
        	}
        }
        result.add(new Interval(start, end));
        return result;
    }
	
	public void printArr(ArrayList<Interval> arr) {
		for (Interval i: arr) {
			System.out.println("start = " + i.start + "; end = " + i.end);
		}
		System.out.println("");
	}
	
	public void test() {
		ArrayList<Interval> arr = new ArrayList<Interval>();
		int[] num = new int[]{0,0,1,2,5,5,2,4,3,3,5,6,5,6,4,6,0,0,1,2,0,2,4,5};
		Interval temp = new Interval();
		for (int i = 0 ; i < num.length; i++) {
			if (i%2 == 0) {
				temp = new Interval();
				temp.start = num[i];
			}
			else {
				temp.end = num[i];
				arr.add(temp);
			}
		}
		printArr(arr);
		ArrayList<Interval> newArr = merge(arr);
		printArr(newArr);
	}
}
