/* Approach -> three states 1. index 
                            2. k
                            3. prev_end_day 

If you sort the array based on start time you will have 3 parameters, if you don't sort and          blindly take/not_take you have to add prev_start_day as well which will make it a four parameter.
T.C =  (n^4)

Now, even when you go for memoization you will have to take 3 parameter and since constraints are large it will Memory exceeded. (3rd submission)

Now what is the solution?
1st - Sort the array based on start time.
2nd - Start your recurrsion based on take/ not_take
3rd - In order to pick the next event use binary serach
4th - Nothing to do when you are not_picking
*/
import java.util.*;
class Event{
    int startDay;
    int endDay;
    int value;

    Event(int startDay, int endDay, int value){
        this.startDay=startDay;
        this.endDay=endDay;
        this.value = value;
    }
}
class Solution {
    public int findNextEvent(Event[] eventArray, int start, int currEndDay){
        int end = eventArray.length-1;
        int ans = eventArray.length;

        while(start<=end){
            int mid = start + (end-start)/2;

            if(eventArray[mid].startDay>currEndDay){
                ans = mid;
                end = mid-1;
            }else{
                start=mid+1;
            }
        }
        return ans;
    }
    public int solve(Event[] eventArray, int index, int k, int[][] dp){
        if(index>=eventArray.length || k<=0)
        return 0;

        if(dp[index][k]!=-1)
        return dp[index][k];

        int nextEvent = findNextEvent(eventArray,index+1,eventArray[index].endDay);
        int taken = eventArray[index].value + solve(eventArray,nextEvent,k-1,dp);
        int not_taken = solve(eventArray,index+1,k,dp);

        return dp[index][k]= Math.max(taken,not_taken);
    }
     public int maxValue(int[][] events, int k){
        int n = events.length;
        Event[] eventArray = new Event[n];

        for(int i=0;i<n;i++){
            eventArray[i] = new Event(events[i][0],events[i][1],events[i][2]);
        }

        int[][] dp = new int[n+1][k+1];
        for(int[] arr:dp)
        Arrays.fill(arr,-1);

        Arrays.sort(eventArray,(a,b)->a.startDay-b.startDay);
        return solve(eventArray,0,k,dp);
    }
}