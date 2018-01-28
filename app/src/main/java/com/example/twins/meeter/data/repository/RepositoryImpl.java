package com.example.twins.meeter.data.repository;


import android.content.Context;
import android.support.annotation.NonNull;

import com.example.twins.meeter.R;
import com.example.twins.meeter.data.callback.DataCallback;
import com.example.twins.meeter.data.models.AnimalModel;

import java.util.ArrayList;
import java.util.List;

import static com.example.twins.meeter.Constants.CAT;
import static com.example.twins.meeter.Constants.DOG;

/**
 * Created by twins on 27.01.2018.
 */

public class RepositoryImpl implements Repository {
    private List<AnimalModel> listModelAnim = getList();
    private AnimalModel animalModel;
    private Context context;

    public RepositoryImpl(@NonNull Context context) {
        this.context = context;
    }

    @Override
    public void getAllAnimals(DataCallback<List<AnimalModel>> callback) {
//        List<AnimalModel> list = new ArrayList<>();
//        for (int i = 0; i < 25; i++) {
//            AnimalModel model = new AnimalModel();
//            model.setNickName("Nick name " + (i + 1));
//            model.setAge("" + (i + 2) / 2);
//            model.setType("Type test");
//            list.add(model);
//        }
//        list.get(0).setImage(R.drawable.cat_1);
//        list.get(1).setImage(R.drawable.cat_2);
//        list.get(2).setImage(R.drawable.dog_1);
//        list.get(3).setImage(R.drawable.cat_3);
//        list.get(4).setImage(R.drawable.dog_2);
//        list.get(5).setImage(R.drawable.cat_4);
//        list.get(6).setImage(R.drawable.dog_3);
//        list.get(7).setImage(R.drawable.dog_4);
//        callback.onEmit(list);
        callback.onEmit(listModelAnim);
        callback.onCompleted();
    }

    @Override
    public void getDogAnimals(DataCallback<List<AnimalModel>> callback) {
        List<AnimalModel> list = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            AnimalModel model = new AnimalModel();
//            model.setNickName("Dog name " + (i + 1));
//            model.setAge("" + (i + 2) / 2);
//            model.setType("Type test");
//            list.add(model);
//        }
        for (AnimalModel model : listModelAnim) {
            if (model.getAnimal() == DOG)
                list.add(model);
        }
        callback.onEmit(list);
        callback.onCompleted();
    }

    @Override
    public void getCatAnimals(DataCallback<List<AnimalModel>> callback) {
        List<AnimalModel> list = new ArrayList<>();
//        for (int i = 0; i < 11; i++) {
//            AnimalModel model = new AnimalModel();
//            model.setNickName("Cat name " + (i + 1));
//            model.setAge("" + (i + 2) / 2);
//            model.setType("Type test");
//            list.add(model);
//        }
        for (AnimalModel model : listModelAnim) {
            if (model.getAnimal() == CAT)
                list.add(model);
        }
        callback.onEmit(list);
        callback.onCompleted();
    }

    @Override
    public void getInbox(DataCallback<List<AnimalModel>> callback) {
        List<AnimalModel> list = new ArrayList<>();
//        for (int i = 0; i < 7; i++) {
//            AnimalModel model = new AnimalModel();
//            model.setNickName("Inbox name " + (i + 1));
//            model.setAge("" + (i + 2) / 2);
//            model.setType("Type test");
//
//            list.add(model);
//        }
        list.add(listModelAnim.get(1));
        list.add(listModelAnim.get(2));
        list.add(listModelAnim.get(5));
        list.add(listModelAnim.get(6));
        list.add(listModelAnim.get(8));
        list.add(listModelAnim.get(10));
        list.add(listModelAnim.get(11));
        list.add(listModelAnim.get(12));
        callback.onEmit(list);
        callback.onCompleted();
    }

    @Override
    public void getOutbox(DataCallback<List<AnimalModel>> callback) {
        List<AnimalModel> list = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            AnimalModel model = new AnimalModel();
//            model.setNickName("Outbox name " + (i + 1));
//            model.setAge("" + (i + 2) / 2);
//            model.setType("Type test");
//            list.add(model);
//        }
        list.add(listModelAnim.get(3));
        list.add(listModelAnim.get(4));
        list.add(listModelAnim.get(5));
        list.add(listModelAnim.get(10));
        list.add(listModelAnim.get(1));
        callback.onEmit(list);
        callback.onCompleted();
    }

    @Override
    public void getJoint(DataCallback<List<AnimalModel>> callback) {
        List<AnimalModel> list = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            AnimalModel model = new AnimalModel();
//            model.setNickName("Joint name " + (i + 1));
//            model.setAge("" + (i + 2) / 2);
//            model.setType("Type test");
//            list.add(model);
//        }
        list.add(listModelAnim.get(5));
        list.add(listModelAnim.get(10));
        list.add(listModelAnim.get(1));
        callback.onEmit(list);
        callback.onCompleted();
    }

    @Override
    public void setAnimalModel(AnimalModel animalModel) {
        this.animalModel = animalModel;
    }

    @Override
    public AnimalModel getAnimalModel() {
        return animalModel;
    }

    private List<AnimalModel> getList() {
        List<AnimalModel> list = new ArrayList<>();
        if (true) {
            AnimalModel model = new AnimalModel();
            model.setNickName("Виолета");
            model.setAnimal(CAT);
            model.setAge("2,5 года");
            model.setType("персидская");
            model.setImage(R.drawable.cat_1);
            model.setSex("женский");
            model.setCity("Одесса");
            list.add(model);
        }
        if (true) {
            AnimalModel model = new AnimalModel();
            model.setNickName("Доллар");
            model.setAnimal(DOG);
            model.setAge("1,5 года");
            model.setType("Бордер-терьер");
            model.setImage(R.drawable.dog_1);
            model.setSex("женский");
            model.setCity("Одесса");
            list.add(model);
        }
        if (true) {
            AnimalModel model = new AnimalModel();
            model.setNickName("Бусинка");
            model.setAnimal(CAT);
            model.setAge("3,5 года");
            model.setType("Корниш-рекс (Корнуэльский рекс) [CRX]");
            model.setImage(R.drawable.cat_2);
            model.setSex("женский");
            model.setCity("Одесса");
            list.add(model);
        }
        if (true) {
            AnimalModel model = new AnimalModel();
            model.setNickName("Спартак");
            model.setAnimal(CAT);
            model.setAge("5,5 года");
            model.setType("тайскач");
            model.setImage(R.drawable.cat_3);
            model.setSex("Парень");
            model.setCity("Одесса");
            list.add(model);
        }
        if (true) {
            AnimalModel model = new AnimalModel();
            model.setNickName("Виолета");
            model.setAnimal(DOG);
            model.setAge("6,5 года");
            model.setType("Котон-де-тулеар");
            model.setImage(R.drawable.dog_2);
            model.setSex("Парень");
            model.setCity("Одесса");
            list.add(model);
        }
        if (true) {
            AnimalModel model = new AnimalModel();
            model.setNickName("Дуся");
            model.setAnimal(DOG);
            model.setAge("2,5 года");
            model.setType("овчарка");
            model.setImage(R.drawable.dog_3);
            model.setSex("женский");
            model.setCity("Одесса");
            list.add(model);
        }
        if (true) {
            AnimalModel model = new AnimalModel();
            model.setNickName("Красотка");
            model.setAnimal(CAT);
            model.setAge("4 года");
            model.setType("Абиссинская кошка");
            model.setImage(R.drawable.cat_4);
            model.setSex("женский");
            model.setCity("Одесса");
            list.add(model);
        }
        if (true) {
            AnimalModel model = new AnimalModel();
            model.setNickName("Шустрый");
            model.setAnimal(DOG);
            model.setAge("5 года");
            model.setType("Афганская борзая");
            model.setImage(R.drawable.dog_4);
            model.setSex("Парень");
            model.setCity("Одесса");
            list.add(model);
        }
//double
        if (true) {
            AnimalModel model = new AnimalModel();
            model.setNickName("Виолета");
            model.setAnimal(CAT);
            model.setAge("2,5 года");
            model.setType("персидская");
            model.setImage(R.drawable.cat_1);
            model.setSex("женский");
            model.setCity("Одесса");
            list.add(model);
        }
        if (true) {
            AnimalModel model = new AnimalModel();
            model.setNickName("Доллар");
            model.setAnimal(DOG);
            model.setAge("1,5 года");
            model.setType("Бордер-терьер");
            model.setImage(R.drawable.dog_1);
            model.setSex("женский");
            model.setCity("Одесса");
            list.add(model);
        }
        if (true) {
            AnimalModel model = new AnimalModel();
            model.setNickName("Бусинка");
            model.setAnimal(CAT);
            model.setAge("3,5 года");
            model.setType("Корниш-рекс (Корнуэльский рекс) [CRX]");
            model.setImage(R.drawable.cat_2);
            model.setSex("женский");
            model.setCity("Одесса");
            list.add(model);
        }
        if (true) {
            AnimalModel model = new AnimalModel();
            model.setNickName("Спартак");
            model.setAnimal(CAT);
            model.setAge("5,5 года");
            model.setType("тайскач");
            model.setImage(R.drawable.cat_3);
            model.setSex("Парень");
            model.setCity("Одесса");
            list.add(model);
        }
        if (true) {
            AnimalModel model = new AnimalModel();
            model.setNickName("Виолета");
            model.setAnimal(DOG);
            model.setAge("6,5 года");
            model.setType("Котон-де-тулеар");
            model.setImage(R.drawable.dog_2);
            model.setSex("Парень");
            model.setCity("Одесса");
            list.add(model);
        }
        if (true) {
            AnimalModel model = new AnimalModel();
            model.setNickName("Дуся");
            model.setAnimal(DOG);
            model.setAge("2,5 года");
            model.setType("овчарка");
            model.setImage(R.drawable.dog_3);
            model.setSex("женский");
            model.setCity("Одесса");
            list.add(model);
        }
        if (true) {
            AnimalModel model = new AnimalModel();
            model.setNickName("Красотка");
            model.setAnimal(CAT);
            model.setAge("4 года");
            model.setType("Абиссинская кошка");
            model.setImage(R.drawable.cat_4);
            model.setSex("женский");
            model.setCity("Одесса");
            list.add(model);
        }
        if (true) {
            AnimalModel model = new AnimalModel();
            model.setNickName("Шустрый");
            model.setAnimal(DOG);
            model.setAge("5 года");
            model.setType("Афганская борзая");
            model.setImage(R.drawable.dog_4);
            model.setSex("Парень");
            model.setCity("Одесса");
            list.add(model);
        }

        return list;
    }
}
