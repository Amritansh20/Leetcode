/*
    Time: O(n logk)
    Space: O(k)
 */
import java.util.*;
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i=0;i<nums.length;i++){
            if(minHeap.size()<k){
                minHeap.offer(nums[i]);
            }else if(minHeap.size()==k){
                if(nums[i]>minHeap.peek()){
                    minHeap.poll();
                    minHeap.offer(nums[i]);
                }
            }
        }
        return minHeap.peek();
    }
}