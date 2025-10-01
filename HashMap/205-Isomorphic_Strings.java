package HashMap;

import java.util.*;

// Two Map Approach
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,List<Integer>> sMap = new HashMap<>();
        Map<Character,List<Integer>> tMap = new HashMap<>();

        for(int i=0;i<s.length();i++){
            if(!sMap.containsKey(s.charAt(i)))
            sMap.put(s.charAt(i),new ArrayList<>());

            sMap.get(s.charAt(i)).add(i);

            if(!tMap.containsKey(t.charAt(i)))
            tMap.put(t.charAt(i),new ArrayList<>());
            
            tMap.get(t.charAt(i)).add(i);

            if(!sMap.get(s.charAt(i)).equals(tMap.get(t.charAt(i))))
            return false;
        }
        return true;
    }
}

// One Map Approach
// Possible as order need to preerved
class Solutions{
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char original = s.charAt(i);
            char replace = t.charAt(i);

            if(!map.containsKey(original)){
                if(!map.containsValue(replace))
                map.put(original,replace);
                else
                return false;
            }else{
                char mapped = map.get(s.charAt(i));
                if(mapped != t.charAt(i))
                return false;
            }
        }
        return true;
    }
}