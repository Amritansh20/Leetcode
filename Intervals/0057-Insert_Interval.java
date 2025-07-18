// This approach can only com to your mind once you consider that input is already non
// overlapping.

// This is extension of Merge Intervals.
import java.util.*;
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int i=0;
        while(i<intervals.length){
            if(intervals[i][1]<newInterval[0])
            ans.add(intervals[i]);
            else if(intervals[i][0]>newInterval[1])
            break;
            else{
                newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
                newInterval[1]=Math.max(intervals[i][1],newInterval[1]);
            }
            i++;
        }
        ans.add(newInterval);

        while(i<intervals.length){
            ans.add(intervals[i]);
            i++;
        }
        return ans.toArray(new int[ans.size()][]);
    }
}