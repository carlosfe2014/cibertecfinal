package com.example.trabajofinalcibertec.presentation.carrito;

import android.content.Context;

import com.example.trabajofinalcibertec.data.entities.CompraProducto;

import java.util.List;

public interface ICarritoContract {

    interface IView{
        void showError(String errorMsg);
        Context getContext();
        void closeActivity(long respuesta);
    }
    interface IPresenter{
        void attachView(IView view);
        void detachView();
        boolean isViewAttached();
        void guardarCarrito(String titulo, String descripcion, List<CompraProducto> compraProductos);
    }
}
