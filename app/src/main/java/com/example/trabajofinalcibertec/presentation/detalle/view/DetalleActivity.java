package com.example.trabajofinalcibertec.presentation.detalle.view;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.trabajofinalcibertec.R;
import com.example.trabajofinalcibertec.base.BaseActivity;
import com.example.trabajofinalcibertec.data.entities.Producto;


import com.example.trabajofinalcibertec.di.components.DaggerPresentationComponent;
import com.example.trabajofinalcibertec.di.modules.PresentationModule;
import com.example.trabajofinalcibertec.presentation.detalle.IDetalleContract;
import com.example.trabajofinalcibertec.presentation.detalle.presenter.DetallePresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class DetalleActivity extends BaseActivity implements IDetalleContract.IView {

    private RecyclerView recyclerViewDetalle;
    private DetalleAdapter detalleAdapter;
    private List<Producto> detalleList;

    @Inject
    DetallePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);



        presenter.attachView(this);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        recyclerViewDetalle = findViewById(R.id.rvListaDetalle);

        recyclerViewDetalle.setLayoutManager(new LinearLayoutManager(this));
        detalleList = new ArrayList<>();
        detalleAdapter = new DetalleAdapter(detalleList);
        recyclerViewDetalle.setAdapter(detalleAdapter);
        presenter.getAllProductos();
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
        return R.layout.activity_detalle;
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
        this.detalleList.addAll(productoList);
        detalleAdapter.notifyDataSetChanged();
    }
}
