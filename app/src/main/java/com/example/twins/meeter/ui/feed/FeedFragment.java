package com.example.twins.meeter.ui.feed;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.twins.meeter.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FeedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FeedFragment extends Fragment {

    public FeedFragment() {
        // Required empty public constructor
    }

    public static FeedFragment newInstance() {
        return new FeedFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feed, container, false);

        return view;
    }
}
