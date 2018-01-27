package com.example.twins.meeter.ui.list_animal;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.twins.meeter.R;
import com.example.twins.meeter.data.models.AnimalModel;
import com.example.twins.meeter.ui.activityMain.ListAnimalListener;

import java.util.List;


public class ListAnimalFragment extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;
    private List<AnimalModel> animalModelList;
    private ListAnimalListener mListener;

    public ListAnimalFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ListAnimalFragment newInstance(int columnCount) {
        ListAnimalFragment fragment = new ListAnimalFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_animal, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new AnimalRecyclerViewAdapter(animalModelList, mListener));
        }
        return view;
    }

    public void setAnimalModelList(List<AnimalModel> animalModelList) {
        this.animalModelList = animalModelList;
    }

    public void setListener(ListAnimalListener mListener) {
        this.mListener = mListener;
    }
}
