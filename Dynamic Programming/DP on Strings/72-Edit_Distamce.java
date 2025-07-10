/*
    We have to make decisions weather to replace, remove or insert.
    This gives us an idea of decision DP

    State: dp[i][j] 
        The min operation required to make first i chars of word1 to first j chars of word2.

    Transition:
        If there is a char match we need to perform any opetaions
        else
        We have to choose the min of all operations and add 1.
    
    Base Case:
        Where your transition will fail or give wrong res?
        We are assuming that none of the strings is empty. we cannot do that
        There might a an empty string. 

        If word2 is empty then we have to delete all chars from word1 (remove operations)
        If word1 is empty then we have to indert all chars of word2 in an empty word1 string.

    Final Subproblem:
        See where your dp transions ends
        d[m][n];

    Time :
        O(m*n)
    Space:
        O(m*n)
 */
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m+1][n+1];

        for(int i=0;i<=m;i++)
        dp[i][0]=i;

        for(int i=0;i<=n;i++)
        dp[0][i]=i;

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    int replace = dp[i-1][j-1];
                    int delete = dp[i-1][j];
                    int insert = dp[i][j-1];

                    dp[i][j] = 1+Math.min(replace,Math.min(delete,insert));
                }
            }
        }
        return dp[m][n];
    }
}