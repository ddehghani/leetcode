public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().multiply("199", "1"));
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int num1Len = num1.length(), num2Len = num2.length(), carryOver = 0;
        StringBuilder ansInReverse = new StringBuilder();
        for (int i = 0; i < num1Len + num2Len - 1; i++) { // n + m - 1 max digits without carry over
            int digitMul = carryOver;
            for (int j = 0; j <= i; j++)
                if (j < num1Len && i - j < num2Len)
                    digitMul += (num1.charAt(num1Len - 1 - j) - '0') * (num2.charAt(num2Len - 1 - i + j) - '0');
            carryOver = digitMul / 10;
            ansInReverse.append(digitMul % 10);
        } 
        if (carryOver != 0) ansInReverse.append(carryOver);
        return ansInReverse.reverse().toString();
    }
}