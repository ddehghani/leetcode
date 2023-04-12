import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solveNQueens(1));
    }

    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!board[i][j]) {
                    board[i][j] = true;
                }
            }
        }
        // pick a position from row 1 put a queen there
        // remove unavailable poses 
        // put another queen in row 2 place a queen 
        // if you can't go back
        // if you place last queen add it to list and go next
        return null;
    }

    public List<String> solveNQueens(boolean[][] board, int row) {
        for (int col = 0; col < board.length; col++) {
            if (!board[row][col]) {
                boolean[][] board
                board[row][col] = true;
            }
        }
        return null;
    }
}


