class Solution {
    static int dp[][] = new int[101][101];
    public static int recur(int row,int col){
        if(row==0 && col==0)
        return 1;

        if(row<0 || col<0)
        return 0;

        if(dp[row][col]!=-1) return dp[row][col];

        int up = recur(row-1,col);
        int left = recur(row,col-1);

        return dp[row][col]=up+left;
    }
    public int uniquePaths(int m, int n) {
        for(int i=0;i<101;i++){
            for(int j=0;j<101;j++){
                dp[i][j]=-1;
            }
        }
        return recur(m-1,n-1);
    }
}