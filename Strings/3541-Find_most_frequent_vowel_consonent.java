package Strings;

import java.util.*;
class Solution {
    public boolean isVowel(char ch){
        return "aeiou".indexOf(ch)!=-1;
    }
    public int maxFreqSum(String s) {
        Map<Character,Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++)
        map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);

        int maxV=0;
        int maxC=0;

        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(isVowel(entry.getKey())){
                maxV = Math.max(entry.getValue(),maxV);
            }else{
                maxC = Math.max(entry.getValue(),maxC);
            }
        }
        return maxV+maxC;
    }
}