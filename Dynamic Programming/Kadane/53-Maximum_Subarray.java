// Code with printing logic 

//  public int maxSubArray(int[] nums) {
//         int sum_so_far = nums[0];
//         int max_sum_so_far=nums[0];

//         int start=0;
//         int end=0;

//         for(int i=1;i<nums.length;i++){
//             if(sum_so_far+nums[i]>nums[i]){
//                 sum_so_far+= nums[i];
//             }else{
//                 sum_so_far=nums[i];
//                 start=i;
//             }

//             if(max_sum_so_far<sum_so_far){
//                 max_sum_so_far = sum_so_far;
//                 end =i;
//             }
//         }

//         for(int i=start;i<=end;i++)
//         System.out.print(nums[i]+" ");

//         return max_sum_so_far;
// }
class Solution {
     public int maxSubArray(int[] nums) {
        int sum_so_far = nums[0];
        int max_sum_so_far=nums[0];

        for(int i=1;i<nums.length;i++){
            sum_so_far = Math.max(sum_so_far+nums[i],nums[i]);
            max_sum_so_far = Math.max(max_sum_so_far,sum_so_far);
        }
        return max_sum_so_far;
    }
}

