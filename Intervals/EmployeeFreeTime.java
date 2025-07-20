/*
    schedule = [
    [[1,3],[6,7]],
    [[2,4]],
    [[2,5],[9,12]]
    ].

    Every inner 2D array tells us the schdule if an employee on a 
    particulat day. 
    there are 3 employees.

    Approach -> 
    1- Flatten all the intervals in one List<int[]>
   
    2-Sort the list based on start time.
    [[1,3],[2,4],[2,5],[6,7],[9,12]]
   
    3-Merge overlap intervals.
    [[1,5],[6,7],[9,12]]

    Now from merged list. you can easily identify the gaps.

 */

import java.util.*;

public class EmployeeFreeTime {
    public int[][] mergeInterval(int[][] allIntervals){
        int[] interval = new int[2];
        interval = allIntervals[0].clone();
        List<int[]> ans = new ArrayList<>();

        for(int i=1;i<allIntervals.length;i++){
            if(allIntervals[i][0]<=interval[1]){
                interval[0] = Math.min(interval[0],allIntervals[i][0]);
                interval[1] = Math.max(interval[1], allIntervals[i][1]);
            }else {
                ans.add(interval);
                interval=allIntervals[i].clone();
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
    public int[][] getFreeTime(int[][][] schedule){
        List<int[]> mergedSchdule = new ArrayList<>();
        List<int[]> ans = new ArrayList<>();
        
        for(int i=0;i<schedule.length;i++){
            for(int j=0;j<schedule[i].length;j++){
                mergedSchdule.add(schedule[i][j]);
            }
        }


        int[][] allIntervals = new int[mergedSchdule.size()][2];
        allIntervals=mergedSchdule.toArray(new int[mergedSchdule.size()][]);    
        Arrays.sort(allIntervals,(a,b)->a[0]-b[0]);
        int[][] mergedInterval=mergeInterval(allIntervals);

        for(int i=0;i<mergedInterval.length-1;i++){
            int[] freeTime = new int[2];
            freeTime[0] = mergedInterval[i][1];
            freeTime[1]=mergedInterval[i+1][0];
            if(freeTime[0]<freeTime[1])
            ans.add(freeTime);
        }



      return ans.toArray(new int[ans.size()][]);
    }
}
