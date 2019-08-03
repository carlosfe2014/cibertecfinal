package com.example.trabajofinalcibertec.presentation.detalle.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.trabajofinalcibertec.MyApplication;
import com.example.trabajofinalcibertec.R;
import com.example.trabajofinalcibertec.data.entities.Producto;
import com.example.trabajofinalcibertec.presentation.detalle.IDetalleContract;
import com.example.trabajofinalcibertec.presentation.detalle.presenter.DetallePresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class DetalleActivity extends AppCompatActivity implements IDetalleContract.IView {

    private RecyclerView recyclerViewDetalle;
    private DetalleAdapter detalleAdapter;
    private List<Producto> detalleList;

    @Inject
    DetallePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);


        //presenter = new DetallePresenter();

        ((MyApplication) getApplication()).getAppComponent().inject(DetalleActivity.this);
        presenter.attachView(this);

        recyclerViewDetalle = findViewById(R.id.rvListaDetalle);

        recyclerViewDetalle.setLayoutManager(new LinearLayoutManager(this));
        detalleList = new ArrayList<>();
        detalleAdapter = new DetalleAdapter(detalleList);
        recyclerViewDetalle.setAdapter(detalleAdapter);
        presenter.getAllProductos();

    }

    @Override
    public void showError(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getAllProductosSuccess(List<Producto> productoList) {
        this.detalleList.addAll(productoList);
        detalleAdapter.notifyDataSetChanged();
    }
}
