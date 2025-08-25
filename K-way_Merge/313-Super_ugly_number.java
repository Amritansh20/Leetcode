/*
    Pattern: k-way merge
    Time: O(n logk) where k is the length of prime array
    Space: O(k)
 */
import java.util.*;
class Touple{
    long element;
    long prime;
    int index;

    Touple(long element, long prime, int index){
        this.element=element;
        this.prime =prime;
        this.index=index;
    }
}
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        List<Integer> ugly = new ArrayList<>();
        ugly.add(1);

        PriorityQueue<Touple> minHeap = new PriorityQueue<>((a,b)->Long.compare(a.element,b.element));

        for(int prime:primes)
        minHeap.offer(new Touple(prime,prime,0));

        while(ugly.size()<n){
            Touple touple = minHeap.poll();
            long uglyNumber = touple.element;
            long prime = touple.prime;
            int index = touple.index;

            if(ugly.get(ugly.size()-1) != uglyNumber)
            ugly.add((int)uglyNumber);

            minHeap.offer(new Touple(prime*ugly.get(index+1),prime,index+1));
        }
        return ugly.get(n-1);
    }
}