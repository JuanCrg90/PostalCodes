package me.juancrg90.postalcodes.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.juancrg90.postalcodes.R;
import me.juancrg90.postalcodes.adapters.PostalCodeAdapter;
import me.juancrg90.postalcodes.entities.PostalCode;

/**
 * A simple {@link Fragment} subclass.
 */
public class PostalCodesListFragment extends Fragment implements PostalCodesListFragmentListener {

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    PostalCodeAdapter adapter;

    public PostalCodesListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_postal_codes_list, container, false);
        ButterKnife.bind(this, view);
        initAdapter();
        initRecyclerView();
        return view;
    }


    private void initAdapter() {
        if(adapter == null) {
            adapter = new PostalCodeAdapter(getActivity().getApplicationContext(), new ArrayList<PostalCode>());
        }
    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void addToList(List<PostalCode> postalCodeList) {
        clearList();

        for(int i = 0; i < postalCodeList.size(); i++) {
            adapter.add(postalCodeList.get(i));
        }

    }

    @Override
    public void clearList() {
        adapter.clear();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
