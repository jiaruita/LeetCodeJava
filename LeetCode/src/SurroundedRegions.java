import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;


public class SurroundedRegions {
	class Point {
		int x;
		int y;
		Point(int a, int b) {
			x = a;
			y = b;
		}
		public String toString() {
			String s = "(" + x + "," + y + ")";
			return s;
		}
		public boolean equals(Object p) {
			if (p instanceof Point) {
				Point po = (Point) p;
				return (x == po.x && y == po.y);
			}
			return false;
		}
		
		public int hashCode() {
			return 41 * (41 + x) + y;
		}
	}
	
	public void solve(char[][] board) {
		int height = board.length;
        if (height <= 2) {
        	return;
        }
        int width = board[0].length;
        if (width <= 2) {
        	return;
        }
        ArrayList<Point> nei = new ArrayList<Point>();
		HashSet<Point> visited = new HashSet<Point>();
        ArrayDeque<Point> queue = new ArrayDeque<Point>();
        Point start;
        for (int i = 0; i < height; i++) {
        	if (board[i][0] == 'O') {
        		//System.out.println("board[" + i + "][0]: " + board[i][0]);
        		start = new Point(i,0);
        		queue.add(start);
        		visited.add(start);
        		bfs(board, nei, visited, queue);
        	}
        	if (board[i][width - 1] == 'O') {
        		//System.out.println("board[" + i + "][width - 1]: " + board[i][width - 1]);
        		start = new Point(i,width - 1);
        		queue.add(start);
        		visited.add(start);
        		bfs(board, nei, visited, queue);
        	}
        }
        for (int i = 0; i < width; i++) {
        	if (board[0][i] == 'O') {
        		start = new Point(0,i);
        		queue.add(start);
        		visited.add(start);
        		bfs(board, nei, visited, queue);
        	}
        	if (board[height - 1][i] == 'O') {
        		start = new Point(height - 1, i);
        		queue.add(start);
        		visited.add(start);
        		bfs(board, nei, visited, queue);
        	}
        }
        for (int i = 1; i < height - 1; i++) {
        	for (int j = 1; j < width - 1; j++) {
        		if (board[i][j] == 'O') {
        			board[i][j] = 'X';
        		}
        	}
        }
        for (int i = 0; i < height; i++) {
        	for (int j = 0; j < width; j++) {
        		if (board[i][j] == '*') {
        			board[i][j] = 'O';
        		}
        	}
        }
	}
	public void neighbors(Point p, ArrayList<Point> nei) {
		nei.clear();
		int x = p.x;
		int y = p.y;
		nei.add(new Point(x - 1, y));
		nei.add(new Point(x, y - 1));
		nei.add(new Point(x, y + 1));
		nei.add(new Point(x + 1, y));
	}
	public void bfs(char[][] board, ArrayList<Point> nei, HashSet<Point> visited, ArrayDeque<Point> queue) {
		//System.out.println("queue = " + queue.toString());
		nei.clear();
		//visited.clear();
		int height = board.length;
		int width = board[0].length;
		Point current;
		while (!queue.isEmpty()) {
			current = queue.pollFirst();
			neighbors(current, nei);
			//System.out.println("current = " + current.toString());
			for (Point p : nei) {
				if (visited.contains(p)) {
					continue;
				}
				int x = p.x;
				int y = p.y;
				if (x >= 0 && x < height && y >= 0 && y < width) {
					
					if (board[x][y] == 'O') {
						//System.out.println("\t" + p.toString());
						board[x][y] = '*';
						queue.add(p);
						visited.add(p);
					}
				}
			}
		}
	}
	
	/*
	public void solve(char[][] board) {
        int height = board.length;
        if (height <= 2) {
        	return;
        }
        int width = board[0].length;
        if (width <= 2) {
        	return;
        }
        ArrayList<Point> points = new ArrayList<Point>();
        HashSet<Point> thisLevel = new HashSet<Point>();
        HashSet<Point> visited = new HashSet<Point>();
        ArrayDeque<Point> queue = new ArrayDeque<Point>();
        ArrayList<Point> neighbors = new ArrayList<Point>();
        int levelSize = 1;
        int si= height;
        int sj = width;
        LinkedList<Point> cand = new LinkedList<Point>();
        for (si = 1; si < height - 1; si++) {
        	for (sj = 1; sj < width - 1; sj++) {
        		if (board[si][sj] == 'O') {
        			cand.add(new Point(si,sj));
        		}
        	}
        }
        if (cand.isEmpty()) {
        	return;
        }
        Point start = cand.pollFirst();
        //System.out.println(start.toString());
        queue.add(start);
        visited.add(start);
        points.add(start);
        Point current;
        boolean con = false;
        while(!queue.isEmpty() || !cand.isEmpty()) {
        	if (queue.isEmpty()) {
        		while(!cand.isEmpty() && visited.contains(cand.peekFirst())) {
        			cand.pollFirst();
        		}
        		if (cand.isEmpty()) {
        			break;
        		}
        		else {
        			//System.out.println("cand");
        			levelSize = 1;
        			queue.add(cand.pollFirst());
        			points.add(queue.peekFirst());
        			visited.add(queue.peekFirst());
        		}
        	}
        	//System.out.println("visited:" + visited.toString());
        	current = queue.pollFirst();
        	//System.out.println("\tqueue:" + queue.toString());
        	levelSize--;
        	neighbors(current, neighbors);
        	//System.out.println("current: " + current.toString());
        	for (Point p: neighbors) {
        		if (p.x < 0 || p.x >= height || p.y < 0 || p.y >= width) {
        			//System.out.println("clear: x = " + p.x + "; y = " + p.y);
        			points.clear();
        			//con = false;
        			break;
        		}
        		else {
        			thisLevel.add(p);
        			if (board[p.x][p.y] == 'O') {
        				//System.out.println("\tcon = true");
        				con = true;
        			}
        			if (visited.contains(p)) {
        				points.add(p);
        				continue;
        			}
        			//System.out.println("\tneighbor: " + p.toString());
        		}
        	}
        	if (levelSize == 0) {
        		if (!con) {
        			//System.out.println("con == false");
        			for (Point p: points) {
        				board[p.x][p.y] = 'X';
        			}
        			points.clear();
        		}
        		//System.out.println("thisLevel: " + thisLevel.toString());
        		for (Point p: thisLevel) {
        			if (!visited.contains(p)) {
        				visited.add(p);
        				if (board[p.x][p.y] == 'O') {
        					queue.add(p);
        				}
        			}
        		}
        		con = false;
        		levelSize = queue.size();
        		//System.out.println("level finish, new size = " + levelSize);
        		//System.out.println("queue: " + queue.toString());
        		thisLevel.clear();
        	}
        }
        
    }
	
	public void neighbors(Point p, ArrayList<Point> nei) {
		nei.clear();
		int x = p.x;
		int y = p.y;
		nei.add(new Point(x - 1, y));
		nei.add(new Point(x, y - 1));
		nei.add(new Point(x, y + 1));
		nei.add(new Point(x + 1, y));
	}
	*/
	
	/*
	public void neighbors(Point p, int height, int width, ArrayList<Point> nei) {
		nei.clear();
		int x = p.x;
		int y = p.y;
		if (x - 1 >= 0) {
			if (y - 1 >= 0) {
				nei.add(new Point(x - 1, y - 1));
			}
			else if (y + 1 < width) {
				nei.add(new Point(x - 1, y + 1));
			}
		}
		else if (x + 1 < height) {
			if (y - 1 >= 0) {
				nei.add(new Point(x + 1, y - 1));
			}
			else if (y + 1< width) {
				nei.add(new Point(x + 1, y + 1));
			}
		}
	}
	*/
	
	public void printp(Point p ) {
		System.out.print("(" + p.x + "," + p.y + ")");
	}
	
	public void printBoard(char[][] board) {
		int height = board.length;
		int width = board[0].length;
		System.out.print("  ");
		for (int i = 0; i < width; i++) {
			System.out.print(i + " ");
		}
		System.out.println("");
		for (int i = 0; i < height; i++) {
			System.out.print(i + " ");
			for (int j = 0; j < width; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
	public void test() {
		String[] arr = new String[]{"OXXOX","XOOXO","XOXOX","OXOOO","XXOXO"};
		int height = arr.length;
		int width = arr[0].length();
		char[][] board = new char[height][width];
		for(int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				board[i][j] = arr[i].charAt(j);
			}
		}
		printBoard(board);
		solve(board);
		printBoard(board);
	}
}
