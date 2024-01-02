import java.util.*;
class Solution {
    static int dp[][] = new int[1001][1001];
    public static int longSub(String text1, String text2, int m, int n){
        if(n==0||m==0)
        return 0;

        if(dp[m][n]!=-1)
        return dp[m][n];

        if(text1.charAt(m-1) == text2.charAt(n-1))
        return dp[m][n]=1+longSub(text1, text2, m-1,n-1);
        else
        return dp[m][n]=Math.max(longSub(text1,text2,m-1,n),longSub(text1,text2,m,n-1));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        longSub(text1,text2, text1.length(),text2.length());
        return dp[text1.length()][text2.length()];
    }
}