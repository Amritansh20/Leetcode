/*
    State:
        dp[i] = Max amount of robbery til ith house.
    
    Transistion:
        If at any house I decide not to rob I cannot rob the house one left to it.
        If I decide not to rob I can I can try robbing the house left to it. 

        If robbed
        dp[i]= nums[i]+solve(i-2)
        If not robbed
        dp[i]= solve(i-1)

    Base case:
        See where your ransition fails
        If I am 0 and robb that house I jump to -2 
        If I am 1 and rob that house I jume to -1
        If I am 0 and do not rob I jump to -1
        So jumping to -ve is base case.
    
    Final Sub problem
        I need max of my transitions
        So, dp[i] = Math.max(robb,not_robb)

    Time complexity:
        Number of states * Time to calculate each state
        n*1
    Space Complexity:
        O(n) for dp array and stack space
 */

import java.util.*;
class Solution {
    public int solve(int curr_house, int[] nums, int[] dp){
        if(curr_house<0)
        return 0;

        if(dp[curr_house]!=-1)
        return dp[curr_house];

        int not_rob_curr_house = solve(curr_house-1,nums,dp);
        int rob_curr_house= nums[curr_house]+solve(curr_house-2,nums,dp);

        return dp[curr_house]=Math.max(rob_curr_house,not_rob_curr_house);

    }
    public int rob(int[] nums) {
       int n = nums.length;
       int[] dp= new int[n+1];
       Arrays.fill(dp,-1);
       solve(n-1,nums,dp); 
       return dp[n-1];

    }
}

/*
    State:
        dp[i] = Max amount of robbery til ith house.
    
    Transistion:
        If at any house I decide not to rob I cannot rob the house one left to it.
        If I decide not to rob I can I can try robbing the house left to it. 

        If robbed
        dp[i]= nums[i]+dp[i-2]
        If not robbed
        dp[i]= dp[i-1]

    Base case:
        It's tricy to understand. 
        My sub problems are dependent on two states backwards.
        What If I am 0 and 1? 
        Think of dp[0] and dp[1] as a independent sub problem. I need max rigth?
        What is the max at index 0? nums[0]
        
        Now think of dp[1] that there is only 2 houses. 
        I cannot rob both as they are adjancent and I need max
        So I will store max of two houses.
    
    Final Sub problem
        I need max of my transitions
        So, dp[i] = Math.max(robb,not_robb)

    Time complexity:
        Number of states * Time to calculate each state
        n*1
    Space Complexity:
        O(n) for dp array 
 */
class Solutions {
    public int rob(int[] nums) {
       int n = nums.length;
       if(n==1)
       return nums[0];

       if(n==2)
       return Math.max(nums[0],nums[1]);
       
       int[] dp= new int[n+1];

       dp[0]= nums[0];
       dp[1] = Math.max(nums[0],nums[1]);

       for(int i=2;i<nums.length;i++){
            int not_rob = dp[i-1];
            int rob = nums[i]+dp[i-2];

            dp[i]=Math.max(rob,not_rob);
       }
       return dp[n-1];
    }
}