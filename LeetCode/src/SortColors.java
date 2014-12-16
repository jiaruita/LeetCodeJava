
public class SortColors {
	public void sortColors(int[] A) {
        int len = A.length;
        if (len == 0) {
        	return;
        }
        int firstOne = 0;
        int firstTwo = len;
        for (int i = 0; i < firstTwo; i++) {
        	if (A[i] == 0) {
        		swap(A, i, firstOne);
        		firstOne++;
        	}
        	else if(A[i] == 2) {
        		swap(A, i, firstTwo - 1);
        		firstTwo--;
        		i--;
        	}
        }
    }
	
	public void swap(int[] A, int x, int y) {
		int temp = A[x];
		A[x] = A[y];
		A[y] = temp;
	}
	
	public void testSort() {
		int[] A = {2,1,0,2,2,1,1,0};
		sortColors(A);
		for(Integer x: A) {
			System.out.print(x + " ");
		}
		System.out.print("\n");
	}
}
