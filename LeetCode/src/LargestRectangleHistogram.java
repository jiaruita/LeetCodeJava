
public class LargestRectangleHistogram {
	public int largestRectangleArea(int[] height) {
        int len = height.length;
        if (len == 0) {
        	return 0;
        }
        int[] leftIndex = new int[len];
        leftIndex[0] = -1;
        for (int i = 1; i < len; i++) {
        	if (height[i] > height[i - 1]) {
        		leftIndex[i] = i - 1;
        	}
        	else {
        		leftIndex[i] = -1;
        		for (int j = leftIndex[i - 1]; j >= 0; j--) {
        			if (height[j] < height[i]) {
        				leftIndex[i] = j;
        				break;
        			}
        		}
        	}
        }
        int[] rightIndex = new int[len];
        rightIndex[len - 1] = len;
        for (int i = len - 2; i >= 0; i--) {
        	if (height[i] > height[i + 1]) {
        		rightIndex[i] = i + 1;
        	}
        	else {
        		rightIndex[i] = len;
        		for (int j = rightIndex[i + 1]; j < len ;j++) {
        			if (height[j] < height[i]) {
        				rightIndex[i] = j;
        				break;
        			}
        		}
        	}
        }
        System.out.println("left");
        printArr(leftIndex);
        System.out.println("right");
        printArr(rightIndex);
        int area = 0;
        for (int i = 0; i < len; i++) {
        	int temp = height[i] * (rightIndex[i] - leftIndex[i] - 1);
        	if (temp > area) {
        		area = temp;
        	}
        }
        return area;
    }
	
	public void printArr(int[] num) {
		for (Integer x: num) {
			System.out.print(x + " ");
		}
		System.out.println(""); 
	}
	
	public void test() {
		int[] height = new int[]{4,2,0,3,2,4,3,4};
		System.out.println(largestRectangleArea(height));
	}
}
