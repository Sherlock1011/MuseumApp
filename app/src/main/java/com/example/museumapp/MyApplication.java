package com.example.museumapp;

import android.app.Application;
import android.widget.Toast;

import com.example.museumapp.bean.greendao.DatabaseManager;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        DatabaseManager.getInstance().initDataBase(this);
    }
}
