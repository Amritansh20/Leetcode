/*
    Time - O(m^n)
    Space - O(n)
 */
import java.util.*;
class Solution {
    public void solve(List<String> input, StringBuilder ds, List<String> ans, int index){

        if(ds.length()==input.size()){
            ans.add(ds.toString());
            return;
        }
        for(int i=0;i<input.get(index).length();i++){
            ds.append(input.get(index).charAt(i));
            solve(input,ds,ans,index+1);
            ds.deleteCharAt(ds.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        List<String> input = new ArrayList<>();
        for(int i=0;i<digits.length();i++){
            input.add(map.get(digits.charAt(i)));
        }

        List<String> ans = new ArrayList<>();

        if(digits.length()==0)
        return ans;

        StringBuilder ds = new StringBuilder();
        solve(input,ds,ans,0);
        return ans;
    }
}