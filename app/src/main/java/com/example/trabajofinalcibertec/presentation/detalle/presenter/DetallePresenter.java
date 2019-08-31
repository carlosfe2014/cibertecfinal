package com.example.trabajofinalcibertec.presentation.detalle.presenter;

import com.example.trabajofinalcibertec.data.entities.Compra;
import com.example.trabajofinalcibertec.data.entities.CompraProducto;
import com.example.trabajofinalcibertec.domain.detalle_interactor.IDetalleInteractor;
import com.example.trabajofinalcibertec.presentation.detalle.IDetalleContract;

import java.util.List;

import javax.inject.Inject;

public class DetallePresenter implements IDetalleContract.IPresenter {
    IDetalleContract.IView view;

    private final IDetalleInteractor interactor;

    @Inject
    public DetallePresenter(IDetalleInteractor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void attachView(IDetalleContract.IView view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public boolean isViewAttached() {
        return view != null;
    }

    @Override
    public void getCarritoDetalle(long id) {
        Compra compra = interactor.getCarritoDetalle(id);
        view.getCarritoDetalle(compra);
    }

    @Override
    public void getCarritoProductos(long id) {
        List<CompraProducto> carritoList = interactor.getCarritoProductos(id);
        view.getAllCarritoProductos(carritoList);
    }
}
