package com.example.trabajofinalcibertec.domain.buscarproducto_interactor;

import com.example.trabajofinalcibertec.data.entities.responses.BusquedaResponse;
import com.example.trabajofinalcibertec.data.entities.responses.ProductoResponse;
import com.example.trabajofinalcibertec.data.repository.IProductoRepository;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

public class BuscarProductoInteractorImpl implements IBuscarProductoInteractor{

    private final IProductoRepository productoRepository;
    private final Scheduler uiThread;
    private final Scheduler executorThread;

    @Inject
    public BuscarProductoInteractorImpl(IProductoRepository productoRepository, Scheduler uiThread, Scheduler executorThread) {
        this.productoRepository = productoRepository;
        this.uiThread = uiThread;
        this.executorThread = executorThread;
    }

    @Override
    public Observable<BusquedaResponse> searchProductos(String query) {
        return productoRepository.searchProductos(query).observeOn(uiThread)
                .subscribeOn(executorThread);
    }
}
