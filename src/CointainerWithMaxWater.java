public class CointainerWithMaxWater {
    public int maxArea(int[] x) {
        int[] arr = null;
        int[] leftMax = new int[arr.length];
        int[] rightMax = new int[arr.length];

        int max = arr[0];

        for (int i = 1; i < arr.length - 1; i++) {
            max = Math.max(max, arr[i]);
            leftMax[i] = max;
        }

        max = arr[arr.length - 1];
        for (int i = arr.length - 2; i > 0; i--) {
            max = Math.max(max, arr[i]);
            rightMax[i] = max;
        }

        int count = 0;

        for (int i = 1; i < arr.length - 1; i++) {
            count += (Math.min(leftMax[i], rightMax[i]) - arr[i]);
        }
        return count;
    }
}
