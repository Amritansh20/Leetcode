/*
    Pattern - Top K Elements
    Time: First loop - O(nlog k)
        Ans construction : O(klogk)
    Space - O(k)
 */
import java.util.*;
class Touple{
    int x;
    int y;
    double dist;

    Touple(int x, int y, double dist){
        this.x=x;
        this.y=y;
        this.dist=dist;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Touple> maxHeap = new PriorityQueue<>((a,b)->Double.compare(b.dist,a.dist));

        for(int i=0;i<points.length;i++){
            double dist = Math.sqrt(points[i][0]*points[i][0] + points[i][1]*points[i][1]);
            
            if(maxHeap.size()<k){
                maxHeap.offer(new Touple(points[i][0],points[i][1],dist));
            }else if(maxHeap.size()==k){
                if(maxHeap.peek().dist>dist){
                    maxHeap.poll();
                    maxHeap.offer(new Touple(points[i][0],points[i][1],dist));
                }
            }
        }

        List<int[]> ans = new ArrayList<>();
        while(!maxHeap.isEmpty()){
            Touple touple = maxHeap.poll();
            int[] temp = new int[2];
            temp[0]=touple.x;
            temp[1]=touple.y;
            ans.add(temp);
        } 
        return ans.toArray(new int[ans.size()][]);
    }
}