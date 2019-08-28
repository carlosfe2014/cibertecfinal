package com.example.trabajofinalcibertec.presentation.main;

import android.content.Context;

import com.example.trabajofinalcibertec.data.entities.Compra;

import java.util.List;

public interface IMainContract {
    interface IView{
        void showError(String errorMsg);
        void getAllComprasSuccess(List<Compra> compraList);
        Context getContext();
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
