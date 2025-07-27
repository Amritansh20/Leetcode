import java.util.*;

// This is brute after trying multiple options.
// I can try to eliminate the index part. 
class Pair{
    char num;
    int index;

    Pair(char num, int index){
        this.num=num;
        this.index=index;
    }
}
class Solution {
    public int largestInteger(int num) {
        StringBuilder str = new StringBuilder(String.valueOf(num));
        int n = str.length();
        PriorityQueue<Pair> evenPq = new PriorityQueue<>((a,b)->b.num-a.num);
        PriorityQueue<Pair> oddPq = new PriorityQueue<>((a,b)->b.num-a.num);

        for(int i=0;i<n;i++){
            int digit = Character.getNumericValue(str.charAt(i));
            if(digit%2==0)
            evenPq.offer(new Pair(str.charAt(i),i));
            else
            oddPq.offer(new Pair(str.charAt(i),i));

        }

        for(int i=0;i<n;i++){
            char currentChar = str.charAt(i);
            int currentDigit = Character.getNumericValue(currentChar);
            if(currentDigit%2==0){
                List<Pair> list = new ArrayList<>();
                while(!evenPq.isEmpty()){
                    Pair top = evenPq.poll();
                    char topChar = top.num;
                    int topDigit = Character.getNumericValue(topChar);
                    int topIndex = top.index;

                    if(topDigit>currentDigit && topIndex>i){
                        str.setCharAt(i,topChar);
                        str.setCharAt(topIndex,currentChar);
                        evenPq.offer(new Pair(currentChar,topIndex)); 
                        break;
                    }else{
                        list.add(top);
                    }
                }

                for(Pair p : list)
                evenPq.offer(p);

            }else{
                List<Pair> list = new ArrayList<>();
                while(!oddPq.isEmpty()){
                    Pair top = oddPq.poll();
                    char topChar = top.num;
                    int topDigit = Character.getNumericValue(topChar);
                    int topIndex = top.index;

                    if(topDigit>currentDigit && topIndex>i){
                        str.setCharAt(i,topChar);
                        str.setCharAt(topIndex,currentChar);
                        oddPq.offer(new Pair(currentChar,topIndex)); 
                        break;
                    }else{
                        list.add(top);
                    }
                }

                for(Pair p : list)
                oddPq.offer(p);
            }
        }
        return Integer.valueOf(str.toString());
    }
}

//Time - O(nlogn)
class Solutions {
    public int largestInteger(int num) {
        String s = String.valueOf(num);
        int n = s.length();
        int[] digits = new int[n];
        PriorityQueue<Integer> even = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> odd = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<n;i++){
            digits[i] = s.charAt(i)-'0';
        }

        for(int i=0;i<n;i++){
            if(digits[i]%2==0)
            even.offer(digits[i]);
            else
            odd.offer(digits[i]);
        }

        StringBuilder ans = new StringBuilder();
        for(int i=0;i<n;i++){
            if(digits[i]%2==0)
            ans.append(even.poll());
            else
            ans.append(odd.poll());
        }
        return Integer.valueOf(ans.toString());
    }
}