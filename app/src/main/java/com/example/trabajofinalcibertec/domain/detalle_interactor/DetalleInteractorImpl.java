package com.example.trabajofinalcibertec.domain.detalle_interactor;

import com.example.trabajofinalcibertec.data.entities.Compra;
import com.example.trabajofinalcibertec.data.entities.CompraProducto;
import com.example.trabajofinalcibertec.data.repository.ICompraRepository;

import java.util.List;

import javax.inject.Inject;

public class DetalleInteractorImpl implements IDetalleInteractor{

    private final ICompraRepository compraRepository;

    @Inject
    public DetalleInteractorImpl(ICompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    @Override
    public Compra getCarritoDetalle(long id) {
        return compraRepository.getCarritoDetalle(id);
    }

    @Override
    public List<CompraProducto> getCarritoProductos(long id) {
        return compraRepository.getCarritoProductos(id);
    }
}
