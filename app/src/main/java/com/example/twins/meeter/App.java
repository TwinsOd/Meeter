package com.example.twins.meeter;

import android.app.Application;

import com.example.twins.meeter.data.repository.Repository;
import com.example.twins.meeter.data.repository.RepositoryImpl;

/**
 * Created by twins on 27.01.2018.
 */

public class App extends Application {
    private static Repository repository;
    @Override
    public void onCreate() {
        super.onCreate();
        repository = new RepositoryImpl(this);
    }

    public static Repository getRepository() {
        return repository;
    }
}
