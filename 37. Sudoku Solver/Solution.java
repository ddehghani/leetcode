import java.util.*;

public class Solution {
    public static void main(String[] args) {
        char[][] board = 
        {{'5','3','.','.','7','.','.','.','.'},
        {'6','.','.','1','9','5','.','.','.'},
        {'.','9','8','.','.','.','.','6','.'},
        {'8','.','.','.','6','.','.','.','3'},
        {'4','.','.','8','.','3','.','.','1'},
        {'7','.','.','.','2','.','.','.','6'},
        {'.','6','.','.','.','.','2','8','.'},
        {'.','.','.','4','1','9','.','.','5'},
        {'.','.','.','.','8','.','.','7','9'}};
        Solution s = new Solution();
        s.printBoard(board);
        System.out.println();
        s.solveSudoku(board);
        s.printBoard(board);
    }

    public void printBoard(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    }

    public void solveSudoku(char[][] board) {
        solveSudokuOrReturnNull(board);
    }

    public char[][] solveSudokuOrReturnNull(char[][] board) {
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board.length; j++)
                if (board[i][j] == '.') {
                    for (char c : getPossibleValues(board, i, j)) {
                        board[i][j] = c;
                        char[][] solvedBoard = solveSudokuOrReturnNull(board);
                        if (solvedBoard != null) return solvedBoard;  
                    }
                    board[i][j] = '.';
                    return null;
                }
        
        return board;
    }

    public Iterable<Character> getPossibleValues(char[][] board, int row, int col) {
        boolean[] possibleValues = new boolean[9];
        for (int i = 0; i < 9; i++) {
            if (board[row][i] != '.')
                possibleValues[board[row][i] - '1'] = true;
            if (board[i][col] != '.')
                possibleValues[board[i][col] - '1'] = true;
        }
        for (int i = (row/3) * 3; i < (row/3) * 3 + 3; i++)
            for (int j = (col/3) * 3; j < (col/3) * 3 + 3; j++)
                if (board[i][j] != '.')
                    possibleValues[board[i][j] - '1'] = true;
        
        return () -> new Iterator<Character>() {
                    int position;
                    
                    @Override
                    public boolean hasNext() {
                        if (position >= possibleValues.length)
                            return false;
                        if (possibleValues[position]) {
                            position++;
                            return hasNext();
                        }
                        return true;
                    }

                    @Override
                    public Character next() {
                        return (char) (position++ + '1');
                    }
                };
    }
}