package com.example.twins.meeter.ui.filter;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.example.twins.meeter.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FilterDialogFragment extends DialogFragment {


    public FilterDialogFragment() {
        // Required empty public constructor
    }

    public static FilterDialogFragment newInstance() {
        return new FilterDialogFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_filter_dialog, container, false);
//        if (getDialog().getWindow() != null)
//            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().setTitle(getString(R.string.settings));


        return view;
    }

}
