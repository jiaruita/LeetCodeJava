import java.util.ArrayList;


public class InsertInterval {
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int len = intervals.size();
        ArrayList<Interval> result = new ArrayList<Interval>();
        if (len == 0) {
        	result.add(newInterval);
        	return result;
        }
        /*
        if (newInterval.end < intervals.get(0).start) {
        	result.add(newInterval);
        	result.addAll(intervals);
        	return result;
        }*/
        int start = newInterval.start;
        int end = newInterval.end;
        Interval temp;
        int i = 0;
        while(i < len) {
        	temp = intervals.get(i);
        	if (temp.end < newInterval.start) {
        		result.add(temp);
        	}
        	else {
        		start = Math.min(start, temp.start);
        		break;
        	}
        	i++;
        }
        while (i < len) {
        	temp = intervals.get(i);
        	if (temp.start > end) {
        		break;
        	}
        	end = Math.max(temp.end, end);
        	i++;
        }
        result.add(new Interval(start, end));
        while (i < len) {
        	result.add(intervals.get(i));
        	i++;
        }
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
		Interval newInterval = new Interval(6,6);
		int[] num = new int[]{3,5,12,15};
		Interval temp = new Interval();
		for (int i = 0; i < num.length; i++) {
			if (i % 2 == 0) {
				temp = new Interval();
				temp.start = num[i];
			}
			else {
				temp.end = num[i];
				arr.add(temp);
			}
		}
		printArr(arr);
		ArrayList<Interval> newArr = insert(arr, newInterval);
		printArr(newArr);
	}
	
	/*
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int len = intervals.size();
        ArrayList<Interval> result = new ArrayList<Interval>();
        if (len == 0) {
        	result.add(newInterval);
        	return result;
        }
        if (newInterval.end < intervals.get(0).start) {
        	result.add(newInterval);
        	result.addAll(intervals);
        	return result;
        }
        int start = newInterval.start;
        int end = newInterval.end;
        Interval temp;
        int flag = 0;
         for (int i = 0; i < len; i++) {
        	temp = intervals.get(i);
        	if (temp.end < start || temp.start > end) {
        		if (flag == 1) {
        			result.add(new Interval(start, end));
        			flag = 2;
        		}
        		result.add(temp);
        	}
        	else {
        		flag = 1;
        		start = Math.min(start, temp.start);
        		end = Math.max(end, temp.end);
        	}
        }
        if (flag != 2) {
            result.add(new Interval(start, end));
        }
       // result.add(new Interval(start, end));
        return result;
	}*/
	
	/*
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int len = intervals.size();
        ArrayList<Interval> result = new ArrayList<Interval>();
        if (len == 0) {
        	result.add(newInterval);
        	return result;
        }
        int i = 0;
        int start = 0;
        int end = newInterval.end;
        if (newInterval.end < intervals.get(0).start) {
        	result.add(newInterval);
        	result.addAll(intervals);
        	return result;
        }
        for (; i < len; i++) {
        	Interval temp = intervals.get(i);
        	if (temp.end < newInterval.start) {
        		result.add(temp);
        	}
        	else {
        		start = Math.min(temp.start, newInterval.start);
        		break;
        	}
        }
        if (i == len) {
        	result.add(newInterval);
        	return result;
        }
        for (; i < len; i++) {
        	Interval temp = intervals.get(i);
        	if (temp.start > end) {
        		result.add(new Interval(start, end));
        		break;
        	}
        	if (temp.end >= newInterval.end) {
        		i++;
        		end = temp.end;
        		result.add(new Interval(start, end));
        		break;
        	}
        }
        if (i == len) {
        	result.add(new Interval(start, newInterval.end));
        	return result;
        }
        else {
        	result.add(new Interval(start, end));
        }
        for (;i<len; i++) {
        	result.add(intervals.get(i));
        }
        return result;
    }
    */
}
