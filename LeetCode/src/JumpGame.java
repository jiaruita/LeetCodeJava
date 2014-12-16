
public class JumpGame {
	public boolean canJump(int[] A) {
        int len = A.length;
        if (len == 0) {
        	return false;
        }
        boolean[] arr = new boolean[len];
        int right = len - 1;
        for (int i = len - 2; i >= 0; i--) {
        	if (A[i] + i >= right) {
        		arr[i] = true;
        		right = i;
        	}
        }
        return arr[0];
    }
}
