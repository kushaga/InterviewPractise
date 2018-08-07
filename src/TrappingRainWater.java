public class TrappingRainWater {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("waterUnits:" + waterUnits(arr));
    }

    //number of water units collected at any point is diff. between the element
    // and the smallest of the greatest tower height from the left and right side
    static int waterUnits(int arr[]) {
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
