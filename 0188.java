class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int dp[][][] = new int [n+1][2][k+1];
        //Initialization
        for (int i = 0;i<n;i++) {
            for (int j = 0; j < 2; j++) {
                for (int l = 0; l < k+1; l++) {
                    dp[i][j][l] = 0;
                }
            }
        }
        //Base Case

        for(int index=0;index<n;index++){
            for(int buy=0;buy<2;buy++){
                dp[index][buy][0]=0;
            }
        }

        for(int buy=0;buy<2;buy++){
            for(int cap=0;cap<k+1;cap++){
                dp[n][buy][cap]=0;
            }
        }

        //Reoccurrance
        for(int index=n-1;index>=0;index--){
            for(int buy=0;buy<2;buy++){
                for(int cap=1;cap<k+1;cap++){
                    if(buy==1){
                        dp[index][buy][cap]=Math.max(-prices[index]+dp[index+1][0][cap],dp[index+1][1][cap]);
                    }else{
                        dp[index][buy][cap]=Math.max(prices[index]+dp[index+1][1][cap-1],dp[index+1][0][cap]);
                    }
                }
            }
        }

        return dp[0][1][k];
    }
}