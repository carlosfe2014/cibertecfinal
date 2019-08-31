package com.example.trabajofinalcibertec.data.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Producto {
    private int id;
    private String nombre;
    private String descripcion;
    private String imagen;

    @SerializedName("precio_metro")
    private Double precioMetro;

    @SerializedName("precio_plazavea")
    private Double precioPlazaVea;

    @SerializedName("precio_tottus")
    private Double precioTottus;

    @SerializedName("best")
    private Integer best;

    private List<Comentario> comentarios;

    public Producto(int id, String nombre, String descripcion, String imagen, Double precioMetro, Double precioPlazaVea, Double precioTottus, Integer best) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.precioMetro = precioMetro;
        this.precioPlazaVea = precioPlazaVea;
        this.precioTottus = precioTottus;
        this.best = best;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Double getPrecioPlazaVea() {
        return precioPlazaVea;
    }

    public void setPrecioPlazaVea(Double precioPlazaVea) {
        this.precioPlazaVea = precioPlazaVea;
    }

    public Double getPrecioMetro() {
        return precioMetro;
    }

    public void setPrecioMetro(Double precioMetro) {
        this.precioMetro = precioMetro;
    }

    public Double getPrecioTottus() {
        return precioTottus;
    }

    public void setPrecioTottus(Double precioTottus) {
        this.precioTottus = precioTottus;
    }

    public Integer getBest() {
        return best;
    }

    public void setBest(Integer best) {
        this.best = best;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }
}
