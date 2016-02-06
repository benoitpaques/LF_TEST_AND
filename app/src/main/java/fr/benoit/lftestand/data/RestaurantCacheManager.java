package fr.benoit.lftestand.data;

import android.content.Context;
import android.util.Log;

import java.util.HashMap;

import fr.benoit.lftestand.model.Restaurant;

/**
 * Singleton using FileManager to write restaurant data specific on the disk
 *
 * Created by benoit on 06/02/2016.
 */
public class RestaurantCacheManager {

    private static final String TAG = "RestaurantCacheManager";

    private static RestaurantCacheManager sInstance = null;

    private static Object _lock = new Object();

    private HashMap<String, Restaurant> restaurantById = new HashMap<>();
    private FileManager fileManager;

    public static RestaurantCacheManager getInstance(Context context){
        if (sInstance == null){
            synchronized (_lock){
                if (sInstance == null){
                    sInstance = new RestaurantCacheManager(context);
                }
            }
        }
        return sInstance;
    }

    private RestaurantCacheManager(Context context){
        fileManager = FileManager.getInstance(context);
    }

    public Restaurant loadRestaurantFromCache(String restaurantId){

        Restaurant restaurant = restaurantById.get(restaurantId);
        if (restaurant == null){
            restaurant = (Restaurant) fileManager.loadObject(restaurantId, FileManager.DIRECTORY_RESTAURANT);
            Log.i(TAG, "Restaurant message loaded from cache " + restaurant);
            restaurantById.put(restaurantId, restaurant);
        }

        return restaurant;
    }

    public void storeCommentsInCache(String restaurantId, Restaurant restaurant){
        fileManager.saveObject(restaurant, restaurantId, FileManager.DIRECTORY_RESTAURANT);
        Log.i(TAG, "Restaurant stored to cache " + restaurant);
     }

}
