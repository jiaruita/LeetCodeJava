
public class NextPermutation {
	public void nextPermutation(int[] num) {
        int len = num.length;
        if (len <= 1) {
        	return;
        }
        int i = len - 1;
        for (; i > 0; i--) {
        	if (num[i] > num[i - 1]) {
        		break;
        	}
        }
        reverse(num, i, len - 1);
        if (i == 0) {
        	return;
        }
        int left = i - 1;
        int right = i;
        while (num[right] <= num[left]) {
        	right++;
        }
        int temp = num[right];
        num[right] = num[left];
        num[left] = temp;
        return;
    }
	
	public void reverse(int[] num, int start, int end) {
		if (start >= end) {
			return;
		}
		int left = start;
		int right = end;
		int temp;
		while(left < right) {
			temp = num[left];
			num[left] = num[right];
			num[right] = temp;
			left++;
			right--;
		}
	}
	
	public void printArr(int[] num) {
		for (Integer x: num) {
			System.out.print(x + " ");
		}
		System.out.println(" ");
	}
	
	public void test() {
		int[] num = new int[] {2,3,1};
		nextPermutation(num);
		printArr(num);
	}
}
