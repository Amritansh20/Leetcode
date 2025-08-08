import java.util.*;
class Solution {
    int count =0;

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
    public void solve(int n,List<String> board, int row){
        if(row==n){
            count++;
            return;
        }

        for(int col=0;col<n;col++){
            if(isValid(board,col,row)){
                StringBuilder currRow = new StringBuilder(board.get(row));
                currRow.setCharAt(col,'Q');
                board.set(row,currRow.toString());
                solve(n,board,row+1);
                currRow.setCharAt(col,'.');
                board.set(row,currRow.toString());
            }
        }
    }
    public int totalNQueens(int n) {
        
        List<String> board = new ArrayList<>();
        
        if(n==0)
        return 0;

        for(int i=0;i<n;i++){
            StringBuilder str = new StringBuilder();
            for(int j=0;j<n;j++){
                str.append('.');
            }   
            board.add(str.toString());
        }

        solve(n,board,0);
        return count;
    }
}