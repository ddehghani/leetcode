public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minPathSum(new int[][] {{1, 2, 3}, {4, 5, 6}}));
    }

    public void printGrid(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++)
                System.out.print(grid[i][j] + " ");
            System.out.println();
        }
    }
    
    public int minPathSum(int[][] grid) {
        int cRow = grid.length, cCol = grid[0].length;

        for (int i = cRow - 2; i >= 0; i--) 
            grid[i][cCol - 1] += grid[i + 1][cCol - 1];

        for (int i = cCol - 2; i >= 0; i--)
            grid[cRow - 1][i] += grid[cRow - 1][i + 1];

        for (int i = cRow - 2; i >= 0; i--)
            for (int j = cCol - 2; j >= 0; j--)
                grid[i][j] += Math.min(grid[i+1][j], grid[i][j+1]);

        return grid[0][0];
    }
}