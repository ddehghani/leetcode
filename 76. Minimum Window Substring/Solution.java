import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("ab", "b"));
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++)
            tMap.compute(t.charAt(i), (key, val) -> (val == null) ? 1 : val + 1);
        int wLeft = 0, wRight = 0, minWindowLeft = 0, minWindowRight = 0, minWindowLength = Integer.MAX_VALUE;

        // 1: move wRight until tMap is < 0
        while (true) {
            while (wLeft < s.length() && !tMap.containsKey(s.charAt(wLeft))) { wLeft++; }
            while (tMap.values().stream().anyMatch((num) -> num > 0)) {
                if (wRight >= s.length())
                    return minWindowLength == Integer.MAX_VALUE ? "" : s.substring(minWindowLeft, minWindowRight);
                char cur = s.charAt(wRight);
                Integer count = tMap.get(cur);
                if (count != null)
                    tMap.put(cur, count - 1);
                wRight++;
            }
            // then update minWindowLength if necessary
            if (wRight - wLeft < minWindowLength) {
                minWindowLength = wRight - wLeft;
                minWindowRight = wRight;
                minWindowLeft = wLeft;
            }
            System.out.println("Curr Window: " + s.substring(wLeft, wRight) + " wLeft: " + wLeft + " wRight: " + wRight);
            System.out.println(tMap);
            tMap.put(s.charAt(wLeft), tMap.get(s.charAt(wLeft)) + 1);
            // move wLeft to next character from tMap and update tMap go back to 1
            wLeft++;
            // System.out.println(tMap);
        }
    }
}