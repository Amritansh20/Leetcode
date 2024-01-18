import java.util.*;
class Solution {
    static int[][] dp=new int[2][50001];
    public static int profit(int[] prices,int index,int buy, int fee){

        if(index == prices.length)
        return 0;

        if(dp[buy][index]!=-1) return dp[buy][index];

        if(buy==1){
           return dp[buy][index] = Math.max((-prices[index]-fee)+profit(prices,index+1,0,fee),
            profit(prices,index+1,1,fee));
        }else{
            return dp[buy][index]= Math.max(prices[index]+profit(prices,index+1,1,fee),
            profit(prices,index+1,0,fee));
        }
       
    }
    public int maxProfit(int[] prices, int fee) {
         for(int i=0;i<2;i++){
            Arrays.fill(dp[i],-1);
        }
        return profit(prices,0,1,fee);
    }
}