import java.util.*;

public class Solution {
    public static void main(String[] args) {
        char[][] board = 
        {{'5','3','.','.','7','.','.','.','.'}
        ,{'6','.','.','1','9','5','.','.','.'}
        ,{'.','9','8','.','.','.','.','6','.'}
        ,{'8','.','.','.','6','.','.','.','3'}
        ,{'4','.','.','8','.','3','.','.','1'}
        ,{'7','.','.','.','2','.','.','.','6'}
        ,{'.','6','.','.','.','.','2','8','.'}
        ,{'.','.','.','4','1','9','.','.','5'}
        ,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(new Solution().isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {
        boolean row[] = new boolean[9], col[] = new boolean[81], box[] = new boolean[81];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '1';
                if (row[num] || col[j * 9 + num] || box[((i/3) * 3 + (j/3)) * 9 + num]) return false; 
                row[num] = col[j * 9 + num] = box[((i/3) * 3 + (j/3)) * 9 + num] = true;
            }
            row = new boolean[9];
        }
        return true;
    }
}