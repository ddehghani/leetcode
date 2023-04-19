import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().fullJustify(new String[] {"What","must","be","acknowledgment","shall","be"}, 16));
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<String>();
        int firstWordIndex = 0, currWordIndex = 0, lineLength = 0;
        while (currWordIndex < words.length) {
            firstWordIndex = currWordIndex;
            lineLength = -1;
            StringBuilder line = new StringBuilder(words[firstWordIndex]);

            while (lineLength < maxWidth && currWordIndex < words.length)
                lineLength += words[currWordIndex++].length() + 1;
            
            if (lineLength < maxWidth) { // last line
                for (int i = firstWordIndex + 1; i < currWordIndex; i++)
                    line.append(' ').append(words[i]);
                for (int i = 0; i < maxWidth - lineLength; i++)
                    line.append(' ');
            
            } else if (lineLength == maxWidth) { // justifying not needed
                for (int i = firstWordIndex + 1; i < currWordIndex; i++)
                    line.append(' ').append(words[i]);
           
            } else { // justifying needed
                lineLength -= words[--currWordIndex].length() + 1;
                int wordCount = currWordIndex - firstWordIndex;

                if (wordCount == 1) 
                    for (int j = 0; j < maxWidth - lineLength ; j++)
                        line.append(' ');
                else {
                    int spaces = maxWidth - lineLength + wordCount - 1; // number of spaces
                    int baseSpaceNum = spaces / wordCount - 1;
                    int surplus = spaces % wordCount - 1;
                    for (int i = firstWordIndex + 1; i < currWordIndex; i++) {
                        for (int j = 0; j < baseSpaceNum; j++)
                            line.append(' ');
                        if (surplus != 0) {
                            line.append(' ');
                            surplus--;
                        }
                        line.append(words[i]);
                    }
                }
            }
            result.add(line.toString());
        }
        return result;
    }
}