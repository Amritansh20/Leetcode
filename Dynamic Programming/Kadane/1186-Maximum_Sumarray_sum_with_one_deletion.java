/* Let us understand Kadane's Algorithm first 
   
   Problem Statement - Given an array of integers (can be positive, negative, or zero), 
   find the contiguous subarray that has the maximum sum.

   Approch -> We have two choices at every index
    1-> We continue with current subArray. (add the number to curr_sum)
    2-> Start fresh 

   int maxSoFar = num[0];
   int currentMax = nums[0];

   for(int i=1;i<n;i++){
    currentMax = Math.max(currentMax, currentMax+nums[i]);
    maxSoFar = Math.max(currentMAx,maxSoFar);
   }
   return maxSoFar;
    

    Now This Problem is extension of Kadane's Algorithms 
    We should note that Kadane is both greedy+DP

    In this problem we have two options at every index
    1- Delete only one number and continue;
    2- Don't delete anything and continue;

    Note -> 
    1-In  basic Kadane there is only one parameter changing (currentMax)
    2- In max Product Subarray two parameter is changing(max and min)
    3- In this problem as well two parameter is changing (noDelete and onrDelete)
*/
class Solution {
    public int maximumSum(int[] nums) {
        int n = nums.length;
        // Remember the initialisation of DP. It is same as that
        int max_one_del = 0;
        int max_no_del = nums[0];
        int max_so_far = nums[0];

        for(int i=1;i<n;i++){
            max_one_del = Math.max(max_no_del,max_one_del+nums[i]); 
            max_no_del = Math.max(nums[i],max_no_del+nums[i]);
            max_so_far = Math.max(max_so_far,Math.max(max_one_del,max_no_del));
        }
        return max_so_far;
    }
}