import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().longestValidParentheses(")(())))(())())"));
    }

    public int longestValidParentheses(String s) {
        int left = 0, right = 0, result = 0, len = s.length();
        for(int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') left++;
            else right++;
            if(left == right) result = Math.max(result, right * 2);
            else if(right > left) left = right = 0;
        }
        left = right = 0;
        for(int i = len - 1; i >= 0; i--) {
            if (s.charAt(i)==')') right++;
            else left++;
            if (left == right) result = Math.max(result, right * 2);
            else if(left > right) left = right = 0;
        }
        return result;
    }
}