import java.util.*;
class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> tMap = new HashMap<>();
        for(int i=0;i<t.length();i++)
        tMap.put(t.charAt(i),tMap.getOrDefault(t.charAt(i),0)+1);
        int tSize = tMap.size();

        int left=0,right=0,minLen=Integer.MAX_VALUE;
        int start=-1,end=-1;
        while(right<s.length()){
            if(tMap.containsKey(s.charAt(right))){
                int freq = tMap.get(s.charAt(right));
                freq--;

                if(freq==0)
                tSize-=1;

                tMap.put(s.charAt(right),freq);
            }

            while(left<=right && tSize==0){
                if(right-left+1<minLen){
                    start = left;
                    end =right;
                    minLen = right-left+1;
                }
                if(tMap.containsKey(s.charAt(left))){
                    int freq = tMap.get(s.charAt(left));
                    freq++;

                    tMap.put(s.charAt(left),freq);

                    if(freq>0)
                    tSize++;
                }
                left++;
            }
            right++;
        }
        return start==-1||end==-1 ? "" : s.substring(start,end+1);
    }
}