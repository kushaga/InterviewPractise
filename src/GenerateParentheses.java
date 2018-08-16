import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n > 0) {
            getValidParen(new char[2 * n], 0, n, 0, 0, res);
        } else {
            return new ArrayList<>();
        }
        return res;
    }

    public List<String> getValidParen(char[] chars, int pos, int n, int close, int open, List<String> list) {
        if (close == n) {
            String res = "";
            for (int i = 0; i < chars.length; i++) {
                res = res + chars[i];
            }
            list.add(res);
            return list;
        } else {
            if (open > close) {
                chars[pos] = ')';
                //imp don't return from here
                getValidParen(chars, pos + 1, n, close + 1, open, list);
            }
            if (open < n) {
                chars[pos] = '(';
                //imp don't return from here
                getValidParen(chars, pos + 1, n, close, open + 1, list);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        for (String s : generateParentheses.generateParenthesis(3)) {
            System.out.println(s);
        }
    }
}
