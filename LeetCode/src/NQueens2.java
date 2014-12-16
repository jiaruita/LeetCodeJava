
public class NQueens2 {
	public int totalNQueens(int n) {
		if (n == 0) {
			return 0;
		}
		int result = 0;
		int digits = (1 << n) - 1;
		System.out.println("digits = " + Integer.toBinaryString(digits));
		result = recur(result, digits, 0, 0, 0);
		System.out.println("result = " + Integer.toBinaryString(result));
		return result;
    }
	
	public int recur(int result, int digits, int row, int ld, int rd) {
		if (row == digits){
			result++;
			System.out.println("result = " + Integer.toBinaryString(result));
			return result;
		}
		else {
			System.out.println("row = " + Integer.toBinaryString(row) + "; ld = " + Integer.toBinaryString(ld) + "; rd = " +Integer.toBinaryString(rd));
			int space = digits & (~(row | ld | rd));
			System.out.println("space = " + Integer.toBinaryString(space));
			while (space > 0) {
				int cur = space & (~space + 1);
				System.out.println("cur = " + Integer.toBinaryString(cur));
				space = space - cur;
				System.out.println("new space = " + Integer.toBinaryString(space));
				result = recur(result, digits, row + cur, (ld + cur) << 1, (rd + cur) >> 1);
			}
		}
		return result;
	}
	
	public void test() {
		System.out.println(totalNQueens(4));
	}
}
