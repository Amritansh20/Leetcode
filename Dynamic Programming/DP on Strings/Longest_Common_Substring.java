/*
    This question is slight modification of Longest cpmmon subsequence.
    The only diff-
    If the characters are not matching we store 0. 

    state ->
    dp[i][j] = Longest common substring ending at i,j;

    Transition:
    If char matches we inc 1 from previous state 
    else store 0.

    Final Sunproblem:
    If we want longest length. We iterate in grid to find the max
    length;

    Time- O(n^2)
    Space - O(n^2)


 */
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n+1][n+1];

        StringBuilder str = new StringBuilder(s);
        str.reverse();

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==str.charAt(j-1))
                dp[i][j] = 1+dp[i-1][j-1];
                else
                dp[i][j] = 0;
            }
        }

        int x=-1;
        int y=-1;
        int maxLen= -1;
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                if(dp[i][j]>maxLen){
                    maxLen = dp[i][j];
                    x =i;
                    y =j;
                }
            }
        }

        StringBuilder ans = new StringBuilder();

        while(dp[x][y]!=0){
            ans.append(s.charAt(x-1));
            x--;
            y--;
        }
        return ans.toString();
    }
}