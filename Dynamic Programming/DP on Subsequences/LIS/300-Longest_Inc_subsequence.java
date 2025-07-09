/*
    State
    dp[i] - max length of LCS ending at index i;

    Transition-
    From every element behind dp[i] has possibility to extend it's subsequence 
    if nums[i] > nums[j] j>=0 && j<i
    
    I update dp[i] = max(dp[i],1+dp[j])

    Final subproblem-
    We keep the track of max dp[i]

    T.C - O(n^2)
    S.C - O(n)

 */
import java.util.*;
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        Arrays.fill(dp,1);
        int maxLen=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],1+dp[j]);
                }
            }
            maxLen = Math.max(maxLen,dp[i]);
        }
        return maxLen;
    }
}

/*
    Idea - 
    10,9,2,5,3,7,101,18

    list1 = {10,101}
    list2 ={9,101}
    list3= {2,5,7,101} // ans
    list4 = {3,7,101}
    list5 ={18}

    What are we doing? 
    We are checking the the array element with the last element of list, if it is 
    greater we add pushing it. if not the creating a new list starting with current element.

    We element is greater than last element of multiple lists , we add in all. 

    We cannot create so many lists so took advantage of the place where the incoming number would lie.

    T.C - O(nlogn)
    S.C - O(n)
 */
class Solutions {
    public int lowerBound(List<Integer> list, int element){
        int low=0;
        int high = list.size()-1;

        while(low<=high){
            int mid = low + (high-low)/2;

            if(element>list.get(mid))
            low=mid+1;
            else 
            high = mid-1;
        }
        return low;
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        int len=1;

        for(int i=1;i<n;i++){
            if(nums[i]>list.get(list.size()-1)){
                list.add(nums[i]);
                len++;
            }else{
                int index = lowerBound(list,nums[i]);
                list.set(index,nums[i]);
            }
        }
        return len;
    }
}