package com.example.twins.meeter.data.repository;


import android.content.Context;
import android.support.annotation.NonNull;

import com.example.twins.meeter.data.callback.DataCallback;
import com.example.twins.meeter.data.models.AnimalModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by twins on 27.01.2018.
 */

public class RepositoryImpl implements Repository {
    private Context context;

    public RepositoryImpl(@NonNull Context context) {
        this.context = context;
    }

    @Override
    public void getAllAnimals(DataCallback<List<AnimalModel>> callback) {
        List<AnimalModel> list = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            AnimalModel model = new AnimalModel();
            model.setNickName("Nick name " + (i +1));
            model.setAge("" + (i+2)/2);
            model.setType("Type test");
            list.add(model);
        }
        callback.onEmit(list);
        callback.onCompleted();
    }

    @Override
    public void getDogAnimals(DataCallback<List<AnimalModel>> callback) {
        List<AnimalModel> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            AnimalModel model = new AnimalModel();
            model.setNickName("Dog name " + (i +1));
            model.setAge("" + (i+2)/2);
            model.setType("Type test");
            list.add(model);
        }
        callback.onEmit(list);
        callback.onCompleted();
    }

    @Override
    public void getCatAnimals(DataCallback<List<AnimalModel>> callback) {
        List<AnimalModel> list = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            AnimalModel model = new AnimalModel();
            model.setNickName("Cat name " + (i +1));
            model.setAge("" + (i+2)/2);
            model.setType("Type test");
            list.add(model);
        }
        callback.onEmit(list);
        callback.onCompleted();
    }

    @Override
    public void getInbox(DataCallback<List<AnimalModel>> callback) {
        List<AnimalModel> list = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            AnimalModel model = new AnimalModel();
            model.setNickName("Inbox name " + (i +1));
            model.setAge("" + (i+2)/2);
            model.setType("Type test");
            list.add(model);
        }
        callback.onEmit(list);
        callback.onCompleted();
    }

    @Override
    public void getOutbox(DataCallback<List<AnimalModel>> callback) {
        List<AnimalModel> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            AnimalModel model = new AnimalModel();
            model.setNickName("Outbox name " + (i +1));
            model.setAge("" + (i+2)/2);
            model.setType("Type test");
            list.add(model);
        }
        callback.onEmit(list);
        callback.onCompleted();
    }

    @Override
    public void getJoint(DataCallback<List<AnimalModel>> callback) {
        List<AnimalModel> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            AnimalModel model = new AnimalModel();
            model.setNickName("Joint name " + (i +1));
            model.setAge("" + (i+2)/2);
            model.setType("Type test");
            list.add(model);
        }
        callback.onEmit(list);
        callback.onCompleted();
    }
}
