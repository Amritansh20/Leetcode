class Solution {
    public int findDuplicate(int[] nums) {
        int low=0;
        int high= nums.length-1;
        
        while(low<=high){
        int count=0;
        int mid = low + (high-low)/2;

            for(int i=0;i<nums.length;i++){
               
                if(nums[i]<=mid)
                count++;
            }   

            if(count<=mid)
            low = mid+1;
            else
            high=mid-1;
        }
        return low;
    }
}

/* TC-> O(logN)  SC-> O(1)*/