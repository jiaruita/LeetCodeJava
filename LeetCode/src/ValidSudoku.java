
public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
        if (board.length != 9) {
        	return false;
        }
        if (board[0].length != 9) {
        	return false;
        }
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] block = new boolean[9][9];
        
        for (int i = 0; i < 9; i++) {
        	for (int j = 0; j < 9; j++) {
        		if (board[i][j] != '.') {
        			int value = board[i][j] - '1';
        			System.out.println("i = " + i + "; j = " + j + "; value = " + value);
        			System.out.println("\trow[" + i + "][" + value + "] = " + row[i][value]);
        			System.out.println("\tcol[" + j + "][" + value + "] = " + col[j][value]);
        			System.out.println("\tblock[" + ((i/3)*3 + (j/3)) + "][" + value + "] = " + block[(i / 3) * 3 + (j / 3)][value]);
        			if (row[i][value] || col[j][value] || block[(i / 3) * 3 + (j / 3)][value]) {
        				return false;
        			}
        			else {
        				row[i][value] = true;
        				col[j][value] = true;
        				block[(i / 3) * 3 + (j / 3)][value] = true;
        			}
        		}
        	}
        	
        }
        return true;
    }
	public void test() {
		String[] strings = new String[]{".87654321","2........","3........","4........","5........","6........","7........","8........","9........"};
		char[][] board = new char[9][9];
		for (int i = 0; i < 9; i++) {
			board[i] = strings[i].toCharArray();
		}
		System.out.println(isValidSudoku(board));
	}
}
