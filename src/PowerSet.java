import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
//Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
public class PowerSet {
    public List<List<Integer>> subsets(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        int counter = 0;
        long powerSetLen = (long) Math.pow(2, nums.length);
        for (counter = 0; counter < powerSetLen; counter++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((counter & (1 << j)) > 0) {
                    tmp.add(nums[j]);
                }
            }
            tmp.sort((o1, o2) -> o1 < o2 ? -1 : 1);
            set.add(tmp);
        }
        set.forEach(integers -> res.add(integers));
        return res;
    }

    public static void main(String[] args) {
        PowerSet powerSet = new PowerSet();
        int[] nums = { 1, 2, 3 };
        powerSet.subsets(nums);
    }
}
