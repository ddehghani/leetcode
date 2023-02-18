public class Solution {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("ccc"));
    }
    public static String longestPalindrome(String s) {
        int longestStart = 0, longestEnd = 0, longest = 1;
        for (int i = 0; i < s.length() && longest / 2 < s.length() - i; i++) {
            int start, end, length;

            if (equalChar(s, i , i + 1)) {
                start = i;
                end = i + 1;
                length = 2;
                while (equalChar(s, --start, ++end)) 
                    length += 2;
                if (length > longest) {
                    longest = length;
                    longestStart = ++start;
                    longestEnd = --end;
                }
            }

            if (equalChar(s, i + 1, i - 1)) {
                start = i - 1;
                end = i + 1;
                length = 3;
                while (equalChar(s, --start, ++end)) 
                    length += 2;
                if (length > longest) {
                    longest = length;
                    longestStart = ++start;
                    longestEnd = --end;
                }
            }
        }
        return s.substring(longestStart, longestEnd + 1);
    }

    public static boolean equalChar(String s, int index1, int index2) {
        if (index1 < 0 || index1 >= s.length() || index2 < 0 || index2 >= s.length())
            return false;
        return s.charAt(index1) == s.charAt(index2);
    }
}