import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().canJump(new int[] {3,2,1,1,4}));
    }

    public boolean canJump(int[] nums) {
        int covered = -1, reach = 0;
        while (covered++ < reach && reach < nums.length - 1)
            reach = Math.max(covered + nums[covered], reach);
        return reach >= nums.length - 1;
    }
}