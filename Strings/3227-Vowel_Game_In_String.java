package Strings;

class Solution {
    public boolean isVowel(char ch){
        return "aeiou".indexOf(ch)!=-1;
    }
    public boolean doesAliceWin(String s) {
        int vowelCount=0;

        for(int i=0;i<s.length();i++){
            if(isVowel(s.charAt(i)))
            vowelCount++;
        }

        if(vowelCount==0)
        return false;
        else if(vowelCount%2==0)
        return true;
        else
        return true;
    }
}