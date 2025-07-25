/*
    If there are T tasks in array:
        Making a map = O(T)

        Heap Insertiton: There are U unique tasks. O(U logU) There can be atmost 26 chars so O(1)

        In the inner loop I am running it n+1 times.
        If the freq of a task is f then it it removed and gets added f times. 
        Each heap operation is O(lon N)
        So, f * O(log U)
 */

 import java.util.*;
class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> map = new HashMap<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<tasks.length;i++)
        map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);

        for(int value:map.values()){
            maxHeap.offer(value);
        }

        int time =0;
        while(!maxHeap.isEmpty()){
            int cycle = n+1;
            List<Integer> list = new ArrayList<>();

            while(!maxHeap.isEmpty() && cycle>0){
                int maxFreq= maxHeap.poll();
                maxFreq--;

                time++;
                cycle--;

                if(maxFreq>0)
                list.add(maxFreq);
            }

                for(int i=0;i<list.size();i++){
                    maxHeap.offer(list.get(i));
                }

                if(maxHeap.isEmpty())
                return time;

                time+= cycle;
        }

        return time;
    }
}