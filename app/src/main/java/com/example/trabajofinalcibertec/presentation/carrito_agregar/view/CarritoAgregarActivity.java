package com.example.trabajofinalcibertec.presentation.carrito_agregar.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trabajofinalcibertec.MyApplication;
import com.example.trabajofinalcibertec.R;
import com.example.trabajofinalcibertec.base.BaseActivity;
import com.example.trabajofinalcibertec.data.entities.Comentario;
import com.example.trabajofinalcibertec.data.entities.Producto;
import com.example.trabajofinalcibertec.data.entities.responses.ProductoResponse;
import com.example.trabajofinalcibertec.di.components.DaggerPresentationComponent;
import com.example.trabajofinalcibertec.di.modules.PresentationModule;
import com.example.trabajofinalcibertec.presentation.carrito.view.CarritoActivity;
import com.example.trabajofinalcibertec.presentation.carrito_agregar.ICarritoAgregarContract;
import com.example.trabajofinalcibertec.presentation.carrito_agregar.presenter.CarritoAgregarPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CarritoAgregarActivity extends BaseActivity implements ICarritoAgregarContract.IView {


    private TextView tvCarritoAgregarNombre;
    private TextView tvCarritoAgregarDescripcion;
    private TextView tvListaCarritoAgregarVacio;

    private Button btnCarritoAgregarAgregarComentario;

    private RecyclerView recyclerViewCarritoAgregar;
    private CarritoAgregarAdapter carritoAgregarAdapter;
    private List<Comentario> carritoAgregarList;

    @Inject
    CarritoAgregarPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_carrito_agregar;
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
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CarritoAgregarActivity.this, CarritoActivity.class);
                startActivity(intent);
            }
        });

        int id = getIntent().getIntExtra("id", -1);

        if(id == -1){
            showError("No se encontró el ID del producto");
            finish();
        }

        presenter.attachView(this);

        tvCarritoAgregarNombre = findViewById(R.id.tvCarritoAgregarNombre);
        tvCarritoAgregarDescripcion = findViewById(R.id.tvCarritoAgregarDescripcion);
        tvListaCarritoAgregarVacio = findViewById(R.id.tvListaCarritoAgregarVacio);
        recyclerViewCarritoAgregar = findViewById(R.id.rvListaCarritoAgregar);


        recyclerViewCarritoAgregar.setVisibility(View.GONE);
        tvListaCarritoAgregarVacio.setVisibility(View.GONE);


        btnCarritoAgregarAgregarComentario = findViewById(R.id.btnCarritoAgregarAgregarComentario);


        btnCarritoAgregarAgregarComentario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CarritoAgregarActivity.this, "Aqui se agrega comentarios xd", Toast.LENGTH_SHORT).show();
            }
        });



        recyclerViewCarritoAgregar.setLayoutManager(new LinearLayoutManager(this));
        carritoAgregarList = new ArrayList<>();
        carritoAgregarAdapter = new CarritoAgregarAdapter(carritoAgregarList);
        recyclerViewCarritoAgregar.setAdapter(carritoAgregarAdapter);
        presenter.getComentarios(id);
        presenter.getProducto(1);
    }


    @Override
    protected void resolveDaggerDependency() {
        DaggerPresentationComponent.builder()
                .applicationComponent(getApplicationComponent())
                .presentationModule(new PresentationModule())
                .build().inject(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showError(String errorMsg) {
        Toast.makeText(this,errorMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getComentariosSuccess(List<Comentario> comentarioList) {
        //this.carritoAgregarList.addAll(comentarioList);
        //carritoAgregarAdapter.notifyDataSetChanged();
    }

    @Override
    public void getPostDetailSuccess(ProductoResponse productoResponse) {

        if(productoResponse.getEstado() == 200){
            Producto producto = productoResponse.getData();
            tvCarritoAgregarNombre.setText(producto.getNombre());
            tvCarritoAgregarDescripcion.setText(producto.getDescripcion());
            if(producto.getComentarios() != null){
                this.carritoAgregarList.addAll(producto.getComentarios());
                carritoAgregarAdapter.notifyDataSetChanged();
                recyclerViewCarritoAgregar.setVisibility(View.VISIBLE);
                tvListaCarritoAgregarVacio.setVisibility(View.GONE);
            } else {
                recyclerViewCarritoAgregar.setVisibility(View.GONE);
                tvListaCarritoAgregarVacio.setVisibility(View.VISIBLE);
            }
        } else {
            finish();
            Toast.makeText(this, "El producto seleccionado no existe...", Toast.LENGTH_SHORT).show();
        }
    }
}
