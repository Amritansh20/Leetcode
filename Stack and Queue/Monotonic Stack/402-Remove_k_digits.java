import java.util.*;

class Solution {
    /*
       The Brute force of this problem is to try to find out all the String of length
       num.length()-k and store the minimum of all.

       We can use backtracking approach for this.(take and not take approch)
       T.C - 2^n

       Better way -> Monotonic Stack. 
       Idea - Agar suru ke number of hata denge toh number zada chota ho jta hai
       as compared to last number ko hatane se.

       I will try to remove k elements from left to right. 
       For this I will make a monotonic increasing stack.\

       Case 1 - If we exhaust k in the process very good. Simply put it ins stringbuilder and reverse.

       Case 2 - If we cannot exhauset all k after interating the entire string. We remove the k elements from 
       stack after we complete iterating he string. 

       Case 3 - If our ans - of 0 length it meanns it's "0"

       T.C - O(n);
       S.C - O(n); 
     */
    public String removeKdigits(String num, int k) {

        if(k>num.length())
        return "";
        StringBuilder str = new StringBuilder();

        ArrayDeque<Character> stack = new ArrayDeque<>();

        for(int i=0;i<num.length();i++){
            while(!stack.isEmpty() && num.charAt(i)<stack.peek() && k>0){
                stack.pop();
                k--;
            }

            stack.push(num.charAt(i));

            if(stack.size()==1 && num.charAt(i)=='0')
            stack.poll();
        }

        while(k>0 && !stack.isEmpty()){
            k--;
            stack.poll();
        }
        while(!stack.isEmpty()){
            str.append(stack.pop());
        }
        
        str.reverse();
        if(str.length()==0)
        return "0";
        return str.toString();
    }
}