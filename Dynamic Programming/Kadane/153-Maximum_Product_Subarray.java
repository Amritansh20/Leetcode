/*
    Brute Force - Two nested loops to explore all possible sub arrays.
    T.c - O(n^2)

   Optimized Approach (Variation of Kadane's Algorithm for Product):
    - When dealing with products, negative numbers create a unique challenge:
        1. A negative number multiplied by another negative number can turn into a large positive number.
        2. A large positive product multiplied by a negative number can turn into a large negative product.
    - Therefore, we need to keep track of both:
        - max_so_far: The maximum product subarray ending at the current position.
        - min_so_far: The minimum product subarray ending at the current position (can become maximum if 
        multiplied by a negative number later).

    T.C- O(n)
    S.C - O(1)
 */
class Solution {
    public int maxProduct(int[] nums) {
        int max_till_now = nums[0];
        int min_till_now = nums[0];
        int ans = nums[0];
        for(int i=1;i<nums.length;i++){
            int temp = min_till_now;
            min_till_now = Math.min(nums[i],Math.min(min_till_now*nums[i],max_till_now*nums[i]));
            max_till_now = Math.max(nums[i],Math.max(temp*nums[i],max_till_now*nums[i]));
            ans = Math.max(ans,Math.max(min_till_now,max_till_now));
        }
        return ans;
    }
}