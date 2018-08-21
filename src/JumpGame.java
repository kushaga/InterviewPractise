//is the end of array reachable ??

public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }
        if (nums.length == 0 || nums.length == 1) {
            return true;
        }

        int[] jumpArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            jumpArr[i] = Integer.MAX_VALUE;
        }
        jumpRec(nums, 0, nums[0], 1, jumpArr);
        if (jumpArr[nums.length - 1] != Integer.MAX_VALUE) {
            return true;
        }
        return false;
    }

    public void jumpRec(int[] nums, int indx, int curr_val, int jumps, int[] jumpArr) {
        if (curr_val == 0 || indx >= nums.length) {
            return;
        }
        for (int i = indx, j = 1; i <= curr_val; i++, j++) {
            if (indx + 1 < nums.length && i < nums.length) {
                jumpArr[i] = Math.min(jumpArr[i], jumps);
                jumpRec(nums, i + 1, (curr_val - j) + nums[indx + 1], jumps + 1, jumpArr);
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = { 2, 0 };
        JumpGame jumpGame = new JumpGame();
        jumpGame.canJump(nums);
    }
}
