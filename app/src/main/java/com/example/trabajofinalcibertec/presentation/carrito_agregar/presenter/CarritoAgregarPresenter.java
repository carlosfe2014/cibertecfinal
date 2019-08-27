package com.example.trabajofinalcibertec.presentation.carrito_agregar.presenter;

import com.example.trabajofinalcibertec.data.entities.Comentario;
import com.example.trabajofinalcibertec.data.entities.responses.ProductoResponse;
import com.example.trabajofinalcibertec.domain.agregarproducto_interactor.IAgregarProductoInteractor;
import com.example.trabajofinalcibertec.presentation.carrito_agregar.ICarritoAgregarContract;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class CarritoAgregarPresenter implements ICarritoAgregarContract.IPresenter {
    ICarritoAgregarContract.IView view;

    private final IAgregarProductoInteractor interactor;
    private Disposable disposable;

    @Inject
    public CarritoAgregarPresenter(IAgregarProductoInteractor interactor) {
        this.interactor = interactor;
    }


    @Override
    public void attachView(ICarritoAgregarContract.IView view) {
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
    public void getProducto(int id) {
        interactor.getProducto(id)
                .subscribe(new Observer<ProductoResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable = d;
                    }

                    @Override
                    public void onNext(ProductoResponse productoResponse) {
                        if(isViewAttached()) {
                            view.getPostDetailSuccess(productoResponse);
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

    @Override
    public void getComentarios(int id) {
        List<Comentario> comentarioList = new ArrayList<>();
        comentarioList.add(new Comentario(1, 1, "Carlos Felipa", "Este es un comentario dejado por el usuario Carlos Felipa como una prueba simple del modelo", "01/08/2019"));
        comentarioList.add(new Comentario(2, 1, "Pedro Villa", "Este es un comentario dejado por el usuario Pedro Villa como una prueba simple del modelo", "01/08/2019"));
        comentarioList.add(new Comentario(3, 1, "Mario Sanchez", "Este es un comentario dejado por el usuario Mario Sanchez como una prueba simple del modelo", "02/08/2019"));
        comentarioList.add(new Comentario(4, 1, "Julio Vega", "Este es un comentario dejado por el usuario Julio Vega como una prueba simple del modelo", "03/08/2019"));
        view.getComentariosSuccess(comentarioList);
    }
}
