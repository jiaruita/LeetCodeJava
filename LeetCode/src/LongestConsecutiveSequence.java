import java.util.HashSet;


public class LongestConsecutiveSequence {
	/*
	public int longestConsecutive(int[] num) {
        boolean[] pos = new boolean[1000];
        boolean[] neg = new boolean[1000];
        
        for (int x: num) {
        	if (x>= 0) {
        		pos[x] = true;
        	}
        	else {
        		neg[0 - x] = true;
        	}
        }
        int max = 0;
        int count = 0;
        boolean prev = false;
        for (boolean x: neg) {
        	if (x) {
        		prev = true;
        		count++;
        	}
        	else {
        		prev = false;
        		if (count > max) {
        			max = count;
        		}
        		count = 0;
        	}
        }
        for (boolean x: pos) {
        	if (x) {
        		prev = true;
        		count++;
        	}
        	else {
        		prev = false;
        		if (count > max) {
        			max = count;
        		}
        		count = 0;
        	}
        }
        return max;
    }
	*/
	
	public int longestConsecutive(int[] num) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int x: num) {
			set.add(x);
		}
		
		int max = 0;
		for (int x: num) {
			int mid = x;
			int up = 0;
			int down = 0;
			set.remove(x);
			while (set.remove(mid + 1)) {
				up++;
				mid++;
			}
			mid = x;
			while (set.remove(mid - 1)) {
				down++;
				mid--;
			}
			max = up + down + 1 > max ? up + down + 1 : max;
		}
		return max;
	}
	
	public void testCon() {
		int[] arr = {100, 4, 200, 1, 3, 2};
		System.out.println(longestConsecutive(arr));
	}
}
