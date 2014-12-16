
public class RemoveDuplicatesFromSortedArray2 {
	public int removeDuplicates(int[] A) {
        int len = A.length;
        if (len <= 2) {
        	return len;
        }
        int count = 1;
        int i = 0;
        for (int j = 1; j < len; j++) {
        	if (A[j] != A[j - 1]) {
        		A[++i] = A[j];
        		count = 1;
        	}
        	else if (count == 1) {
        		A[++i] = A[j];
        		count = 2;
        	}
        }
        return i + 1;
    }
	
	public void printArr(int[] A) {
		for (Integer x: A) {
			System.out.print(x + " ");
		}
		System.out.print("\n");
	}
	
	public void testRemove() {
		int [] A = {1,1,1,2,3};
		System.out.println(removeDuplicates(A));
		printArr(A);
	}
}
