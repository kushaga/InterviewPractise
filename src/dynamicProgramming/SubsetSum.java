package dynamicProgramming;

//Given a positive integer N, count all possible distinct binary strings of
// length N such that there are no consecutive 1’s.
public class SubsetSum {

    public static int cnt(char[] str, int n) {
        if (n == 0) {
            return 1;
        }
        if (n + 1 < str.length && str[n + 1] == '1') {
            str[n] = '0';
            return cnt(str, n - 1);
        } else {
            str[n - 1] = '0';
            int zCnt = cnt(str, n - 1);
            str[n - 1] = '1';
            int oCnt = cnt(str, n - 1);
            return zCnt + oCnt;
        }
    }

    public static void main(String[] args) {
        System.out.println(cnt(new char[2], 2));
    }
}
