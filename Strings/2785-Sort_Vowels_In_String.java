package Strings;

import java.util.*;
class Solution {
    public boolean isVovel(char ch) {
        return "aeiouAEIOU".indexOf(ch) != -1;
    }

    public String sortVowels(String s) {
        StringBuilder str = new StringBuilder(s);
        
        List<Character> vowels = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (isVovel(c))
                vowels.add(c);
        }

        Collections.sort(vowels);
        int j=0;

        for (int i = 0; i < s.length(); i++) {
            if (isVovel(str.charAt(i))) {
                str.setCharAt(i, vowels.get(j++));
            }
        }
        return str.toString();
    }
}