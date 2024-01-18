class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][][] = new int [n+1][2][3];
        //Initialization
        for (int i = 0;i<n;i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = 0;
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
            for(int cap=0;cap<3;cap++){
                dp[n][buy][cap]=0;
            }
        }

        //Reoccurrance
        for(int index=n-1;index>=0;index--){
            for(int buy=0;buy<2;buy++){
                for(int cap=1;cap<3;cap++){
                    if(buy==1){
                        dp[index][buy][cap]=Math.max(-prices[index]+dp[index+1][0][cap],dp[index+1][1][cap]);
                    }else{
                        dp[index][buy][cap]=Math.max(prices[index]+dp[index+1][1][cap-1],dp[index+1][0][cap]);
                    }
                }
            }
        }

        return dp[0][1][2];
     }
}

// Time - O(n*2*3)
// Space - O(n*2*3)