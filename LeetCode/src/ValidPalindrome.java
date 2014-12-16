
public class ValidPalindrome {
	 public boolean isPalindrome(String s) {
		 int len = s.length();
		 if (len <= 1) {
			 return true;
		 }
		 char[] arr = s.toCharArray();
		 int j = 0;
		 for (int i = 0; i < len; i++) {
			 if (arr[i] >= 'a' && arr[i] <= 'z' || arr[i] <= 'Z' && arr[i] >= 'A' || arr[i] >= '0' && arr[i] <= '9') {
				 arr[j++] = arr[i];
			 }
			 else {
				 continue;
			 }
		 }
		 len = j;
		 if (len <= 1) {
			 return true;
		 }
		 for (int i = 0; i <= len / 2; i++) {
			 int offset = 'A' - 'a';
			 if (arr[i] != arr[len - 1 - i] && arr[i] + offset != arr[len - 1 - i] && arr[i] - offset != arr[len - 1 - i]) {
				 return false;
			 }
		 }
		 return true;
	 }
}
