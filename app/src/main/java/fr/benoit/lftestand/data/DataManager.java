package fr.benoit.lftestand.data;

import android.content.Context;

import fr.benoit.lftestand.model.Restaurant;
import fr.benoit.lftestand.request.RequestManager;
import fr.benoit.lftestand.request.RequestRestaurant;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Singleton used to fetch the data
 *
 * Created by benoit on 06/02/2016.
 */
public class DataManager {

    private static final String TAG = "DataManager";

    private static DataManager sInstance = null;

    private static Object _lock = new Object();

    private RestaurantCacheManager restaurantCacheManager;
    private RequestManager requestManager;

    public static DataManager getInstance(Context context) {
        if (sInstance == null) {
            synchronized (_lock) {
                if (sInstance == null) {
                    sInstance = new DataManager(context);
                }
            }
        }
        return sInstance;
    }

    private DataManager(Context context) {
        this.restaurantCacheManager = RestaurantCacheManager.getInstance(context);
        this.requestManager = RequestManager.getInstance();
    }

    /**
     * Retrieve the data of the restaurant.
     * The callback can be called two times maximum. The first when the cache respond if there are some data.
     * The second time from the network response.
     *
     * @param id The restaurant id
     * @param callback Callback called when data is retrieved.
     */
    public void retrieveRestaurant(final String id, final DataCallback callback) {
        final Restaurant restaurant = restaurantCacheManager.loadRestaurantFromCache(id);

        if (restaurant != null) {
            if (callback != null) {
                callback.onRestaurantLoaded(0, restaurant);
            }
        }

        requestManager.retrieveRestaurantInfo(id, new Callback<RequestRestaurant>() {
            @Override
            public void onResponse(Call<RequestRestaurant> call, Response<RequestRestaurant> response) {
                if (callback != null) {
                    restaurantCacheManager.storeCommentsInCache(id, response.body().getData());
                    callback.onRestaurantLoaded(1, response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<RequestRestaurant> call, Throwable t) {
                if (callback != null) {
                    callback.onRestaurantLoaded(1, null);
                }
            }
        });

    }

    public interface DataCallback {
        /**
         * Restaurant is loaded
         *
         * @param type 0 from cache 1 for the internet
         * @param data
         */
        public void onRestaurantLoaded(int type, Restaurant data);
    }

}
