import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().isScramble("", ""));
   
    }

    public boolean isScramble(String s1, String s2) {
        return scramble(s1).contains(s2);
    }

    public Collection<String> scramble (String s) {
        if (s.length() == 1) return new HashSet<>(Arrays.asList(s));
        
        Collection<String> set = new HashSet<>();
        for (int i = 1; i < s.length(); i++) {
            String s1 = s.substring(0, i), s2 = s.substring(i);
            for (String x: scramble(s1)) {
                for (String y: scramble(s2)) {
                    set.add(x + y);
                    set.add(y + x);
                }
            }
        }
        return set;
    }
}