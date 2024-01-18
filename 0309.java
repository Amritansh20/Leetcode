class Solution {
    static int dp[][] = new int [5001][2];
    public static int  function(int[] prices, int index, int buy){
        
        if(index>=prices.length) return 0;
        if(dp[index][buy]!=-1) return dp[index][buy];

        if(buy==1){
            return dp[index][buy]=Math.max(-prices[index]+function(prices,index+1,0),function(prices,index+1,1));
        }else{
          return dp[index][buy]=Math.max(prices[index]+function(prices,index+2,1), function(prices,index+1,0));
        }

    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        for(int i=0;i<5001;i++){
            for(int j=0;j<2;j++){
                dp[i][j]=-1;
            }
        }
        return function(prices,0,1);
    }
}