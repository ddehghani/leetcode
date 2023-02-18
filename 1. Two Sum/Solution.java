import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] input = {3,3};
        for (int i :twoSum(input, 6))
            System.out.println(i);
    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index != null) 
                return new int[] {map.get(target - nums[i]), i};
            map.put(nums[i],i);
        }
        return null;
    }
}
