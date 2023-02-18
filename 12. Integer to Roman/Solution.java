public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().intToRoman(344));
    }
    public String intToRoman(int num) {
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", 
                            "L", "XL", "X", "IX", "V", "IV", "I"};
        short[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder result = new StringBuilder();
        for (int i=0; i < symbols.length; i++) {
            short value = values[i];
            while (num >= value) {
                result.append(symbols[i]);
                num -= value;
            }
        }

        return result.toString();
    }
}