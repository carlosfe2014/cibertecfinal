package com.example.trabajofinalcibertec.presentation.carrito_agregar;

import com.example.trabajofinalcibertec.data.entities.Comentario;

import java.util.List;

public interface ICarritoAgregarContract {

    interface IView{
        void showError(String errorMsg);
        void getComentariosSuccess(List<Comentario> comentarioList);
        //void getAllPostSuccess(List<Com> postList);
        //void gotToDetailPost(int postId);
    }
    interface IPresenter{
        void attachView(IView view);
        void detachView();
        boolean isViewAttached();
        void getComentarios(int id);
    }
}
