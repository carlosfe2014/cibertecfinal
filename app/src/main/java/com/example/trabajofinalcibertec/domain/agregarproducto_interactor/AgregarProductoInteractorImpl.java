package com.example.trabajofinalcibertec.domain.agregarproducto_interactor;

import com.example.trabajofinalcibertec.data.entities.responses.ProductoResponse;
import com.example.trabajofinalcibertec.data.repository.IProductoRepository;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

public class AgregarProductoInteractorImpl implements IAgregarProductoInteractor{
    private final IProductoRepository productoRepository;
    private final Scheduler uiThread;
    private final Scheduler executorThread;

    @Inject
    public AgregarProductoInteractorImpl(IProductoRepository productoRepository, Scheduler uiThread, Scheduler executorThread) {
        this.productoRepository = productoRepository;
        this.uiThread = uiThread;
        this.executorThread = executorThread;
    }

    @Override
    public Observable<ProductoResponse> getProducto(int productoId) {
        return productoRepository.getProducto(productoId).observeOn(uiThread)
                .subscribeOn(executorThread);
    }
}
