package com.example.trabajofinalcibertec.presentation.detalle.view;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.trabajofinalcibertec.R;
import com.example.trabajofinalcibertec.base.BaseActivity;
import com.example.trabajofinalcibertec.data.entities.Compra;
import com.example.trabajofinalcibertec.data.entities.CompraProducto;
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
    private List<CompraProducto> detalleList;
    private TextView tvDetalleTitulo;
    private TextView tvDetalleDescricion;
    private TextView tvDetallePrecioPlazaVea;
    private TextView tvDetallePrecioTottus;
    private TextView tvDetallePrecioMetro;

    @Inject
    DetallePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);


        long id = getIntent().getLongExtra("id", -1);


        if(id == -1){
            showError("No se encontró el ID del producto");
            finish();
        }

        presenter.attachView(this);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        tvDetalleTitulo = findViewById(R.id.tvDetalleTitulo);
        tvDetalleDescricion = findViewById(R.id.tvDetalleDescricion);
        tvDetallePrecioPlazaVea = findViewById(R.id.tvDetallePrecioPlazaVea);
        tvDetallePrecioTottus = findViewById(R.id.tvDetallePrecioTottus);
        tvDetallePrecioMetro = findViewById(R.id.tvDetallePrecioMetro);


        recyclerViewDetalle = findViewById(R.id.rvListaDetalle);

        recyclerViewDetalle.setLayoutManager(new LinearLayoutManager(this));
        detalleList = new ArrayList<>();
        detalleAdapter = new DetalleAdapter(detalleList);
        recyclerViewDetalle.setAdapter(detalleAdapter);
        presenter.getCarritoDetalle(id);
        presenter.getCarritoProductos(id);
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
    public void getAllCarritoProductos(List<CompraProducto> compraProductoList) {
        this.detalleList.addAll(compraProductoList);
        detalleAdapter.notifyDataSetChanged();

        Double metro = 0d;
        Double plazaVea = 0d;
        Double tottus = 0d;
        if(compraProductoList.size() > 0){
            for(CompraProducto producto : compraProductoList){
                metro += producto.getPrecioMetro() * producto.getCantidad();
                plazaVea += producto.getPrecioPlazaVea() * producto.getCantidad();
                tottus += producto.getPrecioTottus() * producto.getCantidad();
            }
        }
        tvDetallePrecioMetro.setText("S/. " + String.format("%.2f", metro));
        tvDetallePrecioPlazaVea.setText("S/. " + String.format("%.2f", plazaVea));
        tvDetallePrecioTottus.setText("S/. " + String.format("%.2f", tottus));


    }

    @Override
    public void getCarritoDetalle(Compra compra) {
        tvDetalleTitulo.setText(compra.getTitulo());
        tvDetalleDescricion.setText(compra.getDescripcion());
    }
}
