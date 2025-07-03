package Strings;

/*
    Question -> I need to find a substring which is lexicograpcally largest 
                given that other all friends have a string.

    Idea-> Lexicograpacally largets string will be starting from the greatest character.
           length of the substring does not matter.

           eg- "abc"
           "c"

           eg- "abcjef"
           "jef"

           I don't care what other people get. I only care about what one person get.
           So, What is the ongest string possible?
           I give one char to each of numFriends-1 friends and remaining can be my ans
           given that remining start from largest char.

           It is not sure that my answer will be of longest possible string.
        
           eg: "dbca"
           I give a to one friend and string starting from largest char becomes my ans of
           longest_possible_length

        eg: "abche" numFriends=2
        My answer will start from "h" 
        longest_possible_length = I assign any one char to friend 1
        longest_possible_length=4;

        is there any string of length 4 posible starting from "h"? No
        So In this case I return whateven I can of length between 1('h') to 4
        So, I returned "he" and "abc" is assigned to another person

        In the same example if numFriends=3? 
        Do I care ? No. "abc" will be dividied among 2 frinds and third one will have "he"

        Came across an edge case: If multiple strings starting from max_char
        In such case I need to find the best substring (largest) starting from max_char

        if(best.length()>longest_possible)
        return best.substring(0,longest-possible)
        else
        return best


    Reminder:
    If you have to compare to String lexicographcally.
    It's better to use String rather that StringBuilder
    String implements Comparable interface which brings compareTofunction
    str1.compareTo(str2)
    if:
    str1 is lexicograically bigger than str2 it will return >0
    str1==str2, it retruns 0;
    str1<str2 it returns -1
*/
class Solution {
    public String answerString(String word, int numFriends) {
        if(numFriends==1)
        return word;
        
        int n = word.length();
        int longest_length_possible = n-(numFriends-1);
        int max_char_index = 0;
        char max_char = word.charAt(0);

        for(int i=1;i<n;i++){
            if(word.charAt(i)>max_char){
                max_char_index=i;
                max_char = word.charAt(i);
            }
        }

        
        String best = "";
        for(int i=0;i<n;i++){
            if(max_char == word.charAt(i)){
                String candidate = word.substring(i);
                if(candidate.compareTo(best)>0)
                best = candidate;
            }
        }
        
        // if(max_char_index+longest_length_possible<n)
        // return word.substring(max_char_index,max_char_index+longest_length_possible);
        // else
        // return word.substring(max_char_index);

        if(best.length() > longest_length_possible)
        return best.substring(0,longest_length_possible);

        return best;
    }
}