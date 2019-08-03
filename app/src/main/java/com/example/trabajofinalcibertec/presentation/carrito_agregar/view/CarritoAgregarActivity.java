package com.example.trabajofinalcibertec.presentation.carrito_agregar.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trabajofinalcibertec.MyApplication;
import com.example.trabajofinalcibertec.R;
import com.example.trabajofinalcibertec.data.entities.Comentario;
import com.example.trabajofinalcibertec.presentation.carrito.view.CarritoActivity;
import com.example.trabajofinalcibertec.presentation.carrito_agregar.ICarritoAgregarContract;
import com.example.trabajofinalcibertec.presentation.carrito_agregar.presenter.CarritoAgregarPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CarritoAgregarActivity extends AppCompatActivity implements ICarritoAgregarContract.IView {


    private TextView tvCarritoAgregarNombre;
    private TextView tvCarritoAgregarDescripcion;

    private Button btnCarritoAgregarAgregarComentario;

    private RecyclerView recyclerViewCarritoAgregar;
    private CarritoAgregarAdapter carritoAgregarAdapter;
    private List<Comentario> carritoAgregarList;

    @Inject
    CarritoAgregarPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito_agregar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CarritoAgregarActivity.this, CarritoActivity.class);
                startActivity(intent);
            }
        });


        int id = getIntent().getIntExtra("id", -1);
        String nombre = getIntent().getStringExtra("nombre");
        String descripcion = getIntent().getStringExtra("descripcion");
        if(id == -1 || nombre == null || descripcion == null){
            showError("No se encontró el ID del producto");
            finish();
        }

        //presenter = new CarritoAgregarPresenter();

        ((MyApplication) getApplication()).getAppComponent().inject(CarritoAgregarActivity.this);
        presenter.attachView(this);

        recyclerViewCarritoAgregar = findViewById(R.id.rvListaCarritoAgregar);
        tvCarritoAgregarNombre = findViewById(R.id.tvCarritoAgregarNombre);
        tvCarritoAgregarDescripcion = findViewById(R.id.tvCarritoAgregarDescripcion);

        btnCarritoAgregarAgregarComentario = findViewById(R.id.btnCarritoAgregarAgregarComentario);


        btnCarritoAgregarAgregarComentario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CarritoAgregarActivity.this, "Aqui se agrega comentarios xd", Toast.LENGTH_SHORT).show();
            }
        });

        tvCarritoAgregarNombre.setText(nombre);
        tvCarritoAgregarDescripcion.setText(descripcion);

        recyclerViewCarritoAgregar.setLayoutManager(new LinearLayoutManager(this));
        carritoAgregarList = new ArrayList<>();
        carritoAgregarAdapter = new CarritoAgregarAdapter(carritoAgregarList);
        recyclerViewCarritoAgregar.setAdapter(carritoAgregarAdapter);
        presenter.getComentarios(id);

    }

    @Override
    public void showError(String errorMsg) {
        Toast.makeText(this,errorMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getComentariosSuccess(List<Comentario> comentarioList) {
        this.carritoAgregarList.addAll(comentarioList);
        carritoAgregarAdapter.notifyDataSetChanged();
    }
}
