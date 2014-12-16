
public class SearchRotatedArray {
	public int search(int[] A, int target) {
        int len = A.length;
        if (len == 0) {
        	return -1;
        }
        int left = 0;
        int right = len - 1;
        while (left <= right) {
        	
        	int mid = left + (right - left) / 2;
        	System.out.println("left = " + left + "; right = " + right + "; mid = " + mid);
        	if (A[mid] == target) {
        		System.out.println("case 1");
        		return mid;
        	}
        	if (A[left] <= A[mid]) {
        		if (target<A[mid] && A[left] <= target) {
        			System.out.println("case 2");
        			right = mid - 1;
        		}
        		else {
        			System.out.println("case 3");
        			left = mid + 1;
        		}
        	}
        	else {
        		if (target <= A[right] && target > A[mid]) {
        			System.out.println("case 4");
        			left = mid + 1;
        		}
        		else {
        			System.out.println("case 5");
        			right = mid - 1;
        		}
        	}
        }
        return -1;
    }
	
	public void testSearch() {
		int[] A = {3,1};
		System.out.println(search(A, 1));
	}
}
