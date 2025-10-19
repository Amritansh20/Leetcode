package Strings;


// We are using brute force only. Not possible other ways.
// We generated all possbile values and choose the smallest
import java.util.*;
class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> visited = new HashSet<>();
        ArrayDeque<String> q = new ArrayDeque<>();
        q.offer(s);
        visited.add(s);
        String smallest =s;

        while(!q.isEmpty()){
            String top = q.poll();
            
            if(top.compareTo(smallest)<0)
            smallest = top;

            StringBuilder str = new StringBuilder(top);

            for(int i=1;i<top.length();i=i+2){
                str.setCharAt(i,(char) ((top.charAt(i)-'0'+a)%10 + '0'));
            }      
            
            if(visited.add(str.toString()))
            q.offer(str.toString());

            String rotated = top.substring(top.length()-b)+ top.substring(0,top.length()-b);
            
            if(visited.add(rotated))
            q.offer(rotated);
        }
        return smallest;
    }
}