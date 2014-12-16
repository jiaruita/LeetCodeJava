
public class MergeSort {
	public void merge(int A[], int m, int B[], int n) {
        int a = m - 1;
        int b = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
        	if (a < 0) {
        		A[i] = B[b--];
        	}
        	else if (b < 0) {
        		A[i] = A[a--];
        	}
        	else if (A[a] > B[b]) {
        		A[i] = A[a];
        		a--;
        	}
        	else {
        		A[i] = B[b];
        		b--;
        	}
        }
    }
	
	public void testMerge() {
		int[] A = new int[10];
		A[0] = 1;
		A[1] = 3;
		A[2] = 6;
		int[] B = {2,4,5};
		merge(A,3, B,3);
		for (Integer x: A) {
			System.out.print(x + " ");
		}
		System.out.print("\n");
	}
}
