/*
    This is not ans easy problem to figure out. 
    Question is understandable but feels stuck when you approach it. 
    Felt like DP on first glace. But it's sliding window.

    Idea-  
        When we slide one meeting(to make it consecutive) we combine two free spots. 
        If we combine k meeting we will combine k+1 free spots.

        Now if we make an array of all free spots and find out the max sum of k+1 size 
        by using sliding window we can get our ans.

        Coming up with this pattern was difficult.
 */

 import java.util.*;
class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n =  startTime.length;
        List<Integer> gaps = new ArrayList<>();

        gaps.add(startTime[0]);

        for(int i=1;i<n;i++){
            gaps.add(startTime[i]-endTime[i-1]);
        }

        gaps.add(eventTime-endTime[n-1]);

        int left=0;
        int right=0;
        int sum=0;
        int maxSum=0;
        
        while(right<gaps.size()){
            sum += gaps.get(right);

            if(right-left+1 ==k+1){
                maxSum = Math.max(maxSum,sum);
                sum -= gaps.get(left);
                left++;
            }
            right++;
        }
        return maxSum;
    }
}