// Given a 2D array arr[][], where arr[i][0] is the starting time 
// of ith meeting and arr[i][1] is the ending time of ith meeting, 
// the task is to check if it is possible for a person to attend 
// all the meetings such that he can attend only one meeting at 
// a particular time.

// Note: A person can attend a meeting if its starting time is 
// greater than or equal to the previous meeting's ending time.

import java.util.*;
class Solution {
    static boolean canAttend(int[][] arr) {
        // code here
        int n = arr.length;
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        
        for(int i=1;i<n;i++){
            if(arr[i][0]<arr[i-1][1])
            return false;
        }
        return true;
    }
}