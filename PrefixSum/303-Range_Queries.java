package PrefixSum;

import java.util.*;
class NumArray {
    int[] nums;
    Map<Integer,Integer> map;
    public NumArray(int[] nums) {
        this.nums=nums;
        map= new HashMap<>();
        int sumTillNow=nums[0];
        map.put(0,sumTillNow);
        for(int i=1;i<nums.length;i++){
            sumTillNow+=nums[i];
            map.put(i,sumTillNow);
        }

    }
    
    public int sumRange(int left, int right) {
        return map.get(right)-map.get(left)+nums[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */