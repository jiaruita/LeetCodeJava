
public class JumpGame2 {
	public int jump(int[] A) {
		int len = A.length;
		if (len <= 1) {
			return 0;
		}
		int min = 1;
		int far = A[0];
		for (int cur = 1; cur < len; cur++) {
			//System.out.println("cur = " + cur + "; far = " + far);
			if (far >= len) {
				return min;
			}
			if (far < cur) {
				return -1;
			}
			int temp = 0;
			for (int i = cur; i <= far; i++) {
				if (i + A[i] > temp) {
					temp = i + A[i];
				}
				//System.out.println("\ti = " + i + "; temp = " + temp);
			}
			cur = far;
			if (temp > far) {
				min++;
				//cur = far;
				far = temp;
				//System.out.println("update far = " + far +"; min = " + min);
			}
		}
		return min;
	}
	
	public void test() {
		int[] A = new int[60000];
		for (int i = 0; i < 60000; i++) {
			A[i] = 59999 - i;
		}
		System.out.println(jump(A));
	}
}
