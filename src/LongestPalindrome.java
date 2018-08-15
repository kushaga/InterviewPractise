public class LongestPalindrome {

    class Node {
        protected int start, end;

        public Node(int start, int end) {
            this.end = end;
            this.start = start;
        }
    }

    public String longestPalindrome(String s) {
        int a =-1;


        if (s == null) {
            return "";
        }
        char arr[] = s.toCharArray();
//        Integer.parseInt()
        return null;
    }

    public Node longestLength(char[] arr, int str, int end, int num) {
        int maxLen = 0;
        if (num % 2 == 0) {
            if (arr[str] == arr[end]) {
                //check for i-1 and j+1
                int i = str, j = end;
                while (i >= 0 && j < num - 1) {
                    if (arr[i] == arr[j]) {
                        maxLen = (j - i) + 1;
                    }
                    i--;
                    j++;
                }
                //Node rightMax = longestLength(arr, )
            }
        } else {

        }
        return null;
    }

    public static void main(String[] args) {

    }
}
