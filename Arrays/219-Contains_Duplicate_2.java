package Arrays;

import java.util.*;
/*
    This solution is accepted but will give wrong answers if we need strictly equal to k.
    eg : 1,2,1,5,1 k=3
    
    For strictly ==k I can use sliding windiow
 */
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]) && Math.abs(map.get(nums[i])-i)<=k)
            return true;

            map.put(nums[i],i);


        }
        return false;
    }
}