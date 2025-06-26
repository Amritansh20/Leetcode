import java.util.*;
class Solution {
    static int profitAmount =0;
    static int[][] dp=new int[2][30001];
    public static int profit(int[] prices,int index,int buy){

        if(index == prices.length)
        return 0;

        if(dp[buy][index]!=-1) return dp[buy][index];

        if(buy==1){
            profitAmount = Math.max(-prices[index]+profit(prices,index+1,0),
            profit(prices,index+1,1));
        }else{
            profitAmount= Math.max(prices[index]+profit(prices,index+1,1),
            profit(prices,index+1,0));
        }
        return dp[buy][index]=profitAmount;
    }
    public int maxProfit(int[] prices) {
        for(int i=0;i<2;i++){
            Arrays.fill(dp[i],-1);
        }
        return profit(prices,0,1);
    }
}