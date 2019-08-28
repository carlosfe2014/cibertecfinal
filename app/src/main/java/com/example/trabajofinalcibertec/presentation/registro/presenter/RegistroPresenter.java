package com.example.trabajofinalcibertec.presentation.registro.presenter;

import android.text.TextUtils;

import com.example.trabajofinalcibertec.presentation.registro.IRegistroContract;
import com.google.firebase.auth.FirebaseAuth;

import javax.inject.Inject;

public class RegistroPresenter implements IRegistroContract.IPresenter {

    IRegistroContract.IView view;

    private final FirebaseAuth firebaseAuth;

    @Inject
    public RegistroPresenter(FirebaseAuth firebaseAuth) {
        this.firebaseAuth = firebaseAuth;
    }

    @Override
    public void attachView(IRegistroContract.IView view) {
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
    public void register(String username, String password) {
        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
            if(isViewAttached()) view.showError("No deje los campos vacios");
        } else {
            firebaseAuth.createUserWithEmailAndPassword(username, password)
                    .addOnCompleteListener(task -> {
                        if(isViewAttached()){
                            if(task.isSuccessful()){
                                view.goToHome();
                            } else {
                                view.showError(task.getException().getMessage());
                            }
                        }
                    });
        }
    }
}
