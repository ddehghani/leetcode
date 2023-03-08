import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().jump(new int[] {2,3,0,1,4}));
    }
    public int jump(int[] nums) {
        int reachable = 0, previousReachable = -1;
        int jump = 0;
        while (reachable < nums.length - 1) {
            jump++;
            int i = previousReachable + 1;
            previousReachable = reachable;
            while (i <= previousReachable)
                reachable = Math.max(reachable, nums[i] + i++);
        }
        return jump;
    }

}