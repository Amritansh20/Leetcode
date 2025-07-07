/*
    This is a tricky problem because of edge cases.
    Try to simulate the problem. 

    Approach ->
    If Stack is empty or the incoming number is positive -> Directly push the incoming element.
    (containing all right going elements) 
    
    Edge case -1 (We should also take care if array ke start me left going elemnts hai
    toh woh bhi stack me chale jaane chaiye. example array starts with -9)

    If incoming is negative then go to else block. 
    
    Check all positive numbers on stack whos value is lesser than abs(negative element) and pop is
    
    Why are we writing seperate case if the value at stack peek is equal to incoming -ve value?
    Because in such case we only want one value from stack to be removed amd the incoming to be destroyed.

    Suppose if top two elemets in stack is 9,9 and then there is -9 coming. If we put = sign in while both 9 
    from stack will remove.

    [-2,-1,1,2] -> Important edge case for understanding all cases.

    One more question you mighr come across later
    Why stack.peek()>0 is required in the conditions of while loop and if statement.
    The answer is out Stack can also be in the state where the top elemets (in this case all elemenets) are -ve
    Left goings are going left and new right goings will not make contact.
     
 */
import java.util.*;
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
       int n = asteroids.length; 
       ArrayDeque<Integer> stack = new ArrayDeque<>();

       for(int i=0;i<n;i++){
            
            // agar stack empty ho toh +ve or -ve dono stack me chala jayega.
            // but +ve aa rha ho toh sidha stack me.
            if(stack.isEmpty() || asteroids[i]>0){
            stack.push(asteroids[i]);
            } // Agar -ve value aaye toh else case
            else{
                // Left moving aestroid. Resolve the collsions.
                while(!stack.isEmpty() &&stack.peek()>0 && stack.peek()<Math.abs(asteroids[i]))
                stack.pop(); // Smaller right jaane wale aestroids getting destroyed.
                
                if(!stack.isEmpty() && stack.peek()>0 && stack.peek()==Math.abs(asteroids[i])){
                stack.pop(); // Both explode of equal size (only 1 pair allowed) Very imp point
                }else if(stack.isEmpty() || stack.peek()<0){ 
                    // Stack is empty or top is also a left-moving asteroid (Edge case 1 from above)
                    stack.push(asteroids[i]); // push the surviving left-moving asteroid
                }
                
                
            }
       }
       List<Integer> list = new ArrayList<>();

       while(!stack.isEmpty()){
        list.add(stack.peek());
        stack.pop();
       }
       Collections.reverse(list);
       return list.stream().mapToInt(Integer:: intValue).toArray();
    }
}