/*
    State - 
    dp[i] -> Longest palindromic subsequence till ith index. but there is
    one string how to compare the characters for palindromic ? So we make a new string
    which is reevrse of String s.
    Two mirror strings and finding longest common subsequence will give us longest
    palindromic subsequence.

    Since we introduced a new string and we are comparing both string. We need
    add a new parameter to our dp state. 
    dp[i][j] - Longest Common subsequence considering first i char from string 1
    and first j chars from string 2. 

    Transition-
        If ith and jth char matches then we simply add 1 to our previous state. 
        dp[i][j] = 1+dp[i-1][j-1];

        If it does not match then we don't know which char to consider which will 
        give us max length.         
        So we chcek both. I can consider ith char from string 1 and move
        forward or we can consider jth char from string 2 and move forward. 
        We try both and take max. 

        dp[i][j] = max(dp[i-1][j],dp[i][j-1]);

    Base case - If length of any string is 0 then max length will be 0. So 
    1st row and 1st col will be 0;

    Final subproblem -
        You check where our states are moving and decide the final state. 
        dp[n][n]

    Time complexity - O(n^2);
    Space complexity - O(n^2);

 */

class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder str = new StringBuilder(s);
        str.reverse();
        
        int n = s.length();
        int[][] dp = new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==str.charAt(j-1))
                dp[i][j] = 1+ dp[i-1][j-1];
                else
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][n];
    }
}