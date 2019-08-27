package com.example.trabajofinalcibertec.presentation.carrito_buscar;

import com.example.trabajofinalcibertec.data.entities.Producto;
import com.example.trabajofinalcibertec.data.entities.responses.BusquedaResponse;
import com.example.trabajofinalcibertec.data.entities.responses.ProductoResponse;

import java.util.List;

public interface ICarritoBuscarContract {
    interface IView{
        void showError(String errorMsg);
        void getBuscarProductosSuccess(List<Producto> productoList);
        //void getAllPostSuccess(List<Com> postList);
        //void gotToDetailPost(int postId);
        void gotToProductoAgregar(int position);
        void getSearchProductosSuccess(BusquedaResponse busquedaResponse);
    }
    interface IPresenter{
        void attachView(IView view);
        void detachView();
        boolean isViewAttached();
        void searchProductos(String query);
    }
}
