package com.example.trabajofinalcibertec.presentation.carrito_agregar;

import com.example.trabajofinalcibertec.data.entities.Comentario;
import com.example.trabajofinalcibertec.data.entities.responses.ProductoResponse;

import java.util.List;

public interface ICarritoAgregarContract {

    interface IView{
        void showError(String errorMsg);
        void getComentariosSuccess(List<Comentario> comentarioList);
        void getPostDetailSuccess(ProductoResponse productoResponse);
        //void getAllPostSuccess(List<Com> postList);
        //void gotToDetailPost(int postId);
    }
    interface IPresenter{
        void attachView(IView view);
        void detachView();
        boolean isViewAttached();
        void getProducto(int id);
        void getComentarios(int id);
    }
}
