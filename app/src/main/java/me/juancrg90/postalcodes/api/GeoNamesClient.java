package me.juancrg90.postalcodes.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by JuanCrg90 on 11/26/16.
 */

public class GeoNamesClient {
    private Retrofit retrofit;
    private final static String BASE_URL = "http://api.geonames.org/";

    public GeoNamesClient() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public GeoNamesSevice getGeoNamesService() {
        return this.retrofit.create(GeoNamesSevice.class);
    }

}
