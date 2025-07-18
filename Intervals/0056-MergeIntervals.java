// T.C - O(n logn) + O(n)
//SC - O(n)
import java.util.*;
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int[] curr = intervals[0];
        List<int[]> ans = new ArrayList<>();

        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<= curr[1]){
                curr[0] = Math.min(intervals[i][0],curr[0]);
                curr[1]= Math.max(intervals[i][1],curr[1]);
            }else{
                ans.add(curr);
                curr = intervals[i];
            }
        }
        ans.add(curr);
        return ans.toArray(new int[ans.size()][]);
    }
}