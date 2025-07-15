import java.util.*;
class Touple{
    int row;
    int col;
    int length;

    Touple(int row, int col, int length){
        this.row=row;
        this.col=col;
        this.length=length;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if(grid[0][0]==1)
        return -1;

        if(grid[m-1][n-1]==1)
        return -1;

        if(m==1 && n==1 && grid[0][0]==0)
        return 1;


        PriorityQueue<Touple> pq = new PriorityQueue<>((x,y)->x.length-y.length);
        int[][] dis = new int[m][n];

        for(int[] arr : dis)
        Arrays.fill(arr,Integer.MAX_VALUE);

        dis[0][0]=0;

        pq.offer(new Touple(0,0,0));

        int[] delR = {-1, 0, 1, 0, -1, -1, 1, 1};  
        int[] delC = {0, 1, 0, -1, -1, 1, 1, -1};

        while(!pq.isEmpty()){
            Touple t = pq.poll();
            int row = t.row;
            int col = t.col;
            int length=t.length;

            if(row==m-1 && col==n-1)
            return length+1;

            for(int i=0;i<8;i++){
                int newR = delR[i]+row;
                int newC = delC[i]+col;
                int newLength = length+1;

                if(newR>=0 && newC>=0 && newR<m && newC<n && grid[newR][newC]==0 && newLength<dis[newR][newC]){
                    dis[newR][newC]=newLength;
                    pq.offer(new Touple(newR,newC,newLength));
                }
            }
        }
        return -1;
    }
}