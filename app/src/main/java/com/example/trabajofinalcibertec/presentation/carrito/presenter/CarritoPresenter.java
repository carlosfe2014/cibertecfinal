package com.example.trabajofinalcibertec.presentation.carrito.presenter;

import android.text.TextUtils;
import android.widget.Toast;

import com.example.trabajofinalcibertec.data.entities.Producto;
import com.example.trabajofinalcibertec.domain.carrito_interactor.ICarritoInteractor;
import com.example.trabajofinalcibertec.presentation.carrito.ICarritoContract;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CarritoPresenter implements ICarritoContract.IPresenter {
    ICarritoContract.IView view;

    private final ICarritoInteractor interactor;

    @Inject
    public CarritoPresenter(ICarritoInteractor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void attachView(ICarritoContract.IView view) {
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
    public void getAllProductos() {
        List<Producto> carritoList = new ArrayList<>();
        //carritoList.add(new Producto(1,"Inka Cola 1 Lt", "Bebina gasseosa", "ada", 6.10,6.20,6.0, 1));
        //carritoList.add(new Producto(1,"Coca Cola 1 Lt", "Bebina gasseosa", "ada", 5.10,5.20,5.0, 1));
        //carritoList.add(new Producto(1,"Pepsi Cola 1 Lt", "Bebina gasseosa", "ada", 4.10,4.20,4.0, 1));
        //carritoList.add(new Producto(1,"Kola Real 1 Lt", "Bebina gasseosa", "ada", 2.10,2.20,1.9, 1));
        view.getAllProductosSuccess(carritoList);
    }

    @Override
    public void guardarCarrito(String titulo, String descripcion) {
        if(TextUtils.isEmpty(titulo)){
            if(isViewAttached()) view.showError("El titulo del Carrito es invalido.");
        } else {
            FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
            if(currentFirebaseUser != null){
                long respuesta = interactor.guardarCarrito(currentFirebaseUser.getUid(), titulo, descripcion);
                view.closeActivity();
            }

        }
    }
}
