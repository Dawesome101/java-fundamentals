package inheritance;

import java.util.HashMap;

public class RestaurantCollection {
    public static HashMap<Long, Restaurant> restaurantList = new HashMap<>();

    public static boolean hasKey (long key){
        return restaurantList.containsKey(key);
    }
}
