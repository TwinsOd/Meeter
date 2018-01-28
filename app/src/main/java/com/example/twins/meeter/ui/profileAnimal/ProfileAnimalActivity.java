package com.example.twins.meeter.ui.profileAnimal;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.twins.meeter.App;
import com.example.twins.meeter.R;
import com.example.twins.meeter.data.models.AnimalModel;
import com.example.twins.meeter.data.utils.DisplayUtils;

import static com.example.twins.meeter.Constants.CAT;
import static com.example.twins.meeter.Constants.DOG;

public class ProfileAnimalActivity extends Activity implements View.OnClickListener{
private AnimalModel animalModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_animal);
        animalModel = App.getRepository().getAnimalModel();
        ((TextView)findViewById(R.id.type_view)).setText(animalModel.getType());
        ((TextView)findViewById(R.id.price_view)).setText(animalModel.getPrice());
        ((TextView)findViewById(R.id.sex_view)).setText(animalModel.getSex());
        ((TextView)findViewById(R.id.city_view)).setText(animalModel.getCity());
        ((TextView)findViewById(R.id.age_view)).setText(animalModel.getAge());
        ((TextView)findViewById(R.id.breeding_view)).setText(animalModel.getBreeding() == null ? "  -   " : animalModel.getBreeding());
        ((TextView)findViewById(R.id.certification_view)).setText(animalModel.getListCertification() == null ? "  -   " : animalModel.getBreeding());
        TextView title = findViewById(R.id.title_tool_bar);
        switch (animalModel.getAnimal()){
            case CAT:
                title.setText("Кот/Кошка");
                break;
            case DOG:
                title.setText("Собака");
                break;
        }
        ImageView photo = findViewById(R.id.photo_animal);
        int widthDisplay = DisplayUtils.getDisplaySize(this).x;
        ViewGroup.LayoutParams param = photo.getLayoutParams();
        param.width = widthDisplay;
        param.height = (widthDisplay / 100) * 70;
        photo.setLayoutParams(param);
        Glide
                .with(this)
                .load(animalModel.getImage())
                .into(photo);
        findViewById(R.id.back_view).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_view:
                onBackPressed();
                break;
        }
    }
}
