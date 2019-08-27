package com.example.trabajofinalcibertec.di.modules;

import com.example.trabajofinalcibertec.data.repository.IProductoRepository;
import com.example.trabajofinalcibertec.di.scope.PerActivity;
import com.example.trabajofinalcibertec.domain.agregarproducto_interactor.AgregarProductoInteractorImpl;
import com.example.trabajofinalcibertec.domain.agregarproducto_interactor.IAgregarProductoInteractor;
import com.example.trabajofinalcibertec.domain.buscarproducto_interactor.BuscarProductoInteractorImpl;
import com.example.trabajofinalcibertec.domain.buscarproducto_interactor.IBuscarProductoInteractor;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;

@Module
public class PresentationModule {


    @PerActivity
    @Provides
    IBuscarProductoInteractor provideBuscarProductoInteractor(IProductoRepository repository,
                                                               @Named("ui_thread") Scheduler uiThread,
                                                               @Named("executor_thread") Scheduler executorThread){
        return new BuscarProductoInteractorImpl(repository, uiThread, executorThread);
    }


    @PerActivity
    @Provides
    IAgregarProductoInteractor provideAgregarProductoInteractor(IProductoRepository repository,
                                                                @Named("ui_thread") Scheduler uiThread,
                                                                @Named("executor_thread") Scheduler executorThread){
        return new AgregarProductoInteractorImpl(repository, uiThread, executorThread);
    }
}
