package com.example.trabajofinalcibertec.presentation.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trabajofinalcibertec.R;
import com.example.trabajofinalcibertec.base.BaseActivity;
import com.example.trabajofinalcibertec.di.components.DaggerPresentationComponent;
import com.example.trabajofinalcibertec.di.modules.PresentationModule;
import com.example.trabajofinalcibertec.presentation.carrito_agregar.presenter.CarritoAgregarPresenter;
import com.example.trabajofinalcibertec.presentation.login.ILoginContract;
import com.example.trabajofinalcibertec.presentation.login.presenter.LoginPresenter;
import com.example.trabajofinalcibertec.presentation.main.view.MainActivity;
import com.example.trabajofinalcibertec.presentation.registro.view.RegistroActivity;

import javax.inject.Inject;

public class LoginActivity extends BaseActivity implements ILoginContract.IView {


    @Inject
    LoginPresenter presenter;

    EditText etLoginUsuario;
    EditText etLoginPassword;
    Button btnLoginIngresar;
    Button btnLoginRegistro;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);


        presenter.attachView(this);
        presenter.checkUserLogged();

        etLoginUsuario = findViewById(R.id.etLoginUsuario);
        etLoginPassword = findViewById(R.id.etLoginPassword);
        btnLoginIngresar = findViewById(R.id.btnLoginIngresar);
        btnLoginRegistro = findViewById(R.id.btnLoginRegistro);

        setListeners();
    }

    @Override
    protected void resolveDaggerDependency() {
        DaggerPresentationComponent.builder()
                .applicationComponent(getApplicationComponent())
                .presentationModule(new PresentationModule())
                .build().inject(this);
    }


    @Override
    protected int getContentView() {
        return R.layout.activity_login;
    }

    @Override
    public void showError(String errorMsg) {
        Toast.makeText(this,errorMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void goToHome() {
        Intent intent = new Intent(getApplicationContext() , MainActivity.class);
        startActivity(intent);
    }

    private void setListeners(){
        btnLoginIngresar.setOnClickListener(v -> {
            String username = etLoginUsuario.getText().toString();
            String password = etLoginPassword.getText().toString();
            presenter.login(username,password);
        });
        btnLoginRegistro.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), RegistroActivity.class);
            startActivity(intent);
        });
    }

}
