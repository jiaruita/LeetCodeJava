import java.util.ArrayList;
import java.util.Stack;


public class ReversedPolishNotation {
	
	
	/*
	 public int evalRPN(String[] tokens) {
		 ArrayList<String> stack = new ArrayList<String>();
		 int result = 0;
		 for (String t:tokens) {
			 if (t == "+") {
				 int a = Integer.parseInt(stack.get(stack.size() - 2));
				 int b = Integer.parseInt(stack.get(stack.size() - 1));
				 int sum = a + b;
				 //System.out.println("a = " + a + "; b = " + b + "; sum = " + sum);
				 stack.remove(stack.size() - 1);
				 stack.remove(stack.size() - 1);
				 stack.add("" + sum);
			 }
			 else if (t == "-") {
				 int a = Integer.parseInt(stack.get(stack.size() - 2));
				 int b = Integer.parseInt(stack.get(stack.size() - 1));
				 int diff = a - b;
				 //System.out.println("a = " + a + "; b = " + b + "; diff = " + diff);
				 stack.remove(stack.size() - 1);
				 stack.remove(stack.size() - 1);
				 stack.add("" + diff);
			 }
			 else if (t == "*") {
				 int a = Integer.parseInt(stack.get(stack.size() - 2));
				 int b = Integer.parseInt(stack.get(stack.size() - 1));
				 int prod = a * b;
				 //System.out.println("a = " + a + "; b = " + b + "; prod = " + prod);
				 stack.remove(stack.size() - 1);
				 stack.remove(stack.size() - 1);
				 stack.add("" + prod);
			 }
			 else if (t == "/") {
				 int a = Integer.parseInt(stack.get(stack.size() - 2));
				 int b = Integer.parseInt(stack.get(stack.size() - 1));
				 int q = a / b;
				 //System.out.println("a = " + a + "; b = " + b + "; q = " + q);
				 stack.remove(stack.size() - 1);
				 stack.remove(stack.size() - 1);
				 stack.add("" + q);
			 }
			 else {
				 //System.out.println("add: " + t);
				 stack.add(t);
			 }
		 }
		 System.out.println("final size = " + stack.size());
		 result = Integer.parseInt(stack.get(stack.size() - 1));
		 return result;
	 }  
	 */
	
	/*
	public int evalRPN(String[] tokens) {
		 int[] stack = new int[10];
		 int top = 0;
		 for (String s: tokens) {
		     if (s == "+") {
		         int r = stack[top - 2] + stack[top -1];
		         stack[top - 2] = r;
		         top--;
		     }
		     else if (s == "-") {
		         stack[top - 2] = stack[top - 2] - stack[top -1];
		         top--;
		     }
		     else if (s == "*") {
		         stack[top - 2] = stack[top - 2] * stack[top -1];
		         top--;
		     }
		     else if (s == "/") {
		         stack[top - 2] = stack[top - 2] / stack[top -1];
		         top--;
		     }
		     else {
		         stack[top++] = Integer.parseInt(s);
		     }
		 }
		 return stack[0];
	 }  
	*/
	
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		for (String token: tokens) {
			if (token.equals("+")) {
				int b = stack.pop();
				int a = stack.pop();
				stack.push(a + b);
			}
			else if (token.equals("-")) {
				int b = stack.pop();
				int a = stack.pop();
				stack.push(a - b);
			}
			else if (token.equals("*")) {
				int b = stack.pop();
				int a = stack.pop();
				stack.push(a * b);
			}
			else if (token.equals("/")) {
				int b = stack.pop();
				int a = stack.pop();
				stack.push(a / b);
			}
			else {
				stack.push(Integer.parseInt(token));
			}
		}
		return stack.pop().intValue();
	}
	
	
	 public void testRPN() {
		 String[] rpn = {"0","3","+"};
		 System.out.println(evalRPN(rpn));
	 }
}
