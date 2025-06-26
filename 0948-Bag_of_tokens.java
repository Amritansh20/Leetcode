import java.util.*;

class Solution {
    public static boolean isPossible(int token, int power){
        if(power>=token)
        return true;
        else
        return false;
    }
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int n = tokens.length;
        int i=0;
        int j=n-1;
        int score =0;
        while(i<=j){

            if(i==j && isPossible(tokens[i],power)==false){
                i++;
                continue;
            }

            if(isPossible(tokens[i],power)==true){
                score++;
                power -= tokens[i];
                i++;
            }else if(score!=0){
                power+= tokens[j];
                j--;
                score--;
            }else{
                i++;
            }

        }
        return score;
    }
}