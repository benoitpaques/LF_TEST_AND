package fr.benoit.lftestand.request;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by benoit on 06/02/2016.
 */
public interface RestaurantService {

    @GET("api?key=IPHONEPRODEDCRFV&method=restaurant_get_info")
    public Call<RequestRestaurant> getRestaurant(@Query("id_restaurant") String restaurantId);
}
