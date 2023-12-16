class Solution {

    public static int findSum(int[] arr){
        int sum=0;

        for(int i=0;i<arr.length;i++){
            sum+= arr[i];
        }
        return sum;
    }

    public static Boolean sumAfterDivision(int[] arr, int limit, int mid){
        int reqSum=0;

        for(int i=0;i<arr.length;i++){
            reqSum += Math.ceil((double)arr[i]/(double)mid);
        }
        
        if(reqSum<=limit)
        return true;

        return false;

    }
    public static int smallestDivisor(int arr[], int limit) {
        // Write your coder here
        int low =1;
        int high = findSum(arr);

        while(low<=high){
            int mid = low + (high-low)/2;
           
            if(sumAfterDivision(arr, limit, mid))
            high=mid-1;
            else
            low=mid+1;
        }
        return low;
    }
}