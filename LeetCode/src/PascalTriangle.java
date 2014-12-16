import java.util.ArrayList;


public class PascalTriangle {
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> tri = new ArrayList<ArrayList<Integer>>();
        if (numRows == 0) {
        	return tri;
        }
        ArrayList<Integer> firstRow = new ArrayList<Integer>();
        firstRow.add(1);
        tri.add(firstRow);
        for (int i = 1; i < numRows; i++) {
        	ArrayList<Integer> row = new ArrayList<Integer>();
        	row.add(1);
        	for (int j = 1; j < i; j++) {
        		row.add(tri.get(i - 1).get(j -1) + tri.get(i - 1).get(j));
        	}
        	row.add(1);
        	tri.add(row);
        }
        return tri;
    }
	
	public void testTri() {
		ArrayList<ArrayList<Integer>> tri = generate(5);
		for (int i = 0; i < tri.size(); i++) {
			ArrayList<Integer> row = tri.get(i);
			for (int j = 0; j < row.size(); j++) {
				System.out.print(row.get(j) + " ");
			}
			System.out.print("\n");
		}
	}
}
