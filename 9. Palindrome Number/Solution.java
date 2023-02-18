public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPalindrome(1221));
    }

    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        
        int xCopy = x;
        int reverse = 0;
        while (x != 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return xCopy == reverse;
    }
}