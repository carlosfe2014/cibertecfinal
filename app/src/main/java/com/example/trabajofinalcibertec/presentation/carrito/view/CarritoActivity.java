package com.example.trabajofinalcibertec.presentation.carrito.view;

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
import com.example.trabajofinalcibertec.data.entities.Producto;
import com.example.trabajofinalcibertec.presentation.carrito.ICarritoContract;
import com.example.trabajofinalcibertec.presentation.carrito.presenter.CarritoPresenter;
import com.example.trabajofinalcibertec.presentation.carrito_buscar.view.CarritoBuscarActivity;
import com.example.trabajofinalcibertec.presentation.detalle.view.DetalleActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CarritoActivity extends AppCompatActivity implements ICarritoContract.IView {


    private Button btnCarritoAgregar;
    private RecyclerView recyclerViewCarrito;
    private CarritoAdapter carritoAdapter;
    private List<Producto> carritoList;

    @Inject
    CarritoPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CarritoActivity.this, DetalleActivity.class);
                startActivity(intent);
            }
        });


        //presenter = new CarritoPresenter();
        ((MyApplication) getApplication()).getAppComponent().inject(CarritoActivity.this);
        presenter.attachView(this);

        btnCarritoAgregar = findViewById(R.id.btnCarritoAgregar);
        recyclerViewCarrito = findViewById(R.id.rvListaCarrito);

        recyclerViewCarrito.setLayoutManager(new LinearLayoutManager(this));
        carritoList = new ArrayList<>();
        carritoAdapter = new CarritoAdapter(carritoList);
        recyclerViewCarrito.setAdapter(carritoAdapter);
        presenter.getAllProductos();

        btnCarritoAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CarritoActivity.this, CarritoBuscarActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void showError(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getAllProductosSuccess(List<Producto> productoList) {
        this.carritoList.addAll(productoList);
        carritoAdapter.notifyDataSetChanged();
    }
}
