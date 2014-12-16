import java.util.ArrayList;
import java.util.LinkedList;


public class SimplifyPath {
	public String simplifyPath(String path) {
		int len = path.length();
		if (len <= 1) {
			return path;
		}
		LinkedList<String> queue = new LinkedList<String>();
		ArrayList<String> split = split(path);
		for (String s: split) {
			if (s.equals(".")) {
				continue;
			}
			else if (s.equals("..")) {
				if (queue.size() > 0)
				{
					queue.removeLast();
				}
							}
			else {
				queue.add(s);
			}
		}
		String result = "";
		for (String s : queue) {
			result += "/" + s; 
		}
		if (result.length() < 1) {
			result += "/";
		}
		return result;
	}
	
	public ArrayList<String> split(String s) {
		ArrayList<String> result = new ArrayList<String>();
		s = s.substring(1);
		int index = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != '/') {
				continue;
			}
			else {
				String sub = s.substring(index, i);
				if (sub.length() > 0) {
					result.add(s.substring(index, i));
				}
				index = i + 1;
			}
		}
		if (index < s.length()) {
			result.add(s.substring(index, s.length()));
		}
		System.out.println(result.toString());
		return result;
	}
	
	public void test() {
		String path = "///";
		String sub = path.substring(0,0);
		System.out.println(sub.length());
		System.out.println(simplifyPath(path));
	}
}
