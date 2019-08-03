package com.example.trabajofinalcibertec.presentation.carrito;

import com.example.trabajofinalcibertec.data.entities.Producto;

import java.util.List;

public interface ICarritoContract {

    interface IView{
        void showError(String errorMsg);
        void getAllProductosSuccess(List<Producto> productoList);
        //void getAllPostSuccess(List<Com> postList);
        //void gotToDetailPost(int postId);
    }
    interface IPresenter{
        void attachView(IView view);
        void detachView();
        boolean isViewAttached();
        void getAllProductos();
    }
}
