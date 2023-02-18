import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().numberToWords(0));
    }

    public String numberToWords(int num) {
        final String[] 
                ones = { "Zero", "One", "Two", "Three", 
                "Four", "Five", "Six", "Seven", "Eight", "Nine"},
                twentyToNinety = {"Twenty", "Thirty", "Forty", 
                "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"},
                tenToTwenty = {"Ten", "Eleven", "Twelve", "Thirteen", 
                "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"},
                labels = { " Billion", " Million", " Thousand", " Hundred"};
        final int[] values = {1_000_000_000, 1_000_000, 1_000, 100};

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            int leftSide = num / values[i];
            if (leftSide > 0) {
                result.append(numberToWords(leftSide));
                result.append(labels[i]);
                num %= values[i];
                if (num != 0)
                    result.append(" ");
                else
                    return result.toString();
            }
        }

        // less than hundred
        int tens = num / 10;
        if (tens >= 2) {
            result.append(twentyToNinety[tens - 2]);
            num %= 10;
            if (num != 0)
                result.append(" ");
            else
                return result.toString();
        }

        // less than 20
        result.append(num >= 10 ? tenToTwenty[num - 10] : ones[num]);
        return result.toString();
    }
}
