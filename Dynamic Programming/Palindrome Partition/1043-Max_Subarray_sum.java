import java.util.*;
class Solution {
    static int dp[][] = new int[501][501];
    public static int solve(int index, int[] arr, int k){
        if(index==arr.length) return 0;
        
        if(dp[index][k]!=-1) return dp[index][k];

        int maxi = Integer.MIN_VALUE;
        int maxSum=0, len=0;
        for(int i=index;i< Math.min(arr.length,index+k);i++){
            len++;
            maxi = Math.max(maxi,arr[i]);
            int sum = (len*maxi) + solve(i+1,arr,k);
            maxSum = Math.max(maxSum,sum);
        }
        return dp[index][k]=maxSum;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {

        for(int a[]:dp){
            Arrays.fill(a,-1);
        }
        return solve(0,arr,k);
    }
}