class Solution {
        public int[][] lcs(int m, int n, String s1, String s2){
        int dp[][] = new int[m+1][n+1];
        
        for(int i=0;i<m+1;i++){
            dp[i][0]=0;
        }
        
        for(int i=1;i<n+1;i++){
            dp[0][i]=0;
        }
        
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else{
                    dp[i][j]= Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp;
    }
    public String shortestCommonSupersequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int dp[][] = new int[m+1][n+1];

        dp = lcs(m,n,s1,s2);

        int i=m;
        int j=n;
        String ans ="";
      
        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                ans += s1.charAt(i-1);
                i--;
                j--;
            }else{
                if(dp[i][j-1]>dp[i-1][j]){
                    ans += s2.charAt(j-1);
                    j--;
                }else{
                    ans += s1.charAt(i-1);
                    i--;
                }
            }
        }

        while(i>0){
            ans += s1.charAt(i-1);
            i--;
        }

        while(j>0){
            ans += s2.charAt(j-1);
            j--;
        }

        String req ="";

        for(int k=ans.length()-1;k>=0;k--){
            req += ans.charAt(k);
        }
        return req;
    }
}