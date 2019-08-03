package com.example.trabajofinalcibertec.presentation.detalle;

import com.example.trabajofinalcibertec.data.entities.Producto;

import java.util.List;

public interface IDetalleContract {
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
