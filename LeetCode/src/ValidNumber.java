
public class ValidNumber {
	 public boolean isNumber(String s) {
		 s = s.trim();
		 int len = s.length();
		 if (len == 0) {
			 return false;
		 }
		 if (nonneg(s)) {
			 System.out.println("if nonneg");
			 return true;
		 }
		 if (frac(s)) {
			 System.out.println("if frac");
			 return true;
		 }
		 if (negInt(s)) {
			 System.out.println("if negInt");
			 return true;
		 }
		 if (negFrac(s)) {
			 System.out.println("if negFrac");
			 return true;
		 }
		 if (natural(s)) {
			 System.out.println("if natural");
			 return true;
		 }
		 return false;
	 }
	 
	 public boolean nonneg(String s) {
		 System.out.println("nonneg:" + s);
		 int len = s.length();
		 if (len == 0) {
			 return false;
		 }
		 /*
		 if (s.charAt(0) == '0') {
			 return len == 1;
		 }*/
		 for (int i = 0; i < len; i++) {
			 if (s.charAt(i) > '9' || s.charAt(i) < '0') {
				 return false;
			 }
		 }
		 return true;
	 }
	 
	 public boolean frac(String s) {
		 System.out.println("enter frac, s = " + s);
		 int len = s.length();
		 if (len == 0) {
			 return false;
		 }
		 int i = 0;
		 for (; i < len; i++) {
			 if (s.charAt(i) == '.') {
				 break;
			 }
		 }
		 System.out.println("i = " + i);
		 if (i == len) {
			 return false;
		 }
		 if (len == 1) {
			 return false;
		 }
		 //".1" is true
		 System.out.println("frac");
		 if ((i == 0 || nonneg(s.substring(0, i))) && (i == len - 1 || nonneg(s.substring(i + 1, len)))) {
			 return true;
		 }
		 else {
			 return false;
		 }
	 }
	 
	 public boolean negInt(String s) {
		 if (s.charAt(0) != '-' && s.charAt(0) != '+') {
			 return false;
		 }
		 if (s.length() == 1) {
			 return false;
		 }
		 /*
		 if (s.charAt(1) == '0') {
			 return false;
		 }*/
		 if (nonneg(s.substring(1))) {
			 return true;
		 }
		 else {
			 return false;
		 }
	 }
	 
	 public boolean negFrac(String s) {
		 if (s.charAt(0) != '-' && s.charAt(0) != '+') {
			 return false;
		 }
		 if (s.length() == 1) {
			 return false;
		 }
		 if (frac(s.substring(1))) {
			 return true;
		 }
		 else {
			 return false;
		 }
	 }
	 
	 public boolean natural(String s) {
		 int len = s.length();
		 int i = 0;
		 for (; i < len; i++) {
			 if (s.charAt(i) == 'e') {
				 break;
			 }
		 }
		 if (i == 0 || i >= len - 1) {
			 return false;
		 }
		 String pre = s.substring(0, i);
		 String post = s.substring(i + 1);
		 if (((negInt(pre)) || negFrac(pre)) || nonneg(pre) || frac(pre)) {
			 if (negInt(post) || nonneg(post)) {
				 return true;
			 }
		 }
		 return false;
	 }
	 
	 public void test() {
		 String s = ".1";
		 System.out.println(isNumber(s));
	 }
	 
	 /*
	  * "e" 	false
	  * "0"		true
	  * "  0.1 "true
	  * "2e10"	true
	  * "a" 	false
	  * "-e." 	false
	  * ".1" 	true
	  * "01"	true
	  * "0.."	false
	  * "."		false
	  * "7.e-"	false
	  * "6e6.5"	false
	  * */
}
