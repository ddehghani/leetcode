import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().spiralOrder(new int[][] {{1,2,3}, {4,5,6}, {7,8,9}}));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> sol = new ArrayList<Integer>();
        int upperBound = 1, lowerBound = matrix.length - 1, rightBound = matrix[0].length - 1, leftBound = 0, cRow = 0, cCol = -1;
        while (true) {
            if(cCol >= rightBound) return sol;  // go right until right bound
            while (cCol < rightBound) sol.add(matrix[cRow][++cCol]);

            if (cRow >= lowerBound) return sol;  // go down until lower bound
            while (cRow < lowerBound) sol.add(matrix[++cRow][cCol]);

            if (cCol <= leftBound) return sol; // go left until left bound
            while (cCol > leftBound) sol.add(matrix[cRow][--cCol]);

            if (cRow <= upperBound) return sol; // go up until upper bound
            while (cRow > upperBound) sol.add(matrix[--cRow][cCol]);

            // set new bounds
            lowerBound--;
            upperBound++;
            rightBound--;
            leftBound++;
        }
    }
}