import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().isNumber(""));
    }

    public boolean isNumber(String s) {
        return Pattern.compile("^(?:[-+]?(?:\\d+\\.\\d*|\\.\\d+)|[-+]?\\d+)(?:[eE][-+]?\\d+)?$", 
                Pattern.CASE_INSENSITIVE).matcher(s).matches();
    }
}