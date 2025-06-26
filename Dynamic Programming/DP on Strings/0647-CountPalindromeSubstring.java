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

    public int countSubstrings(String s) {
        int n = s.length();
        int count=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isPalindrome(s,i,j)==1)
                count++;
            }
        }
        return count;
    }
}