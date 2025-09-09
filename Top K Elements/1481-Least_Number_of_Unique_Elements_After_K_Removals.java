import java.util.*;
class Pair{
    int num;
    int count;

    Pair(int num, int count){
        this.num=num;
        this.count=count;
    }
}
class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b)->a.count-b.count);
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<arr.length;i++)
        map.put(arr[i], map.getOrDefault(arr[i],0)+1);

        for(Map.Entry<Integer,Integer> entry: map.entrySet())
        minHeap.offer(new Pair(entry.getKey(),entry.getValue()));

        while(!minHeap.isEmpty() && k-- >0){
            Pair p = minHeap.poll();
            p.count--;

            if(p.count==0)
            continue;
            else
            minHeap.offer(p);
        }
        return minHeap.size();
    }
}