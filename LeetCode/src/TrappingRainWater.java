
public class TrappingRainWater {
	public int trap(int[] A) {
		int len = A.length;
		if (len <= 2) {
			return 0;
		}
        int result = 0;
        int[] lMax = new int[len];
        lMax[0] = 0;
        int[] rMax = new int[len];
        rMax[len - 1] = 0;
        for (int i = 1; i < len; i++) {
        	lMax[i] = lMax[i -1] > A[i - 1] ? lMax[i - 1] : A[i -1];
        }
        for (int i = len - 2; i >= 0; i--) {
        	rMax[i] = rMax[i + 1] > A[i + 1] ? rMax[i + 1] : A[i + 1];
        }
        printArr(lMax);
        printArr(rMax);
        for (int i = 1 ; i < len - 1; i++) {
        	int height = lMax[i] > rMax[i] ? rMax[i] : lMax[i];
        	if (height > A[i]) {
        		result += height - A[i];
        	}
        }
        return result;
    }
	
	public void printArr(int[] arr) {
		for (Integer x: arr) {
			System.out.print(x + " ");
		}
		System.out.print("\n");
	}
	
	public void test() {
		int [] A = {0,2,0};
		System.out.println(trap(A));
	}
}
