/*
    Number of segments = 4;
    Choices per segment <=3

    T.C - O(4^3) 
    This is constant time as IP address have fixed length constraint;
 */

 import java.util.*;
class Solution {
    public boolean isValid(String s){
        if(s.length()>3 || (s.length()>1 && s.charAt(0)=='0'))
        return false;

        if(Integer.valueOf(s) > 255)
        return false;

        return true;
    }
    public void solve(String s, List<String> ans, List<String> temp, int index){
        
        if(temp.size()>4)
        return;

        if(temp.size()==4 && index==s.length()){
            ans.add(String.join(".",temp));
            return;
        }

        for(int i=index;i<s.length();i++){
            if(isValid(s.substring(index,i+1))){
                temp.add(s.substring(index,i+1));
                solve(s,ans,temp,i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        solve(s,ans,temp,0);
        return ans;
    }
}