import java.util.*;
class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
         Arrays.sort(happiness);
        long ans =0;
        int j = 0; 
        int l=happiness.length -1;
        
        while(k-- >0){
            if(happiness[l] - j >0){
            ans = ans+happiness[l]-j;
            j++;
            l--;   
            }
        }
        return ans;
    }
}