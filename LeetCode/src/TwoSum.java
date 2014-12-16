
public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		int len = numbers.length;
        int[] result = new int[2];
        for (int i = 1; i < len; i++) {
        	for (int j = 0; j < i; j++) {
        		if (numbers[i] + numbers[j] == target) {
        			result[0] = j + 1;
        			result[1] = i + 1;
        			return result;
        		}
        	}
        }
        return result;
    }
	
	public void testSum() {
		int[] numbers = {2,3,6,9};
		int[] result = twoSum(numbers, 9);
		for (Integer x: result) {
			System.out.print(x + " ");
		}
	}
}
