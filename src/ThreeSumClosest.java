import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3 || nums == null) {
            return Integer.MAX_VALUE;
        }
        Arrays.sort(nums);

        int closest = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == target) {
                    return sum;
                }

                if (sum > target) {
                    right--;
                } else {
                    left++;
                }
                closest = Math.abs(sum - target) < Math.abs(closest - target) ? sum : closest;
            }
        }

        return closest;
    }
}
