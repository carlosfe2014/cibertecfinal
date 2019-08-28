package com.example.trabajofinalcibertec.presentation.carrito_buscar.presenter;

import android.text.TextUtils;

import com.example.trabajofinalcibertec.data.entities.Producto;
import com.example.trabajofinalcibertec.data.entities.responses.BusquedaResponse;
import com.example.trabajofinalcibertec.data.entities.responses.ProductoResponse;
import com.example.trabajofinalcibertec.domain.buscarproducto_interactor.IBuscarProductoInteractor;
import com.example.trabajofinalcibertec.presentation.carrito_buscar.ICarritoBuscarContract;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class CarritoBuscarPresenter implements ICarritoBuscarContract.IPresenter {
    ICarritoBuscarContract.IView view;

    private final IBuscarProductoInteractor interactor;

    private Disposable disposable;

    @Inject
    public CarritoBuscarPresenter(IBuscarProductoInteractor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void attachView(ICarritoBuscarContract.IView view) {
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
    public void searchProductos(String query) {

        interactor.searchProductos(query)
                .subscribe(new Observer<BusquedaResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable = d;
                    }

                    @Override
                    public void onNext(BusquedaResponse busquedaResponse) {
                        if(isViewAttached()) {
                            view.getSearchProductosSuccess(busquedaResponse);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if(isViewAttached()) {
                            view.showError(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
