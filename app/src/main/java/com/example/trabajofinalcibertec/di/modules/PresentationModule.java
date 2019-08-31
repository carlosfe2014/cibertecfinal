package com.example.trabajofinalcibertec.di.modules;

import com.example.trabajofinalcibertec.data.repository.ICompraRepository;
import com.example.trabajofinalcibertec.data.repository.IProductoRepository;
import com.example.trabajofinalcibertec.di.scope.PerActivity;
import com.example.trabajofinalcibertec.domain.agregarproducto_interactor.AgregarProductoInteractorImpl;
import com.example.trabajofinalcibertec.domain.agregarproducto_interactor.IAgregarProductoInteractor;
import com.example.trabajofinalcibertec.domain.buscarproducto_interactor.BuscarProductoInteractorImpl;
import com.example.trabajofinalcibertec.domain.buscarproducto_interactor.IBuscarProductoInteractor;
import com.example.trabajofinalcibertec.domain.carrito_interactor.CarritoInteractorImpl;
import com.example.trabajofinalcibertec.domain.carrito_interactor.ICarritoInteractor;
import com.example.trabajofinalcibertec.domain.detalle_interactor.DetalleInteractorImpl;
import com.example.trabajofinalcibertec.domain.detalle_interactor.IDetalleInteractor;
import com.example.trabajofinalcibertec.domain.main_interactor.IMainInteractor;
import com.example.trabajofinalcibertec.domain.main_interactor.MainInteractorImpl;

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


    @PerActivity
    @Provides
    IMainInteractor provideIMainInteractor(ICompraRepository repository){
        return new MainInteractorImpl(repository);
    }

    @PerActivity
    @Provides
    ICarritoInteractor provideCarritoInteractor(ICompraRepository repository){
        return new CarritoInteractorImpl(repository);
    }

    @PerActivity
    @Provides
    IDetalleInteractor provideDetalleInteractor(ICompraRepository repository){
        return new DetalleInteractorImpl(repository);
    }

}
