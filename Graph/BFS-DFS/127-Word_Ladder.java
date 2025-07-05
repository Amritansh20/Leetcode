/*
    Time- 
        We are processing each word with 26 chars. If the len of words is L
        then 26*L

        We are processing each word once since we are removing it from set.
        There are N words. At worst all words queued at once so O(n)

        total = 26 * L * N

    Space:
        O(n)
 */

import java.util.*;
class Pair{
    String word;
    int steps;

    Pair(String word, int steps){
        this.word = word;
        this.steps=steps;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        ArrayDeque<Pair> q = new ArrayDeque<>();

        for(String str : wordList)
        set.add(str);

        q.offer(new Pair(beginWord,1));

        while(!q.isEmpty()){
            Pair p = q.poll();
            String word = p.word;
            int steps = p.steps;

            if(word.equals(endWord))
            return steps;

            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] charArray = word.toCharArray();
                    charArray[i]=ch;
                    String s = new String(charArray); // This conversion is important
                    
                    if(set.contains(s)){
                        q.offer(new Pair(s,steps+1));
                        set.remove(s);
                    }
                }
            } 
        }
        return 0;
    }
}