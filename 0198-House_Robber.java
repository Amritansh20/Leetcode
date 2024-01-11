import java.util.Arrays;
class Solution {
    static int dp[] = new int[101];
    public static int function(int[] nums, int index){
        if(index<0)
        return 0;

        if(dp[index]!=-1) return dp[index];

        return dp[index]=Math.max(nums[index]+function(nums,index-2), function(nums,index-1));
    }
    public int rob(int[] nums) {
        int n = nums.length;
        Arrays.fill(dp,-1);
        return function(nums,n-1); 
    }
}