import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int left=0,right=0;
        int maxLen =0;
       
        while(right<s.length()){
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);

            while(left<=right && map.get(s.charAt(right))>1){
                int freq = map.get(s.charAt(left));
                freq--;

                if(freq==0)
                map.remove(s.charAt(left));
                else
                map.put(s.charAt(left),freq);
                
                left++;
            }
            maxLen = Math.max(maxLen,right-left+1);
            right++;
        }   
        return maxLen;
    }
}