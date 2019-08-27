package com.example.trabajofinalcibertec.data.repository.Impl;

import com.example.trabajofinalcibertec.data.entities.Producto;
import com.example.trabajofinalcibertec.data.entities.responses.BusquedaResponse;
import com.example.trabajofinalcibertec.data.entities.responses.ProductoResponse;
import com.example.trabajofinalcibertec.data.repository.IProductoRepository;
import com.example.trabajofinalcibertec.network.JsonPlaceHolderApi;

import javax.inject.Inject;

import io.reactivex.Observable;

public class ProductoRepositoryImpl implements IProductoRepository {

    private  final JsonPlaceHolderApi jsonPlaceHolderApi;

    @Inject
    public ProductoRepositoryImpl(JsonPlaceHolderApi jsonPlaceHolderApi) {
        this.jsonPlaceHolderApi = jsonPlaceHolderApi;
    }

    @Override
    public Observable<ProductoResponse> getProducto(int postId) {
        return jsonPlaceHolderApi.getProducto(postId);
    }

    @Override
    public Observable<BusquedaResponse> searchProductos(String query) {
        return jsonPlaceHolderApi.searchProductos(query);
    }
}
