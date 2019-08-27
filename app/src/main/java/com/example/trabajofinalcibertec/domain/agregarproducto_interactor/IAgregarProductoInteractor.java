package com.example.trabajofinalcibertec.domain.agregarproducto_interactor;

import com.example.trabajofinalcibertec.data.entities.responses.ProductoResponse;

import io.reactivex.Observable;

public interface IAgregarProductoInteractor {
    Observable<ProductoResponse> getProducto(int productoId);
}
