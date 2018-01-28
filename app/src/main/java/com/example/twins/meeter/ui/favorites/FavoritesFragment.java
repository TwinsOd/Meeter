package com.example.twins.meeter.ui.favorites;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.twins.meeter.R;
import com.example.twins.meeter.ui.activityMain.ListAnimalListener;
import com.example.twins.meeter.ui.feed.FeedPagerAdapter;

public class FavoritesFragment extends Fragment {
    private ListAnimalListener listAnimalListener;

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
        ViewPager viewPager = view.findViewById(R.id.view_pager_favorites);
        FavoritesPagerAdapter adapter = new FavoritesPagerAdapter(getContext(), getChildFragmentManager(), listAnimalListener);
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = view.findViewById(R.id.tab_layout_favorites);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }

    public void setListener(ListAnimalListener listAnimalListener) {
        this.listAnimalListener = listAnimalListener;
    }
}
