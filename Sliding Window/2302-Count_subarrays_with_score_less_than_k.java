/*
    I don't understand why this was marked hard. It was basic sliding window.
 */
class Solution {
    public long countSubarrays(int[] nums, long k) {
        int left=0,right=0;
        long count=0;
        long sum =0;

        while(right<nums.length){
            sum += nums[right];
            long score = sum*(right-left+1);

            while(left<=right && score>=k){
                sum-=nums[left];
                left++;

                score = sum*(right-left+1);
            }
            count += (right-left+1);
            right++;
        }
        return count;
    }
}