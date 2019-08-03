package com.example.trabajofinalcibertec.presentation.carrito_buscar.presenter;

import com.example.trabajofinalcibertec.data.entities.Producto;
import com.example.trabajofinalcibertec.presentation.carrito_buscar.ICarritoBuscarContract;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CarritoBuscarPresenter implements ICarritoBuscarContract.IPresenter {
    ICarritoBuscarContract.IView view;

    @Inject
    public CarritoBuscarPresenter() {
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
    public void buscarProductos(String query) {
        List<Producto> carritoList = new ArrayList<>();
        carritoList.add(new Producto(1,"Inka Cola 1 Lt", "Bebina gasseosa", "ada", 6.10,6.20,6.0));
        carritoList.add(new Producto(1,"Coca Cola 1 Lt", "Bebina gasseosa", "ada", 5.10,5.20,5.0));
        carritoList.add(new Producto(1,"Pepsi Cola 1 Lt", "Bebina gasseosa", "ada", 4.10,4.20,4.0));
        carritoList.add(new Producto(1,"Kola Real 1 Lt", "Bebina gasseosa", "ada", 2.10,2.20,1.9));
        view.getBuscarProductosSuccess(carritoList);
    }
}
