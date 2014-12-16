import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class WordBreak {
	/*
	public boolean wordBreak(String s, Set<String> dict) {
        int[][] mat = new int[200][200];
        for (String token: dict) {
        	//System.out.println("token: " + token);
        	int length = token.length();
        	int index = s.indexOf(token);
        	while(index >= 0) {
        		mat[index][index + length] = 1;
        		//System.out.println("\t" + index + ", " + (index + length));
        		index = s.indexOf(token, index + 1);
        	}
        }
        //System.out.println("end for");
        int result = 0;
        
        result = recur(0, s.length(), mat);
        
        if (result == 1) {
        	return true;
        }
        else {
        	return false;
        }
    }
	
	public int recur(int start, int end, int[][] matrix) {
		if (matrix[start][end] == 1) {
			//System.out.println("true:" + start + ", " + end);
			return 1;
		}
		else {
			for (int i = start + 1; i < end; i++) {
				if (recur(start, i, matrix) == 1 && recur(i, end, matrix) == 1) {
					return 1;
				}
			}
		}
		return 0;
	}
	
	*/
	
	public boolean wordBreak(String s, Set<String> dict) {
		int length = s.length();
		boolean[] flags = new  boolean[length + 1];
		flags[0] = true;
		for (int i = 1; i <= length; i ++) {
			for (int j = 0; j < i; j++) {
				if (flags[j] && dict.contains(s.substring(j, i))) {
					flags[i] = true;
					break;
				}
				
			}
		}
		return flags[length];
	}
	
	public void testWordBreak() {
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		
		Set<String> dict = new HashSet<String>();
		dict.add("a");
		dict.add("aa");
		dict.add("aaa");
		dict.add("aaaa");
		dict.add("aaaaa");
		dict.add("aaaaaa");
		dict.add("aaaaaaa");
		dict.add("aaaaaaaa");
		dict.add("aaaaaaaaa");
		dict.add("aaaaaaaaaa");
		//dict.add("o");
		System.out.println(wordBreak(s, dict));
	}
}
