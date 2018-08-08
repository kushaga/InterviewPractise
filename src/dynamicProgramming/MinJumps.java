package dynamicProgramming;

//Minimum number of jumps to reach end
public class MinJumps {
    public static void main(String[] args) {
        int arr[] = { 1, 3, 6, 3, 2, 3, 6, 8, 9, 5 };
        int jumps[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            jumps[i] = -1;
        }
        System.out.println(minJumps(arr, jumps, 0, arr.length - 1));
    }

    static int minJumps(int[] arr, int[] jumps, int start, int end) {
        if (start <= end) {
            if (start == end) {
                return 0;
            }
            if (arr[start] == 0) {
                return Integer.MAX_VALUE;
            }
            if (jumps[start] != -1) {
                return jumps[start];
            }
            int min = Integer.MAX_VALUE;
            for (int j = start + 1; j <= start + arr[start] && j <= end; j++) {
                int jump = minJumps(arr, jumps, j, end);
                if (jump != Integer.MAX_VALUE && jump + 1 < min) {
                    min = jump + 1;
                }
            }
            jumps[start] = min;
            return jumps[start];
        }
        return Integer.MAX_VALUE;
    }
}
