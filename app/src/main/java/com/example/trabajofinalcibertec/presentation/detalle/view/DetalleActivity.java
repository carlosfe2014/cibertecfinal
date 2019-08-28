package com.example.trabajofinalcibertec.presentation.detalle.view;


import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.trabajofinalcibertec.R;
import com.example.trabajofinalcibertec.base.BaseActivity;
import com.example.trabajofinalcibertec.data.entities.Producto;


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
        setContentView(R.layout.activity_detalle);


        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


        //presenter = new DetallePresenter();

        //((MyApplication) getApplication()).getApplicationComponent().inject(DetalleActivity.this);
        presenter.attachView(this);

        recyclerViewDetalle = findViewById(R.id.rvListaDetalle);

        recyclerViewDetalle.setLayoutManager(new LinearLayoutManager(this));
        detalleList = new ArrayList<>();
        detalleAdapter = new DetalleAdapter(detalleList);
        recyclerViewDetalle.setAdapter(detalleAdapter);
        presenter.getAllProductos();

    }

    @Override
    protected void resolveDaggerDependency() {

    }

    @Override
    protected int getContentView() {
        return 0;
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
