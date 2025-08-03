import java.util.*;
class Solution {
    public int atMost(int[] nums, int k){
        Map<Integer,Integer> map = new HashMap<>();
        int left=0,right=0;
        int count=0;

        while(right<nums.length){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);

            while(left<=right && map.size()>k){
                int freq = map.get(nums[left]);
                freq--;

                if(freq==0)
                map.remove(nums[left]);
                else
                map.put(nums[left],freq);

                left++;
            }
            count += (right-left+1);
            right++;
        }
        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums,k) - atMost(nums,k-1);
    }
}