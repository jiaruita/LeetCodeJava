import java.util.LinkedList;
import java.util.Stack;


public class ValidParentheses {
	public boolean isValid(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        if(len == 0) {
        	return true;
        }
        if (len % 2 != 0) {
        	return false;
        }
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < len; i++) {
        	if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {
        		stack.push(chars[i]);
        	}
        	else {
        		if (stack.size() == 0) {
        			return false;
        		}
        		if (chars[i] == ')') {
        			char c = stack.pop();
        			if (c != '(') {
        				return false;
        			}
        		}
        		else if (chars[i] == ']') {
        			char c = stack.pop();
        			if (c != '[') {
        				return false;
        			}
        		}
        		else if (chars[i] == '}') {
        			char c = stack.pop();
        			if (c != '{') {
        				return false;
        			}
        		}
        		else {
        			return false;
        		}
        	}
        }
        if (stack.size() == 0) {
        	return true;
        }
        else {
        	return false;
        }
    }
}
