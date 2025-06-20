class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int left=0;
        int right=0;
        int n = arr.length;
        int sum=0;
        int count=0;
        int compare = threshold*k;

        while(right<n){
            sum+= arr[right];
            if(right-left+1<k){
                right++;
            }else if(right-left+1==k){
                if(sum>=compare){
                    count++;
                }

                sum -= arr[left];
                left++;
                right++;
            }
        }
        return count;
    }
}