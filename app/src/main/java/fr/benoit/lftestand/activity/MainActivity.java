package fr.benoit.lftestand.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

import fr.benoit.lftestand.R;
import fr.benoit.lftestand.data.DataManager;
import fr.benoit.lftestand.model.Restaurant;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private static final String TAG = "MainActivity";

    private ImageView imageFull;

    private TextView type;
    private TextView name;
    private TextView address;

    private TextView picturesCount;
    private TextView rating;

    private GoogleMap map;

    private Restaurant restaurant;

    // Used to change restaurant on click on the image
    private String[] restaurantsId = {"6861", "40370", "16409", "14163"};
    private int currentId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        retrieveViews();

        configureToolbar();

        getRestaurantData(restaurantsId[currentId]);

    }

    /**
     * Retrieve the views from the xml
     */
    private void retrieveViews(){
        imageFull = (ImageView) findViewById(R.id.activity_main_image);

        imageFull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getRestaurantData(restaurantsId[getNextCurrentId()]);
            }
        });

        type = (TextView) findViewById(R.id.activity_main_type_price);
        name = (TextView) findViewById(R.id.activity_main_name);
        address = (TextView) findViewById(R.id.activity_main_address);

        picturesCount = (TextView) findViewById(R.id.activity_main_pictures_btn);
        rating = (TextView) findViewById(R.id.activity_main_rating);
    }

    /**
     * Increment the current id
     * @return the new current id
     */
    private int getNextCurrentId(){
        if (currentId < 3) {
            ++currentId;
        }else{
            currentId = 0;
        }

        return currentId;
    }

    /**
     * Toolbar configuration
     */
    private void configureToolbar(){
        Toolbar toolbar =   (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("");

        setSupportActionBar(toolbar);
    }

    /**
     * Fetch the data from the cache if there is any, from the internet otherwise.
     *
     * @param restaurantId The restaurant id to fetch
     */
    private void getRestaurantData(String restaurantId){

        DataManager.getInstance(this).retrieveRestaurant(restaurantId, new DataManager.DataCallback() {
            @Override
            public void onRestaurantLoaded(int type, Restaurant data) {

                if (data != null) {
                    restaurant = data;
                    fillViews();
                }
            }
        });

    }

    /**
     * Fill the views with the content
     */
    private void fillViews(){

        // Using Picasso to load the picture from either cache or Internet
        Picasso.with(this).load(restaurant.getPicsMain().get("612x344"))
                .into(imageFull);

        type.setText(constructTypeAndPrice());
        name.setText(restaurant.getName());
        address.setText(constructAddressField());

        picturesCount.setText(constructPicturesCount());
        rating.setText(constructRating());

        loadLocalizationFragment();

        setMaps();
    }

    private Spanned constructTypeAndPrice(){
        return Html.fromHtml(String.format(getString(R.string.activity_main_type_and_price),
                "<b>" + restaurant.getSpeciality() + "</b>",
                restaurant.getCardPrice()));
    }

    private String constructAddressField(){
        return restaurant.getAddress() + ", " +
                restaurant.getCity() + ", " +
                restaurant.getZipcode() + ", " +
                restaurant.getCity();
    }

    private String constructPicturesCount(){
        return String.format(getString(R.string.activity_main_pictures_count), restaurant.getPicsDiaporama().length);
    }

    private Spanned constructRating(){
        return Html.fromHtml(String.format(getString(R.string.activity_main_rating), "<b>" + restaurant.getAverageRate() + "</b>",
                "<br/>" + (restaurant.getRatings() == null ? "0" : restaurant.getRateCount())));
    }

    private void loadLocalizationFragment(){

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        MapFragment fragment = new MapFragment();
        fragment.getMapAsync(this);
        fragmentTransaction.add(R.id.activity_main_content, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        setMaps();
    }

    /**
     * Set the maps to the coordinate of the restaurant
     */
    private void setMaps(){
        if (map != null && restaurant != null){

            map.clear();
            BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.location);
            LatLng restaurantPosition = new LatLng(restaurant.getGpsLat(), restaurant.getGpsLong());
            map.addMarker(new MarkerOptions().position(restaurantPosition).title(restaurant.getName()).icon(icon));
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(restaurantPosition, 14.0f));
            Log.i(TAG, "setting position to " + restaurantPosition);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_menu, menu);

        return super.onCreateOptionsMenu(menu);

    }
}
