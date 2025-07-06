/*
    Iska BFS might seem difficult but it's not.
    BSF steps:
    q = {(bat),(bat,bot),(bat,pat),(bat,bot,pot),(bat,pat,pot)...}

    Why usedOnLevel = look (bat,bot,pot) and (bat,pat,pot) both have same last word
                      If ek me daal ke remove kr den toh nexr me nhi jaygea

                      So, if a poll a list from q and them I have to look
                      all possible words forming from the last word of that list.
                      I will offer all the possibility seperately in queue. 
                      Then I will remove the added words from the set.

                      From "bat" I can form two possiblity which is "bot" and "pat"
                      This will bot go seperatly in queue
                      {"bat","bot"}
                      {"bat","pat"}

                      Now I am allowed to remove "bot" (when I poll {"bat","bot"} bow will remove ) 
                      and " pat" from the set (When I poll {"bat","pat"} pat will be removed from set) 

 */
import java.util.*;
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        
        for(String s : wordList)
        set.add(s); 

        ArrayDeque<List<String>> q = new ArrayDeque<>();
        List<String> ls = new ArrayList<>();
        ls.add(beginWord);
        q.offer(ls);

        List<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(beginWord);

        List<List<String>> ans = new ArrayList<>();
        int level=0;

        while(!q.isEmpty()){
            List<String> vec = q.poll();

            if(vec.size()>level){
                level++;

                for(String it : usedOnLevel){
                    set.remove(it);
                }
            }

            String word = vec.get(vec.size()-1);

            if(word.equals(endWord)){
                if(ans.size()==0 || ans.get(0).size()==vec.size())
                ans.add(vec);
                // else if(ans.get(0).size()==vec.size())
                // ans.add(vec);
            }

            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] charArray = word.toCharArray();
                    charArray[i]=ch;
                    String newString = new String(charArray);
                    if(set.contains(newString)){
                        vec.add(newString);
                        List<String> temp = new ArrayList<>(vec);
                        q.offer(temp);
                        usedOnLevel.add(newString);
                        vec.remove(vec.size()-1); // why we are removing? vec={bat} Now word = bat. 
                                                  //while looking for possibility i will get bot. vec={bat,bot} 
                                                  // Now vec ka copy bna ke me daal die {bat,bot}
                                                  // agar vec se remove nhi krte hai toh this will happen
                                                  // "bat" ka another possibility is "pat"
                                                  // vec = {bat,bot,pat} which is not corrent.
                                                  // phir iss vec ka copy q me chala jayega.
                    }
                }
            }
        }
        return ans;
    }
}