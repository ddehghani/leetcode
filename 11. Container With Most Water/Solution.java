import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxArea(new int[] {1,0,3,4,3}));
    }

    public int maxArea(int[] height) {
        int maxArea = -1, leftWall = 0, rightWall = height.length - 1, currentArea;
        
        while (leftWall < rightWall) {
            if (height[leftWall] > height[rightWall]) {
                currentArea = height[rightWall] * (rightWall - leftWall);
                rightWall--;
            }
            else {
                currentArea = height[leftWall] * (rightWall - leftWall);
                leftWall++;
            }
            maxArea = Math.max(maxArea, currentArea);
        }
        return maxArea;
    }
}