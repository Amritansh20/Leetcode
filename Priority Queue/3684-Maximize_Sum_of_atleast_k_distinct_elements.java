import java.util.*;
class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Map<Integer,Boolean> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(minHeap.size()<k && !map.containsKey(nums[i])){
                minHeap.offer(nums[i]);
                map.put(nums[i],true);
            }else{
                if(nums[i]>minHeap.peek() && !map.containsKey(nums[i])){
                    minHeap.poll();
                    minHeap.offer(nums[i]);
                    map.put(nums[i],true);
                }
            }
        }

        int ans[] = new int[minHeap.size()];
        int j=minHeap.size()-1;

        while(!minHeap.isEmpty()){
            ans[j--]=minHeap.poll();
        }
        return ans;
    }
}