import java.util.*;
class Solution {
    public int characterReplacement(String s, int k) {
        int left=0;
        int right=0;
        int maxOccur=0;
        Map<Character, Integer> map = new HashMap<>();
        int maxLen =0;
        while(right<s.length()){
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
            maxOccur = Math.max(maxOccur,map.get(s.charAt(right)));

            while(left<=right && (right-left+1)-maxOccur>k){
                int freq = map.get(s.charAt(left));
                freq--;
                if(freq==0)
                map.remove(s.charAt(left));
                else
                map.put(s.charAt(left),freq);
                
                left++;
            }
            maxLen = Math.max(right-left+1,maxLen);
            right++;
        }
        return maxLen;
    }
}