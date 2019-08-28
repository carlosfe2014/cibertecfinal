package com.example.trabajofinalcibertec.presentation.registro.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.trabajofinalcibertec.R;
import com.example.trabajofinalcibertec.base.BaseActivity;
import com.example.trabajofinalcibertec.di.components.DaggerPresentationComponent;
import com.example.trabajofinalcibertec.di.modules.PresentationModule;
import com.example.trabajofinalcibertec.presentation.carrito.view.CarritoActivity;
import com.example.trabajofinalcibertec.presentation.carrito_agregar.view.CarritoAgregarActivity;
import com.example.trabajofinalcibertec.presentation.carrito_agregar.view.CarritoAgregarAdapter;
import com.example.trabajofinalcibertec.presentation.main.view.MainActivity;
import com.example.trabajofinalcibertec.presentation.registro.IRegistroContract;
import com.example.trabajofinalcibertec.presentation.registro.presenter.RegistroPresenter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import javax.inject.Inject;

public class RegistroActivity extends BaseActivity implements IRegistroContract.IView {


    private Button btnRegistroRegistrar;
    private Button btnRegistroCancelar;
    private EditText etRegistroEmail;
    private EditText etRegistroPassword;
    private EditText etRegistroPasswordConfirmacion;

    @Inject
    RegistroPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }




    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);

        presenter.attachView(this);
        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        etRegistroEmail = findViewById(R.id.etRegistroEmail);
        etRegistroPassword = findViewById(R.id.etRegistroPassword);
        etRegistroPasswordConfirmacion = findViewById(R.id.etRegistroPasswordConfirmacion);

        btnRegistroRegistrar = findViewById(R.id.btnRegistroRegistrar);
        btnRegistroCancelar = findViewById(R.id.btnRegistroCancelar);

        setListeners();
    }



    @Override
    protected int getContentView() {
        return R.layout.activity_registro;
    }

    @Override
    protected void resolveDaggerDependency() {
        DaggerPresentationComponent.builder()
                .applicationComponent(getApplicationComponent())
                .presentationModule(new PresentationModule())
                .build().inject(this);
    }

    private void setListeners() {
        btnRegistroRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etRegistroEmail.getText().toString();
                String password = etRegistroPassword.getText().toString();
                String passwordConfirmacion = etRegistroPasswordConfirmacion.getText().toString();
                if(password.equals(passwordConfirmacion)){
                    presenter.register(username,password);
                } else {
                    showError("Las contraseñas ingresadas no coinciden.");
                }
            }
        });

        btnRegistroCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showError(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void goToHome() {
        Intent intent = new Intent(RegistroActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
