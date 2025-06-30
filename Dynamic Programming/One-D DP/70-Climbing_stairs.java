

import java.util.*;
class Solution {
    /*
    This is like fib.
    State:- dp[i] = number of ways to reach ith stair.
    
    Transition -> My state is dependent on two previous states dp[i-1] and dp[i-2];
    So = d[i]= solve(n-1)+solve(n-2)
    
    Base = When I reach 1st stair and 2nd stair

    Final Subproblem = dp[n] (Reachinf nth stair)

    T.C - number of states * time to calculate each state
    n*1

    S.C - O(n)

 */
    public int solve(int n, int[] dp){
        if (n == 1)
        return dp[n] = 1;
        if (n == 2)
        return dp[n] = 2;

        if(dp[n]!=-1)
        return dp[n];

        return dp[n] = solve(n-1,dp)+solve(n-2,dp);
    }
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);

        solve(n,dp);
        return dp[n];
    }
}

   /*
    This is like fib.
    State:- dp[i] = number of ways to reach ith stair.
    
    Transition -> My state is dependent on two previous states dp[i-1] and dp[i-2];
    So = d[i]= dp[i-1]+dp[i-2]
    
    Base = When I reach 1st stair and 2nd stair

    Final Subproblem = dp[n] (Reachinf nth stair)

    T.C - number of states * time to calculate each state
    n*1

    S.C - O(n) and no stack space

 */

class Solutions {
    public int climbStairs(int n) {
        if(n==1)
        return 1;

        if(n==2)
        return 2;

        int[] dp = new int[n+1];
        dp[1]=1;
        dp[2]=2;

        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}