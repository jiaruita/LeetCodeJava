
public class RemoveElement {
	/*
	 public int removeElement(int[] A, int elem) {
		 int len = A.length;
		 if (len == 0) {
			 return 0;
		 }
		 for (int i = 0; i < len; i++) {
			 if (A[i] == elem) {
				 while (len > i && A[len - 1] == elem) {
					 len--;
				 }
				 if (len == i) {
					 return len;
				 }
				 A[i] = A[len - 1];
				 len--;
			 }
		 }
		 return len;
	 }
	 */
	
	public int removeElement(int[] A, int elem) {
		int len = A.length;
		if (len == 0) {
			return 0;
		}
		int offset = 0;
		for (int i = 0; i < len - offset; i++) {
			System.out.println("i = " + i + "; offset = " + offset);
			A[i] = A[i + offset];
			if (A[i] == elem) {
				int j = i + 1 + offset;
				offset++;
				while (j < len && A[j] == elem) {
					j++;
					offset++;
				}
				if (j == len) {
					return len - offset;
				}
				A[i] = A[j];
			}
		}
		//printArr(A);
		return len - offset;
	}
	 
	public void printArr(int[] A) {
		for (Integer x : A) {
			
			System.out.print(x + " ");
		}
		System.out.print("\n");
	}
	 public void testRemove() {
		 int[] A = {0,4,4,0,4,4,4,0,2};
		 System.out.println( removeElement(A, 4));
		 printArr(A);
	 }
}
