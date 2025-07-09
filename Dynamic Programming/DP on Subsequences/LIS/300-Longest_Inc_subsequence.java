/*
    State
    dp[i] - max length of LCS ending at index i;

    Transition-
    From every element behind dp[i] has possibility to extend it's subsequence 
    if nums[i] > nums[j] j>=0 && j<i
    
    I update dp[i] = max(dp[i],1+dp[j])

    Final subproblem-
    We keep the track of max dp[i]

    T.C - O(n^2)
    S.C - O(n)

 */
import java.util.Arrays;
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        Arrays.fill(dp,1);
        int maxLen=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],1+dp[j]);
                }
            }
            maxLen = Math.max(maxLen,dp[i]);
        }
        return maxLen;
    }
}