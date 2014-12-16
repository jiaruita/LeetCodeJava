import java.util.ArrayList;

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
public class IntegerToRoman {
	public String intToRoman(int num) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		char[][] chart= new char[4][2];
		chart[0][0] = 'I';
		chart[0][1] = 'V';
		chart[1][0] = 'X';
		chart[1][1] = 'L';
		chart[2][0] = 'C';
		chart[2][1] = 'D';
		chart[3][0] = 'M';
		int copy = num;
		while (copy > 0) {
			list.add(copy % 10);
			copy = copy / 10;
		}
		ArrayList<String> s = new ArrayList<String>();
		int value;
		StringBuffer temp;
		for (int i = 0; i < list.size(); i++) {
			temp = new StringBuffer();
			value = list.get(i);
			if (value <= 3) {
				for (int count = 1; count <= value; count++) {
					temp.append(chart[i][0]);
				}
			}
			else if (value == 4) {
				temp.append(chart[i][0]);
				temp.append(chart[i][1]);
			}
			else if (value == 9) {
				temp.append(chart[i][0]);
				temp.append(chart[i + 1][0]);
			}
			else {
				temp.append(chart[i][1]);
				for (int count = 1; count <= value - 5; count++) {
					temp.append(chart[i][0]);
				}
			}
			s.add(0, temp.toString());
		}
		temp = new StringBuffer();
		for (String str:s) {
			temp.append(str);
		}
		return temp.toString();
    }
}
