import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().getPermutation(4, 9));
    }

    public String getPermutation(int n, int k) {
        List<Integer> digits = new ArrayList<Integer>(n);
        for (int i = 1; i <= n; i++) digits.add(i);
        k--;
        StringBuilder resultBuilder = new StringBuilder();
        int factorial = factorial(n-1);
        
        while (!digits.isEmpty()) {
            int index = k / factorial;
            resultBuilder.append(digits.remove(index));
            k -= factorial * index;
            if (n > 1)
                factorial /= (n-1);
            n--;
        }
        return resultBuilder.toString();
    }

    public int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n-1);
    }
}