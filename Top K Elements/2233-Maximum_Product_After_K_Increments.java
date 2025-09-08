/*
    Time : O(n logn)
    Space : O(n)
 */
import java.util.*;
class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int MOD = 1_000_000_007; 
        for(int num : nums)
        minHeap.offer(num);

        while(!minHeap.isEmpty() && k-- >0){
            int num = minHeap.poll();
            num++;
            minHeap.offer(num);
        }   
        long product = 1;

        while(!minHeap.isEmpty()){
            product = (product*minHeap.poll())%MOD;
        }
        return (int) product % MOD;
    }
}