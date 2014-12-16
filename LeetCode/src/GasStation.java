
public class GasStation {
	/*
	public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        if (len == 0) {
        	return -1;
        }
        if (len == 1) {
        	return 0;
        }
        int[][] mat = new int[len][len];
        for (int i = 0; i < len; i++) {
        	mat[i][(i + 1) % len] = gas[i] - cost[i];
        }
        for (int i = 0; i < len; i++) {
        	int j;
        	for (j = 1; j < len; j++) {
        		int end = (i + j) % len;
        		int prev = (len + end - 1) % len;
        		if(mat[i][prev] < 0) {
        			break;
        		}
        		mat[i][end] = mat[i][prev] + gas[prev] - cost[prev];
        	}
        	if (j == len) {
        		return i;
        	}
        }
        return -1;
    } 
    */
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int len = gas.length;
		if (len == 0) {
			return -1;
		}
		
		int acc = 0;
		int count = 0;
		int start = 0;
		int pc = 0;
		int out = 0;
		int inner = 0;
		while (start < len) {
			out++;
			while (count < len) {
				pc++;
				int cur = (start + count) >= len ? (start + count - len) : (start + count);
			//	System.out.println("start = " + start + "; count = " + count + "; cur = " + cur);
				int net = gas[cur] - cost[cur];
				if (acc + net < 0) {
					start = start + count;
					count = 0;
				//	System.out.println("new start = " + start);
					acc = 0;
					break;
				}
				acc += net;
				count++;
			}
			if (count == len) {
				return start;
			}
			start++;
		}
		System.out.println("out = " + out + "; pc = " + pc);
		return -1;
	}
	
	public void test() {
		int[] gas = new int[60000];
		int[] cost = new int[60000];
		for (int i = 0; i < 60000; i++) {
			gas[i] = i;
			cost[59999 - i] = i+ 1;
		}
		System.out.println(canCompleteCircuit(gas, cost));
	}
}
