package com.example.trabajofinalcibertec.di.components;

import android.content.Context;

import com.example.trabajofinalcibertec.data.repository.IProductoRepository;
import com.example.trabajofinalcibertec.di.modules.ApplicationModule;
import com.example.trabajofinalcibertec.network.JsonPlaceHolderApi;
import com.google.firebase.auth.FirebaseAuth;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;
import io.reactivex.Scheduler;
import retrofit2.Retrofit;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    Retrofit exposeRetrofit();
    JsonPlaceHolderApi exposeJsonPlaceHolderApi();
    FirebaseAuth exposeFirebaseAuth();
    IProductoRepository provideProductoRepository();
    @Named("ui_thread")
    Scheduler uiThread();
    @Named("executor_thread") Scheduler executorThread();
}
