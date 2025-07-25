/*
    Took 3-4 hours to solve this. 
    Submission 1 -> Did on my own. 50% tests passed

    Submission 2 -> Observed the failed test case. Took hint of 2nd PriorityQueue (available rooms)
    10 tests still failed.

    Submission 3 -> Observed the failed test and finally added the while loop condition to 
    add rooms where meetings has already been ended in available rooms. 

    Time: 
        Sorting - mlogm
        Two Heaps: availableRooms can take n rooms and pq can hold m meetings
        ~ O(m logn)
        Finding answer - O(n)

        ~ O(m logn)

    Space: O(m+n)

 */
import java.util.*;
class Pair{
    int end;
    int room;

    Pair(int end, int room){
        this.end=end;
        this.room=room;
    }
}
class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] rooms = new int[n];
        Arrays.sort(meetings,(a,b)->a[0]-b[0]);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.end==b.end? a.room-b.room:a.end-b.end);
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
       
        for(int i=0;i<n;i++){
            availableRooms.offer(i);
        }

        for(int i=0;i<meetings.length;i++){
            while(!pq.isEmpty() && pq.peek().end<=meetings[i][0])
            availableRooms.offer(pq.poll().room);

            if(pq.isEmpty() || (pq.peek().end>meetings[i][0] && !availableRooms.isEmpty())){
                pq.offer(new Pair(meetings[i][1],availableRooms.peek()));
                rooms[availableRooms.peek()]++;
                availableRooms.poll();
            }else{

                Pair earliestEnd = pq.poll();
                int earliestEndTime = earliestEnd.end;
                int lowestEmptyRoom = earliestEnd.room;

                pq.offer(new Pair(earliestEndTime-meetings[i][0]+meetings[i][1],lowestEmptyRoom));
                rooms[lowestEmptyRoom]++;
            }
            
        }

        int roomNumber =0;
        int maxMeetings= rooms[0];
        for(int i=1;i<n;i++){
            if(maxMeetings<rooms[i]){
                maxMeetings= rooms[i];
                roomNumber = i;
            }
        }

        for(int i=0;i<n;i++){
            System.out.println(rooms[i]+" ");
        }
        return roomNumber;
    }
}