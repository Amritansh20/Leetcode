class Solution {
    public int atMost(int[] nums, int goal){
        int left=0;
        int right=0;
        int count=0,sum=0;

        while(right<nums.length){
            sum+= nums[right];

            while(left<=right && sum>goal){
                sum-= nums[left];
                left++;
            }

            count+= (right-left);
            right++;
        }
        return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums,goal)-atMost(nums,goal-1);
    }
}