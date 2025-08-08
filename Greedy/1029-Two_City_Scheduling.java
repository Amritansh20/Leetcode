/*
    It is difficult to understand at first. Upon hit and trial 
    we observe somewhat different sorting logic.

    Sort arrays based on difference of abs(arr[i][0]-arr[i][1])

    Once you figure out this it's smooth.

    T.c - O(n logn)
 */
import java.util.*;
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length;
        Arrays.sort(costs,(a,b)->(Math.abs(b[0]-b[1]))-(Math.abs(a[0]-a[1])));
        int cityA=0;
        int cityB=0;
        int total =0;
        for(int i=0;i<costs.length;i++){
            if(costs[i][0]<costs[i][1]){
                if(cityA< n/2){
                    total += costs[i][0];
                    cityA++;
                }else{
                    total+= costs[i][1];
                    cityB++;
                }
                
            }else{
                if(cityB< n/2){
                    total += costs[i][1];
                    cityB++;
                }else{
                    total+= costs[i][0];
                    cityA++;
                }
            }
        }
        return total;
    }
}