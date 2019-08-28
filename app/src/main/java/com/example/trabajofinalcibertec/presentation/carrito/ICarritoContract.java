package com.example.trabajofinalcibertec.presentation.carrito;

import android.content.Context;

import com.example.trabajofinalcibertec.data.entities.Producto;

import java.util.List;

public interface ICarritoContract {

    interface IView{
        void showError(String errorMsg);
        void getAllProductosSuccess(List<Producto> productoList);
        Context getContext();
        void closeActivity();
        //void getAllPostSuccess(List<Com> postList);
        //void gotToDetailPost(int postId);
    }
    interface IPresenter{
        void attachView(IView view);
        void detachView();
        boolean isViewAttached();
        void getAllProductos();
        void guardarCarrito(String titulo, String descripcion);
    }
}
