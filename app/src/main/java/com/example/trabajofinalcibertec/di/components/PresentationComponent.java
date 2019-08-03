package com.example.trabajofinalcibertec.di.components;

import com.example.trabajofinalcibertec.di.modules.PresentationModule;
import com.example.trabajofinalcibertec.presentation.carrito.view.CarritoActivity;
import com.example.trabajofinalcibertec.presentation.carrito_agregar.view.CarritoAgregarActivity;
import com.example.trabajofinalcibertec.presentation.carrito_buscar.view.CarritoBuscarActivity;
import com.example.trabajofinalcibertec.presentation.detalle.view.DetalleActivity;
import com.example.trabajofinalcibertec.presentation.main.view.MainActivity;

import dagger.Component;

@Component(modules = PresentationModule.class)
public interface PresentationComponent {
    void inject(MainActivity mainActivity);
    void inject(CarritoActivity carritoActivity);
    void inject(CarritoAgregarActivity carritoAgregarActivity);
    void inject(CarritoBuscarActivity carritoBuscarActivity);
    void inject(DetalleActivity detalleActivity);
}