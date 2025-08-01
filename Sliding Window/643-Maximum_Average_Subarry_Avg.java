// Be mindful of how I have used -Double.MAX_VALUE
// Double.MIN_VALUE starts from +ve 
// Hence it is giving wrrong ans where sum is -ve
// nums = [-1] , k=1 
// If we take maxAvg = Double.MIN_VALUE then ans will be 0.000 which is wrong
// so we took -Double.MAX_VALUE
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left=0,right=0;
        int sum =0;
        double maxAvg = -Double.MAX_VALUE;
        while(right<nums.length){
            sum+= nums[right];

            if(right-left+1==k){
                double avg = (double) sum/k;
                maxAvg = Math.max(avg,maxAvg);
                
                sum-= nums[left];
                left++;
            }
            right++;
        }
        return maxAvg;
    }
}