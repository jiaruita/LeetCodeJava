
public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
        int len1 = s.length();
        int len2 = p.length();
        char[] s1 = s.toCharArray();
        char[] s2 = p.toCharArray();
        //boolean[][] mat = new boolean[len1][len2];
        return recur(s1, s2, 0, 0);
    }
	
	public boolean recur(char[] s, char[] p, int i, int j) {
		
		if (j == p.length) {
			return i == s.length;
		}
		//next char in RE is not '*' (or there is no next char)
		if (j == p.length - 1 || p[j + 1] != '*') {
			return (i < s.length && (s[i] == p[j] || p[j] == '.')) && recur(s, p, i + 1, j + 1); 
		}
		//next char in RE is '*'
		else {
			//if match when skip '*', which means '*' match 0 char
			if (recur(s, p, i, j + 2)) {
				return true;
			}
			//'*' has to match one or more char
			else {
				//match current one char, try to skip '*' and match
				while (i < s.length && (s[i] == p[j] || p[j] == '.')) {
					//System.out.println("in while, i = " + i + "; s.length = " + s.length);
					 if (recur(s, p, i + 1, j + 2)) {
						 return true;
					 }
					 //if cannot match, keep matching chars in s
					 i++;
				}
				//fail
				return false;
			}
		}
	}
	
	public void test() {
		String s = "ab";
		String p = ".*c";
		System.out.println(isMatch(s, p));
	}
}
