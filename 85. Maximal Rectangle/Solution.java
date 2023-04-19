import java.util.*;

public class Solution {
    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'}, {'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'} };
        System.out.println(new Solution().maximalRectangle(matrix));
   
    }

    public int maximalRectangle(char[][] matrix) {
        int maximalRectangle = 0;
        int[] heights = new int[matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                heights[col] = matrix[row][col] == '0' ? 0 : heights[col] + 1;
            }
            maximalRectangle = Math.max(maximalRectangle, largestRectangleArea(heights));
        }
        return maximalRectangle;
    }

    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i <= heights.length; i++) {
            int currHeight = i == heights.length ? 0 : heights[i];
            while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int left = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max(maxArea, height * (i - left - 1));
            }
            stack.push(i);
        }
        return maxArea;
    }
}