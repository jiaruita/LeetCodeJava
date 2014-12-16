import java.util.ArrayList;


public class Candy {
	public int candy(int[] ratings) {
		int num = ratings.length;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < num; i++) {
			arr.add(1);
		}
		for (int i = 1; i < num; i++) {
			if (ratings[i] > ratings[i - 1] && arr.get(i) <= arr.get(i - 1)) {
				arr.set(i, arr.get(i - 1) + 1);
			}
		}
		for (int i = num - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1] && arr.get(i) <= arr.get(i + 1)){
				arr.set(i, arr.get(i + 1) + 1);
			}
		}
		int count = 0;
		for (Integer x: arr) {
			count += x;
		}
        return count;
    }
	
	public void testCandy() {
		int[] ratings = {1,2,3,2};
		System.out.println(candy(ratings));
	}
}
