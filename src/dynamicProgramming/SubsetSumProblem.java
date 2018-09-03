package dynamicProgramming;
//Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
public class SubsetSumProblem {
    public static boolean subsetSum(int[] arr, int indx, int sum) {
        if (sum == 0) {
            return true;
        }
        if (sum < 0 || (indx == 0 && sum - arr[indx] != 0)) {
            return false;
        }
        return subsetSum(arr, indx - 1, sum) || subsetSum(arr, indx - 1, sum - arr[indx]);
    }

    public static void main(String[] args) {
        int set[] = { 3, 34, 4, 12, 5, 2 };
        System.out.println(subsetSum(set, set.length - 1, 9));
    }
}
