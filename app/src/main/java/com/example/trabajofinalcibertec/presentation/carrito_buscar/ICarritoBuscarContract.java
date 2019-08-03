package com.example.trabajofinalcibertec.presentation.carrito_buscar;

import com.example.trabajofinalcibertec.data.entities.Producto;

import java.util.List;

public interface ICarritoBuscarContract {
    interface IView{
        void showError(String errorMsg);
        void getBuscarProductosSuccess(List<Producto> productoList);
        //void getAllPostSuccess(List<Com> postList);
        //void gotToDetailPost(int postId);
        void gotToProductoAgregar(int position);
    }
    interface IPresenter{
        void attachView(IView view);
        void detachView();
        boolean isViewAttached();
        void buscarProductos(String query);
    }
}
