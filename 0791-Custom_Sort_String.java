import java.util.*;
class Solution {
    public String customSortString(String order, String s) {
        ArrayList<Character> list = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            list.add(s.charAt(i));
        }

        ArrayList<Character> ans = new ArrayList<>();

        for(int i=0;i<order.length();i++){
            if(list.contains(order.charAt(i))){
                Character ch = order.charAt(i);
                ans.add(ch); 
                list.remove(ch);
            }
        }

        if(list.size()!=0){
            for(int i=0;i<list.size();i++){
                Character ch = list.get(i);
                if(ans.contains(ch)){
                    int index = ans.indexOf(ch);
                    ans.add(index,ch);
                }else{
                    ans.add(ch);
                }
            }
        }
        String result="";
        for(int i=0;i<ans.size();i++){
            Character ch = ans.get(i);
            result = result + ch;
        }
        return result;
    }
}