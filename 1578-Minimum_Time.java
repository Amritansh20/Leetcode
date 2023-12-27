class Solution {
    public int minCost(String colors, int[] neededTime) {
        int sum=0;
        int max_sum=0;
        int ans =0;

        for(int i=0;i<colors.length();i++){
            if(i>0 && colors.charAt(i)!=colors.charAt(i-1)){
                ans += sum-max_sum;
                max_sum=0;
                sum=0;
            }

            sum += neededTime[i];
            max_sum = Math.max(max_sum,neededTime[i]);
        }

        ans += sum-max_sum;
        return ans;
    }
}