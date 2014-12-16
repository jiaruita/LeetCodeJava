import java.util.ArrayList;


public class SudokuSolver {
	public void solveSudoku(char[][] board) {
        int len = board.length;
        if (len != 9) {
        	return;
        }
        ArrayList<Integer> empty = findEmpty(board);
        //System.out.println("empty: " + empty.toString());
        dfs(board, empty, 0);
    }
	
	public ArrayList<Integer> findEmpty(char[][] board) {
		ArrayList<Integer> empty = new ArrayList<Integer>();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					empty.add(i * 9 + j);
				}
			}
		}
		return empty;
	}
	
	public boolean dfs(char[][] board, ArrayList<Integer> empty, int index) {
		
		if (index == empty.size()) {
			return true;
		}
		int next = empty.get(index);
		int x = next / 9;
		int y = next - (next / 9) * 9;
		//System.out.println("index = " + index + "; next = " + next + "; x = " + x + "; y = " + y);
		boolean valid;
		for (int num = 1; num <= 9; num++) {
			valid = valid(board, x, y, num);
			//System.out.println("valid(" + num + ") = " + valid);
			if (!valid) {
				continue;
			}
			else {
				board[x][y] = (char)('0' + num);
				if (dfs(board, empty, index + 1)) {
					return true;
				}
				else {
					board[x][y] = '.';
					continue;
				}
			}
		}
		return false;
	}
	
	public boolean valid(char[][] board, int x, int y, int num) {
		int blockX = (x / 3) * 3;
		int blockY = (y / 3) * 3;
		for (int i = 0; i < 9; i++) {
			if (board[x][i] - '0' == num) {
				//System.out.println("row invalid: x = " + x + "; y = " + i +"; num = " + num);
				return false;
			}
			if (board[i][y] - '0' == num) {
				//System.out.println("col invalid: x = " + i + "; y = " + y +"; num = " + num);
				return false;
			}
			if (board[blockX + i / 3][blockY + i - (i / 3) * 3] - '0' == num) {
				//System.out.println("block invalid: x = " + (blockX + i / 3) + "; y = " + (blockY + i - (i / 3) * 3) +"; num = " + num);
				return false;
			}
		}
		return true;
	}
	
	public char[][] input(String[] ss) {
		char[][] board = new char[9][9];
		for (int i = 0; i < 9; i++) {
			String s = ss[i];
			for (int j = 0; j < 9; j++) {
				board[i][j] = s.charAt(j);
			}
		}
		return board;
	}
	
	public void printBoard(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
	public void test() {
		String[] ss = new String[]{"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
		char[][] board = input(ss);
		printBoard(board);
		solveSudoku(board);
		printBoard(board);
	}
}
