package com.example.trabajofinalcibertec.data.entities.responses;

import com.example.trabajofinalcibertec.data.entities.Producto;

public class ProductoResponse {
    private int estado;
    private String codigo;
    private Producto data;

    public int getEstado() {
        return estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public Producto getData() {
        return data;
    }
}
