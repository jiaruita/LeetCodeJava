
public class Stock3 {
	public int maxProfit(int[] prices) {
        int days = prices.length;
        if (days == 0) {
        	return 0;
        }
        int[] before = new int[days];
        int[] after = new int[days];
        int max = 0;
        before[0] = 0;
        after[days - 1] = 0;
        int high = prices[0];
        int low = prices[0];
        for (int day = 1; day < days; day++) {
        	if (prices[day] > high) {
        		//before[day] = before[day - 1] + prices[day] - high;
        		before[day] = prices[day] - low;
        		high = prices[day];
        		if (before[day] > max) {
        			max = before[day];
        		}
        	}
        	else if (prices[day] < low) {
        		low = prices[day];
        		before[day] = before[day - 1];
        	}
        	else {
        		if (before[day - 1] > prices[day] - low) {
        			before[day] = before[day - 1];
        		}
        		else {
        			before[day] = prices[day] - low;
        		}
        	}
        }
        System.out.println("before: ");
        for (int x: before) {
        	System.out.print(x + " ");
        }
        System.out.print("\n");
        
        
        max = 0;
        high = prices[days - 1];
        low = high;
        for (int day = days - 2; day >= 0; day--) {
        	if (prices[day] < low) {
        		//after[day] = low - prices[day] + after[day + 1];
        		after[day] = high - prices[day];
        		low = prices[day];
        		if (after[day] > max) {
        			max = after[day];
        		}
        	}
        	else if (prices[day] > high) {
        		high = prices[day];
        		after[day] = after[day + 1];
        	}
        	else {
        		if (after[day + 1] > high - prices[day]) {
        			after[day] = after[day + 1];
        		}
        		else {
        			after[day] = high - prices[day];
        		}
        	}
        }
        System.out.println("after: ");
        for (int x: after) {
        	System.out.print(x + " ");
        }
        System.out.print("\n");
        max = 0;
        for (int day = 0; day < days; day++) {
        	if (before[day] + after[day] > max) {
        		max = before[day] + after[day];
        	}
        }
        return max;
    }
	
	public void testStock() {
		int[] prices = {3,2,6,5,0,3};
		for (int x: prices) {
			System.out.print(x + " ");
		}
		System.out.print("\n");
		System.out.println(maxProfit(prices));
	}
}
