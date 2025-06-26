import java.util.*;
class Solution {
    public int maxFrequencyElements(int[] nums) {
      int arr[] = new int[101];

      for(int i=0;i<nums.length;i++){
          arr[nums[i]]++;
      }

      Arrays.sort(arr);
      int ans =arr[100];
      int j=arr.length-2;
      while(arr[j]==arr[100]){
          ans += arr[j];
          j--;
      }
      return ans;
    }
}