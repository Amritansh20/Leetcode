import java.util.*;

/*
    T.C - O(n)
    S.c- O(n)

    // This question cam also be solved by rolling hash. 
    // Refer Educative Solution
 */
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String,Integer> map = new HashMap<>();
        int right=0;
        StringBuilder str = new StringBuilder();
        while(right<s.length()){
            str.append(s.charAt(right));

            if(str.length()==10){
                map.put(str.toString(),map.getOrDefault(str.toString(),0)+1);
                str.deleteCharAt(0);
            }
            right++;
        }

        List<String> ans = new ArrayList<>();
        for(Map.Entry<String,Integer> it : map.entrySet()){
            if(it.getValue()>1){
                ans.add(it.getKey());
            }
        }
        return ans;
    }
}