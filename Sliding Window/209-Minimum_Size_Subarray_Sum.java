class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int left=0,right=0;

        int sum=0;
        while(right<nums.length){
            sum+= nums[right];

            while(left<=right && sum>=target){
            minLen = Math.min(right-left+1,minLen);
            sum -= nums[left];
            left++;
            }
            right++;
        }
        return minLen==Integer.MAX_VALUE?0:minLen;
    }
}