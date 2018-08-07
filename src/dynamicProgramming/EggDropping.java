package dynamicProgramming;

public class EggDropping {
    public static void main(String[] args) {
        int[][] arr = new int[3][11];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 11; j++) {
                arr[i][j] = -1;
            }
        }
        System.out.println(ways(2, 10, arr));
    }

    public static int ways(int eggs, int floors, int arr[][]) {
        if (floors == 0) {
            return 0;
        }
        if (floors == 1) {
            return 1;
        }
        //we will have to go iteratievely till the end.
        if (eggs == 1) {
            return floors;
        }
        if (arr[eggs - 1][floors - 1] != -1) {
            return arr[eggs - 1][floors - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int x = 1; x <= floors; x++) {
            min = Math.min(min, Math.max(ways(eggs - 1, x - 1, arr), ways(eggs, floors - x, arr)));
        }
        arr[eggs - 1][floors - 1] = min + 1;
        return min + 1;
    }
}
