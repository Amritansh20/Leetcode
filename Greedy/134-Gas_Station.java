/*
    This is brute force
    T.C - O(n^2)
 */
class Solution {
    public boolean canMakeIt(int[] gas, int[] cost, int startIndex, int n){
        int gasPresent=gas[startIndex]-cost[startIndex];

        int i=(startIndex+1)%n;
        
        while(i!=startIndex){
            gasPresent += gas[i];

            if(gasPresent>=cost[i]){
                gasPresent -= cost[i];
                i = (i+1)%n;
            }else{
                return false;
            }

        }
        return i==startIndex;
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for(int i=0;i<n;i++){
            if(gas[i]<cost[i])
            continue;

            if(canMakeIt(gas,cost,i,n))
            return i;
        }
        return -1;
    }
}


// Optimized - O(n);
class Solutions {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank =0;
        int currentTank =0;
        int start=0;

        for(int i=0;i<gas.length;i++){
            int gain = gas[i]-cost[i];
            totalTank += gain;
            currentTank += gain;

            if(currentTank<0){
                currentTank =0;
                start = i+1;
            }
        }
        return totalTank>=0 ? start : -1;
    }
}