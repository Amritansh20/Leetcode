/*
    T.C  O(n!)
    S.C - O(n^2)
 */
import java.util.*;
class Solution {
    public boolean isValid(List<String> board, int col, int row){
        int n = board.size();
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(board.get(i).charAt(j)=='Q')
            return false;
        }

        for(int i=row-1,j=col+1;i>=0&&j<n;i--,j++){
            if(board.get(i).charAt(j)=='Q')
            return false;
        }

        for(int i=row-1;i>=0;i--){
            if(board.get(i).charAt(col)=='Q')
            return false;
        }
        return true;
    }
    public void solve(int n, List<List<String>> ans, List<String> board, int row){
        if(row==n){
            ans.add(new ArrayList<>(board));
            return;
        }

        for(int col=0;col<n;col++){
            if(isValid(board,col,row)){
                StringBuilder currRow = new StringBuilder(board.get(row));
                currRow.setCharAt(col,'Q');
                board.set(row,currRow.toString());
                solve(n,ans,board,row+1);
                currRow.setCharAt(col,'.');
                board.set(row,currRow.toString());
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> board = new ArrayList<>();
        
        if(n==0)
        return ans;

        for(int i=0;i<n;i++){
            StringBuilder str = new StringBuilder();
            for(int j=0;j<n;j++){
                str.append('.');
            }   
            board.add(str.toString());
        }

        solve(n,ans,board,0);
        return ans;
    }
}