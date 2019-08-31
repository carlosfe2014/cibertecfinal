package com.example.trabajofinalcibertec.presentation.carrito.presenter;

import android.text.TextUtils;

import com.example.trabajofinalcibertec.data.entities.CompraProducto;
import com.example.trabajofinalcibertec.domain.carrito_interactor.ICarritoInteractor;
import com.example.trabajofinalcibertec.presentation.carrito.ICarritoContract;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

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
    public void guardarCarrito(String titulo, String descripcion, List<CompraProducto> compraProductos) {
        if(TextUtils.isEmpty(titulo)){
            if(isViewAttached()) view.showError("El titulo del Carrito es invalido.");
        } else {

            if(compraProductos.size() > 0){
                FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
                if(currentFirebaseUser != null){
                    long respuesta = interactor.guardarCarrito(currentFirebaseUser.getUid(), titulo, descripcion);
                    if(respuesta > 0){
                        boolean guardar = interactor.guardarProductos(respuesta, compraProductos);
                        if(guardar){
                            view.closeActivity(respuesta);
                        }
                    } else {
                        if(isViewAttached()) view.showError("Error: No se pudo guardar la lista de compras.");
                    }
                } else {
                    if(isViewAttached()) view.showError("El inicio de sesión no es valido.");
                }
            } else {
                if(isViewAttached()) view.showError("El carrito está vacio.");
            }

        }
    }
}
