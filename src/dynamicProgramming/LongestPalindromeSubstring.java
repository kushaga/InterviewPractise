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
        System.out.println("Malen :" + maxLenght);
        for (int i = start; i < start + maxLenght; i++) {
            res = res + arr[i];
        }

        return res;
    }

    boolean isPal(String str, int i, int j) {
        while (i <= j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public int maxLen(String str, int i, int j, int[][] res) {
        if (i == j) {
            res[i][j] = 1;
            return res[i][j];
        }

        if (i == j - 1 && str.charAt(i) == str.charAt(j)) {
            res[i][j] = 2;
            return res[i][j];
        }

        if (res[i][j] != 0) {
            return res[i][j];
        }

        if (i <= j) {
            int max = 0;
            if (isPal(str, i, j)) {
                max = j - i + 1;
                res[i][j] = max;
                return max;
            } else {
                max = Math.max(max, Math.max(maxLen(str, i + 1, j, res), maxLen(str, i, j - 1, res)));
                res[i][j] = max;
                return max;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        LongestPalindromeSubstring lps = new LongestPalindromeSubstring();
        String str = "forgeeksskeegfor";
        int[][] res = new int[str.length()][str.length()];
        System.out.println(lps.longestPalindrome("babad"));
        System.out.println(lps.longestPalindrome("aacdefcaa"));
        System.out.println(lps.maxLen(str, 0, str.length() - 1, res));
    }
}
