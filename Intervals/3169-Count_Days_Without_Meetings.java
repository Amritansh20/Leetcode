/*
    This is a variation of merge interval.
    Sort the metting and merge overlapping meetings.

    Count all the days in which there is meetings and subtract it from total days.

    T.C -> O(nlogn) for sorting
            O(n) for merging 
            O(n) for finding ans
    S.C -> O(n);
 */
import java.util.*;
class Solution {
    public void merge(int[][] meetings, List<int[]> modifiedMeeting){
        Arrays.sort(meetings,(a,b)->a[0]-b[0]);
        int[] interval = meetings[0];

        for(int i=1;i<meetings.length;i++){
            if(interval[1]>=meetings[i][0]){
                interval[0] = Math.min(interval[0],meetings[i][0]);
                interval[1] = Math.max(interval[1],meetings[i][1]);
            }else{
                modifiedMeeting.add(interval);
                interval = meetings[i];
            }
        }
        modifiedMeeting.add(interval);
    }
    public int countDays(int days, int[][] meetings) {
        List<int[]> modifiedMeeting = new ArrayList<>();
        merge(meetings,modifiedMeeting);
        int meetingDays = 0;

        for(int i=0;i<modifiedMeeting.size();i++){
            System.out.println(modifiedMeeting.get(i)[0] +", "+modifiedMeeting.get(i)[1]);
        }
        for(int i=0;i<modifiedMeeting.size();i++){
            meetingDays += (modifiedMeeting.get(i)[1]-modifiedMeeting.get(i)[0]+1);
        }


        return days-meetingDays;
    }
}