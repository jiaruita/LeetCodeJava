import java.util.ArrayList;


public class PascalTriangle2 {
	public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int[] row = new int[rowIndex + 1];
        row[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
        	for (int j = i - 1; j > 0; j--) {
        		row[j] = row[j] + row[j - 1];
        	}
        	row[i] = 1;
        }
        for (Integer x: row) {
        	result.add(x);
        }
        return result;
    }
	
	public void testTri() {
		for (Integer x: getRow(0)) {
			System.out.print(x + " ");
		}
	}
}
