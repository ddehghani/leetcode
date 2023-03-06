import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findSubstring("wordgoodgoodgoodbestword", new String[] {"word","good","best","word"}));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        Set<String> allWords = new HashSet<>(Arrays.asList(words)), usedWords = new HashSet<>();
        int wordLen = words[0].length(), wordCount = words.length, totalLen = wordLen * wordCount;
        //from 0 to wordLen - 1
        for (int i = 0; i < wordLen; i++) {
            int currCount = 0;
            for (int currIndex = i; currIndex + wordLen <= s.length(); currIndex += wordLen) {
                String currWord = s.substring(currIndex, currIndex + wordLen);
                if (allWords.contains(currWord)) {
                    if (usedWords.contains(currWord)) {
                        int beginIndex = currIndex - currCount * wordLen;
                        String deleteWord = null;
                        while (deleteWord != currWord) {
                            deleteWord = s.substring(beginIndex, beginIndex + wordLen);
                            usedWords.remove(deleteWord);
                            beginIndex += wordLen;
                            currCount--;
                        }
                        currCount++;
                    } else {
                        usedWords.add(currWord);
                        currCount += 1;
                        if (currCount == wordCount) {
                            result.add(currIndex - totalLen + wordLen);
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