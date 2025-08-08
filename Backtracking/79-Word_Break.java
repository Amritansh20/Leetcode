/*
    T.C - O(m*n*4^L)
    S.C - O(n*m) ignoring recurrsin stack space
 */
class Solution {
    public boolean solve(int row, int col, char[][] board, String word, int[] delR,int[] delC, int[][] vis, int index){
        
        if(index==word.length())
        return true;

        for(int i=0;i<4;i++){
            int newR = delR[i]+row;
            int newC = delC[i]+col;

            if(newR>=0 && newC>=0 && newR<board.length && newC<board[0].length && vis[newR][newC]==0 && board[newR][newC]==word.charAt(index)){
                vis[newR][newC]=1;
                if(solve(newR,newC,board,word,delR,delC,vis,index+1))
                return true;
                vis[newR][newC]=0;
            }
        }
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        int[] delR = {-1,0,1,0};
        int[] delC = {0,1,0,-1};
        int[][] vis = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
                    vis[i][j]=1;
                    if(solve(i,j,board,word,delR,delC,vis,1))
                    return true;
                    vis[i][j]=0;
                }
            }
        }
        return false;
    }
}