package com.example.trabajofinalcibertec.domain.main_interactor;

import com.example.trabajofinalcibertec.data.entities.Compra;
import com.example.trabajofinalcibertec.data.repository.ICompraRepository;

import java.util.List;

import javax.inject.Inject;

public class MainInteractorImpl implements IMainInteractor{

    private final ICompraRepository compraRepository;

    @Inject
    public MainInteractorImpl(ICompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }


    @Override
    public List<Compra> searchProductos(String usuario) {
        return compraRepository.searchProductos(usuario);
    }
}
