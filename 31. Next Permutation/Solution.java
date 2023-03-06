import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1,3,2};
        new Solution().nextPermutation(arr);
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ (i < arr.length - 1 ? "," :"]"));
        }
        System.out.println();
    }

    public void nextPermutation(int[] nums) {
        byte msdToChange = (byte) (nums.length - 2);
        while (msdToChange >= 0 && nums[msdToChange] >= nums[msdToChange + 1]) msdToChange--;
        if (msdToChange >= 0) {
            byte otherNum = (byte) (msdToChange + 1);
            while (otherNum < nums.length && nums[otherNum] > nums[msdToChange]) otherNum++;
            swap(nums, (byte) (otherNum - 1), msdToChange);
        }
        reverse(nums,(byte)(msdToChange + 1), (byte)(nums.length -1));
    }

    public void swap(int[] arr, byte firstIndex, byte secondIndex) {
        byte temp = (byte) arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }

    public void reverse(int[] arr, byte from, byte to) {
        while (from < to) swap(arr, from++, to--);
    }
}