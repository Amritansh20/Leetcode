class Solution {
    public int maximumGroups(int[] grades) {
      int left=0;
      int right=1000;
      int n = grades.length;
    
      while(left<=right){
         
          int mid = left + (right-left)/2;
          if((mid*(mid+1))/2 > n)
          right = mid-1;
          else
          left=mid+1;
      }
        return right;
    }
}

/*Time complexity - > O(log1000)
 * Space-> O(n) 
 */