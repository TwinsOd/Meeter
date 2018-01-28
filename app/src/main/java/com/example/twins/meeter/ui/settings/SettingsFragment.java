package com.example.twins.meeter.ui.settings;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.twins.meeter.App;
import com.example.twins.meeter.R;
import com.example.twins.meeter.data.models.AnimalModel;
import com.example.twins.meeter.ui.profileAnimal.ProfileAnimalActivity;

import static com.example.twins.meeter.Constants.CAT;
import static com.example.twins.meeter.Constants.DOG;


public class SettingsFragment extends Fragment implements View.OnClickListener {

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

        ImageView anim_2 = view.findViewById(R.id.anim_2);
        Glide.with(getContext())
                .load(R.drawable.dog_2)
                .apply(RequestOptions.circleCropTransform())
                .into(anim_2);

        view.findViewById(R.id.anim_layout_1).setOnClickListener(this);
        view.findViewById(R.id.anim_layout_2).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.anim_layout_1:
                AnimalModel model = new AnimalModel();
                model.setNickName("Спартак");
                model.setAnimal(CAT);
                model.setAge("2,5 года");
                model.setType("персидская");
                model.setImage(R.drawable.cat_1);
                model.setSex("женский");
                model.setCity("Одесса");
                model.setPrice("Не интересвется потомством");
                App.getRepository().setAnimalModel(model);
                startActivity(new Intent(getContext(), ProfileAnimalActivity.class));
                break;
            case R.id.anim_layout_2:
                AnimalModel model2 = new AnimalModel();
                model2.setNickName("Тоди");
                model2.setAnimal(DOG);
                model2.setAge("1,5 года");
                model2.setType("Бордер-терьер");
                model2.setImage(R.drawable.dog_1);
                model2.setSex("женский");
                model2.setCity("Киев");
                App.getRepository().setAnimalModel(model2);
                startActivity(new Intent(getContext(), ProfileAnimalActivity.class));
                break;
            }
        }
    }
