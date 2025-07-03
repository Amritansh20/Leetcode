/*
    State: 
    dp[i][j] = Number of ways to distribute j candies till ith children.
    
    Transition:
    How many candies can I allocate to a child?
    It can be from 0 to limit. Math.min(limit,j)
    
    If I am giving 1 candy to a child and the limit is 3 then 2 candies will be distributed 
    among other children

    dp[i][j] = dp[i-1][j-0] + dp[i-1][j-1]+ ... dp[i-1][j-Math.min(j,limit)]

    Base case:
    I have 0 candy and 0 children then 1 wasy to distribute.

    Final Subproblem:
    dp[3][n];

    This will give TLE as we are calculating the sum in thirst loop for transition.

    Let's try to removed that and apply prefix sum. 

 */
class Solution {
    public long distributeCandies(int n, int limit){
        long[][] dp = new long[4][n+1];
        dp[0][0]=1;

        for(int i=1;i<4;i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=0;
                for(int k=0;k<=Math.min(j,limit);k++){
                    dp[i][j]+= dp[i-1][j-k];
                }
            }
        }
        return dp[3][n];
    }
}

/*
    State: 
    dp[i][j] = Number of ways to distribute j candies till ith children.
    
    Transition:
    How many candies can I allocate to a child?
    It can be from 0 to limit. Math.min(limit,j)
    
    If I am giving 1 candy to a child and the limit is 3 then 2 candies will be distributed 
    among other children

    dp[i][j] = dp[i-1][j-0] + dp[i-1][j-1]+ ... dp[i-1][j-Math.min(j,limit)]

    Base case:
    I have 0 candy and 0 children then 1 wasy to distribute.

    Final Subproblem:
    dp[3][n];

    This will give TLE as we are calculating the sum in thirst loop for transition.

    Let's try to removed that and apply prefix sum. 
    Learn to apply prefix sum in these questions and try to visualize.

    I was able to identify this as DP. 
    I got stuck in state transition. Took help from chatgpt. did not copy pasted it.
    
 */
class Solutions {
    public long distributeCandies(int n, int limit){
        long[][] dp = new long[4][n+1];
        dp[0][0]=1;

        for(int i=1;i<4;i++){
            long[] prefix = new long[n+1];
            prefix[0]= dp[i-1][0];
           
            for(int j=1;j<=n;j++)
            prefix[j]= prefix[j-1]+dp[i-1][j];

            for(int j=0;j<=n;j++){
                int remain_candies = j-limit;
                if(remain_candies>0){
                    dp[i][j]= prefix[j]-prefix[remain_candies-1];
                }else{
                    dp[i][j]=prefix[j];
                }
            }
           
        }
        return dp[3][n];
    }
}