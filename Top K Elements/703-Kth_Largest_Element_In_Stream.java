/*
    T.C = O(n logk)
    S.C - O(k)
 */
import java.util.*;

class KthLargest {
    PriorityQueue<Integer> minHeap;
    int k;
    int[] nums;
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.k=k;
        this.nums=nums;

        for(int i=0;i<nums.length;i++){
            if(minHeap.size()<k)
            minHeap.offer(nums[i]);
            else if(minHeap.size()==k){
                if(nums[i]>minHeap.peek()){
                    minHeap.poll();
                    minHeap.offer(nums[i]);
                }
            }
        }
    }
    
    public int add(int val) {
        if(minHeap.size()<k)
            minHeap.offer(val);
        else if(minHeap.size()==k){
            if(val>minHeap.peek()){
                minHeap.poll();
                minHeap.offer(val);
                }
            }
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */