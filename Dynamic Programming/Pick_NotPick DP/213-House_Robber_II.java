/*
    Core Idea: If I rob first house, I can't rob last house and vice versa.

    State: 
        dp[i]: The max amout of robbery till house i

    Transition: 
        If I decide to rob current house my state is dependent on i-2th house
        dp[i] = nums[i]+solve(i-2)
        If I decide not to rob the house I must not be robbing i-1th house 
        dp[i]=solve(i-1);

    Base case: The parameter where the transition fails.
        i<0
    
    Final subproblem:
        dp[n]
 */
import java.util.*;

class Solution {
    public int solve(int[] input, int[] dp, int curr_house){
        if(curr_house<0)
        return 0;

        if(dp[curr_house]!=-1)
        return dp[curr_house];

        int not_rob = solve(input,dp,curr_house-1);
        int rob = input[curr_house] + solve(input,dp,curr_house-2);

        return dp[curr_house]=Math.max(not_rob,rob);
    }
    public int rob(int[] nums) {
        int n = nums.length;

        if(n==1)
        return nums[0];

        if(n==2)
        return Math.max(nums[0],nums[1]);

        // Making two arrays of size n-1
        // 1-> If I pick 1st I will not pick last
        //   2-> If I pick last I will not pick first;

        int[] input1 = new int[n-1];
        int[] input2 = new int[n-1];

        for(int i=0;i<n-1;i++)
        input1[i]=nums[i];

        for(int i=n-2;i>=0;i--)
        input2[i]=nums[i+1];

        // making couple of DP arrays.
        int[] dp1 = new int[n];
        Arrays.fill(dp1,-1);

        int[] dp2 = new int[n];
        Arrays.fill(dp2,-1);

        return Math.max(solve(input1,dp1,n-2),solve(input2,dp2,n-2));
    }
}

/*
    Core Idea: If I rob first house, I can't rob last house and vice versa.
    Everything is same as House Robber 1. 
    Only difference is that we are doing it for two input sets and returing the
    max out of those.

    State: 
        dp[i]: The max amout of robbery till house i

    Transition: 
        If I decide to rob current house my state is dependent on i-2th house
        dp[i] = nums[i]+dp[i-2]
        If I decide not to rob the house I must not be robbing i-1th house 
        dp[i]=dp[i-1]

    Base case: The parameter where the transition fails.
        i<0
    
    Final subproblem:
        dp[n]

    Time: Number of states * Calculation time for each state
            2*(n*1)
    Space :
        Space for new input sets nad dp arrays.
        O(n)
 */

class Solutions {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n==1)
        return nums[0];

        if(n==2)
        return Math.max(nums[0],nums[1]);

        // Making two arrays of size n-1
        // 1-> If I pick 1st I will not pick last
        //   2-> If I pick last I will not pick first;

        int[] input1 = new int[n-1];
        int[] input2 = new int[n-1];

        for(int i=0;i<n-1;i++)
        input1[i]=nums[i];

        for(int i=n-2;i>=0;i--)
        input2[i]=nums[i+1];

        // making couple of DP arrays.
        int[] dp1 = new int[n];
        dp1[0]=input1[0];
        dp1[1]=Math.max(input1[0],input1[1]);

        int[] dp2 = new int[n];
        dp2[0]=input2[0];
        dp2[1]= Math.max(input2[0],input2[1]);

        for(int i=2;i<n-1;i++){
            int not_rob = dp1[i-1];
            int rob = input1[i]+dp1[i-2];

            dp1[i]=Math.max(not_rob,rob);      
        }
        
        for(int i=2;i<n-1;i++){
            int not_rob = dp2[i-1];
            int rob = input2[i]+dp2[i-2];

            dp2[i]=Math.max(not_rob,rob);
        }

        return Math.max(dp1[n-2],dp2[n-2]);
    }
}