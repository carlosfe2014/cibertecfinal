package com.example.trabajofinalcibertec.domain.buscarproducto_interactor;

import com.example.trabajofinalcibertec.data.entities.responses.BusquedaResponse;
import com.example.trabajofinalcibertec.data.entities.responses.ProductoResponse;

import io.reactivex.Observable;

public interface IBuscarProductoInteractor {
    Observable<BusquedaResponse> searchProductos(String query);
}
