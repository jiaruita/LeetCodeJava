import java.util.ArrayList;


public class ReverseWordsInString {
    public String reverseWords(String s) {
        if (s != null) {
            s = s.trim();
        }
        else {
            return null;
        }
        int len = s.length();
        if (len == 0) {
            return "";
        }
        ArrayList<String> results = new ArrayList<String>();
        boolean flag = false;
        int start = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ') {
                if (!flag) {
                    flag = true;
                    results.add(new String(s.substring(start, i)));
                }
                else {
                    continue;
                }
            }
            else {
                if (flag) {
                    start = i;
                    flag = false;
                }
                else {
                    continue;
                }
            }
        }
        results.add(new String(s.substring(start, len)));
        for (int i = 0; i < results.size() / 2; i++) {
            String temp = results.get(i);
            results.set(i, results.get(results.size() - 1 - i));
            results.set(results.size() - 1 - i, temp);
        }
        StringBuffer sb = new StringBuffer();
        for (String str : results) {
            sb.append(str);
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    
    public void test() {
        String s = "a";
        System.out.println(reverseWords(s));
    }
}
