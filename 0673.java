import java.util.*;

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        int count[] = new int[nums.length];
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        int maxLen=1;
         for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                if(dp[j]+1 > dp[i]){
                dp[i] = dp[j]+1;
                count[i]=count[j];
                }else if(dp[i] == dp[j]+1){
                count[i] += count[j];
                }
            }
            maxLen = Math.max(maxLen,dp[i]);
        }
    }
    int numOfLis = 0;
    for(int i=0;i<count.length;i++){
        if(dp[i]==maxLen)
        numOfLis += count[i];
    }

    return numOfLis;
    }
}