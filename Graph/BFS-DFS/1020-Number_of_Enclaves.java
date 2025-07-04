import java.util.*;
class Pair{
    int row;
    int col;

    Pair(int row, int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        ArrayDeque<Pair> q = new ArrayDeque<>();

        for(int i=0;i<n;i++){
            if(grid[0][i]==1){
                q.offer(new Pair(0,i));
                vis[0][i]=1;
            }
        }

        for(int i=0;i<n;i++){
            if(grid[m-1][i]==1){
                q.offer(new Pair(m-1,i));
                vis[m-1][i]=1;
            }
        }

        for(int i=0;i<m;i++){
            if(grid[i][0]==1){
                q.offer(new Pair(i,0));
                vis[i][0]=1;
            }
        }

        for(int i=0;i<m;i++){
            if(grid[i][n-1]==1){
                q.offer(new Pair(i,n-1));
                vis[i][n-1]=1;
            }
        }

        int[] delR = {0,1,0,-1};
        int[] delC = {1,0,-1,0};

        while(!q.isEmpty()){
            Pair p = q.poll();
            int row = p.row;
            int col = p.col;

            for(int i=0;i<4;i++){
                int newR = row+delR[i];
                int newC = col+delC[i];

                if(newR>=0 && newC>=0 && newR<m && newC<n && grid[newR][newC]==1 && vis[newR][newC]==0){
                    vis[newR][newC]=1;
                    q.offer(new Pair(newR,newC));
                }
            }
        }
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && vis[i][j]==0)
                count++;
            }
        }
        return count;
    }
}