package com.example.trabajofinalcibertec.presentation.carrito_agregar.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabajofinalcibertec.R;
import com.example.trabajofinalcibertec.base.BaseActivity;
import com.example.trabajofinalcibertec.data.entities.Comentario;
import com.example.trabajofinalcibertec.data.entities.CompraProducto;
import com.example.trabajofinalcibertec.data.entities.Producto;
import com.example.trabajofinalcibertec.data.entities.responses.ProductoResponse;
import com.example.trabajofinalcibertec.di.components.DaggerPresentationComponent;
import com.example.trabajofinalcibertec.di.modules.PresentationModule;
import com.example.trabajofinalcibertec.presentation.carrito_agregar.ICarritoAgregarContract;
import com.example.trabajofinalcibertec.presentation.carrito_agregar.presenter.CarritoAgregarPresenter;
import com.example.trabajofinalcibertec.utils.Utils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CarritoAgregarActivity extends BaseActivity implements ICarritoAgregarContract.IView {


    private TextView tvCarritoAgregarNombre;
    private TextView tvCarritoAgregarDescripcion;
    private TextView tvListaCarritoAgregarVacio;
    private EditText etCarritoAgregarCantidad;

    private Button btnCarritoAgregarAgregarComentario;
    private Producto producto;
    private CompraProducto compraProducto;

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
        etCarritoAgregarCantidad = findViewById(R.id.etCarritoAgregarCantidad);


        recyclerViewCarritoAgregar.setVisibility(View.GONE);
        tvListaCarritoAgregarVacio.setVisibility(View.GONE);


        btnCarritoAgregarAgregarComentario = findViewById(R.id.btnCarritoAgregarAgregarComentario);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String cantidad = etCarritoAgregarCantidad.getText().toString();
                if(Utils.isStringInteger(cantidad) && Integer.valueOf(cantidad) > 0){
                    compraProducto = new CompraProducto(producto.getNombre(), producto.getDescripcion(), producto.getImagen(), producto.getPrecioMetro(), producto.getPrecioPlazaVea(), producto.getPrecioTottus(), producto.getBest(), Integer.valueOf(cantidad));
                    finish();
                } else {
                    showError("Ingrese una cantidad válida para el producto.");
                }
            }
        });


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
        presenter.getProducto(id);
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
            producto = productoResponse.getData();
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

    @Override
    public void finish() {

        if(producto != null){
            Intent returnIntent = new Intent();
            returnIntent.putExtra("producto", compraProducto);
            setResult(RESULT_OK, returnIntent); //By not passing the intent in the result, the calling activity will get null data.
            super.finish();
        } else {
            showError("Ingrese una cantidad válida para el producto.");
        }
    }

}
