import java.util.Stack;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int max = 0;

        Stack<Character> stack = new Stack<>();
        int cur = 0;
        for (Character c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {

                if (c == '(') {
                    stack.push(c);
                }

                if (c == ')') {
                    if (stack.peek() == '(') {
                        stack.pop();
                        cur = cur + 2;
                        max = Math.max(max, cur);
                    } else {
                        stack.push(c);
                    }
                }

            }
        }
        return max;
    }

    public static void main(String args[]) {
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        System.out.println(longestValidParentheses.longestValidParentheses("(()"));
        System.out.println(longestValidParentheses.longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses.longestValidParentheses("()(())"));
    }
}
