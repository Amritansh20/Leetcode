import java.util.*;
class Solution {
    public long largestPerimeter(int[] nums) {
        if(nums.length<3)
        return -1;

       Arrays.sort(nums);
       long sum = 0;
       for(int i=0;i<nums.length;i++)
       sum+= nums[i];

       for(int i=nums.length-1;i>=2;i--){
           long largestSide = nums[i];
           long remainSum = sum-largestSide;
           if(remainSum>largestSide)
           return sum;
           
           sum -= nums[i];
        } 
       return -1;
    }
}