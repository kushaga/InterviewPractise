import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> numList = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    numList.add(nums[j]);
                }
            }
            List<Integer> tmp = twoSum(numList, -nums[i]);
            if (tmp.size() != 0) {
                tmp.add(nums[i]);
                res.add(tmp);
            }
        }
        return res;
    }

    public List<Integer> twoSum(List<Integer> nums, int sum) {
        List<Integer> res = new ArrayList<>();
        nums.sort((o1, o2) -> o1 > o2 ? 1 : -1);
        int i = 0, j = nums.size() - 1;
        int currentSum = 0;
        while (i <= j) {
            currentSum = nums.get(i) + nums.get(j);
            if (currentSum == sum && i != j) {
                res.add(nums.get(i));
                res.add(nums.get(j));
                break;
            } else {
                if (sum < currentSum) {
                    j--;
                } else {
                    i++;
                }
            }
        }
        return res;
    }

    public static void main(String args[]) {
        ThreeSum threeSum = new ThreeSum();
        int[] input = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> res = threeSum.threeSum(input);
        for (List<Integer> list : res) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
