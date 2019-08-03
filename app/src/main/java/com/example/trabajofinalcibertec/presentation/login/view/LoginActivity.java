package com.example.trabajofinalcibertec.presentation.login.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trabajofinalcibertec.R;
import com.example.trabajofinalcibertec.presentation.login.ILoginContract;
import com.example.trabajofinalcibertec.presentation.main.view.MainActivity;
import com.example.trabajofinalcibertec.presentation.registro.view.RegistroActivity;

public class LoginActivity extends AppCompatActivity implements ILoginContract.IView {


    EditText etLoginUsuario;
    EditText etLoginPassword;
    Button btnLoginIngresar;
    Button btnLoginRegistro;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etLoginUsuario = findViewById(R.id.etLoginUsuario);
        etLoginPassword = findViewById(R.id.etLoginPassword);
        btnLoginIngresar = findViewById(R.id.btnLoginIngresar);
        btnLoginRegistro = findViewById(R.id.btnLoginRegistro);

        btnLoginIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnLoginRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void showError(String errorMsg) {
        Toast.makeText(this,errorMsg, Toast.LENGTH_SHORT).show();
    }
}
