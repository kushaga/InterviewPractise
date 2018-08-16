package dynamicProgramming;

public class LongestPalindromeSubstring {
    public String longestPalindrome(String str) {
        char[] arr = str.toCharArray();
        if (str == "" || str == null || arr.length == 0) {
            return "";
        }
        boolean[][] mat = new boolean[arr.length][arr.length];

        for (int i = 0; i < arr.length; i++) {
            mat[i][i] = true;
        }
        int maxLenght = 1;
        int start = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                mat[i][i + 1] = true;
                start = i;
                maxLenght = 2;
            }
        }

        for (int k = 3; k < str.length(); k++) {
            for (int i = 0; i < str.length() - k - 1; i++) {
                int j = k + i - 1;
                if (mat[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
                    mat[i][j] = true;
                    if (k > maxLenght) {
                        start = i;
                        maxLenght = k;
                    }
                }
            }
        }

        String res = "";
        for (int i = start; i < start + maxLenght; i++) {
            res = res + arr[i];
        }

        return res;
    }

    public static void main(String[] args) {
        LongestPalindromeSubstring lps = new LongestPalindromeSubstring();
        System.out.println(lps.longestPalindrome("babad"));
        System.out.println(lps.longestPalindrome("aacdefcaa"));
//        System.out.println(lps.longestPalindrome("ccc"));
    }
}
