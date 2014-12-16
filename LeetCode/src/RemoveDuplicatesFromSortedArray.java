
public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] A) {
		int len = A.length;
		if (len == 0) {
			return 0;
		}
		int offset = 0;
		for (int i = 0; i < len - offset; i++) {
			A[i] = A[i + offset];
			if (i + offset + 1 == len) {
				return len - offset;
			}
			else if (A[i + offset + 1] == A[i]) {
				offset++;
				int j = i + offset + 1;
				while (j < len && A[j] == A[i]) {
					j++;
					offset++;
				}
				if (j == len) {
					return len - offset;
				}
				A[i + 1] = A[j];
			}
		}
		return len - offset;
	}
	
	public void printArr(int[] A) {
		for (Integer x: A) {
			System.out.print(x + " ");
		}
		System.out.print("\n");
	}
	
	public void testRemove() {
		int [] A = {1,2,2,3,4};
		System.out.println(removeDuplicates(A));
		printArr(A);
	}
}
