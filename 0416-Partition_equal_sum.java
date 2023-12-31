import java.util.*;
class Solution {
    public boolean subset(int[] nums, int sum){
        int n = nums.length;
        if(n==0)
        return false;

        if(sum==0)
        return true;

        boolean dp[][]=new boolean[n+1][sum+1];

        for(int i=0;i<n+1;i++){
            dp[i][0]=true;
        }

        for(int i=1;i<sum+1;i++){
            dp[0][i]=false;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(nums[i-1]<=j){
                    dp[i][j]= dp[i-1][j-nums[i-1]] || dp[i-1][j];
                }else{
                    dp[i][j]= dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
    public boolean canPartition(int[] nums) {
        int sum= Arrays.stream(nums).sum();

        if(sum%2==1)
        return false;
        else
        return subset(nums,sum/2);
    }
}