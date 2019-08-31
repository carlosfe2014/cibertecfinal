package com.example.trabajofinalcibertec.presentation.main.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabajofinalcibertec.R;
import com.example.trabajofinalcibertec.base.BaseActivity;
import com.example.trabajofinalcibertec.data.entities.Compra;
import com.example.trabajofinalcibertec.di.components.DaggerPresentationComponent;
import com.example.trabajofinalcibertec.di.modules.PresentationModule;
import com.example.trabajofinalcibertec.presentation.carrito.view.CarritoActivity;
import com.example.trabajofinalcibertec.presentation.carrito_buscar.view.CarritoBuscarAdapter;
import com.example.trabajofinalcibertec.presentation.carrito_buscar.view.CarritoBuscarClickListener;
import com.example.trabajofinalcibertec.presentation.detalle.view.DetalleActivity;
import com.example.trabajofinalcibertec.presentation.main.IMainContract;
import com.example.trabajofinalcibertec.presentation.main.presenter.MainPresenter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements IMainContract.IView {

    private RecyclerView recyclerViewCompras;
    private CompraAdapter compraAdapter;
    private List<Compra> comprasList;
    private TextView tvListaComprasVacia;

    @Inject
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);

        presenter.attachView(this);

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
                Intent intent = new Intent(MainActivity.this, CarritoActivity.class);
                startActivity(intent);
            }
        });

        tvListaComprasVacia = findViewById(R.id.tvListaComprasVacia);
        tvListaComprasVacia.setVisibility(View.GONE);
        recyclerViewCompras = findViewById(R.id.rvListaCompras);
        recyclerViewCompras.setLayoutManager(new LinearLayoutManager(this));
        comprasList = new ArrayList<>();
        compraAdapter = new CompraAdapter(comprasList);

        compraAdapter.setOnItemClickListener(new MainClickListener() {
            @Override
            public void onClick(int position) {
                goToCompra(position);
            }
        });

        recyclerViewCompras.setAdapter(compraAdapter);
        presenter.getAllCompras();

    }
    private void goToCompra(int position) {
        long id = comprasList.get(position).getId();
        Intent intent = new Intent(MainActivity.this, DetalleActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
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
        return R.layout.activity_main;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
    public void getAllComprasSuccess(List<Compra> compraList) {
        comprasList.clear();
        this.comprasList.addAll(compraList);
        compraAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.getAllCompras();
    }

    @Override
    public Context getContext(){
        return getApplicationContext();
    }
}
