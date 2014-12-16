
public class Stock {
	public int maxProfit(int[] prices) {
		int max = 0;
		int days = prices.length;
		if (days == 0) {
			return 0;
		}
        int[] lowest = new int[days];
        lowest[0] = prices[0];
        for (int day = 1; day < days; day++) {
        	if (prices[day] < lowest[day - 1]) {
        		lowest[day] = prices[day];
        	}
        	else {
        		lowest[day] = lowest[day - 1];
        	}
        }
        for (int day = 1; day < days; day++) {
        	if (prices[day] - lowest[day] > max) {
        		max = prices[day] - lowest[day];
        	}
        }
        return max;
    }
	
	public void testStock() {
		;
	}
}
