

class Solution {
    /*
       Key Idea - If you want to know how much water is trapped in a building 
               Find the tallest in right and tallest in left. Among them Choose the miniumum.
               Now, subtract the height of current building from the minimum of both.

               Take two arrays which will store the tallest building in the left and the otehr array will store the 
               tallest building in the right.

               Iterate the array store the submission of Min(left[i],right[i]) - height[i]

               Time - O(n)
               Space - O(n)
     */

    public int trapp(int[] height) {
        int n = height.length;
        int[] rightMax = new int[n];
        int[] leftMax = new int[n];

        rightMax[n-1]=height[n-1];
        leftMax[0]=height[0];

        for(int i=n-2;i>=0;i--)
        rightMax[i]= Math.max(rightMax[i+1],height[i]);

        for(int i=1;i<n;i++)
        leftMax[i]=Math.max(leftMax[i-1],height[i]);

        int ans=0;

        for(int i=0;i<n;i++){
            ans += Math.min(leftMax[i],rightMax[i])-height[i];
        }
        return ans;
    }


    /*
    Key idea - If you want to know how much water is trapped in a building 
               Find the tallest in right and tallest in left. Among them Choose the miniumum.
               Now, subtract the height of current building from the minimum of both.

               Approch -> Two Pointer
               left =0;
               right=n-1;

               since I have to choose minimum of (tallest in right, tallest in left)
               I will always pick smaller value from height[left] and height[right]

               Why? 
               I want min (tallest in left and tallest in right)
               Now when I compare heightp[left] and height[right] and supppose height[left]<height[right]
               Then I trust that there is something larger in the right
               So all the heights in left including the current is smaller and I need 
               min(tallest in left, tallest in right) . 

               We keep track by leftMax and rightMax

               Time - O(n)
               Space - (1)
*/
    public int trap(int[] height) {
        int n=height.length;
        int left=0;
        int right=n-1;
        int leftMax= 0;
        int rightMax = 0;
        int res =0;
        while(left<=right){
            if(height[left]<=height[right]){
                if(height[left]>leftMax){
                    leftMax = height[left];
                }else{
                    res += (leftMax-height[left]);
                }
                left++;
            }else{
                if(height[right]>rightMax){
                    rightMax=height[right];
                }else{
                    res+=(rightMax-height[right]);
                }
                right--;
            }
        }
        return res;
    }
}