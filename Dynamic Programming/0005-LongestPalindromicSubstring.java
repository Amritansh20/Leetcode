class Solution {
    static int dp[][] =new int[1001][1001];
    
    public static int isPalindrome(String s, int i, int j){
        if(i>=j)
        return dp[i][j]=1;

        if(dp[i][j]!=-1) return dp[i][j];

        if(s.charAt(i)==s.charAt(j))
        return dp[i][j]=isPalindrome(s,i+1,j-1);        

        return dp[i][j]=0;
    }
    public String longestPalindrome(String s) {
        int maxLen = Integer.MIN_VALUE;
        int startPoint=0;
        int n = s.length();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isPalindrome(s,i,j)==1){
                    if(maxLen<j-i+1){
                    maxLen= j-i+1;
                    startPoint=i;
                    }
                }
            }
        }
        return s.substring(startPoint,startPoint+maxLen);
    }
}