public class UniquePathsObstacle {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (m == 1 && n == 1) {
            return 0;
        }
        int[][] arr = new int[m][n];
        paths(arr, m - 1, n - 1, obstacleGrid);
        return arr[m - 1][n - 1];
    }

    public int paths(int[][] arr, int m, int n, int[][] obstacleGrid) {
        if (m == 0 || n == 0) {
            arr[m][n] = 1;
            return 1;
        }
        if (arr[m][n] != 0) {
            return arr[m][n];
        }

        if (obstacleGrid[m - 1][n] != 1 && obstacleGrid[m][n - 1] != 1) {
            arr[m][n] = paths(arr, m - 1, n, obstacleGrid) + paths(arr, m, n - 1, obstacleGrid);
        } else if (obstacleGrid[m - 1][n] == 1 && obstacleGrid[m][n - 1] != 1) {
            arr[m][n] = paths(arr, m, n - 1, obstacleGrid);
        } else if (obstacleGrid[m - 1][n] != 1 && obstacleGrid[m][n - 1] == 1) {
            arr[m][n] = paths(arr, m - 1, n, obstacleGrid);
        }
        return arr[m][n];
    }

}
