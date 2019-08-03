package com.example.trabajofinalcibertec.presentation.main;

import com.example.trabajofinalcibertec.data.entities.Compra;

import java.util.List;

public interface IMainContract {
    interface IView{
        void showError(String errorMsg);
        void getAllComprassSuccess(List<Compra> compraList);
        //void getAllPostSuccess(List<Com> postList);
        //void gotToDetailPost(int postId);
    }
    interface IPresenter{
        void attachView(IView view);
        void detachView();
        boolean isViewAttached();
        void getAllCompras();
    }
}
