public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] arr = new int[m][n];
        paths(arr, m, n);
        return arr[m - 1][n - 1];
    }

    public int paths(int[][] arr, int m, int n) {
        if (m == 0 || n == 0) {
            arr[m][n] = 1;
            return 1;
        }
        if (arr[m][n] != 0) {
            return arr[m][n];
        }

        arr[m][n] = paths(arr, m - 1, n) + paths(arr, m, n - 1);
        return arr[m][n];
    }
}
