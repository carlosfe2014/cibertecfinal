package com.example.trabajofinalcibertec.domain.carrito_interactor;

import com.example.trabajofinalcibertec.data.entities.CompraProducto;

import java.util.List;

public interface ICarritoInteractor {
    long guardarCarrito(String usuario, String titulo, String descripcion);
    boolean guardarProductos(long idCarrito, List<CompraProducto> compraProductos);
}
