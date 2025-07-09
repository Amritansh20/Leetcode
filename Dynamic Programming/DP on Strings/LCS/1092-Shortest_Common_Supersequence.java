/*
    This problem is extension of LCS. 
    I am not talking about LCS DP ka state and transition. We already covered that
    on LCS problem. 

    The additional is the construction of the supersequence.

    How are we doing it?
    Target:
    1- we need the longest common subsequence once in our ans string.
    2- Then we can add the additioanl char from str 1 and str 2

    We start iterting the dp from bottom right cell. 
    Traversal optiosn we have - 
    1- We append char from str 1
    2- We append char from str 2

    How our dp state is defined -> dp[i][j] depends on dp[i-1][j-1], dp[i-1][j] 
    and dp[i][j-1] 

    We will move in same direction. 
    The catch here is if the char is matching in both string we move i-1 and j-1
    This ensurs that we are taking the common char only once. 

    If they are not matching then we check which is greater (choose LCS path)
    dp[i-1][j] or dp[i][j-1]

    If dp[i-j] is bigger then we append the char at ith index of string 1 and make i--
    Same if I find dp[i][j-1] greater. 

    This ensures all elements get to the final string in desired pos with common 
    char getting into final string only once.

    T.C - O(n^2) DP array
          O(k) for ans construction 
    S.C - O(n^2) for DP 
          O(lcs len + (m-lcs len) + (n- lcs_len)) for ans string.



 */
class Solution {
    public void lcs(String str1, String str2, int[][] dp){

        for(int i=1;i<=str1.length();i++){
            for(int j=1;j<=str2.length();j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
    }
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int[][] dp = new int[m+1][n+1];
        lcs(str1,str2,dp);

        int i=m;
        int j=n;
        StringBuilder ans = new StringBuilder();
        while(i>0 && j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                ans.append(str1.charAt(i-1));
                i--;
                j--;
            }else if(dp[i-1][j]>dp[i][j-1]){
                ans.append(str1.charAt(i-1));
                i--;
            }else{
                ans.append(str2.charAt(j-1));
                j--;
            }
        }

        while(i>0){
            ans.append(str1.charAt(i-1));
            i--;
        }

        while(j>0){
            ans.append(str2.charAt(j-1));
            j--;
        }
        ans.reverse();
        return ans.toString();
    }
}