/*
    This problem is exactly same as Meeting rooms 2;
    T.C - nlogn
 */

import java.util.*;

class Solution {
    public static int minimumMachines(int[][] tasks) {
        Arrays.sort(tasks,(a,b)->a[0]-b[0]);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int machine =1;
        minHeap.offer(tasks[0][1]);
        
        for(int i=1;i<tasks.length;i++){
            if(tasks[i][0]>=minHeap.peek()){
                minHeap.poll();
            }else{
                machine++;
            }
            minHeap.offer(tasks[i][1]);
        }
        
        return machine;
    }
}