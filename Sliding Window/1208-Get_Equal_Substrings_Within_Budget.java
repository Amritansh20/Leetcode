class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int left=0,right=0;
        int maxLen=0;
        int j=0;
        int cost =0;

        while(right<s.length() && j< t.length()){
            cost += Math.abs((s.charAt(right)-'a') - (t.charAt(j)-'a'));

            while(left<=right && cost>maxCost){
                cost -= Math.abs((s.charAt(left)-'a') - (t.charAt(left)-'a'));
                left++;
            }
            maxLen = Math.max(maxLen,right-left+1);
            right++;
            j++;
        }   
        return maxLen;
    }
}