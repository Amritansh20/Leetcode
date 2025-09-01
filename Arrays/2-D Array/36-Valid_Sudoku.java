/*
    Since board size is always 9*9
    There will be 81 iterations. So,over all time is O(1);

    S.C -> Set can contains add upto 243 elements in wort case. 
        3 entries for each cell.
        Space : O(1)
 */
import java.util.*;
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                char element = board[i][j];

                if(element =='.')
                continue;

                String rPos = element+"-"+i;
                String cPos = element+"_"+j;
                String cubePos = element+"_"+(i/3)+"_"+(j/3);
                
                if(set.contains(rPos))
                return false;

                if(set.contains(cPos))
                return false;

                if(set.contains(cubePos))
                return false;

                set.add(rPos);
                set.add(cPos);
                set.add(cubePos);
            }
        }
        return true;
    }
}