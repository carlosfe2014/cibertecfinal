package com.example.trabajofinalcibertec.di.components;

import com.example.trabajofinalcibertec.di.modules.PresentationModule;
import com.example.trabajofinalcibertec.di.scope.PerActivity;
import com.example.trabajofinalcibertec.presentation.carrito.view.CarritoActivity;
import com.example.trabajofinalcibertec.presentation.carrito_agregar.view.CarritoAgregarActivity;
import com.example.trabajofinalcibertec.presentation.carrito_buscar.view.CarritoBuscarActivity;
import com.example.trabajofinalcibertec.presentation.detalle.view.DetalleActivity;
import com.example.trabajofinalcibertec.presentation.login.view.LoginActivity;
import com.example.trabajofinalcibertec.presentation.main.view.MainActivity;
import com.example.trabajofinalcibertec.presentation.registro.view.RegistroActivity;

import dagger.Component;

@PerActivity
@Component (modules = PresentationModule.class, dependencies = ApplicationComponent.class)
public interface PresentationComponent {
    void inject(MainActivity mainActivity);
    void inject(CarritoActivity carritoActivity);
    void inject(CarritoAgregarActivity carritoAgregarActivity);
    void inject(CarritoBuscarActivity carritoBuscarActivity);
    void inject(DetalleActivity detalleActivity);
    void inject(LoginActivity loginActivity);
    void inject(RegistroActivity registroActivity);
}