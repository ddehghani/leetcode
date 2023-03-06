import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[] {5,0,2,3}, 5));
    }

    public int search(int[] nums, int target) {
        if (nums.length == 1)
            return target == nums[0] ? 0 : -1;
        // find k binary search 
        int left = 1, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            // System.out.println("left: " + left + " right: " + right + " mid: " + mid);
            if (nums[mid] > nums[0]) 
                left = mid + 1;
            else 
                right = mid;
        }
        int k = nums[right] > nums[0] ? 0 : nums.length - right;
        // System.out.println("K = " + k);
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2,
                rotatedMid = (mid - k + nums.length) % nums.length;
            // System.out.println("Visited: " + nums[(mid - k + nums.length) % nums.length]);
            if (nums[rotatedMid] == target) 
                return rotatedMid;
            else if (nums[rotatedMid] > target) 
                right = mid - 1;
            else 
                left = mid + 1;
        }
        return -1;
    }
}