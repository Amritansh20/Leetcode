/*
    T.C - O(n logk)
    S.C - O(k)
 */
import java.util.*;
class Pair{
    int element;
    int dist;

    Pair(int element, int dist){
        this.element=element;
        this.dist=dist;
    }
}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a,b)->b.dist-a.dist);

        for(int i=0;i<arr.length;i++){
            if(maxHeap.size()<k){
                maxHeap.offer(new Pair(arr[i],Math.abs(x-arr[i])));
                continue;
            }
            
            if(maxHeap.size()==k){
               Pair p = maxHeap.peek();
               if(Math.abs(arr[i]-x) < Math.abs(p.element-x) || (Math.abs(arr[i]-x) == Math.abs(p.element-x) && arr[i]<p.element)){
                maxHeap.poll();
                maxHeap.offer(new Pair(arr[i],Math.abs(arr[i]-x)));
               }
            }
        }
        List<Integer> ans = new ArrayList<>();

        while(!maxHeap.isEmpty()){
            ans.add(maxHeap.poll().element);
        }
        
        Collections.sort(ans);
        return ans;
    }
}