package com.example.trabajofinalcibertec.presentation.carrito.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabajofinalcibertec.MyApplication;
import com.example.trabajofinalcibertec.R;
import com.example.trabajofinalcibertec.data.entities.Compra;
import com.example.trabajofinalcibertec.data.entities.Producto;
import com.example.trabajofinalcibertec.database.AppDatabase;
import com.example.trabajofinalcibertec.presentation.carrito.ICarritoContract;
import com.example.trabajofinalcibertec.presentation.carrito.presenter.CarritoPresenter;
import com.example.trabajofinalcibertec.presentation.carrito_buscar.view.CarritoBuscarActivity;
import com.example.trabajofinalcibertec.presentation.detalle.view.DetalleActivity;
import com.example.trabajofinalcibertec.presentation.main.view.MainActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

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

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Compra compra = new Compra("carlosfe", "Compra prueba", "Compra descripcion");

                long insertID = AppDatabase.getInstance(getApplicationContext()).compraDao().insert(compra);

                Toast.makeText(CarritoActivity.this, "" + insertID, Toast.LENGTH_SHORT).show();


                //Intent intent = new Intent(CarritoActivity.this, MainActivity.class);
                //startActivity(intent);
            }
        });


        presenter = new CarritoPresenter();
        //((MyApplication) getApplication()).getAppComponent().inject(CarritoActivity.this);
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
}
