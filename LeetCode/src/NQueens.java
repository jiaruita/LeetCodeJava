import java.util.ArrayList;


public class NQueens {
	public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<Integer[]> results = new ArrayList<Integer[]>();
        ArrayList<String[]> mats = new ArrayList<String[]>();
        if (n <= 0) {
        	return mats;
        }
        if (n == 1) {
        	String[] s = {"Q"};
        	mats.add(s);
        	return mats;
        }
        
        recur(n, 0, new Integer[n], results);
        //System.out.println("number: " + results.size());
        //printResults(results);
        trans(n, results, mats);
        return mats;
    }
	
	public void recur(int n, int row, Integer[] cols, ArrayList<Integer[]> results) {
		if (row == n) {
			results.add(cols.clone());
			//System.out.println("add result:");
			//printArr(cols);
			//printResults(results);
		}
		else {
			for (int i = 0; i < n; i++) {
				if (valid(row, i, cols)) {
					cols[row] = i;
					recur(n, row + 1, cols, results);
				}
			}
		}
	}
	
	public boolean valid(int row, int col, Integer[] cols) {
		//System.out.println("cols:");
		//printArr(cols);
		//System.out.print("valid(row = " + row + "; col = " + col + ")");
		for (int i = 0; i < row; i++) {
			if (cols[i] == col) {
				//System.out.println(" = false: same col");
				return false;
			}
			if (cols[i] - col == row - i || cols[i] - col == i - row) {
				//System.out.println(" = false: same diag");
				return false;
			}
		}
		//System.out.println(" = true");
		return true;
	}
	
	public void trans(int n, ArrayList<Integer[]> results, ArrayList<String[]> mats) {
		for (Integer[] arr: results) {
			char[][] mat = new char[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					mat[i][j] = '.';
				}
			}
			
			for (int i = 0; i < arr.length; i++) {
				mat[i][arr[i]] = 'Q';
			}
			String[] strings = new String[n];
			for (int i = 0; i < n; i++) {
				String s = new String(mat[i]);
				strings[i] = s;
			}
			mats.add(strings);
		}
		
	}
	
	public void printArr(Integer[] arr) {
		for (Integer x: arr) {
			System.out.print(x + " ");
		}
		System.out.print("\n");
	}
	
	public void printResults(ArrayList<Integer[]> results) {
		for (Integer[] arr: results) {
			for (Integer x: arr) {
				System.out.print(x + " ");
			}
			System.out.print("\n");
		}
	}
	
	public void test() {
		solveNQueens(8);
	}
}
