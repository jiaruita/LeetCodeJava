
public class WordSearch {
	public boolean exist(char[][] board, String word) {
		int height = board.length;
		if (height == 0) {
			return false;
		}
		int width = board[0].length;
		if (word.length() == 0) {
			return true;
		}
        boolean [][] visited = new boolean[height][width];
        for (int i = 0; i < height; i++) {
        	for (int j = 0; j < width; j++) {
        		if (board[i][j] == word.charAt(0)) {
        			if (recur(board, i, j, word, 0, visited)) {
        				return true;
        			}
        		}
        	}
        }
        return false;
    }
	
	public boolean recur(char[][] board, int row, int col, String word, int index, boolean[][] visited) {
		if (index == word.length() - 1) {
			return true;
		}
		visited[row][col] = true;
		boolean left =false;
		boolean right= false;
		boolean up = false;
		boolean down = false;
		if (col - 1 >= 0 && !visited[row][col - 1] && board[row][col - 1] == word.charAt(index + 1)) {
			left = recur(board, row, col - 1, word, index + 1, visited);
			if (left) {
				return true;
			}
		}
		if (col + 1 < board[0].length && !visited[row][col + 1] && board[row][col + 1] == word.charAt(index + 1)) {
			right = recur(board, row, col + 1, word, index + 1, visited);
			if (right) {
				return true;
			}
		}
		if (row - 1 >= 0 && !visited[row - 1][col] && board[row - 1][col] == word.charAt(index + 1)) {
			down = recur(board, row - 1, col, word, index + 1, visited);
			if (down) {
				return true;
			}
		}
		if (row + 1 < board.length && !visited[row + 1][col] && board[row + 1][col] == word.charAt(index + 1)) {
			up = recur(board, row + 1, col, word, index + 1, visited);
			if (up) {
				return true;
			}
		}
		visited[row][col] = false;
		return false;
	}
	
	public void testExist() {
		char[][] board = {{'a', 'b', 'c','e'},{'s', 'f', 'c', 's'}, {'a', 'd', 'e', 'e'}};
		String word = "see";
		System.out.println(exist(board, word));
	}
}
