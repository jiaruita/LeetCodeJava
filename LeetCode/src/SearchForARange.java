
public class SearchForARange {
	
	public int[] searchRange(int[] A, int target) {
		int [] result = new int[]{-1,-1};
        int len = A.length;
        if (len == 0) {
        	return result;
        }
        int left, right;
        int start = 0; 
        int end = len - 1;
        while (start < end) {
        	int mid = (start + end) / 2;
        	if (A[mid] < target) {
        		start = mid + 1;
        	}
        	else {
        		end = mid;
        	}
        }
        
        return result;
    }
    
	/*
	public int[] searchRange(int[] A, int target) {
		int [] result = new int[]{-1,-1};
        int len = A.length;
        if (len == 0) {
        	return result;
        }
        int left = -1;
        int right = -1;
        int start = 0; 
        int end = len - 1;
        while (start <= end) {
        	
        	int mid = (start + end) / 2;
        	System.out.println("start = " + start + "; end = " + end + "; mid = " + mid);
        	if (A[mid] == target) {
        	    if (mid == 0 || A[mid] > A[mid - 1]) {
        	        left = mid;
        	        System.out.println("left = " + left);
        	        break;
        	    }
        	    else {
        	        end = mid - 1;
        	    }
        	}
        	else if (A[mid] > target) {
        		end = mid - 1;
        	}
        	else {
        		start = mid + 1;
        	}
        }
        if (left == -1) {
            return result;
        }
        start = 0;
        end = len - 1;
        while (start <= end) {
        	int mid = (start + end) / 2;
        	System.out.println("start = " + start + "; end = " + end + "; mid = " + mid);
        	if (A[mid] == target) {
        	    if (mid == len - 1 || A[mid] < A[mid + 1]) {
        	        right = mid;
        	        System.out.println("right = " + right);
        	        break;
        	    }
        	    else {
        	        start = mid + 1;
        	    }
        	}
        	else if (A[mid] < target) {
        		start = mid + 1;
        	}
        	else {
        		end = mid - 1;
        	}
        }
        if (right == -1) {
            return result;
        }
        result[0] = left;
        result[1] = right;
        return result;
    }
	*/
	public void test() {
		int[] A = new int[]{1,1,2};
		int[] result = searchRange(A, 1);
		for (Integer x: result) {
			System.out.print(x + " ");
		}
		System.out.print("\n");
	}
}
