/*
    Problem: Find the minimum number of insertions needed to make a string a palindrome.

    Insight:
    - This problem is a variation of the Longest Common Subsequence (LCS) problem.
    - Key idea: Find the Longest Palindromic Subsequence (LPS) of the given string.
    - Characters that are not part of the LPS are the ones that need to be "added" to make the string 
    a palindrome.

    Important Point:
    - These extra characters must be inserted at positions that mirror the positions of characters 
      already present in the original string(those which is not the part of LPS) so that the 
      resulting string becomes a palindrome.

    Approach:
    - Find LPS by computing the LCS between the original string and its reversed version.
    - The minimum number of insertions needed = Total characters - Length of LPS.

    Time Complexity: O(n^2)
    Space Complexity: O(n^2)
*/
class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        StringBuilder st = new StringBuilder(s);
        st.reverse();

        int[][] dp = new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==st.charAt(j-1))
                dp[i][j]= 1+dp[i-1][j-1];
                else
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return n-dp[n][n];
    }
}