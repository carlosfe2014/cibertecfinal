package com.example.trabajofinalcibertec.data.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Producto {
    private int id;
    private String nombre;
    private String descripcion;
    private String imagen;

    @SerializedName("precio_metro")
    private Double precioPlazaMetro;

    @SerializedName("precio_plazavea")
    private Double precioPlazaVea;

    @SerializedName("precio_tottus")
    private Double precioPlazaTottus;

    @SerializedName("body")
    private Integer best;

    private List<Comentario> comentarios;

    public Producto(int id, String nombre, String descripcion, String imagen, Double precioPlazaMetro, Double precioPlazaVea, Double precioPlazaTottus, Integer best) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.precioPlazaMetro = precioPlazaMetro;
        this.precioPlazaVea = precioPlazaVea;
        this.precioPlazaTottus = precioPlazaTottus;
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

    public Double getPrecioPlazaMetro() {
        return precioPlazaMetro;
    }

    public void setPrecioPlazaMetro(Double precioPlazaMetro) {
        this.precioPlazaMetro = precioPlazaMetro;
    }

    public Double getPrecioPlazaTottus() {
        return precioPlazaTottus;
    }

    public void setPrecioPlazaTottus(Double precioPlazaTottus) {
        this.precioPlazaTottus = precioPlazaTottus;
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
