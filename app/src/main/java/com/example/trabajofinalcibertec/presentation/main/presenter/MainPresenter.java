package com.example.trabajofinalcibertec.presentation.main.presenter;

import com.example.trabajofinalcibertec.data.entities.Compra;
import com.example.trabajofinalcibertec.database.AppDatabase;
import com.example.trabajofinalcibertec.presentation.main.IMainContract;

import java.util.List;

import javax.inject.Inject;

public class MainPresenter implements IMainContract.IPresenter {




    @Inject
    public MainPresenter() {
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
        AppDatabase db = AppDatabase.getInstance(view.getContext());
        List<Compra> comprasList = db.compraDao().getAll();
        view.getAllComprasSuccess(comprasList);
    }
}
