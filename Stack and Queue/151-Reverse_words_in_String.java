

import java.util.*;
class Solution {
    public String reverseWords(String s) {
        ArrayDeque<String> stack = new ArrayDeque<>();

        for(int i=0;i<s.length();i++){
            StringBuilder word = new StringBuilder();
            int j=i;

            // skipping all spaces 
            while(j<s.length() && s.charAt(j)==' ')
            j++;

            //making the word

            while(j<s.length() && s.charAt(j)!=' '){
                word.append(s.charAt(j));
                j++;
            }

            stack.push(word.toString());
            i=j-1;
        }

        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()){
            ans.append(stack.pop());
            if(!stack.isEmpty()){
                ans.append(" ");
            }
        }
        return ans.toString().trim(); // trim will remove any trailing and leading spaces.
    }
}