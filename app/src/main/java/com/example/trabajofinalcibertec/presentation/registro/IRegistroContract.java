package com.example.trabajofinalcibertec.presentation.registro;

public interface IRegistroContract {
    interface IView{
        void showError(String errorMsg);
        void goToHome();
    }
    interface IPresenter{
        void attachView(IView view);
        void detachView();
        boolean isViewAttached();
        void register(String username, String password);
    }
}
