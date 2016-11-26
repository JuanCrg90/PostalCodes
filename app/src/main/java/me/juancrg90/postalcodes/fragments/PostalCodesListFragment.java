package me.juancrg90.postalcodes.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import me.juancrg90.postalcodes.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PostalCodesListFragment extends Fragment implements PostalCodesListFragmentListener {


    public PostalCodesListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_postal_codes_list, container, false);
    }

    @Override
    public void action(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}
