// User function Template for Java

/*
    Core idea to define weather the island is same or not. 
    We normalize it. 

    1,1,0,1,1
    1,0,0,0,0
    0,0,0,1,1
    1,1,0,1,0

    island = (0,0) (0,1) (1,0) is same as
              (2,3) (2,4) (3,3)

    How to identify? 
    Take the co-cordinates where your island starts as baseR and baseC
    In above case 2,3 is baseR and baseC
    (2,3)-(2,3)=(0,0) C1

    If we encounter (2,4) then 
                    (2,4)-(2,3) = (0,1) C2
    If we encounter (3,3) 
                    (3,3)-(2,3) = (1,0) C3
    
    C1, C2 and C3 is matching with 1st island with (0,0), (0,,1), (1,0)

    
    We store one entire island as a string in set. If similar comes
    it stays one. No double counting.

    T.C - O(m*n)
    We iterate in grid.
    If grid[i][j]==1 and it is not visited we do dfs
    DFS explores 4 directin which is constant. 
    We visit each cell at most once.
    
    
    
    S.C - O(m*n)
 */
import java.util.*;
class Solution {
    public static String toString(int r, int c){
        return Integer.toString(r) +" "+ Integer.toString(c); 
    }
    public static void dfs(int row,int col, int baseRow,int baseCol, int[][] vis, int[][] grid, List<String> list, int[] delR, int[] delC){
        vis[row][col]=1;
        list.add(toString(row-baseRow, col-baseCol));
        
        for(int i=0;i<4;i++){
            int newR = delR[i]+row;
            int newC = delC[i]+col;
            
            if(newR>=0 && newC>=0 && newR<grid.length && newC<grid[0].length && grid[newR][newC]==1 && vis[newR][newC]==0){
                dfs(newR,newC,baseRow,baseCol,vis,grid,list,delR,delC);
            }
        }
        
    }
    int countDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        Set<List<String>> set = new HashSet<>();

        int[][] vis = new int[m][n];
        int[] delR = {0, 1, 0, -1};
        int[] delC = {1, 0, -1, 0};
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    List<String> list = new ArrayList<>();
                    dfs(i,j,i,j,vis,grid,list,delR,delC);
                    set.add(list);
                }
            }
        }
        return set.size();
    }
}
