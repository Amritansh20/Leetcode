class Solution {
    public boolean canJump(int[] nums) {
        int goalpost = nums.length-1;

        for(int i=nums.length-2;i>=0;i--){
            if(i+nums[i]>=goalpost)
            goalpost =i;
        }   
        return goalpost==0?true:false;
    }
}