import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().romanToInt("IV"));
    }

    public int romanToInt(String s) {
        byte[] string = s.getBytes();
        Map<Byte, Short> symbolValue = new HashMap<>();
        symbolValue.put((byte)'M', (short)1000);
        symbolValue.put((byte)'D', (short)500);
        symbolValue.put((byte)'C', (short)100);
        symbolValue.put((byte)'L', (short)50);
        symbolValue.put((byte)'X', (short)10);
        symbolValue.put((byte)'V', (short)5);
        symbolValue.put((byte)'I', (short)1);
        short lastValue = 0;
        int result = 0;
        for (int i = 0; i < string.length; i++) {
            short value = symbolValue.get(string[i]);
            if (lastValue < value)
                result -= 2 * lastValue;
            result += value;
            lastValue = value;
        }
        return result;
    }
}