import java.util.*;
class Solution {
static int dp[][] = new int[2001][2001];
boolean isPalindrome(String s,int i,int j){
      if(i>j)
      return false;

      if(i==j)
      return true;
    
       while(i<j){
           if(s.charAt(i)!=s.charAt(j))
           return false;

           i++;
           j--;
        }
    return true;
    }

    public int solve(String s,int i,int j){
        
        if(i>=j)
        return 0;   
          
         
        if(isPalindrome(s,i,j-1)){
            return 0;     
         }
        
        
        if(dp[i][j]!=-1)
        return dp[i][j];
        
        int ans=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
         
            if(isPalindrome(s,i,k)==true){
                ans=Math.min(ans,1+ solve(s,k+1,j));
            }
            
        }
        return dp[i][j]=ans;
    }
    public int minCut(String s) {
        int n=s.length();
            
        for(int j[]:dp)
        Arrays.fill(j,-1);
        
        return solve(s,0,n);
    }
}