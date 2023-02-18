public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.convert("AB", 1));
    }

    public String convert(String s, int numRows) {
        StringBuilder result = new StringBuilder();
        int step = 2 * numRows - 2;
        if (step == 0)
            step++;
        for (int i = 0; i < numRows; i++) { // 0 - 3
            if (i == 0 || i == numRows - 1) { // first or last row
                int index = i;
                while (index < s.length()) {
                    result.append(s.charAt(index));
                    index += step;
                }
            } else {
                int index = i;
                boolean zigzag = false;
                while (index < s.length()) {
                    result.append(s.charAt(index));
                    index += zigzag ? ((i - 1) * 2) + 2 : step - ((i - 1) * 2) - 2;
                    zigzag = !zigzag;
                }
            }
        }
        // 0       0 + step            0 + 2 step
        // 1    step - 1, 1+ step   1 + 2 step - 1, 1 + 2 step
        // 2    step - 2, 2+ step   2 + 2 step - 2, 2 + 2 step
        // 3       3+step              3+2step
        return result.toString();
    }
}
