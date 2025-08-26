import java.util.*;
class Pair{
    int element;
    int freq;

    Pair(int element, int freq){
        this.element=element;
        this.freq=freq;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b)->Integer.compare(a.freq,b.freq));
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++)
        map.put(nums[i],map.getOrDefault(nums[i],0)+1);

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(minHeap.size()<k)
            minHeap.offer(new Pair(entry.getKey(),entry.getValue()));
            else if(minHeap.size()==k){
                if(entry.getValue()>minHeap.peek().freq){
                    minHeap.poll();
                    minHeap.offer(new Pair(entry.getKey(),entry.getValue()));
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!minHeap.isEmpty()){
            ans.add(minHeap.peek().element);
            minHeap.poll();
        }
        return ans.stream().mapToInt(i->i.intValue()).toArray();
    }
}