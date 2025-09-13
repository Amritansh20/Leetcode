/*
 * This problem can be solved by heap and the solution is prenset in heap folder. 
 * This. can be optimized by binary search
 * 
 */

 import java.util.*;
class Solution {
    public int binarySearch(int[] arr, int target){
        int low =0;
        int high = arr.length-1;

        while(low<=high){
            int mid = low +(high-low)/2;

            if(arr[mid]==target)
            return mid;

            if(arr[mid]>target)
            high=mid-1;
            else
            low=mid+1;
        }
        return low;
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int lowerBound = binarySearch(arr,x);

        int left = lowerBound-1;
        int right = lowerBound;
        
        List<Integer> ans = new ArrayList<>();

        while(k-- >0){
            if(left<0)
            right++;
            else if(right>=arr.length)
            left--;
            else if(Math.abs(arr[left]-x) <= Math.abs(arr[right]-x))
            left--;
            else
            right++;

        }

        System.out.println(lowerBound+","+ left+ "," + right);

        for(int i=left+1;i<right;i++)
        ans.add(arr[i]);

        return ans;
    }
}