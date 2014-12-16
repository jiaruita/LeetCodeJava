import java.util.ArrayList;
import java.util.Stack;


public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		int max = 0;
		int len = s.length();
		int temp = 0;
		for (int i = 0; i < len; i++) {
			if (s.charAt(i) == '(') {
				stack.add(i);
			}
			else {
				if (!stack.isEmpty()) {
					stack.pop();
					int cur;
					if (stack.isEmpty()) {
						cur = i - temp;
					}
					else {
						cur = i - stack.peek();
					}
					max = max > cur? max : cur;
				}
				else {
					temp = i;
				}
			}
		}
		return max;
	}
	
	/*
	public int longestValidParentheses(String s) {
		int max = 0;
		int len = s.length();
		int [] dp = new int[len];
		for (int i = 1; i < len; i++) {
			if (s.charAt(i) == ')') {
				int match = i - 1 - dp[i - 1];
				if (match >= 0 && s.charAt(match) == '(') {
					dp[i] = i - match + 1;
					if (match > 0) {
						dp[i] += dp[match - 1];
					}
					max = max > dp[i]? max : dp[i];
				}
			}
		}
		return max;
	}
	*/
	/*
	public int longestValidParentheses(String s) {
		int max = 0;
        int len = s.length();
        int idx;
        for (idx = 0; idx < len; idx++) {
        	if (s.charAt(idx) == '(') {
        		break;
        	}
        }
        s = s.substring(idx);
        len = s.length();
        for (idx = len - 1; idx >= 0; idx--) {
        	if (s.charAt(idx) == ')') {
        		break;
        	}
        }
        s = s.substring(0, idx + 1);
        len = s.length();
        ArrayList<Integer> left = new ArrayList<Integer>();
        for (int i = 0; i < len; i++) {
        	if (s.charAt(i) == '(') {
        		left.add(i);
        	}
        }
        int leftNum = left.size();
        boolean flag = false;
        for (int i = 0; i < leftNum; i++) {
        	int index = left.get(i);
        	int right = index + 2;
        	while (right < len) {
        		if (flag) {
        			if (s.charAt(right - 1) == ')' && s.charAt(right - 2) == '(') {
        				flag = true;
        				max = Math.max(max, right - index);
        				right += 2;
        				continue;
        			}
        			else {
        				flag = false;
        				right += 2;
        				continue;
        			}
        		}
        		if (valid(s.substring(index, right))) {
        			flag = true;
        			max = Math.max(max, right - index);
        		}
        		right += 2;
        	}
        }
        return max;
    }
	
	public boolean valid(String s){
		Stack<Character> stack = new Stack<Character>();
		int len = s.length();
		for (int i = 0; i < len; i++) {
			if (s.charAt(i) == '(') {
				stack.add('(');
			}
			else {
				if (stack.size() > 0) {
					stack.pop();
				}
				else {
					return false;
				}
			}
		}
		return stack.size() == 0;
	}
	*/
	
	public void test() {
		String s = "((())())(()))(()()(()(()))(()((((()))))))((()())()))()()(()(((((()()()())))()())(()()))((((((())))((()))()()))))(()))())))()))()())((()()))))(()(((((())))))()((()(()(())((((())(())((()()(()())))())(()(())()()))())(()()()))()(((()())(((()()())))(((()()()))(()()))()))()))))))())()()((()(())(()))()((()()()((())))()(((()())(()))())())))(((()))))())))()(())))()())))())()((()))((()))()))(((())((()()()(()((()((())))((()()))())(()()(()))))())((())))(()))()))))))()(()))())(()())))))(()))((())(()((())(((((()()()(()()())))(()())()((()(()()))(()(())((()((()))))))))(()(())()())()(()(()(()))()()()(()()())))(())(()((((()()))())))(())((()(())())))))())()()))(((())))())((()(()))(()()))((())(())))))(()(()((()((()()))))))(()()()(()()()(()(())()))()))(((()(())()())(()))())))(((()))())(()((()))(()((()()()(())()(()())()(())(()(()((((())()))(((()()(((()())(()()()(())()())())(()(()()((()))))()(()))))(((())))()()))(()))((()))))()()))))((((()(())()()()((()))((()))())())(()((()()())))))))()))(((()))))))(()())))(((()))((()))())))(((()(((())))())(()))))(((()(((((((((((((())(((()))((((())())()))())((((())(((())))())(((()))))()())()(())())(()))))()))()()()))(((((())()()((()))())(()))()()(()()))(())(()()))()))))(((())))))((()()(()()()()((())((((())())))))((((((()((()((())())(()((()))(()())())())(()(())(())(()((())((())))(())())))(()()())((((()))))((()(())(()(()())))))))))((()())()()))((()(((()((()))(((((()()()()()(()(()((()(()))(()(()((()()))))()(()()((((((()((()())()))((())()()(((((()(()))))()()((()())((()())()(())((()))()()(()))";
		System.out.println(longestValidParentheses(s));
	}
}
