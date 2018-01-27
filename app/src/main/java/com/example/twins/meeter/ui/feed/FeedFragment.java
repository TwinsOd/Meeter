package com.example.twins.meeter.ui.feed;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.twins.meeter.R;
import com.example.twins.meeter.ui.activityMain.ListAnimalListener;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FeedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FeedFragment extends Fragment {

    private ListAnimalListener listAnimalListener;

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
        ViewPager viewPager = view.findViewById(R.id.view_pager_feed);
        FeedPagerAdapter adapter = new FeedPagerAdapter(getContext(), getFragmentManager(), listAnimalListener);
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = view.findViewById(R.id.tab_layout_feed);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }

    public void setListener(ListAnimalListener listAnimalListener) {
        this.listAnimalListener = listAnimalListener;
    }
}
