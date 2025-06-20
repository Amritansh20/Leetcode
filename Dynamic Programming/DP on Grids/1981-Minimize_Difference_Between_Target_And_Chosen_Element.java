import java.util.*;

class Solution {
    static int[][] dp = new int[71][70*70];
    public static int solve(int[][] mat,int target, int index, int sum){
        if(index==mat.length)
        return Math.abs(target-sum);

        if(dp[index][sum]!=-1) return dp[index][sum];

        int result =Integer.MAX_VALUE;
        for(int i=0;i<mat[index].length;i++){
            result = Math.min(result,solve(mat,target, index+1, sum+mat[index][i]));
        }
        return dp[index][sum]=result;
    }
    public int minimizeTheDifference(int[][] mat, int target) {
        
        for(int arr[]:dp)
        Arrays.fill(arr,-1);

        return solve(mat,target,0,0);
    }
}