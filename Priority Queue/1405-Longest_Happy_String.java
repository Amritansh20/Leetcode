/*
    Step 1 - Make a max Heap and store the count and char if count>0
    Step 2 - Start polling from maxHeap
    Step 3 - If res length >=2, then check if last 2 chars are same
                If yes, then poll the next greater data and append that in res and dec the count
                Put back both data in maxHeap  

                If No, then append the curr char and dec the counf of curr char. Put the
                curr data back to maxHeap
    
    T.C - O(n)
        Each heap operation is O(log 3) - O(1)
        All the char getting added and removed in maxHeap by theri count. So bacially sum of all given a+b+c
    
    S.C - O(1) maxHeap will be of size 3 at max. 
 */
import java.util.*;
class Pair{
    int count;
    char ch;

    Pair(int count, char ch){
        this.count=count;
        this.ch = ch;
    }
}
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((j,k)->k.count-j.count);
        if(a>0)
        maxHeap.offer(new Pair(a,'a'));
        if(b>0)
        maxHeap.offer(new Pair(b,'b'));
        if(c>0)
        maxHeap.offer(new Pair(c,'c'));
        
        StringBuilder res = new StringBuilder();
        
        while(!maxHeap.isEmpty()){
            Pair curr = maxHeap.poll();
            int len = res.length();

            if(len>=2 && res.charAt(len-1) == curr.ch && res.charAt(len-2) == curr.ch){
                if(maxHeap.isEmpty())
                break;

                Pair next = maxHeap.poll();
                res.append(next.ch);

                if(next.count -1 >0)
                maxHeap.offer(new Pair(next.count -1, next.ch));

                maxHeap.offer(curr);
            }else{
                res.append(curr.ch);
                if(curr.count-1>0)
                maxHeap.offer(new Pair(curr.count-1,curr.ch));
            }
        }
        return res.toString();
    }
}