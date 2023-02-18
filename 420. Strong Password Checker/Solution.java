import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().strongPasswordChecker("bbaaaaaaaaaaaaaaacccccc"));
    }

    public int strongPasswordChecker(String password) {
        int len = password.length(), add = Math.max(0, 6 - len), remove = Math.max(0, len - 20), 
            replace = 0, missingChars = 3, repetitions = 0, minValue = 0, counter = 0;
        boolean hasLowercase = false, hasUppercase = false, hasDigit =false;
        char lastChar = Character.MAX_VALUE;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (!hasLowercase && Character.isLowerCase(c)) {
                hasLowercase = true;
                missingChars--;
            }
            if (!hasUppercase && Character.isUpperCase(c)) {
                hasUppercase = true;
                missingChars--;
            }
            if (!hasDigit && Character.isDigit(c)) {
                hasDigit = true;
                missingChars--;
            }
            if (c != lastChar) {
                if (lastChar != Character.MAX_VALUE && counter > 2) {
                    repetitions += counter -2;
                    minValue++;
                }
                counter = 1;
                lastChar = c;
            } else {
                counter++;
            }
        }
        if (counter > 2) {
            repetitions += counter -2;
            minValue++;
        }
        replace = Math.max(0, missingChars - add);
        repetitions -= add;
        repetitions -= remove;
        replace = Math.max(replace, (repetitions + 2) / 3);
        return Math.max(add + remove + replace, minValue);
    }
}
