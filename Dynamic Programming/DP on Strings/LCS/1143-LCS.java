/*
    Base problem for multiple other problems.

    State: 
        dp[i][j] = length of LCS of first i characters of text1 and first j characters of text2.
    
    Transition:
        In case of char matching:
        We can include this character in our subsequence, so we add 1 to the LCS length of the 
        previous prefixes (i-1, j-1).
        
        In case of chars do not match:
        In this case we cannot include both the chars i.e text1[i] and text[j].
        We have to choose only one. But which one? The one which will give me max
        So, we ignore text1[i] (dp[i][j]=dp[i-1][j]) text1[0...i-1] text2[0...j]
        and then we ignore text2[j] (dp[i][j]=dp[i][j-1]) text1[0...i] text2[0....j-1]
        and we choose the max from it.

        There is the index shift dp[i][j] is not same as text1[i] and text2[j]
        dp[i][j]=text1[i-1] text2[j-1]

    Final SubProblem:
        LCS till the last char of text1 and last char of text2. 
        dp[m][n]

 */
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1))
                dp[i][j] = 1+dp[i-1][j-1];
                else
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);

                // dp[i-1][j] = ignoring text1[i-1]
                // dp[i][j-1] = ignoring text2[j-1]
            }
        }
        return dp[m][n];
    }
}