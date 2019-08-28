package com.example.trabajofinalcibertec.presentation.carrito_buscar.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabajofinalcibertec.R;
import com.example.trabajofinalcibertec.base.BaseActivity;
import com.example.trabajofinalcibertec.data.entities.Producto;
import com.example.trabajofinalcibertec.data.entities.responses.BusquedaResponse;
import com.example.trabajofinalcibertec.di.components.DaggerPresentationComponent;
import com.example.trabajofinalcibertec.di.modules.PresentationModule;
import com.example.trabajofinalcibertec.presentation.carrito.view.CarritoActivity;
import com.example.trabajofinalcibertec.presentation.carrito_agregar.view.CarritoAgregarActivity;
import com.example.trabajofinalcibertec.presentation.carrito_agregar.view.CarritoAgregarAdapter;
import com.example.trabajofinalcibertec.presentation.carrito_buscar.ICarritoBuscarContract;
import com.example.trabajofinalcibertec.presentation.carrito_buscar.presenter.CarritoBuscarPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CarritoBuscarActivity extends BaseActivity implements ICarritoBuscarContract.IView {

    private Button btnCarritoBuscarBuscar;
    private EditText etCarritoBuscarQuery;
    private TextView etCarritoBuscarVacio;


    private RecyclerView recyclerViewCarritoBuscar;
    private CarritoBuscarAdapter carritoBuscarAdapter;
    private List<Producto> carritoBuscarList;

    @Inject
    CarritoBuscarPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


        btnCarritoBuscarBuscar = findViewById(R.id.btnCarritoBuscarBuscar);
        etCarritoBuscarQuery = findViewById(R.id.etCarritoBuscarQuery);
        etCarritoBuscarVacio = findViewById(R.id.etCarritoBuscarVacio);

        //presenter = new CarritoBuscarPresenter(interactor);

        //((MyApplication) getApplication()).getAppComponent().inject(CarritoBuscarActivity.this);
        presenter.attachView(this);

        recyclerViewCarritoBuscar = findViewById(R.id.rvListaCarritoBuscar);

        recyclerViewCarritoBuscar.setVisibility(View.GONE);
        etCarritoBuscarVacio.setVisibility(View.VISIBLE);

        recyclerViewCarritoBuscar.setLayoutManager(new LinearLayoutManager(this));
        carritoBuscarList = new ArrayList<>();
        carritoBuscarAdapter = new CarritoBuscarAdapter(carritoBuscarList);

        carritoBuscarAdapter.setOnItemClickListener(new CarritoBuscarClickListener() {
            @Override
            public void onClick(int position) {
                gotToProductoAgregar(position);
            }
        });

        recyclerViewCarritoBuscar.setAdapter(carritoBuscarAdapter);




        btnCarritoBuscarBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!etCarritoBuscarQuery.getText().toString().isEmpty()){
                    String query = etCarritoBuscarQuery.getText().toString();
                    presenter.searchProductos(query);
                }
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
        return R.layout.activity_carrito_buscar;
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
    public void getBuscarProductosSuccess(List<Producto> productoList) {
        this.carritoBuscarList.addAll(productoList);
        carritoBuscarAdapter.notifyDataSetChanged();

        if(this.carritoBuscarList.size() > 0){
            recyclerViewCarritoBuscar.setVisibility(View.VISIBLE);
            etCarritoBuscarVacio.setVisibility(View.GONE);
        } else {
            recyclerViewCarritoBuscar.setVisibility(View.GONE);
            etCarritoBuscarVacio.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void gotToProductoAgregar(int position) {
        int id = carritoBuscarList.get(position).getId();
        String nombre = carritoBuscarList.get(position).getNombre();
        String descripcion = carritoBuscarList.get(position).getDescripcion();
        Intent intent = new Intent(this, CarritoAgregarActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("nombre", nombre);
        intent.putExtra("descripcion", descripcion);
        startActivity(intent);
    }

    @Override
    public void getSearchProductosSuccess(BusquedaResponse busquedaResponse) {
        if(busquedaResponse.getEstado() == 200){
            List<Producto> productoList = busquedaResponse.getData();
            this.carritoBuscarList.clear();
            this.carritoBuscarList.addAll(productoList);
            carritoBuscarAdapter.notifyDataSetChanged();
            recyclerViewCarritoBuscar.setVisibility(View.VISIBLE);
            etCarritoBuscarVacio.setVisibility(View.GONE);
        } else {
            recyclerViewCarritoBuscar.setVisibility(View.GONE);
            etCarritoBuscarVacio.setVisibility(View.VISIBLE);
        }
    }
}
