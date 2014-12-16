import java.util.Arrays;


public class ThreeSumClosest {
	public int threeSumClosest(int[] num, int target) {
        int len = num.length;
        if (len < 3) {
        	return 0;
        }
        
        Arrays.sort(num);
        printArr(num);
        int result = num[0] + num[1] + num[2];
        for (int i = 0; i < len - 2; i++) {
        	int start = i + 1;
        	int end = len - 1;
        	while (start < end) {
        		System.out.println("i = " + i + "; start = " + start + "; end = " + end);
        		int sum = num[i] + num[start] + num[end];
        		System.out.println("result = " + result + "; sum = " + sum);
            	if (Math.abs(sum - target) < Math.abs(result - target)) {
            		System.out.println("result changed");
            		result = sum;
            	}
            	if (sum == target) {
            		return target;
            	}
            	if (sum < target) {
            		start++;
            	}
            	else {
            		end--;
            	}
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
		int[] arr = new int[]{1,-3,3,5,4,1};
		System.out.println(threeSumClosest(arr, 1));
	}
}
