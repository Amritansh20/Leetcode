/*
    This Problem is extension of LIS. 
    The Explaination of state and transition of LIS on LC 300;

    This problem requires the introduction if a new dp state that is count DP.

    State - 
    count[i] - Number of LIS ending at index i;

    Transition-
        If i find a better path i.e increasing we update teh current state state count[i] with previous
        state i.e counf[j] j>=0 and j<i
        Why? because the current element is becmoning the part of previus state and increasing the 
        length of inc subsequence. 

        When we inc the count of LIS (all small states are the LIS in itself)
        We inc it when we encounter a number which is bigger and possible candidate
        but not good enough candidate to be the part ofmy current state. 
        In this case we check is the count of previos of state +1 is equals to current state and 
        the coun of previus state to current state;

    T.C - O(N);
    S.C - O(N)
 */

 import java.util.*;
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];
        int maxLen = 1;
        Arrays.fill(dp,1);
        Arrays.fill(count,1);

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(1+dp[j]>dp[i]){
                        dp[i]=1+dp[j];
                        count[i]=count[j];
                    }else if(1+dp[j]==dp[i]){
                        count[i]+=count[j];
                    }
                }
            }
            maxLen = Math.max(dp[i],maxLen);
        }

        int countOfLIS =0;
        for(int i=0;i<n;i++){
            if(dp[i]==maxLen)
            countOfLIS+=count[i];
        }
        return countOfLIS;
    }
}