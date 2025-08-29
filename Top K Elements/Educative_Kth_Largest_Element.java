import java.util.*;
/*
 * It is same as Leetcode 215. only diff is input format
 * 
 */
class Solution{
    public static String kthLargestInteger (String[] nums, int k) {
        // Replace this placeholder return statement with your code
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int i=0;i<nums.length;i++){
            int num = Integer.valueOf(nums[i]);
            if(minHeap.size()<k){
                minHeap.offer(num);
            }else{
                if(num>minHeap.peek()){
                    minHeap.poll();
                    minHeap.offer(num);
                }
            }
        }
        int ans = minHeap.poll();
        return String.valueOf(ans);
    }
}