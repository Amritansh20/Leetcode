/*
    Time : O(n logk)
    S.C - O(k)
 */
import java.util.*;
class Pair{
    int element;
    int index;

    Pair(int element, int index){
        this.element=element;
        this.index=index;
    }
}
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b)->a.element-b.element);
        PriorityQueue<Pair> minHeap_index= new PriorityQueue<>((a,b)->a.index-b.index);
        

        for(int i=0;i<nums.length;i++){
            if(minHeap.size()<k){
                minHeap.offer(new Pair(nums[i],i));
            }else if(minHeap.size()==k){
                if(nums[i]>minHeap.peek().element){
                    minHeap.poll();
                    minHeap.offer(new Pair(nums[i],i));
                }
            }
        }

        while(!minHeap.isEmpty()){
            minHeap_index.offer(minHeap.poll());
        }

        int i=0;
        int[] ans = new int[k];
        while(!minHeap_index.isEmpty()){
            ans[i++] = minHeap_index.poll().element;
        }
        return ans;
    }   
}