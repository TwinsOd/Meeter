package com.example.twins.meeter.ui.settings;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.twins.meeter.R;


public class SettingsFragment extends Fragment {

    public SettingsFragment() {
        // Required empty public constructor
    }

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        ImageView anim_1 = view.findViewById(R.id.anim_1);
        Glide.with(getContext())
                .load(R.drawable.cat_1)
                .apply(RequestOptions.circleCropTransform())
                .into(anim_1);

        ImageView anim_2 = view.findViewById(R.id.anim_1);
        Glide.with(getContext())
                .load(R.drawable.dog_2)
                .apply(RequestOptions.circleCropTransform())
                .into(anim_2);
        return view;
    }
}
