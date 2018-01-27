package com.example.twins.meeter.ui.favorites;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.twins.meeter.R;

public class FavoritesFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public FavoritesFragment() {
        // Required empty public constructor
    }

    public static FavoritesFragment newInstance() {
        return new FavoritesFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorites, container, false);

        return view;
    }

}
