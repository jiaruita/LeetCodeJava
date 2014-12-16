
public class Stock2 {
	public int maxProfit(int[] prices) {
		int max = 0;
		int days = prices.length;
		if (days <= 1) {
			return 0;
		}
        boolean[] peaks = new boolean[days];
        boolean[] low = new boolean[days];
        for (int day = 1; day < days - 1; day++) {
        	if (prices[day] >= prices[day - 1] && prices[day] >= prices[day + 1]) {
        		peaks[day] = true;
        	}
        	if (prices[day] <= prices[day + 1] && prices[day] <= prices[day - 1]) {
        		low[day] = true;
        	}
        }
        if (prices[0] > prices[1]) {
        	peaks[0] = true;
        }
        else {
        	low[0] = true;
        }
        if (prices[days - 1] > prices[days - 2]) {
        	peaks[days - 1] = true;
        }
        else {
        	low[days - 1] = true;
        }
        System.out.println("peaks: ");
        for (boolean x: peaks) {
        	System.out.print(x + " ");
        }
        System.out.println("\nlow: ");
        for (boolean x: low) {
        	System.out.print(x + " ");
        }
        System.out.print("\n");
        
        for (int day = days - 1; day > 0; day--) {
        	if (peaks[day]) {
        		int high = day;
        		day = day - 1;
        		while (!low[day]) {
        			day = day - 1;
        		}
        		int profit = prices[high] - prices[day];
        		max += profit;
        	}
        }
        return max;
    }
	
	public void testStock() {
		int[] prices = {5,2,3,2,6,6,2,9,1,0,7,4,5,0};
		System.out.println(maxProfit(prices));
	}
}
