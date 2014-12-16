
public class ZigZagConversion {
	public String convert(String s, int nRows) {
		char[] arr = s.toCharArray();
        int len = s.length();
        if (len <= 1 || nRows < 2) {
            return s;
        }
        int col = 0;
        int group = len / (nRows + nRows - 2);
        System.out.println("group = " + group);
        col = group * (nRows - 1);
        int remain = len % (nRows + nRows - 2);
        if (remain > 0) {
        	group++;
        	col++;
        	if (remain > nRows) {
        		remain = remain % nRows;
            	col += remain;
            }
        }
        Character[][] mat = new Character[nRows][col];
        System.out.println("mat nRows = " + nRows + "; col = " + col);
        for (int i = 0; i < nRows; i++) {
        	for (int j = 0; j < col; j++) {
        		mat[i][j] = null;
        	}
        }
        int index = 0;
        for (int i = 0; i < group; i++) {
        	int colIndex = i * (nRows - 1);
        	int vert;
        	for (vert = 0; vert < nRows; vert++) {
        		System.out.println("vert = " + vert);
        		System.out.println("colIndex = " + colIndex);
        		mat[vert][colIndex] = arr[index++];
        		if(index == len) {
        			break;
        		}
        	}
        	if (vert < nRows) {
        		break;
        	}
        	for (int hor = 1; hor <= nRows - 2; hor++) {
        		mat[nRows - 1 - hor][colIndex + hor] = arr[index++];
        		if (index == len) {
        			break;
        		}
        	}
        }
        for (int i = 0; i < nRows; i++) {
        	for (int j = 0; j < col; j++) {
        		if (mat[i][j] == null) {
        			System.out.print("* ");
        		}
        		else {
        			System.out.print(mat[i][j] + " ");
        		}
        	}
        	System.out.println("");
        }
        System.out.println("");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < nRows; i++) {
        	for (int j = 0; j < col; j++) {
        		if (mat[i][j] != null) {
        			sb.append(mat[i][j]);
        		}
        	}
        }
        return sb.toString();
    }
	
	public void test() {
		String s = "ABCD";
		int row = 3;
		System.out.println(convert(s,row));
	}
}
