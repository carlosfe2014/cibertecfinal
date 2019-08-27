package com.example.trabajofinalcibertec.presentation.main.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trabajofinalcibertec.MyApplication;
import com.example.trabajofinalcibertec.R;
import com.example.trabajofinalcibertec.data.entities.Compra;
import com.example.trabajofinalcibertec.presentation.carrito.view.CarritoActivity;
import com.example.trabajofinalcibertec.presentation.main.IMainContract;
import com.example.trabajofinalcibertec.presentation.main.presenter.MainPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements IMainContract.IView {

    private RecyclerView recyclerViewCompras;
    private CompraAdapter compraAdapter;
    private List<Compra> comprasList;
    private TextView tvListaComprasVacia;

    @Inject
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        presenter = new MainPresenter();
        //((MyApplication) getApplication()).getAppComponent().inject(MainActivity.this);
        presenter.attachView(this);

        tvListaComprasVacia = findViewById(R.id.tvListaComprasVacia);
        tvListaComprasVacia.setVisibility(View.GONE);
        recyclerViewCompras = findViewById(R.id.rvListaCompras);
        recyclerViewCompras.setLayoutManager(new LinearLayoutManager(this));
        comprasList = new ArrayList<>();
        compraAdapter = new CompraAdapter(comprasList);
        recyclerViewCompras.setAdapter(compraAdapter);
        presenter.getAllCompras();
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
    public void getAllComprassSuccess(List<Compra> compraList) {
        this.comprasList.addAll(compraList);
        compraAdapter.notifyDataSetChanged();
    }
}
