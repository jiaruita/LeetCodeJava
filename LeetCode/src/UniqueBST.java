
public class UniqueBST {
	/*
	public int numTrees(int n) {
		System.out.println("n = " + n);
        if (n <= 0) {
        	System.out.println("return 0");
        	return 1;
        }
        if (n == 1) {
        	System.out.println("return 1");
        	return 1;
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
        	sum += numTrees(i - 1) * numTrees(n - i);
        }
        System.out.println("n = " + n + "; sum = " + sum);
        return sum;
    }
	*/
	
	public int numTrees(int n) {
		if (n == 0) {
			return 1;
		}
		int[] vector = new int[n + 1];
		vector[0] = 1;
		vector[1] = 1;
		for (int i = 2; i <= n; i++) {
			int sum = 0;
			for (int j = 0; j <= i - 1; j++) {
				sum += vector[j] * vector[i - 1 - j];
			}
			vector[i] = sum;
		}
		for (int x:vector) {
			System.out.print(x + " ");
		}
		System.out.print("\n");
		return vector[n];
    }
	
	public void testNum() {
		System.out.println(numTrees(3));
	}
}
