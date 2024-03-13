class Solution {
    public int pivotInteger(int n) {
        int low=1;
        int high = n;
        int ans =-1;
        int sum = (n*(n+1))/2;

        while(low<=high){
            int mid = low + (high-low)/2;
            int req = (sum + mid)/2;

            int uptoMid = (mid*(mid+1))/2;
            int afterMid = sum - uptoMid +mid;

            if(uptoMid == afterMid)
            return mid;
            else if(uptoMid<req)
            low = mid+1;
            else
            high = mid-1;
        }
        return ans; 
    }
}