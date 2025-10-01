package HashMap;

import java.util.*;

// Leetcode Premium from Educative

class RequestLogger {
  Map<String,List<Integer>> map;
	public RequestLogger(int timeLimit) {
		// Initialize your data structure here
		map = new HashMap<>();
	}

	public boolean messageRequestDecision(int timestamp, String request) {
		// Replace this placeholder return statement with your code
		if(!map.containsKey(request)){
		  map.put(request,new ArrayList<>());
		  map.get(request).add(timestamp);
		  return true;
		}
		
		int lastTimeStamp = map.get(request).get(map.get(request).size()-1);
		if(Math.abs(timestamp-lastTimeStamp)>=7){
		map.get(request).add(timestamp);
		return true;  
		}
		
		
		return false;
	}
}