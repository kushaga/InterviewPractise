package dynamicProgramming;

import java.util.Arrays;

//Given a string, a partitioning of the string is a palindrome partitioning if
//every substring of the partition is a palindrome.
public class PalindromePartition {

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

    int palPart(String str, int i, int j, int[][] res) {
        if (i == j) {
            res[i][j] = 0;
            return 0;
        }
        if (res[i][j] != Integer.MAX_VALUE) {
            return res[i][j];
        }
        if (isPal(str, i, j)) {
            res[i][j] = 0;
            return res[i][j];
        }
        for (int k = i; k < j; k++) {
            res[i][j] = 1 + Math.min(res[i][j], Math.min(palPart(str, i, k, res), palPart(str, k + 1, j, res)));
        }
        return res[i][j];
    }

    public static void main(String[] args) {
        PalindromePartition palindromePartition = new PalindromePartition();
        String str = "ababbbabbababa";
        int[][] res = new int[str.length()][str.length()];
        for (int i = 0; i < str.length(); i++) {
            Arrays.fill(res[i], Integer.MAX_VALUE);
        }
        System.out.println(palindromePartition.palPart(str, 0, str.length() - 1, res));
    }
}
