import java.util.*;
class Solution {


    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int arr[] = {1,2,3,-3,-2};

        map.put(0, 1); // Initialize with 0 sum count as 1

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                int count = map.get(sum);
                System.out.println("Subarray found from index " + (i - count + 1) + " to " + i);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);        
    }
}
}