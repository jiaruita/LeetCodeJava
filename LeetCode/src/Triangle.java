import java.util.ArrayList;


public class Triangle {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		int size = triangle.size();
		if (size == 0) {
			return 0;
		}
        int[] result = new int[size];
        result[0] = triangle.get(0).get(0);
        //System.out.println("result[0] = " + result[0]);
        for (int row = 1; row < size; row++) {
        	//printArr(result);
        	result[row] = triangle.get(row).get(row) + result[row - 1];
        	for (int j = row - 1; j > 0; j--) {
        		int num = triangle.get(row).get(j);
        		int a = result[j] + num;
        		int b = result[j - 1] + num;
        		result[j] = a<b?a:b;
        	}
        	result[0] = triangle.get(row).get(0) + result[0];
        }
        //printArr(result);
        int min = Integer.MAX_VALUE;
        for (Integer x: result) {
        	if (x < min) {
        		min = x;
        	}
        }
        return min;
    }
	
	public void printArr(int[] arr) {
		for (Integer x:arr) {
			System.out.print(x + " ");
			
		}
		System.out.print("\n");
	}
	
	public void testMin() {
		ArrayList<ArrayList<Integer>> tri = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> f = new ArrayList<Integer>();
		f.add(-1);
		ArrayList<Integer> s = new ArrayList<Integer>();
		s.add(-2);
		s.add(-3);
		tri.add(f);
		tri.add(s);
		System.out.println(minimumTotal(tri));
	}
}
