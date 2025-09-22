package Implementation;

import java.util.*;
class Pair{
    int rating;
    String cuisine;

    Pair(int rating, String cuisine){
        this.rating=rating;
        this.cuisine=cuisine;
    }
}
class FoodRatings {
    Map<String,Pair> foodInfo =new HashMap<>();
    Map<String,TreeMap<Integer,TreeSet<String>>> ratingInfo =new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        
        for(int i=0;i<foods.length;i++){
            foodInfo.put(foods[i],new Pair(ratings[i],cuisines[i]));
            
            if(!ratingInfo.containsKey(cuisines[i]))
            ratingInfo.put(cuisines[i],new TreeMap<>(Comparator.reverseOrder()));

            if(!ratingInfo.get(cuisines[i]).containsKey(ratings[i]))
            ratingInfo.get(cuisines[i]).put(ratings[i],new TreeSet<>());

            ratingInfo.get(cuisines[i]).get(ratings[i]).add(foods[i]);
        }
    }
    
    public void changeRating(String food, int newRating) {
        Pair p = foodInfo.get(food);
        int oldRating = p.rating;
        String cuisine = p.cuisine;

        String foodCuisine = foodInfo.get(food).cuisine;
        TreeMap<Integer,TreeSet<String>> map = ratingInfo.get(foodCuisine);
        TreeSet<String> set = map.get(oldRating);
        set.remove(food);

        if(set.isEmpty())
        map.remove(oldRating);

        p.rating=newRating;

        map.computeIfAbsent(newRating, k -> new TreeSet<>()).add(food);
    }
    
    public String highestRated(String cuisine) {
        TreeMap<Integer, TreeSet<String>> map = ratingInfo.get(cuisine);
        Map.Entry<Integer, TreeSet<String>> entry = map.firstEntry();
        return entry.getValue().first();
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */