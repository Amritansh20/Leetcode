/*
    This is extension of Leetcode 84. Se that problem first to understand the underlying concept.
    Idea - The entire matrix is converted into a single array (which represents height) row by row.
    
    First array - 1,0,1,0,0
    Now I find the max rectangle using the concept of Monotonic stack at each index and store maximum.

    Second Array - 2,0,1,1,1
    Same process. While finding the area you 

    Third Array - 3,1,2,2,2

    Fourth Array - 4,0,0,3,0

    Important Point to note -> why it is 0 in 2nd and 3rd index? 
    Because in 4th row when I encountered a 0 it creates a break. Rectangle cannot be formed. This 
    is something important in this problem. 

    Steps ->
    1-Start iterating row wise.
    2-Form a heigh_tracker at each row.
    3-Calculate area where each element in height_tracker is considered max. Retrun largest among 
    each element from height_tracker.(Checking the area of rectangle where each element is max)
    4-Track the global maximum area.
 */
import java.util.*;
class Solution {
    public int[] NSE(int[] height_tracker){
        int n = height_tracker.length;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] nse = new int[n];
        Arrays.fill(nse,n);

        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && height_tracker[i]<height_tracker[stack.peek()]){
                nse[stack.peek()]=i;
                stack.pop();
            }
            stack.push(i);
        }
        return nse;
    }
        public int[] PSE(int[] height_tracker){
        int n = height_tracker.length;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] pse = new int[n];
        Arrays.fill(pse,-1);

        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && height_tracker[i]<height_tracker[stack.peek()]){
                pse[stack.peek()]=i;
                stack.pop();
            }
            stack.push(i);
        }
        return pse;
    }
    public int findArea(int[] height_tracker){
        int[] nse = NSE(height_tracker);
        int[] pse = PSE(height_tracker);
        int area =Integer.MIN_VALUE;

        for(int i=0;i<height_tracker.length;i++){
            int width = nse[i]-pse[i]-1;
            area = Math.max(height_tracker[i]*width,area);
        }
        return area;
    }
    public void resetRectangle(int[] height_tracker,char[][] matrix, int row){
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[row][i]=='1')
            height_tracker[i]+=1;
            else
            height_tracker[i]=0;
        }
    }
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] height_tracker = new int[n];
        int max_area = 0;

        for(int i=0;i<m;i++){
            resetRectangle(height_tracker,matrix,i);
            int area = findArea(height_tracker);
            max_area = Math.max(area,max_area);
        } 
        return max_area;
    }
}