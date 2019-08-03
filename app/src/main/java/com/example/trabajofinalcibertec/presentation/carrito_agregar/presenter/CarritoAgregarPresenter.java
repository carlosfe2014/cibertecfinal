package com.example.trabajofinalcibertec.presentation.carrito_agregar.presenter;

import com.example.trabajofinalcibertec.data.entities.Comentario;
import com.example.trabajofinalcibertec.presentation.carrito_agregar.ICarritoAgregarContract;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CarritoAgregarPresenter implements ICarritoAgregarContract.IPresenter {
    ICarritoAgregarContract.IView view;

    @Inject
    public CarritoAgregarPresenter() {
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
    public void getComentarios(int id) {
        List<Comentario> comentarioList = new ArrayList<>();
        comentarioList.add(new Comentario(1, 1, "Carlos Felipa", "Este es un comentario dejado por el usuario Carlos Felipa como una prueba simple del modelo", "01/08/2019"));
        comentarioList.add(new Comentario(2, 1, "Pedro Villa", "Este es un comentario dejado por el usuario Pedro Villa como una prueba simple del modelo", "01/08/2019"));
        comentarioList.add(new Comentario(3, 1, "Mario Sanchez", "Este es un comentario dejado por el usuario Mario Sanchez como una prueba simple del modelo", "02/08/2019"));
        comentarioList.add(new Comentario(4, 1, "Julio Vega", "Este es un comentario dejado por el usuario Julio Vega como una prueba simple del modelo", "03/08/2019"));
        view.getComentariosSuccess(comentarioList);
    }
}
