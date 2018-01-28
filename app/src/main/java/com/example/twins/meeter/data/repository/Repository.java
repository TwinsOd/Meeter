package com.example.twins.meeter.data.repository;

import com.example.twins.meeter.data.callback.DataCallback;
import com.example.twins.meeter.data.models.AnimalModel;

import java.util.List;

/**
 * Created by twins on 27.01.2018.
 */

public interface Repository {
    void getAllAnimals(DataCallback<List<AnimalModel>> callback);

    void getDogAnimals(DataCallback<List<AnimalModel>> callback);

    void getCatAnimals(DataCallback<List<AnimalModel>> callback);

    void getInbox(DataCallback<List<AnimalModel>> callback);

    void getOutbox(DataCallback<List<AnimalModel>> callback);

    void getJoint(DataCallback<List<AnimalModel>> callback);
}
