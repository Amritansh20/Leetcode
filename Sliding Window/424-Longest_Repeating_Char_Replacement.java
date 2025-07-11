import java.util.*;
class Solution {
    public int characterReplacement(String s, int k) {
        int left=0,right=0;
        Map<Character,Integer> map = new HashMap<>();
        int maxLen =0,maxOccur=0;


        while(right<s.length()){
            char ch = s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);

            maxOccur = Math.max(maxOccur,map.get(ch));

            while(left<=right && (right-left+1)-maxOccur>k){
                char leftChar = s.charAt(left);
                int leftFreq = map.get(leftChar);
                leftFreq--;

                if(leftFreq==0)
                map.remove(leftChar);a
                else
                map.put(leftChar,leftFreq);
                
                left++;
            }
            maxLen = Math.max(maxLen,right-left+1);
            right++;
        }
        return maxLen;
    }
}