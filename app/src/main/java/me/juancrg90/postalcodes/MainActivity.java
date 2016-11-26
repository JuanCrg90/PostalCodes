package me.juancrg90.postalcodes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.juancrg90.postalcodes.api.GeoNamesClient;
import me.juancrg90.postalcodes.api.GeoNamesSevice;
import me.juancrg90.postalcodes.api.PostalCodes;
import me.juancrg90.postalcodes.entities.PostalCode;
import me.juancrg90.postalcodes.fragments.PostalCodesListFragment;
import me.juancrg90.postalcodes.fragments.PostalCodesListFragmentListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.editPostalCode)
    EditText editPostalCode;
    @Bind(R.id.buttonSubmit)
    Button buttonSubmit;

    GeoNamesClient geoNamesClient = new GeoNamesClient();
    GeoNamesSevice geoNamesSevice;

    PostalCodesListFragmentListener fragmentListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        geoNamesSevice = geoNamesClient.getGeoNamesService();

        PostalCodesListFragment fragment = (PostalCodesListFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentList);

        fragment.setRetainInstance(true);
        fragmentListener = (PostalCodesListFragment) fragment;
    }

    @OnClick(R.id.buttonSubmit)
    public void handleSubmitClick() {
        String country = "MX";
        String maxRows = "10";
        String postalcode = editPostalCode.getText().toString();
        String username = "JuanCrg90";
        Call<PostalCodes> call = geoNamesSevice.listPostalCodes(country, maxRows, postalcode, username);

        call.enqueue(new Callback<PostalCodes>() {
            @Override
            public void onResponse(Call<PostalCodes> call, Response<PostalCodes> response) {

                List<PostalCode> postalCodeList = response.body().getPostalCodes();

                fragmentListener.addToList(postalCodeList);
            }

            @Override
            public void onFailure(Call<PostalCodes> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Something went wrong: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}
