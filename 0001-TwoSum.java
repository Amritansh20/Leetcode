import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> mpp = new HashMap<>();
        int ans[] = new int[2];

        for(int i=0;i<nums.length;i++){
            int first = nums[i];
            int required = target-first;
             if(mpp.containsKey(required)){
                 ans[0]=i;
                ans[1] = mpp.get(required);
                break;
             }
            mpp.put(nums[i],i);
        }
        return ans;
    }
}

/*
Complexity Analysis:

Time complexity : O(n). We traverse the list containing nn elements only once. Each look up in the table costs only O(1)O(1) time.

Space complexity : O(n). The extra space required depends on the number of items stored in the hash table, which stores at most nn elements.

*/