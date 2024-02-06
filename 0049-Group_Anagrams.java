import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String,Integer> mpp = new HashMap<>();

        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);

            if(mpp.containsKey(sortedStr)){
                ans.get(mpp.get(sortedStr)).add(str);
            }else{
                mpp.put(sortedStr,ans.size());
                ans.add(new ArrayList<>(Arrays.asList(str)));
            }
        }
        return ans;
    }
}