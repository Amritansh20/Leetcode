class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int low=0;
        int high=n-1;

        while(low<=high){
            int mid = low + (high-low)/2;

            if(citations[mid]== n-mid)
            return n-mid;
            else if(citations[mid] < n-mid)
            low = mid+1;
            else
            high=mid-1;
        }
        return n-low;
    }
}

/*TC -> O(log n)  SC-> O(1) */