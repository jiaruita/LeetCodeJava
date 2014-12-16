
public class MaximumSubarray {
	public int maxSubArray(int[] A) {
		int len = A.length;
		if (len == 0) {
			return 0;
		}
		int[] sum = new int[len];
		sum[0] = A[0];
		for (int i = 1; i < len; i++) {
			int prev = sum[i - 1];
			if (A[i] + prev > A[i]) {
				sum[i] = prev + A[i];
			}
			else {
				sum[i] = A[i];
			}
		}
		int max = sum[0];
		for (int i = 1; i < len; i++) {
			if (sum[i] > max){
				max = sum[i];
			}
		}
		return max;
	}
}
