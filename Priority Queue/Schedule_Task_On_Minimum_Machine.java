/*

We are given an input array, tasks, where tasks[i]= [startI, endI]
tasks. Our goal is to schedule these tasks on machines given the following criteria:
A machine can execute only one task at a time.
A machine can begin executing a new task immediately after completing the previous one.
An unlimited number of machines are available.

Find the minimum number of machines required to complete these n tasks

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