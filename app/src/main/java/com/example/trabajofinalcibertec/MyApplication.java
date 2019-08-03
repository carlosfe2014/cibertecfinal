package com.example.trabajofinalcibertec;

import android.app.Application;

import com.example.trabajofinalcibertec.di.components.DaggerPresentationComponent;
import com.example.trabajofinalcibertec.di.components.PresentationComponent;
import com.example.trabajofinalcibertec.di.modules.PresentationModule;

public class MyApplication extends Application {
    private PresentationComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        inicializarComponent();
    }

    void inicializarComponent(){
        appComponent = DaggerPresentationComponent
                .builder()
                .presentationModule(new PresentationModule())
                .build();
    }

    public PresentationComponent getAppComponent() {
        return appComponent;
    }
}
