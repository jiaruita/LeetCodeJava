import java.util.ArrayList;


public class TextJustification {
	
	public ArrayList<String> fullJustify(String[] words, int L) {
		ArrayList<String> result = new ArrayList<String>();
		int num = words.length;
		System.out.println("words length = " + num);
		int[] lens = new int[num];
		for (int i = 0; i < num; i++) {
			lens[i] = words[i].length();
		}
		StringBuffer sb = new StringBuffer();
		ArrayList<String> temp = new ArrayList<String>();
		int index = 0;
		int sum = -1;
		while (index < num) {
			System.out.println("index = " + index);
			while (index < num && sum + 1 + lens[index] <= L) {
				temp.add(new String(words[index]));
				sum = sum + 1 + lens[index];
				index++;
			}
			System.out.println("\tthis line index: " + index);
			System.out.println("\tsum = " + sum);
			if (index == num) {
				System.out.println("index == num");
				for (String s: temp) {
					sb.append(s + ' ');
				}
				while(sb.length() < L) {
					sb.append(' ');
				}
				result.add(sb.toString().substring(0, L));
				return result;
			}
			int[] spaces = new int[temp.size()];
			int space = L - sum;
			System.out.println("\tspace needed: " + space);
			int even;
			int odd;
			if (temp.size() == 1) {
				even = space;
				odd = 0;
				sb.append(temp.get(0));
				while (even > 0) {
					sb.append(' ');
					even--;
				}
				System.out.println("result add: [" + sb.toString() + "]");
				result.add(sb.toString());
				sb.delete(0, sb.length());
				sum = -1;
				temp.clear();
				continue;
			}
			else {
				even = space / (temp.size() - 1);
				odd = space % (temp.size() - 1);
			}
			System.out.println("\teven = " + even);
			for (int i = 0; i < temp.size() - 1; i++) {
				spaces[i] = even;
			}
			int i = 0;
			while (odd > 0) {
				spaces[i]++;
				i++;
				odd--;
			}
			for (int j = 0; j < temp.size() - 1; j++) {
				sb.append(temp.get(j) + " ");
				for (int k = 0; k < spaces[j]; k++) {
					sb.append(' ');
				}
			}
			sb.append(temp.get(temp.size() - 1));
			result.add(sb.toString());
			System.out.println("\tresult add: [" + sb.toString() + "]");
			sb.delete(0, sb.length());
			temp.clear();
			sum = -1;
		}
		return result;
    }
	
	public void test() {
		String[] words = new String[]{"What","must","be","shall","be."};
		int L = 12;
		ArrayList<String> result = fullJustify(words, L);
		for (String s: result) {
			System.out.println(s);
		}
	}
}
