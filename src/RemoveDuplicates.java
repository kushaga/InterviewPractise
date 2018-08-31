//Given a sorted array nums, remove the duplicates in-place such that
//duplicates appeared at most twice and return the new length.
public class RemoveDuplicates {
    //[1,1,1,2,2,3]
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        int curInt = nums[0];
        int cnt = 1;
        int indx = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == curInt) {
                if (cnt < 2) {
                    cnt++;
                }
            } else {
                res = res + cnt;
                for (int j = indx; j < res; j++) {
                    nums[j] = curInt;
                }
                indx = res - 1;
                curInt = nums[i];
                cnt = 1;
                if (i == nums.length - 1) {
                    nums[indx + 1] = curInt;
                    res++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int nums[] = { 1, 1, 1, 2, 2, 3 };
        removeDuplicates.removeDuplicates(nums);
    }
}

