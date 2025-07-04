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
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] vis = new int[m][n];
        ArrayDeque<Pair> q = new ArrayDeque<>();

        for(int i=0;i<n;i++){
            if(board[0][i]=='O'){
                q.offer(new Pair(0,i));
                vis[0][i]=1;
            }
        }

        for(int i=0;i<n;i++){
            if(board[m-1][i]=='O'){
                q.offer(new Pair(m-1,i));
                vis[m-1][i]=1;
            }
        }

        for(int i=0;i<m;i++){
            if(board[i][0]=='O'){
                q.offer(new Pair(i,0));
                vis[i][0]=1;
            }
        }

        for(int i=0;i<m;i++){
            if(board[i][n-1]=='O'){
                q.offer(new Pair(i,n-1));
                vis[i][n-1]=1;
            }
        }

        int[] delR = {0,1,0,-1};
        int[] delC = {1,0,-1,0};

        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.row;
            int c = p.col;

            for(int i=0;i<4;i++){
                int newR = delR[i]+r;
                int newC = delC[i]+c;

                if(newR>=0 && newC>=0 && newC<n && newR<m && board[newR][newC]=='O' && vis[newR][newC]==0){
                    q.offer(new Pair(newR,newC));
                    vis[newR][newC]=1;
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(vis[i][j]+" ");
            }
            System.out.println();
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O' && vis[i][j]==0)
                board[i][j]='X';
            }
        }
    }
}