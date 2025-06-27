/*
    Brute force is simple. Keep adding the elements in a list. 
    For every indertion. Run a loop till you find a price grater than current price.
    return count;

     public int next(int price) {
        if(list.size()==0){
            list.add(price);
            return 1;
        }

        list.add(0,price);
        int cnt=0;
        for(int i=0;i<list.size();i++){
            if(list.get(i)>price)
            break;

            cnt++;
        }
        return cnt;
    }

    T.C - O(n)
    S.C - O(1)

    Interviewer will most probably not accept this.
    Can we solve this in O(1)? No but we can think of Amortized O(1).
    
    If an operation takes constant time on average across many calls — even if some 
    calls are slower — we say it has amortized O(1) time complexity.

    Concept of Monotonic stack-> 
    See the patten-> we need the smaller element in series. (Until we find prev
    greater element)
    Diff is that -> Instead of storing all the elemets, we are hshing it. storing 
    results of each. 

 */

 import java.util.*;
class Pair{
    int element;
    int count;

    Pair(int element,int count){
        this.element=element;
        this.count=count;
    }
 }
class StockSpanner {
    ArrayDeque<Pair> stack;
    public StockSpanner() {
        stack= new ArrayDeque<>();
    }
    
    public int next(int price) {
        int cnt=1;
        
        while(!stack.isEmpty() && stack.peek().element<=price){
            cnt += stack.pop().count;
        }

        stack.push(new Pair(price,cnt));
        return cnt;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */