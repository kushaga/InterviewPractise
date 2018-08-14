import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int s = 0;
        int end = nums.length - 1;
        Boolean found = false;
        while (s <= end) {
            if (nums[s] + nums[end] == target) {
                found = true;
                break;
            }

            if (nums[s] + nums[end] < target) {
                s++;
            } else {
                end--;
            }
        }

        if (found) {
            int[] arr = { s, end };
            return arr;
        } else {
            return null;
        }
    }

}
