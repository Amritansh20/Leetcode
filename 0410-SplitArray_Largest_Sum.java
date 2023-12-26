import java.util.*;
class Solution {

    public int countDivision(int[] nums,int allowedSum){
        int reqNum =1;
        long sumHolding=0;
        for(int i=0;i<nums.length;i++){
            if(sumHolding+nums[i]<=allowedSum)
            sumHolding+= nums[i];
            else{
                reqNum++;
                sumHolding=nums[i];
            }
        }
        return reqNum;
    }
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        
        if(k>n)
        return -1;
        
        int low = Arrays.stream(nums).max().getAsInt();
        int high = Arrays.stream(nums).sum();

        while(low<=high){
            int mid = low + (high-low)/2;
            int reqNum = countDivision(nums,mid);

            if(reqNum>k)
            low = mid+1;
            else
            high = mid-1;
        }
        return low;
    }
}


/*TC-> O(logn)  SC-> O(1) */