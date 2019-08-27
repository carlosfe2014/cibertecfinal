package com.example.trabajofinalcibertec.data.entities.responses;

import com.example.trabajofinalcibertec.data.entities.Producto;

import java.util.List;

public class BusquedaResponse {
    private int estado;
    private String codigo;
    private List<Producto> data;

    public int getEstado() {
        return estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public List<Producto> getData() {
        return data;
    }
}
