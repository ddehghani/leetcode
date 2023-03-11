import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(- Integer.MIN_VALUE - 1);
        System.out.println(new Solution().myPow( - 2.0, 9));
    }

    public double myPow(double x, int n) {
        System.out.println(x + " " + n);
        if (x == -1) return (n%2 == 0) ? 1.0 : -1.0;
        Map<Integer, Double> map = new HashMap<Integer, Double>();
        map.put(0, 1.0);
        map.put(1, x);
        if (n == Integer.MIN_VALUE) n++;
        return (n < 0) ? 1 / myPow(x, -n, map) : myPow(x, n, map);
    }

    public double myPow(double x, int n, Map<Integer, Double> map) {
        if (map.containsKey(n)) return map.get(n);
        double half = myPow(x, n/2, map);
        map.put(n/2, half);
        double result = half * half;
        map.put((n/2)*2, result);
        if (n % 2 == 1) {
            result *= x;
            map.put(n, result);
        }
        return result;
    }
}


