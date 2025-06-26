import java.util.*;
class Solution {
    public int minCost(int n, int[] cuts) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        for(int i=0;i<cuts.length;i++)
        list.add(cuts[i]);

        list.add(n);
        Collections.sort(list);        
        int c = cuts.length;
        int dp[][] = new int[c+2][c+2];
        
        for(int[] arr:dp)
        Arrays.fill(arr,0);

        for(int i=c;i>=1;i--){
            for(int j=1;j<=c;j++){
                if(i>j) continue;
                int mini = Integer.MAX_VALUE;
                for(int k=i;k<=j;k++){
                    int cost = list.get(j+1)-list.get(i-1)+ dp[i][k-1]+dp[k+1][j];
                    mini = Math.min(mini,cost);
                }
                dp[i][j]= mini;
            }
        }
        return dp[1][c];
    }
}