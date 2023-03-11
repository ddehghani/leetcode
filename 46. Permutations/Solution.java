import java.util.*;

public class Solution {
    // 1 2
    // 2 1
    // 2 1 3
    // 2 3 1
    // 3 1 2
    // 3 2 1
    public static void main(String[] args) {
        System.out.println(new Solution().permute(new int[] {1,2,3,4}));
    }
    public List<List<Integer>> permute(int[] nums) {
        int numsLen = nums.length, permsLen = factorial(numsLen);
        List<List<Integer>> perms = new ArrayList<List<Integer>>(permsLen);
        for (int i = 0; i < permsLen; i++)
            perms.add(new ArrayList<Integer>(numsLen));
        return permute(nums, nums.length - 1, perms);
    }

    public List<List<Integer>> permute(int[] nums, int index, List<List<Integer>> perms) {
        if (index == 0) {
            perms.get(0).add(nums[0]);
            return perms;
        }
        permute(nums, index - 1, perms);   
        int nCurrArrays = factorial(index);
        for (int i = 0; i < nCurrArrays; i++) {
            List<Integer> currPerm = perms.get(i);
            for (int j = 0; j < index; j++) {
                List<Integer> nextPerm = perms.get(i + nCurrArrays * (j + 1));
                if (0 <= j) nextPerm.addAll(currPerm.subList(0, j));
                nextPerm.add(nums[index]);
                if (j <= index) nextPerm.addAll(currPerm.subList(j, index));
            }
            currPerm.add(nums[index]);
        }
        return perms;
    }
    

    public int factorial(int number) {
        int result = 1;
        for (int factor = 2; factor <= number; factor++)
            result *= factor;
        return result;
    }
}