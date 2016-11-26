package me.juancrg90.postalcodes.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by JuanCrg90 on 11/26/16.
 */

public interface GeoNamesSevice {

    @GET("/postalCodeSearchJSON")
    Call<PostalCodes> listPostalCodes(
            @Query("country") String country,
            @Query("maxRows") String maxRows,
            @Query("postalcode") String postalCode,
            @Query("username") String username
                                      );


}
