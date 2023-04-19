import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().largestRectangleArea(new int[] {2,1,5,6,2,3}));
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