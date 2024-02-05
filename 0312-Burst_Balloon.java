import java.util.*;
class Solution {
    public static int solve(ArrayList<Integer> list, int i, int j, int[][] dp){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        
        int maxi = Integer.MIN_VALUE;
        for(int k=i;k<=j;k++){
            int coins = list.get(i-1)*list.get(k)*list.get(j+1)+
                        solve(list,i,k-1,dp)+
                        solve(list,k+1,j,dp);
            maxi = Math.max(coins,maxi);
        }
        return dp[i][j]=maxi;
    }
    public int maxCoins(int[] nums) {
        int n =nums.length;
      
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        for(int i=0;i<nums.length;i++)
        list.add(nums[i]);
        list.add(1);
        
        int dp[][] = new int[n+1][n+1];

        for(int arr[]:dp)
        Arrays.fill(arr,-1);

        return solve(list,1,n,dp);
    }
}