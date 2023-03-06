import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().firstMissingPositive(new int[] {2,2}));
    }

    public int firstMissingPositive(int[] nums) {
        int i = 0, n = nums.length;
        while (i < n) {
            int ithElement = nums[i] - 1;
            if (0 <= ithElement && ithElement < n && nums[i] != nums[ithElement]) {
                nums[i] = nums[ithElement];
                nums[ithElement] = ithElement + 1;
                if (ithElement > i) i--;
            }
            i++;
        }
        
        i = 0;
        while (i < n && nums[i] == i + 1) i++;
        return i + 1;
    }
}