class Solution {
    public int findMin(int[] arr) {
        int low=0;
        int high = arr.length-1;
        int min = Integer.MAX_VALUE;

        while(low<=high){

            while(low< arr.length-1 && arr[low]==arr[low+1])
            low++;

            while(high>0  && arr[high]==arr[high-1])
            high--;

            int mid = low + (high-low)/2;

            if(arr[low]<=arr[mid]){
                min = Math.min(arr[low],min);
                low=mid+1;
            }else{
                min = Math.min(arr[mid],min);                
                high=mid-1;
            }
        }
        return min;
    }
}