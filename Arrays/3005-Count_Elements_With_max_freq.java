package Arrays;

import java.util.*;
class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++)
        map.put(nums[i],map.getOrDefault(nums[i],0)+1);

        int max = -1;
        int cnt=0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(max==-1){
                max = entry.getValue();
                cnt+= entry.getValue();
            }else if(entry.getValue()==max){
                cnt+=entry.getValue();
            }else if(entry.getValue()>max){
                max = entry.getValue();
                cnt = entry.getValue();
            }
        }
        return cnt;
    }
}