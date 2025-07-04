import java.util.*;
class Pair{
    int x;
    int y;
    int dist;

    Pair(int x, int y, int dist){
        this.x=x;
        this.y=y;
        this.dist=dist;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        ArrayDeque<Pair> q = new ArrayDeque<>();
        int[][] vis = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.offer(new Pair(i,j,0));
                    vis[i][j]=1;
                }
            }
        }

        int[] delR = {0,1,0,-1};
        int[] delC = {1,0,-1,0};

        while(!q.isEmpty()){
            Pair p = q.poll();
            int r=p.x;
            int c =p.y;
            int dist =p.dist;

            for(int i=0;i<4;i++){
                int newR=r+delR[i];
                int newC = c+delC[i];

                if(newR>=0 && newC>=0 && newR<m && newC<n && vis[newR][newC]==0 && mat[newR][newC]==1){
                    mat[newR][newC] = dist+1;
                    q.offer(new Pair(newR,newC,dist+1));
                    vis[newR][newC]=1;
                }
            }
        }
        return mat;
    }
}