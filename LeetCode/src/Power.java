
public class Power {
	public double pow(double x, int n) {
        return recur(x, n);
    }
	
	public double recur(double x, int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return x;
		}
		if (n == -1) {
			return 1/x;
		}
		double result;
		int half = n / 2;
		double temp = recur(x, half);
		if (half * 2 == n) {
			result = temp * temp;
		}
		else if (n > 0) {
			result = temp * temp * x; 
		}
		else {
			result = temp * temp / x;
		}
		return result;
	}
	
	public void test() {
		System.out.println(pow(34.00515, -3));
	}
}
