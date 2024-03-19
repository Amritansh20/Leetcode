import java.util.*;
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int start = newInterval[0];
        int end = newInterval[1];
        boolean inserted = false;

        for(int[] interval : intervals){
            int nStart = interval[0];
            int nEnd = interval[1];

            if(nEnd < start || inserted){
                ans.add(new int[]{nStart,nEnd});
                continue;
            }

            start = Math.min(start,nStart);
            if(end<nStart){
                ans.add(new int[]{start,end});
                ans.add(new int[] {nStart,nEnd});
                inserted=true;
                continue;
            }
            if(end <=nEnd){
                ans.add(new int[]{start,nEnd});
                inserted = true;
            }
        }

        if(inserted!=true){
            ans.add(new int[] {start,end});
        }

        return ans.toArray(new int[ans.size()] []);
    }   
}