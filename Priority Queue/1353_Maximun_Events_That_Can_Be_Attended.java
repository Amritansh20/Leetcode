/*
    Idea is to attend any event as last as possible.
    Attend events with lesser end date first.

    I am iterating over days starting from day 1 to maxEndDay.
    Add all the events starting on the particular day to minHeap.

    Now, there might be some expired events that I could not attend. I have to remove that
    as it might get attended when i try to attend the correct event.

    At last I only have to attent one event in a day so I poll the smallest end day from 
    minHeap.

    Time -  O(nlog n) for sorting the array
            O(nlog n) for Heap operatiosn
            O(maxEndDay) for iterating.

            So, O(nlog n)

    Space : O(n)

 */
import java.util.*;
class Solution {
    public int maxEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events,(a,b)->a[0]-b[0]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int maxEndDay = 1;
        for(int i=0;i<events.length;i++)
        maxEndDay = Math.max(maxEndDay,events[i][1]);

        int j=0;
        int res =0;
        for(int day=1;day<=maxEndDay;day++){
            // Add all events starting in day 
            while(j<n && events[j][0]==day){
            minHeap.offer(events[j][1]);
            j++;
            }
            
            // Remove expired events
            while(!minHeap.isEmpty() && minHeap.peek()<day){
                minHeap.poll();
            }

            //Attend only one event on that day
            if(!minHeap.isEmpty()){
                minHeap.poll();
                res++;
            } 
        }

        return res;
    }
}