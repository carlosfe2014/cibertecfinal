package com.example.trabajofinalcibertec.data.repository.Impl;

import com.example.trabajofinalcibertec.data.entities.Compra;
import com.example.trabajofinalcibertec.data.repository.ICompraRepository;
import com.example.trabajofinalcibertec.database.AppDatabase;

import java.util.List;

import javax.inject.Inject;

public class CompraRepositoryImpl implements ICompraRepository {


    private final AppDatabase appDatabase;

    @Inject
    public CompraRepositoryImpl(AppDatabase appDatabase) {
        this.appDatabase = appDatabase;
    }


    @Override
    public List<Compra> searchProductos(String usuario) {
        return appDatabase.compraDao().getAll(usuario);
    }

    @Override
    public long guardarCarrito(String usuario, String titulo, String descripcion) {
        Compra compra = new Compra(usuario, titulo, descripcion);
        return appDatabase.compraDao().insert(compra);
    }
}
