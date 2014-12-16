
public class SearchInRotatedSortedArray2 {
	public boolean search(int[] A, int target) {
        int len = A.length;
        if (len == 0) {
        	return false;
        }
        int left = 0;
        int right = len - 1;
        while (left <= right) {
        	int mid = (left + right) / 2;
        	if (A[mid] == target) {
        		return true;
        	}
        	if (A[mid] > A[left]) {
        		if (target >= A[left] && target < A[mid]) {
        			right = mid - 1;
        		}
        		else {
        			left = mid + 1;
        		}
        	}
        	else if (A[mid] < A[left]) {
        		if (target > A[mid] && target <= A[right]) {
        			left = mid + 1;
        		}
        		else {
        			right = mid - 1;
        		}
        	}
        	else {
        		left++;
        	}
        }
        return false;
    }
}
