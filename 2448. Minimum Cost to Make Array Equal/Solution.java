import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        Test t1 = new Test();
        Test.randomStaticVar = 20;
        t1.printhaha();

        // System.out.println(new Solution().minCost(
        //     new int[] {735103,366367,132236,133334,808160,113001,49051,735598,686615,665317,999793,426087,587000,649989,509946,743518}, 
        //     new int[] {724182,447415,723725,902336,600863,287644,13836,665183,448859,917248,397790,898215,790754,320604,468575,825614}));

    }

    public long minCost(int[] nums, int[] cost) {
        BigInteger totalWeightCost = BigInteger.ZERO; 
        long totalCost = 0;
        for (int i = 0; i < nums.length; i++) {
            totalWeightCost = totalWeightCost.add(BigInteger.valueOf(cost[i] * nums[i])); 
            totalCost += cost[i];
        }
        long mean = totalWeightCost.divide(BigInteger.valueOf(totalCost)).longValue() + 1;
        long distanceLower = Long.MAX_VALUE, distanceUpper = Long.MAX_VALUE;
        long lower = 0, upper = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= mean && (nums[i] - mean < distanceUpper)) {
                upper = nums[i];
                distanceUpper = nums[i] - mean;
            }
            if (nums[i] < mean && (mean - nums[i] < distanceLower)) {
                lower = nums[i];
                distanceLower =  mean - nums[i];
            }
        }
       
        System.out.println("mean: " + mean + " lower: " + lower + " upper: " + upper);
       
        long lowerResult = 0, upperResult = 0;
        for (int i = 0; i < nums.length; i++) {
            upperResult += Math.abs(upper - nums[i]) * cost[i];
            lowerResult += Math.abs(lower - nums[i]) * cost[i];
        }

        
        return Math.min(upperResult, lowerResult);
    }
}

class Test {
    public static int randomStaticVar;
    public int randomVar;

    public int getRandomStaticVar() {
        return randomStaticVar;
    }

    public static void printhaha() {
        System.out.println("Haha");
    }

    public Test() {
        randomStaticVar = 5;
        System.out.println("Default constructor executed");
    }

    public Test(int someVar) {
        System.out.println("Parameterized constructor executed");
    }
}