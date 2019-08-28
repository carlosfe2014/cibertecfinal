package com.example.trabajofinalcibertec.domain.main_interactor;

import com.example.trabajofinalcibertec.data.entities.Compra;

import java.util.List;

public interface IMainInteractor {
    List<Compra> searchProductos(String usuario);
}
