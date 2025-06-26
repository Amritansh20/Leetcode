/*
    This problem is extension of LC-907 Sum of Subarray Minimums.
    In LC 907 we found NSE and PSE in order to find the sum of minimums in all subarray.

    Here we did that. We found the sum of all minimum elements from all subarrays.
    Additionaly we(NGE and PGE) found the sum of all maximums from all subarrays. 
    and returned the diff. 

    T.C - O(n)
    S.C - O(n)
*/
import java.util.*;
class Solution {
    public int[] NSE(int[] nums){
        int n = nums.length;
        int[] nse = new int[n];
        Arrays.fill(nse,n);
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && nums[i]<=nums[stack.peek()]){
            nse[stack.peek()]=i;
            stack.pop();
            }

            stack.push(i);
        }
        return nse;
    }
    public int[] PSE(int[] nums){
        int n = nums.length;
        int[] pse = new int[n];
        Arrays.fill(pse,-1);
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && nums[i]<nums[stack.peek()]){
            pse[stack.peek()]=i;
            stack.pop();
            }

            stack.push(i);
        }
        return pse;
    }

    public int[] NGE(int[] nums){
        int n = nums.length;
        int[] nge = new int[n];
        Arrays.fill(nge,n);
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && nums[i]>=nums[stack.peek()]){
                nge[stack.peek()]=i;
                stack.pop();
            }

            stack.push(i);
        }
        return nge;
    }

    public int[] PGE(int[] nums){
        int n = nums.length;
        int[] pge = new int[n];
        Arrays.fill(pge,-1);
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && nums[i]>nums[stack.peek()]){
                pge[stack.peek()]=i;
                stack.pop();
            }

            stack.push(i);
        }
        return pge;
    }

    public long subArrayRanges(int[] nums) {
        int[] nge = NGE(nums);    
        int[] pge = PGE(nums);    
        int[] nse = NSE(nums);    
        int[] pse = PSE(nums);

        long maxDiff=0;
        long minDiff=0;
        for(int i=0;i<nums.length;i++){
            long leftForMax = i-pge[i];
            long rightForMax = nge[i]-i;

            long leftForMin = i-pse[i];
            long rightForMin= nse[i]-i;

            maxDiff += (leftForMax*rightForMax*nums[i]);
            minDiff += (leftForMin*rightForMin* nums[i]);
            
        }    
        return Math.abs(maxDiff-minDiff);
    }
}