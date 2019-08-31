package com.example.trabajofinalcibertec.domain.carrito_interactor;

import android.util.Log;

import com.example.trabajofinalcibertec.data.entities.CompraProducto;
import com.example.trabajofinalcibertec.data.repository.ICompraRepository;

import java.util.List;

import javax.inject.Inject;

public class CarritoInteractorImpl implements ICarritoInteractor{

    private final ICompraRepository compraRepository;

    @Inject
    public CarritoInteractorImpl(ICompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    @Override
    public long guardarCarrito(String usuario, String titulo, String descripcion) {
        return compraRepository.guardarCarrito(usuario, titulo, descripcion);
    }

    @Override
    public boolean guardarProductos(long idCarrito, List<CompraProducto> compraProductos) {
        if(compraProductos.size() > 0){
            for (CompraProducto producto : compraProductos){
                producto.setCarrito(idCarrito);
                long insetado = compraRepository.guardarProducto(producto);
            }
            return true;
        }
        return false;
    }
}
