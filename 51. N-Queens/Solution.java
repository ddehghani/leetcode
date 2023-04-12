import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solveNQueens(1));
    }

    public List<List<String>> solveNQueens(int n) {
        byte[][] board = new byte[n][n];
        List<List<String>> solList = new ArrayList<List<String>>();
        solveNQueens(0, board, solList);
        return solList;
    }

    private void solveNQueens(int currRow, byte[][] board, List<List<String>> solList) {
        int n = board.length;
        if (currRow == n) {
            // if board is full, add curr sol and its mirror to solution list
            addSolution(board, solList);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (board[currRow][col] == 0) {
                byte[][] oldboard = copyBoard(board);
                addQueen(currRow, col, board);
                solveNQueens(currRow + 1, board, solList);
                board = oldboard;
            }
            // if no solution found, do nothing go next i
        }
    }

    private byte[][] copyBoard(byte[][] board) {
        byte[][] newboard = new byte[board.length][board.length];
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board.length; j++)
                newboard[i][j] = board[i][j];
        return newboard;
    }

    public void printBoard(byte[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

    private void addQueen(int row, int col, byte[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            board[row][i] = board[i][col] = 1;
            if ((row+i < n) && (col+i < n) && (row+i >= 0) && (col+i >= 0)) board[row+i][col+i] = 1;
            if ((row-i < n) && (col-i < n) && (row-i >= 0) && (col-i >= 0)) board[row-i][col-i] = 1;
            if ((row+i < n) && (col-i < n) && (row+i >= 0) && (col-i >= 0)) board[row+i][col-i] = 1;
            if ((row-i < n) && (col+i < n) && (row-i >= 0) && (col+i >= 0)) board[row-i][col+i] = 1;
        }
        board[row][col] = 2;
    }

    private void addSolution(byte[][] board, List<List<String>> solList) {
        int n = board.length;
        List<String> sol = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            StringBuilder solBuilder = new StringBuilder();
            for (int j = 0; j < n; j++) 
                solBuilder.append(board[i][j] == 2 ?'Q' : '.');
            sol.add(solBuilder.toString());
        }
        solList.add(sol);
    }
}


