import java.util.HashMap;

/*
 * A number written in Arabic numerals can be broken into digits. 
 * For example, 1903 is composed of 1 (one thousand), 9 (nine hundreds), 0 (zero tens), and 3 (three units). 
 * To write the Roman numeral, each of the non-zero digits should be treated separately. 
 * In the above example, 1,000 = M, 900 = CM, and 3 = III. Therefore, 1903 = MCMIII.[4]
 * The symbols "I", "X", "C", and "M" can be repeated three times in succession, but no more. 
 * (They may appear more than three times if they appear non-sequentially, such as XXXIX.) 
 * "D", "L", and "V" can never be repeated.[5][6]
 * "I" can be subtracted from "V" and "X" only. 
 * "X" can be subtracted from "L" and "C" only. 
 * "C" can be subtracted from "D" and "M" only. 
 * "V", "L", and "D" can never be subtracted[6]
 * Only one small-value symbol may be subtracted from any large-value symbol.[7]
 * */
/*
 * I = 1
 * V = 5
 * X = 10
 * L = 50
 * C = 100
 * D = 500
 * M = 1000
 * 
 */
public class RomanToInteger {
	 public int romanToInt(String s) {
		 
		 HashMap<Character,Integer> map = new HashMap<Character, Integer>();
		 map.put('I', 1);
		 map.put('V', 5);
		 map.put('X',10);
		 map.put('L',50);
		 map.put('C', 100);
		 map.put('D', 500);
		 map.put('M', 1000);
		 int len = s.length();
		 char[] arr = s.toCharArray();
		 int result = map.get(arr[len - 1]);
		 int value = result;
		 int post;
		 for (int i = len - 2; i >= 0; i--) {
			 post = value;
			 value = map.get(arr[i]);
			 if (value < post) {
				 result -= value;
			 }
			 else {
				 result += value;
			 }
		 }
		 return result;
	 }
}
