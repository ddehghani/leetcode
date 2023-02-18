import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aab"));
        
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0, startPos = 0, endPos = 0;
        for (; endPos < s.length(); endPos++) {
            char currChar = s.charAt(endPos);
            Integer repetitionIndex = map.get(currChar);
            if (repetitionIndex != null) {
                result = Math.max(result , map.size());
                while (map.containsKey(currChar))
                    map.remove(s.charAt(startPos++));
                
            }
            map.put(currChar, endPos);
        }
        return Math.max(result , map.size());
    }
}
