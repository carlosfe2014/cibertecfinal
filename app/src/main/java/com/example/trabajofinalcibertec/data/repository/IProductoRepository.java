package com.example.trabajofinalcibertec.data.repository;


import com.example.trabajofinalcibertec.data.entities.responses.BusquedaResponse;
import com.example.trabajofinalcibertec.data.entities.responses.ProductoResponse;

import java.util.List;

import io.reactivex.Observable;

public interface IProductoRepository {
    Observable<ProductoResponse> getProducto(int postId);
    Observable<BusquedaResponse> searchProductos(String query);
}
