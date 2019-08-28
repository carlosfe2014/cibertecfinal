package com.example.trabajofinalcibertec.data.repository;

import com.example.trabajofinalcibertec.data.entities.Compra;

import java.util.List;

public interface ICompraRepository {
    List<Compra> searchProductos(String usuario);
    long guardarCarrito(String usuario, String titulo, String descripcion);
}
