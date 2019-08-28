package com.example.trabajofinalcibertec.presentation.carrito.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabajofinalcibertec.R;
import com.example.trabajofinalcibertec.base.BaseActivity;
import com.example.trabajofinalcibertec.data.entities.Producto;
import com.example.trabajofinalcibertec.di.components.DaggerPresentationComponent;
import com.example.trabajofinalcibertec.di.modules.PresentationModule;
import com.example.trabajofinalcibertec.presentation.carrito.ICarritoContract;
import com.example.trabajofinalcibertec.presentation.carrito.presenter.CarritoPresenter;
import com.example.trabajofinalcibertec.presentation.carrito_buscar.view.CarritoBuscarActivity;
import com.example.trabajofinalcibertec.presentation.detalle.view.DetalleActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CarritoActivity extends BaseActivity implements ICarritoContract.IView {


    private Button btnCarritoAgregar;
    private RecyclerView recyclerViewCarrito;
    private CarritoAdapter carritoAdapter;
    private List<Producto> carritoList;
    private EditText etCarritoTitulo;
    private EditText etCarritoDescripcion;

    @Inject
    CarritoPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


        FloatingActionButton fab = findViewById(R.id.fab);

        presenter.attachView(this);

        btnCarritoAgregar = findViewById(R.id.btnCarritoAgregar);
        recyclerViewCarrito = findViewById(R.id.rvListaCarrito);
        etCarritoTitulo = findViewById(R.id.etCarritoTitulo);
        etCarritoDescripcion = findViewById(R.id.etCarritoDescripcion);

        recyclerViewCarrito.setLayoutManager(new LinearLayoutManager(this));
        carritoList = new ArrayList<>();
        carritoAdapter = new CarritoAdapter(carritoList);
        recyclerViewCarrito.setAdapter(carritoAdapter);
        presenter.getAllProductos();


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String titulo = etCarritoTitulo.getText().toString();
                //String descripcion = etCarritoDescripcion.getText().toString();
                //presenter.guardarCarrito(titulo, descripcion);


                Intent intent = new Intent(CarritoActivity.this, DetalleActivity.class);
                startActivity(intent);

            }
        });

        btnCarritoAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CarritoActivity.this, CarritoBuscarActivity.class);
                startActivity(intent);
            }
        });
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
        return R.layout.activity_carrito;
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
    public void getAllProductosSuccess(List<Producto> productoList) {
        this.carritoList.addAll(productoList);
        carritoAdapter.notifyDataSetChanged();
    }

    @Override
    public Context getContext(){
        return getApplicationContext();
    }

    @Override
    public void closeActivity() {
        finish();
    }
}
