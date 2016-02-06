package fr.benoit.lftestand.request;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by benoit on 06/02/2016.
 */
public class RequestManager {

    private static final String TAG = "RequestManager";

    private static final String API_BASE_URL = "http://api.lafourchette.com/";

    private static RequestManager sInstance = null;

    private static Object _lock = new Object();

    private Retrofit retrofit;

    public static RequestManager getInstance(){
        if (sInstance == null){
            synchronized (_lock){
                if (sInstance == null){
                    sInstance = new RequestManager();
                }
            }
        }
        return sInstance;
    }

    private RequestManager(){

    }

    public void retrieveRestaurantInfo(String restaurantId, Callback<RequestRestaurant> callback){

        Retrofit retrofit = getRetrofit();

        RestaurantService restaurantService = retrofit.create(RestaurantService.class);
        Call<RequestRestaurant> data = restaurantService.getRestaurant(restaurantId);
        data.enqueue(callback);
    }

    private Retrofit getRetrofit(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(API_BASE_URL)
                    .build();
        }
        return retrofit;
    }
}
