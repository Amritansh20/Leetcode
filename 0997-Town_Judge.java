class Solution {
    public int findJudge(int n, int[][] trust) {
        int arr[] = new int[n+1];
        for(int i=0;i<trust.length;i++){
            if(trust[i][0]!=trust[i][1]){
                arr[trust[i][1]]++;
            }
        }
        int candidate =-1;
        for(int i=0;i<n+1;i++){
            if(arr[i]==n-1)
            candidate =i;
            for(int j=0;j<trust.length;j++){
                if(trust[j][0]==candidate){
                    candidate =-1;
                    break;
                }
                
         }   
        }
        return candidate;
    }
}