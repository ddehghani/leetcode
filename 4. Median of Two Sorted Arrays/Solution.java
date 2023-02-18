import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int errorCount = 0;
        for (int i = 0; i < 150; i++) {
            for (int j = 1; j < 150; j++) {
                int[] arr1 = createArray(i), arr2 = createArray(j);
                if ( median(arr1,arr2) != findMedianSortedArrays(arr1,arr2)){
                    errorCount++;
                    System.out.print("Array 1: ");
                    printArray(arr1);
                    System.out.print("Array 2: ");
                    printArray(arr2);
                    System.out.println("Actual Median: " + median(arr1,arr2));
                    System.out.println("Calculated Median: " + findMedianSortedArrays(arr1,arr2));
                }
            }
        }
        System.out.println("Error Count: " + errorCount);
    }

    public static int[] createArray(int length)
	{
		int[] arr = new int[length];
		for (int i = 0; i < arr.length; i++)
			arr[i] = (int) (Math.random() * 100) ;
		Arrays.sort(arr);
		return arr;
	}

	public static void printArray(int[] array) {
		System.out.print("[");
		for (int i=0; i < array.length; i++)
			System.out.print(array[i] + (i == array.length - 1? "" :", "));
		System.out.println("]");
	}
    
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) { 
        return findMedianSortedArrays(nums1,0, nums1.length - 1, nums2, 0, nums2.length -1);
    }

    public static double median(int[] nums1, int[] nums2) {
		int[] merged = new int[nums1.length + nums2.length];
		int i = 0;
		for (int num : nums1)
			merged[i++] = num;
		for (int num : nums2)
			merged[i++] = num;
		Arrays.sort(merged);
        if (merged.length % 2 == 1)
		    return merged[merged.length/2];
        else 
            return (merged[merged.length/2] + merged[merged.length/2 - 1]) / 2.0;

	}

    public static double findMedianSortedArrays(int[] nums1,int n1Start, int n1End, int[] nums2, int n2Start, int n2End) {
        int total = nums1.length + nums2.length;

        if (total == 1) // special case
            return nums1.length == 1? nums1[0] : nums2[0];

        if (n1End - n1Start < n2End - n2Start) {  // swap n1 and n2
            n1Start = n1Start ^ n2Start ^ (n2Start = n1Start);
            n1End = n1End ^ n2End ^ (n2End = n1End);
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int num1_middle_index = (n1Start + n1End) / 2;
        int num1_middle_in_num2 = Arrays.binarySearch(nums2, n2Start, n2End + 1, nums1[num1_middle_index]);
        int left = num1_middle_index + (num1_middle_in_num2 >= 0 ? num1_middle_in_num2 + 2 : -num1_middle_in_num2);
       
        if (left == total / 2) // we found it
        {
            int nextValueToRight =  Math.min(
                getIndexOrDefault(nums1, num1_middle_index + 1, Integer.MAX_VALUE), // num1 candidate
                getIndexOrDefault(nums2, num1_middle_in_num2 >= 0 ? num1_middle_in_num2 + 1 : -num1_middle_in_num2 - 1, Integer.MAX_VALUE)); // num2 candidate
            
            if (total % 2 == 1) // odd total means nextValueToRight is the median
                return nextValueToRight;
            else { // even total
                int rightMostValueOfLeft = Math.max(
                    getIndexOrDefault(nums1, num1_middle_index, Integer.MIN_VALUE), // num1 candidate
                    getIndexOrDefault(nums2, num1_middle_in_num2 >= 0 ? num1_middle_in_num2: -num1_middle_in_num2 -2, Integer.MIN_VALUE)); // num2 candidate
                return (nextValueToRight + rightMostValueOfLeft) / 2.0;
            }

        }
        else if (left > total / 2)
            return findMedianSortedArrays(
                nums1,n1Start, Math.min(n1End, num1_middle_index - 1), 
                nums2, n2Start, Math.min(n2End, num1_middle_in_num2 >= 0 ? num1_middle_in_num2 : -num1_middle_in_num2 - 1));
        else 
            return findMedianSortedArrays(
                nums1, Math.max(n1Start, num1_middle_index + 1), n1End, 
                nums2, Math.max(n2Start, num1_middle_in_num2 >= 0 ? num1_middle_in_num2: -num1_middle_in_num2 - 1), n2End);
    }

    public static int getIndexOrDefault(int[] nums, int index, int defaultValue) {
        return nums.length > index && index >= 0 ? nums[index] : defaultValue;
    }
}
