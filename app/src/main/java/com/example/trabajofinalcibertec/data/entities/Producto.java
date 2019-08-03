package com.example.trabajofinalcibertec.data.entities;

public class Producto {
    private int id;
    private String nombre;
    private String descripcion;
    private String imagen;
    private Double precioPlazaVea;
    private Double precioPlazaMetro;
    private Double precioPlazaTottus;

    public Producto(int id, String nombre, String descripcion, String imagen, Double precioPlazaVea, Double precioPlazaMetro, Double precioPlazaTottus) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.precioPlazaVea = precioPlazaVea;
        this.precioPlazaMetro = precioPlazaMetro;
        this.precioPlazaTottus = precioPlazaTottus;
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
}
