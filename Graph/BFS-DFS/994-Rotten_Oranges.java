/*
    This is classcal BFS on graph.

    Approach: We define out own DS of touple to store few info like row,col,time.

    Initial config: 
        Take a queue and fill it with the date where oranges are rotten in time 0.

        One by one take the rotten oranges out and check in 4 direction. 
        If you find any oranges present mark it visited and push it in queue.
        These oranges are now rotten. 

    T.C- O(m*n) to find rotten oranges 
         BFS - Each cell is enqueed at most once and we check its 4 direction- O(4*m*n)
         At last we are finding is there is any frest oranges left O(n*m)(worst if (m-1,n-1) cell has 
         fresh orange.

    S.C -> O(m*n) for visited array 
            At worst all the cells will be in the queue so for queue O(m*n)

 */

import java.util.*;

class Touple{
    int x;
    int y;
    int time;

    Touple(int x, int y, int time){
        this.x=x;
        this.y=y;
        this.time=time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        ArrayDeque<Touple> q = new ArrayDeque<>();
        int[][] vis = new int[grid.length][grid[0].length];
        for(int[] arr : vis)
        Arrays.fill(arr,-1);

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    vis[i][j]=1;
                    q.offer(new Touple(i,j,0));
                }
            }
        }

        int[] delR = {0,1,0,-1};
        int[] delC = {1,0,-1,0};

        int totalTime=0;
        while(!q.isEmpty()){
            Touple t = q.poll();
            int x = t.x;
            int y = t.y;
            int time = t.time;

            totalTime =time;

            for(int i=0;i<4;i++){
                int newR=x+delR[i];
                int newC=y+delC[i];
                if(newR>=0 && newC>=0 && newR<m && newC<n && grid[newR][newC]==1 && vis[newR][newC]==-1 ){
                    vis[newR][newC]=1;
                    q.offer(new Touple(newR,newC,time+1));
                }
            }
        }

         for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(grid[i][j]==1 && vis[i][j]==-1)
                    return -1;
                }
            }

        return totalTime;
    }
}