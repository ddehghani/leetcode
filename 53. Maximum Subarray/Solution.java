import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray(new int[] {-1, -2}));
    }

    public int maxSubArray(int[] nums) {
        int right = 0, sum = 0, maxSum = Integer.MIN_VALUE;
        while (right < nums.length) {
            sum += nums[right++];
            if (sum > maxSum) maxSum = sum;
            if (sum < 0) sum = 0;
        }
        return maxSum;
    }
}