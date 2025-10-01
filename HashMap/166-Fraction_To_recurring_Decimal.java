package HashMap;

import java.util.*;

// Asked in Goldman Coder pad
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0)
        return "0";

        StringBuilder res = new StringBuilder();

        if((numerator<0) ^ (denominator<0))
        res.append("-");

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // Integer Part
        res.append((num/den));
        long remainder = num%den;

        if(remainder==0)
        return res.toString();
        res.append(".");

        Map<Long,Integer> map = new HashMap<>();
       
        while(remainder!=0){
            if(map.containsKey(remainder)){
                int index = map.get(remainder);
                res.insert(index,'(');
                res.append(')');
                return res.toString();
            }
            map.put(remainder,res.length());
            remainder = remainder*10;
            res.append(remainder/den);
            remainder = remainder%den;
        }
        return res.toString();
    }
}