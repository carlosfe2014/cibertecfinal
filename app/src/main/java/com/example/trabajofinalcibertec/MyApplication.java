package com.example.trabajofinalcibertec;

import android.app.Application;

import com.example.trabajofinalcibertec.di.components.ApplicationComponent;

import com.example.trabajofinalcibertec.di.components.DaggerApplicationComponent;
import com.example.trabajofinalcibertec.di.modules.ApplicationModule;


public class MyApplication extends Application {
    private ApplicationComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        inicializarComponent();
    }

    void inicializarComponent(){
        appComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
    }


    public ApplicationComponent getApplicationComponent() {
        return appComponent;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
