import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findSubstring("barfoothefoobarman", new String[] {"foo","bar"}));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        Set<String> allWords = new HashSet<>(Arrays.asList(words)), usedWords = new HashSet<>();
        int wordLen = words[0].length(), wordCount = words.length, totalLen = wordLen * wordCount;
        //from 0 to wordLen - 1
        for (int i = 0; i < wordLen; i++) {
            int currCount = 0;
            for (int currIndex = i; currIndex < s.length() - wordLen; currIndex += wordLen) {
                String currWord = s.substring(currIndex, currIndex + wordLen);
                if (allWords.contains(currWord)) {
                    if (usedWords.contains(currWord)) {
                        //remove (from set) frame total length back until curr word is deleted and set currCount accordingly
                    } else {
                        usedWords.add(currWord);
                        currCount += 1;
                        if (currCount == wordCount) {
                            result.add(currIndex);
                            currCount -= 1;
                        }
                    }
                } else {
                    usedWords.clear();
                    currCount = 0;
                }
            }
            currCount = 0;
            usedWords.clear();
        }
        return result;
    }
}