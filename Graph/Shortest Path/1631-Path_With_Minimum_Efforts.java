/*
    This is a variation of Kruskal.
    The only differnece here is how we are mintainign our path. 
    Q might seems confusing at first but it's not if you dry run.
    
    We are keeping the track of Min(max of (diff till now, new diff between two cells));
    The moment when priority queue polls the mth row and nth col  we know this diff is our answer as it polls 
    the min diff in eahc iteration.

    Now - dis[m-1][n-1] might get populated via diff path but if we are not getting mth row and nth col it 
    means there is soem other path which holds better results.

    T.C - ElogV
    S.C - O(m*n) for dis matrix 
          O(m*n) for PQ

 */

import java.util.*;
class Touple{
    int x;
    int y;
    int diff;
    Touple(int x, int y, int diff){
        this.x=x;
        this.y=y;
        this.diff=diff;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        PriorityQueue<Touple> q = new PriorityQueue<>((a,b)->a.diff-b.diff);
        q.offer(new Touple(0,0,0));

        int[][] dis = new int[m][n];
        
        for(int[] arr : dis)
        Arrays.fill(arr,Integer.MAX_VALUE);

        dis[0][0]=0;

        int[] delR = {-1,0,1,0};
        int[] delC = {0,1,0,-1};

        while(!q.isEmpty()){
            Touple t = q.poll();
            int x = t.x;
            int y=t.y;
            int diff = t.diff;

            if(x==m-1 && y==n-1)
            return diff;

            for(int i=0;i<4;i++){
                int nRow = delR[i]+x;
                int nCol = delC[i]+y;

                if(nRow>=0 && nCol>=0 && nRow<m && nCol<n && dis[nRow][nCol] > Math.max(diff,Math.abs(heights[x][y]-heights[nRow][nCol]))){
                    dis[nRow][nCol]= Math.max(diff,Math.abs(heights[x][y]-heights[nRow][nCol]));
                    q.offer(new Touple(nRow,nCol,Math.max(diff,Math.abs(heights[x][y]-heights[nRow][nCol]))));
                }
            }
        }
        return -1;
    }
}