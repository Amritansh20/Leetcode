class Solution {
    public int solve(int[][] grid){
        int n = grid.length;
        int zeroX =0, oneX=0, twoX=0;        
        int zeroY =0, oneY=0, twoY=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if((i<=n/2 && i==j) || (i<=n/2 && i+j==n-1) || (i>n/2 && j== n/2)){
                    if(grid[i][j] !=0) zeroY++;
                    if(grid[i][j] !=1) oneY++;
                    if(grid[i][j] !=2) twoY++;
                }else{
                    if(grid[i][j] !=0) zeroX++;
                    if(grid[i][j] !=1) oneX++;
                    if(grid[i][j] !=2) twoX++;
                }
            }   
     }
     int[] candidates = {oneX+twoY, oneX+zeroY, twoX+zeroY, twoX+oneY, zeroX+oneY,zeroX+twoY};
     int ans = Integer.MAX_VALUE;
     for(int pos : candidates)
     ans = Math.min(ans,pos);

     return ans;
    }
    public int minimumOperationsToWriteY(int[][] grid) {
        return solve(grid);
    }
}