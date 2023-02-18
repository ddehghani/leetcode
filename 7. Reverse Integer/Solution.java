public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverse(-1463847413));
    }

    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int digit = x % 10;
            if (result > 0 && result > (Integer.MAX_VALUE - digit) / 10 || result < 0 && result < (Integer.MIN_VALUE - digit) / 10)
                return 0;
            result = result * 10 + digit;
            x /= 10;
        }
        return result;
    }
}