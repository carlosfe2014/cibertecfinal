package com.example.trabajofinalcibertec.domain.carrito_interactor;

import com.example.trabajofinalcibertec.data.repository.ICompraRepository;

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
}
