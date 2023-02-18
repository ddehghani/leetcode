public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isMatch("aaaaaaaaaaaaaaaaaaa", "a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*"));
        // "cbcc" "cbc*"
    }

    public boolean isMatch(String s, String p) {
        final int sLen = s.length(), pLen = p.length();
        final boolean[][] dp = new boolean[sLen + 2][pLen + 2];
        dp[1][1] = true;
        for (int i = 1; i < sLen + 2; i++) {
            for (int j = 2; j < pLen + 2; j++) {
                char pChar = p.charAt(j - 2);
                if (pChar == '*') { 
                    dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && (
                        s.charAt( i - 2) == p.charAt(j - 3) || p.charAt(j - 3) == '.') );
                } 
                else if (pChar == '.') {
                    dp[i][j] = dp[i-1][j-1];
                } 
                else {
                    dp[i][j] = dp[i-1][j-1] && pChar == s.charAt(i - 2);
                }
            }
        }
        return dp[sLen + 1][pLen + 1];
    }

    public void printTable(boolean[][] table, String s, String p){
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < table[0].length; j++) {
                System.out.print("\t");
                if (i == 0)
                    System.out.print(j < 2 ? j : String.valueOf(p.charAt(j-2)));
                else
                    System.out.print("\b\b-----");
            }
            System.out.println();
        }

        for (int i = 0; i < table.length; i++) {
            System.out.print( i < 2 ? i : String.valueOf(s.charAt(i-2)));
            for (int j = 0; j < table[0].length; j++) {
                System.out.print("\t");
                System.out.print((table[i][j] ? "T" : "F"));
            }
            System.out.println();
            System.out.println();
        }
    }
}