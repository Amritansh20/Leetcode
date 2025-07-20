/*
    Sorting logic - If you sort on the basis of only start time
    then few cases will fail but mostly work

    If Test - [1,2] [1,4] [3,4]
    This is sorted by start time 
    If I apply my logic here I will get two as my ans. 
    as [3,4] will be consumed by [1,4]

    but If you notice [1,2] will also get consumed by [1,4]
    So, ideally my ans should have been 1.

    So for this reason 
    you havse to sort on ascending order on start time and 
    if start time is same then decending order by end time.
 */
import java.util.*;
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        int[] interval = new int[2];
        interval = intervals[0];

        int count =0;
        for(int i=1;i<intervals.length;i++){
            if(interval[0]<=intervals[i][0] && interval[1]>=intervals[i][1]){
                count++;
            }else{
                interval= intervals[i];
            }
        }
        return intervals.length-count;
    }
}