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

import com.example.twins.meeter.App;
import com.example.twins.meeter.Constants;
import com.example.twins.meeter.R;
import com.example.twins.meeter.data.callback.DataCallback;
import com.example.twins.meeter.data.models.AnimalModel;
import com.example.twins.meeter.ui.activityMain.ListAnimalListener;

import java.lang.reflect.Type;
import java.util.List;

import static bolts.AppLinkNavigation.NavigationResult.APP;
import static com.example.twins.meeter.Constants.ALL_ANIMAL;
import static com.example.twins.meeter.Constants.CAT_ANIMAL;
import static com.example.twins.meeter.Constants.DOG_ANIMAL;


public class ListAnimalFragment extends Fragment {

    private static final String TYPE = "type_animal";
    private int type = ALL_ANIMAL;
    private List<AnimalModel> animalModelList;
    private ListAnimalListener mListener;

    public ListAnimalFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ListAnimalFragment newInstance(int type) {
        ListAnimalFragment fragment = new ListAnimalFragment();
        Bundle args = new Bundle();
        args.putInt(TYPE, type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            type = getArguments().getInt(TYPE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_animal, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            final RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
//          recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            DataCallback<List<AnimalModel>> callback = new DataCallback<List<AnimalModel>>() {
                @Override
                public void onEmit(List<AnimalModel> data) {
                    recyclerView.setAdapter(new AnimalRecyclerViewAdapter(data, mListener));
                }

                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable throwable) {

                }
            };
            switch (type){
                case ALL_ANIMAL:
                    App.getRepository().getAllAnimals(callback);
                    break;
                case CAT_ANIMAL:
                    App.getRepository().getCatAnimals(callback);
                    break;
                case DOG_ANIMAL:
                    App.getRepository().getDogAnimals(callback);
                    break;

            }
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
