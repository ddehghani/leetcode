public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.myAtoi("  -0032 kf33"));
    }

    public int myAtoi(String s) {
        short index = 0, length = (byte) s.length();
        boolean sign = true;
        int result = 0;

        if (length == 0)
            return 0;
        
        while (index < length && s.charAt(index) == ' ')
            index++;

        if (index < length && s.charAt(index) == '+')
            index++;
        else if (index < length && s.charAt(index) == '-') {
            sign = false;
            index++;
        }
        
        while (index < length && Character.isDigit(s.charAt(index))) {
            int digit = (s.charAt(index++) - '0') * (sign ? 1 : -1);
            if (sign && result > (Integer.MAX_VALUE - digit) / 10)
                return Integer.MAX_VALUE;
            if (!sign && result < (Integer.MIN_VALUE - digit) / 10)
                return Integer.MIN_VALUE;
            result = result * 10 + digit;
        }
        return result;
    }
}