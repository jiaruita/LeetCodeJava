
public class MultiplyStrings {
	 public String multiply(String num1, String num2) {
		 if (num1.equals("0") || num2.equals("0")) {
			 return "0";
		 }
		 int len1 = num1.length();
		 int len2 = num2.length();
		 char[] n1 = reverse(num1).toCharArray();
		 char[] n2 = reverse(num2).toCharArray();
		 StringBuffer sb = new StringBuffer();
		 int carry = 0;
		 char[] add1 = new char[]{'0'};
		 for (int i = 0; i < len1; i++) {
			 for (int zero = 0; zero < i; zero++) {
				 sb.append('0');
			 }
			 for (int j = 0; j < len2; j++) {
				 int prod = (n1[i] - '0') * (n2[j] - '0') + carry;
				 if (prod >= 10) {
					 carry = prod / 10;
					 prod = prod % 10;
				 }
				 else {
					 carry = 0;
				 }
				 sb.append((char)(prod + '0'));
			 }
			 if (carry > 0) {
				 sb.append((char)(carry + '0'));
				 carry = 0;
			 }
			 //System.out.println(n1[i] + " * " + new String(n2) + " = " + sb.toString());
			 add1 = addition(add1, sb.toString().toCharArray());
			 sb = new StringBuffer();
		 }
		 return reverse(new String(add1));
	 }
	 
	 public String reverse(String s) {
		 int len = s.length();
		 char[] arr = s.toCharArray();
		 for (int i = 0; i < len / 2; i++) {
			 char c = arr[i];
			 arr[i] = arr[len - 1 - i];
			 arr[len - 1- i] = c;
		 }
		 return new String(arr);
	 }
	 
	 public char[] addition(char[] num1, char[] num2) {
		 if (num1.length < num2.length) {
			 char[] temp = num1;
			 num1 = num2;
			 num2 = temp;
		 }
		 int len1 = num1.length;
		 int len2 = num2.length;
		 int carry = 0;
		 StringBuffer sb = new StringBuffer();
		 for (int i = 0; i < len2; i++) {
			 int sum = (num1[i] - '0') + (num2[i] - '0') + carry;
			 if (sum >= 10) {
				 carry = 1;
				 sum = sum - 10;
			 }
			 else {
				 carry = 0;
			 }
			 sb.append((char)(sum + '0'));
		 }
		 for (int i = len2; i < len1; i++) {
			 int sum = (num1[i] - '0') + carry;
			 if (sum >= 10) {
				 sum -= 10;
				 carry = 1;
			 }
			 else {
				 carry = 0;
			 }
			 sb.append((char)(sum + '0'));
		 }
		 if (carry > 0) {
			 sb.append('1');
		 }
		 System.out.println(sb.toString());
		 return sb.toString().toCharArray();
	 }
	 
	 public void test() {
		 String num1 = "123";
		 String num2 = "99";
		 //System.out.println(new String(addition(num1.toCharArray(), num2.toCharArray())));
		 System.out.println(multiply(num1, num2));
	 }
}
