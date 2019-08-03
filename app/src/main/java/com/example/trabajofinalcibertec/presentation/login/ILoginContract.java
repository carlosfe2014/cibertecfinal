package com.example.trabajofinalcibertec.presentation.login;

public interface ILoginContract {
    interface IView{
        void showError(String errorMsg);
    }
    interface IPresenter{
        void attachView(IView view);
        void detachView();
        boolean isViewAttached();
    }
}
