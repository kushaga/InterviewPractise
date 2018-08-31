public class DecodeWays {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        return ways(s.toCharArray(), s.length());
    }

    public int ways(char[] arr, int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int cnt = 0;
        if (arr[n - 1] > '0') {
            cnt = ways(arr, n - 1);
        }
        if (arr[n - 2] == '1' || (arr[n - 2] == '2' && arr[n - 1] < '7')) {
            cnt += ways(arr, n - 2);
        }
        return cnt;
    }
}
