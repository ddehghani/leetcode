import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().permute(new int[] {1,2,3}));
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new LinkedList<>();
        if (nums.length == 1) {
            List<Integer> singleList = new LinkedList<>();
            singleList.add(nums[0]);
            permutations.add(singleList);
            return permutations;
        }
        for (List<Integer> permutation : permute(Arrays.copyOfRange(nums, 1, nums.length))) {
            for (int i = 0; i < nums.length; i++) {
                List<Integer> nextPerm = new LinkedList<Integer>(permutation);
                nextPerm.add(i, nums[0]);
                permutations.add(nextPerm);
            }
        }
        return permutations;
    }
    

    public int factorial(int number) {
        int result = 1;
        for (int factor = 2; factor <= number; factor++)
            result *= factor;
        return result;
    }
}