/*
    Brute Force - 
    For each height you have to expand to left and right in order to find the height smaller than
    the current height.

    for(int i=0;i<n;i++){

        int left=i;
        while(left>=0){
           // Expand
           left--;
        }

        int right =i;
        while(right<n){
            //Expand
            right++
        }

        int width = right-left-1;
        then area. 


        T.C - O(n^2)
        S.C - O(1)        

        What are we doing here? We are finding the next smaller and prev smaller.
        How can we do it efficently? Monotonic stack.
        
        We find index of Next smaller and prev smaller for each height
        width = nse[i]-pse[i]-1;
         
        T.C = O(n)
        S.C = O(n)
    }
*/
import java.util.*;
class Solution {
    public int[] NSE(int[] heights){
        int n = heights.length;
        int[] nse = new int[n];
        Arrays.fill(nse,n);
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && heights[i]<=heights[stack.peek()]){
                nse[stack.peek()]=i;
                stack.pop();
            }
            stack.push(i);
        }
        return nse;
    }

    public int[] PSE(int[] heights){
        int n = heights.length;
        int[] pse = new int[n];
        Arrays.fill(pse,-1);
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && heights[i]<heights[stack.peek()]){
                pse[stack.peek()]=i;
                stack.pop();
            }
            stack.push(i);
        }
        return pse;
    }
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nse = NSE(heights);   
        int[] pse = PSE(heights);

        int area = 0;
        for(int i=0;i<n;i++)
        System.out.print(pse[i]+" ");

        for(int i=0;i<n;i++){
            int width = nse[i]-pse[i]-1;
            area = Math.max(width*heights[i],area);
        }   
        return area;
    }
}