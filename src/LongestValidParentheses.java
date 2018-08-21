import java.util.Stack;

public class LongestValidParentheses {
    public int longestValidParentheses(String str) {
        int n = str.length();
        // Create a stack and push -1 as initial index to it.
        Stack<Integer> stk = new Stack<>();
        stk.push(-1);
        // Initialize result
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '(') {
                stk.push(i);
            } else {
                // Pop the previous opening bracket's index
                stk.pop();
                // Check if this length formed with base of
                // current valid substring is more than max
                // so far
                if (!stk.empty()) {
                    result = Math.max(result, i - stk.peek());
                } else {
                    // If stack is empty. push current index as
                    // base for next valid substring (if any)
                    stk.push(i);
                }
            }
        }

        return result;
    }

    public static void main(String args[]) {
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        System.out.println(longestValidParentheses.longestValidParentheses("(()"));
        System.out.println(longestValidParentheses.longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses.longestValidParentheses("()(())"));
        System.out.println(longestValidParentheses.longestValidParentheses("()(()"));
    }
}
