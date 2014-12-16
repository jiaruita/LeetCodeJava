
public class ContainerWithMostWater {
	public int maxArea(int[] height) {
        int len = height.length;
        if (len == 0) {
        	return 0;
        }
        int max = 0;
        int left = 0;
        int right = len - 1;
        while (left != right) {
        	int less = height[left] < height[right] ? height[left] : height[right];
        	int area = less * (right - left);
        	if (area > max) {
        		max = area;
        	}
        	if (less == height[left]) {
        		left++;
        	}
        	else {
        		right--;
        	}
        }
        return max;
    }
}
