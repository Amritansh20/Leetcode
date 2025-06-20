import java.util.ArrayList;
 class Solution {
    public static int search(ArrayList<Integer> arr, int n, int target) {
        // Write your code here.
        int start=0;
        int end =n-1;

        while(start<=end){
            int mid = start + (end-start)/2;

            if(arr.get(mid)==target)
            return mid;

            if(arr.get(start) <= arr.get(mid)){
                if(target >= arr.get(start) && target <= arr.get(mid)){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }else{
                if(target >= arr.get(mid) && target <= arr.get(end)){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
        }
        return -1;
    }
}


// Time - O(logN)
// Space  - O(1)