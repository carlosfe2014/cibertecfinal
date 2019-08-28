package com.example.trabajofinalcibertec.presentation.main.presenter;

import com.example.trabajofinalcibertec.data.entities.Compra;
import com.example.trabajofinalcibertec.database.AppDatabase;
import com.example.trabajofinalcibertec.domain.main_interactor.IMainInteractor;
import com.example.trabajofinalcibertec.presentation.main.IMainContract;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

public class MainPresenter implements IMainContract.IPresenter {


    private final IMainInteractor interactor;


    @Inject
    public MainPresenter(IMainInteractor interactor) {
        this.interactor = interactor;
    }

    IMainContract.IView view;
    @Override
    public void attachView(IMainContract.IView view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public boolean isViewAttached() {
        return view != null;
    }

    @Override
    public void getAllCompras() {
        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
        if(currentFirebaseUser != null){
            List<Compra> comprasList = interactor.searchProductos(currentFirebaseUser.getUid());
            view.getAllComprasSuccess(comprasList);
        } else{
            view.showError("Error: no se detectó un inicio de sesión.");
        }
    }
}
