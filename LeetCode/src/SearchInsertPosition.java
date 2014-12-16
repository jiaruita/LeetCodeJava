
public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
        int len = A.length;
        if (len == 0) {
        	return 0;
        }
        return recur(A, 0, len - 1, target);
    }
	
	public int recur(int[] A, int start, int end, int target) {
		if (start > end) {
			return -1;
		}
		if (start == end) {
			return start;
		}
		int mid = start + (end - start) / 2;
		if (A[mid] == target) {
			return mid;
		}
		else if (A[mid] < target) {
			if (mid == end) {
				return end;
			}
			return recur(A, mid + 1, end, target);
		}
		else {
			if (mid == start) {
				return start;
			}
			return recur(A, start, mid - 1, target);
		}
	}
}
