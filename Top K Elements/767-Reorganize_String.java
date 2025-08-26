/*
    Approch is simple. Top k Elements pattern.
    You start from the char which has highest freq. You take out two char in each iterations.

    There are cases to be checked. That's why i wrote a seperate loop for returning "" in case ans is 
    not possible.

    Once you write the case where no answer is possile then you don't havw to worry much about cases when 
    you are using while loop.

    T.C.- 
        1- Map Construction - O(n)
        2- For loop to check for answers which is not possible - O(k) -> k is number of item in map
        3- pushing map items in PriorityQueue -  O(k logk) k is number of item in map
        4- while loop - Here you are processing n elements as you decrease the freq and put it back 
            so O(n logk) - k is distict number of char
        Overall - O(n logk)
    S.C - O(k) - where k is distinct chars present in string 
 */
import java.util.*;
class Pair{
    char ch;
    int freq;
    Pair(char ch, int freq){
        this.ch=ch;
        this.freq=freq;
    }
}
class Solution {
    public String reorganizeString(String s) {
        Map<Character,Integer> map = new HashMap<>();
        
        for(int i=0;i<s.length();i++)
        map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);

        for(int value: map.values()){
            if(s.length()%2==0 && value> (s.length()/2))
            return "";

            if(s.length()%2==1 && value> (s.length()/2)+1)
            return "";
        }

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a,b)->Integer.compare(b.freq,a.freq));

        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            maxHeap.offer(new Pair(entry.getKey(),entry.getValue()));
        }

        StringBuilder ans = new StringBuilder();

        while(!maxHeap.isEmpty()){
            List<Pair> list = new ArrayList<>();

            Pair p = maxHeap.poll();
            char ch = p.ch;
            int freq = p.freq;
            ans.append(ch);
            freq--;

            if(freq>0)
            list.add(new Pair(ch,freq));

            if(!maxHeap.isEmpty()){
                Pair pair = maxHeap.poll();
                char ch_2 = pair.ch;
                int freq_2 = pair.freq;
                ans.append(ch_2);
                freq_2--;

                if(freq_2>0)
                list.add(new Pair(ch_2,freq_2));
            }

            for(int i=0;i<list.size();i++)
            maxHeap.offer(list.get(i));
        }
        return ans.toString();
    }
}