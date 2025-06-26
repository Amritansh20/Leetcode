class Solution {
    public static void swap(int a, int b){
        int temp=a;
        a=b;
        b=temp;
    }

    public void sortColors(int[] nums) {
    int start=0;
    int end=nums.length-1;
    int mid=0;

    while(mid<=end){
        if(nums[mid]==0){
            swap(nums[mid],nums[start]);
            mid++;
            start++;
        }else if(nums[mid]==1){
            mid++;
        }else{
            swap(nums[mid],nums[end]);
            end--;
        }
    }
}
};

/*Time Complexity -> O(n)
 * Space Complexity -> O(1)
 */