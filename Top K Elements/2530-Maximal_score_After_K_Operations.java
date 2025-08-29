/*
    T.C - O(n logn)
    S.C - O(n)
 */
import java.util.*;
class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
       
        for(int num : nums)
        maxHeap.offer(num);

        long ans =0;

        while(k-- >0){
            int num = maxHeap.poll();
            ans+= num;

            System.out.println((int) Math.ceil(num/3));
            maxHeap.offer((int) Math.ceil(num/3.0));
        }
        return ans;

    }
}