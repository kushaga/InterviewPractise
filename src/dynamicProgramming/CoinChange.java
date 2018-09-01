package dynamicProgramming;

public class CoinChange {
    public int coinChange(int N, int[] arr, int indx) {
        if (N == 0) {
            return 1;
        }
        int ways = 0;
        for (int i = indx; i < arr.length; i++) {
            if (N >= arr[i]) {
                ways += coinChange(N - arr[i], arr, i);
            }
        }
        return ways;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3 };
        CoinChange change = new CoinChange();
        System.out.println(change.coinChange(4, arr, 0));
    }

}
