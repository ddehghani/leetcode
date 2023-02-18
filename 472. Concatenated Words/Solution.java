import java.util.*;

public class Solution {
    public static void main(String[] args) {
    }

    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        final Set<String> dic = new HashSet<>(Arrays.asList(words));
        final List<String> result = new ArrayList<String>();
        for (String word : words) {
            dic.remove(word);
            if (isConcatenated(word, dic))
                result.add(word);
            dic.add(word);
        }
    
        return result;
    }

    public static boolean isConcatenated(String word, Set<String> dic) {
        final int length = word.length();
        final boolean[] dp = new boolean[length + 1];
        dp[0] = true;
        for (int i = 1; i <= length; i++)
            for (int j = 0; !dp[i] && j <= i; j++)
                if (dp[j] && dic.contains(word.substring(j, i)))
                    dp[i] = true;

        return dp[length];
    }
}
