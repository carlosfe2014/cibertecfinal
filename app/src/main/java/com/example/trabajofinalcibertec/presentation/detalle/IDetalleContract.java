package com.example.trabajofinalcibertec.presentation.detalle;

import com.example.trabajofinalcibertec.data.entities.Compra;
import com.example.trabajofinalcibertec.data.entities.CompraProducto;
import com.example.trabajofinalcibertec.data.entities.Producto;

import java.util.List;

public interface IDetalleContract {
    interface IView{
        void showError(String errorMsg);
        void getAllCarritoProductos(List<CompraProducto> compraProductoList);
        void getCarritoDetalle(Compra compra);
    }
    interface IPresenter{
        void attachView(IView view);
        void detachView();
        boolean isViewAttached();
        void getCarritoDetalle(long id);
        void getCarritoProductos(long id);
    }
}
