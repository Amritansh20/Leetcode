import java.util.*;

class Solution {
    public static int subsetCount(int[] nums,int target){
        
        int n = nums.length;
        int dp[][] =new int[n+1][target+1];

        for(int i=0;i<n+1;i++){
            dp[i][0]=1;
        }

        for(int i=1;i<target+1;i++){
            dp[0][i]=0;
        }

        for(int i=1;i<n+1;i++){
            for(int j=0;j<target+1;j++){
                if(nums[i-1]<=j){
                    dp[i][j]=dp[i-1][j-nums[i-1]] + dp[i-1][j];
                }else{
                    dp[i][j] =dp[i-1][j];
                }
            }
        }
        return dp[n][target];
    }
    public int findTargetSumWays(int[] nums, int target) {
     int sum = Arrays.stream(nums).sum();   
     int reqSum = (sum-target)/2;
     if((sum+target)%2==1 || target>sum)
     return 0;

     return subsetCount(nums,reqSum);
    }
}