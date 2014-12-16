import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


public class WildcardMatching {
	/*
	public boolean isMatch(String s, String p) { 
		int lens = s.length();
		int lenp = p.length();
		char[] a = s.toCharArray();
		char[] b = p.toCharArray();
		boolean[][] mat = new boolean[lens + 1][lenp + 1];
		for (int i = 0; i < lens; i++) {
			mat[i][0] = true;
		}
		for (int i = 0; i < lenp; i++) {
			mat[0][i] = true;
		}
		for (int i = 0; i < lens; i++) {
			for (int j = 0; j < lenp; j++) {
				if (mat[i][j]) {
					continue;
				}
				if (b[j] != '*') {
					if (mat[i - 1][j - 1] && (a[i] == b[j] || b[j] == '?')) {
						mat[i][j] = true;
					}
					else {
						mat[i][j] = false;
					}
				}
				else {
					if (mat[i - 1][j - 1] && a[i] == b[j + 1]) {
						mat[i][j] = true;
						mat[i][j + 1] = true;
					}
					else {
						
					}
				}
			}
		}
	}
	*/

	/*
	public boolean isMatch(String s, String p) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < p.length(); i++) {
			if (i > 0 && p.charAt(i) == '*' && p.charAt(i - 1) == '*') {
				continue;
			}
			else {
				sb.append(p.charAt(i));
			}
		}
		p = sb.toString();
		//System.out.println("after: p:[" + p + "]");
		return recur(s.toCharArray(), p.toCharArray(), 0, 0);
	}
	
	public boolean recur(char[] s, char[] p, int i, int j) {
		//System.out.println("i = " + i + "; j = " + j + "; s[i] = " + (i < s.length?s[i]:"null") + "; p[j] = " + (j < p.length?p[j]:"null"));
		if (i == s.length) {
			//System.out.println("\ti == s.length");
			if (j == p.length) {
				return true;
			}
			else {
				while (j < p.length) {
					//System.out.println("\tp[j] = " + p[j]);
					if (p[j] != '*') {
						return false;
					}
					j++;
				}
				return true;
			}
		}
		if (j == p.length) {
			return false;
		}
		if (p[j] != '*') {
			//System.out.println("\tp[j] != *");
			return ((s[i] == p[j] || p[j] == '?') && recur(s, p, i + 1, j + 1));
		}
		else {
			//System.out.println("\tp[j] == *");
			if (j == p.length - 1 || recur(s, p, i, j + 1)) {
				return true;
			}
			else {
				while(i < s.length) {
					//System.out.println("\t\twhile i < s.length");
					if (recur(s, p, i + 1, j + 1)) {
						return true;
					}
					i++;
				}
				//System.out.println("\t\t\t\tfinally false, i = " + i +"; j = " + j);
				return false;
			}
		}
		
	}
	*/
	public boolean isMatch(String s, String p) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < p.length(); i++) {
			if (i > 0 && p.charAt(i) == '*' && p.charAt(i - 1) == '*') {
				continue;
			}
			else {
				sb.append(p.charAt(i));
			}
		}
		p = sb.toString();
		System.out.println("after: p:" + p);
		int lens = s.length();
		int lenp = p.length();
		int i = 0;
		int j = 0;
		int prevs = -1;
		int prevp = -1;
		char[] a = s.toCharArray();
		char[] b = p.toCharArray();
		while(i < lens) {
			//System.out.println("i = " + i + "; j = " + j + "; a[i] = " + a[i] + "; b[j] = " + b[j]); 
			if (j < lenp && (a[i] == b[j] || b[j] == '?')) {
				i++;
				j++;
			}
			else if (j < lenp && b[j] == '*') {
				if (j == b.length - 1) {
					return true;
				}
				prevs = i;
				prevp = j;
				j++;
			}
			else {
				if (prevs != -1) {
					i = prevs + 1;
					j = prevp + 1; 
					prevs++;
				}
				else {
					return false;
				}
			}
		}
		while (j < lenp) {
			if (b[j] != '*') {
				return false;
			}
			j++;
		}
		return true;
	}
	
	public void test() {
		String s = "hi";
		String p = "*?";
		//String s = "babaaababaabababbbbbbaabaabbabababbaababbaaabbbaaab";
		//String p = "***bba**a*bbba**aab**b";
		System.out.println(isMatch(s, p));
	}
}
