class Solution {
    static int[][] dp = new int[2500][2501];
    public static int LIS(int[] nums, int index, int prev_index){
        int n = nums.length;

        if(index==n)
        return 0;

        if(dp[index][prev_index+1]!=-1)
        return dp[index][prev_index+1];

        dp[index][prev_index+1] = LIS(nums,index+1,prev_index);

        if(prev_index==-1 || nums[index]>nums[prev_index])
        dp[index][prev_index+1] = Math.max(dp[index][prev_index+1] , 1+LIS(nums,index+1,index));

        return dp[index][prev_index+1];
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
  
        for(int i=0;i<n;i++){
            for(int j=0;j<n+1;j++){
                dp[i][j] = -1;
            }
        }

        return LIS(nums,0,-1);
    }
}