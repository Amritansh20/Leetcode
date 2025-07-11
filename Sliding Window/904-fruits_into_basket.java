import java.util.*;
class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer> map = new HashMap<>();
        int left=0,right=0,maxLen=0;
        
        while(right<fruits.length){
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
        

            while(left<=right && map.size()>2){
                int type = fruits[left];
                int freq = map.get(type);
                freq--;

                if(freq==0)
                map.remove(type);
                else
                map.put(type,freq);

                left++;
            }
            maxLen = Math.max(maxLen,right-left+1);
            right++;
        }
        return maxLen;
    }
}