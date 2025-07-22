/*
    I put all meetings in pairs for better hold.
    I sorted the meetings based on start time. 

    Approach - 
        you keep track of end time. 
        If some meeting comes which start before the  meeting ending latest. 
        (minHeap tells us this). 
        We take a new room

        If a meeting comes which start after or at the same time
        compared from the meeting ending latest. We use the last meeting room
        ans remove it from heap.

        T.C - O(nlogn)
        S.C - O(n)
 */
import java.util.*;
class Solution {
    public int minMeetingRooms(int[] start, int[] end) {
        
       int[][] meetings = new int[start.length][2];
       
       for(int i=0;i<start.length;i++){
           meetings[i][0] = start[i];
           meetings[i][1] = end[i];
       }
       
       Arrays.sort(meetings,(a,b)->a[0]-b[0]);
       PriorityQueue<Integer> minHeap = new PriorityQueue<>();
       minHeap.offer(meetings[0][1]);
       int rooms =1;
       
       for(int i=1;i<meetings.length;i++){
            if(!minHeap.isEmpty() && minHeap.peek()>meetings[i][0]){
                rooms++;
            }else{
                    minHeap.poll();
            }
            minHeap.offer(meetings[i][1]);
         
       }
       return rooms;
    }
}
