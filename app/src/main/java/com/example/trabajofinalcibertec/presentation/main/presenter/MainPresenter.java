package com.example.trabajofinalcibertec.presentation.main.presenter;

import com.example.trabajofinalcibertec.data.entities.Compra;
import com.example.trabajofinalcibertec.presentation.main.IMainContract;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainPresenter implements IMainContract.IPresenter {

    @Inject
    public MainPresenter() {
    }

    IMainContract.IView view;
    @Override
    public void attachView(IMainContract.IView view) {
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
    public void getAllCompras() {
        List<Compra> comprasList = new ArrayList<>();
        comprasList.add(new Compra(1,"Compras Desayuno", "Compras para el desayuno"));
        comprasList.add(new Compra(2,"Compras Semana Santa", "Compras para semana santa"));
        comprasList.add(new Compra(3,"Compras Cena", "Compras para la cena"));
        comprasList.add(new Compra(4,"Compras desde presenter", "Compras presenter"));
        view.getAllComprassSuccess(comprasList);
    }
}
