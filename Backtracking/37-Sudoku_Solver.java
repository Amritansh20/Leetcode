/*
    Time:
        Initializing the set: O(n^2) where n=9 so, O(81) i.E O(1)
        Backtracking- Each empty cell has 9 choices. 
        so O(9^ number of empty cells)
        Worst number of empty cells could be 81.
        O(9^81) ~ O(1)
 */

 import java.util.*;
class Solution {
    public boolean solve(char[][] board, int r, int c, Set<String> set){
        if(r==9)
        return true;

        if(c==9)
        return solve(board,r+1,0,set);

        if(board[r][c]!='.')
        return solve(board,r,c+1,set);

        for(int num=1;num<=9;num++){
            char ch = (char) (num+'0');

            if(set.contains(ch+"r"+r) || set.contains(ch+"c"+c) || set.contains(ch+"b"+(r/3)+(c/3)))
            continue;

            board[r][c]=ch;
            set.add(ch+"r"+r);
            set.add(ch+"c"+c);
            set.add(ch+"b"+(r/3)+(c/3));

            if(solve(board,r,c+1,set))
            return true;

            board[r][c]='.';
            set.remove(ch+"r"+r);
            set.remove(ch+"c"+c);
            set.remove(ch+"b"+(r/3)+(c/3));
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        Set<String> set = new HashSet<>();

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    set.add(board[i][j]+"r"+i);
                    set.add(board[i][j]+"c"+j);
                    set.add(board[i][j]+"b"+(i/3)+(j/3));
                }
            }
        }
        solve(board,0,0,set);
    }
}