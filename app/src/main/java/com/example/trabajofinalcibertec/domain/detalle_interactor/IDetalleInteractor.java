package com.example.trabajofinalcibertec.domain.detalle_interactor;

import com.example.trabajofinalcibertec.data.entities.Compra;
import com.example.trabajofinalcibertec.data.entities.CompraProducto;

import java.util.List;

public interface IDetalleInteractor {
    Compra getCarritoDetalle(long id);
    List<CompraProducto> getCarritoProductos(long id);
}
