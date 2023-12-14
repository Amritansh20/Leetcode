import java.util.*;

class Solution {
    public int leastInterval(char[] s, int k) {
         HashMap<Character,Integer> mpp = new HashMap<Character,Integer>();
        
        for(int i=0;i<s.length;i++){
            if(mpp.containsKey(s[i])){
                mpp.put(s[i], mpp.get(s[i])+1);
            }else{
                mpp.put(s[i],1);
            }
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(Map.Entry<Character,Integer> it : mpp.entrySet()){
            maxHeap.add(it.getValue());
        }

        int time=0;
        while(!maxHeap.isEmpty()){
            int cycle = k+1;
            List<Integer> list = new ArrayList<>();
            
            while(cycle!=0 && !maxHeap.isEmpty()){
                int max_freq = maxHeap.peek();
                maxHeap.remove();

                if(max_freq >1){
                    list.add(max_freq-1);
                }

                cycle--;
                time++;
            }

            for(int i=0;i<list.size();i++){
                maxHeap.add(list.get(i));
            }

            if(maxHeap.isEmpty())
            break;

            time += cycle;
        }
        return time;
    }
}