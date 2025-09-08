import java.util.*;
class Touple{
    int sum;
    int i;
    int j;
    
    Touple(int sum, int i, int j){
        this.sum=sum;
        this.i=i;
        this.j=j;
    }
}
class Solution {
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        Arrays.sort(a);
        Arrays.sort(b);

        PriorityQueue<Touple> maxHeap = new PriorityQueue<>((c,d)->d.sum-c.sum);
        Set<String> vis = new HashSet<>();
        maxHeap.offer(new Touple(a[a.length-1]+b[b.length-1],a.length-1,b.length-1));
        vis.add((a.length-1)+","+(b.length-1));
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int count=0;count<k;count++){
            Touple t = maxHeap.poll();
            int sum = t.sum;
            int i= t.i;
            int j = t.j;
            
            ans.add(sum);
            
            if(i-1>=0 && !vis.contains((i-1)+","+j)){
            maxHeap.offer(new Touple(a[i-1]+b[j],i-1,j));
            vis.add((i-1)+","+j);   
            }

            if(j-1>=0 && !vis.contains(i+","+(j-1))){
            maxHeap.offer(new Touple(a[i]+b[j-1],i,j-1));
            vis.add(i+","+(j-1));   
            }
        }
        return ans;
    }
}