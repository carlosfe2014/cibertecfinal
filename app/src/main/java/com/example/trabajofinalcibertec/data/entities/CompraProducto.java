package com.example.trabajofinalcibertec.data.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;


@SuppressWarnings("serial")
@Entity
public class CompraProducto implements Serializable {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    @ColumnInfo(name = "carrito")
    private long carrito;

    @NonNull
    @ColumnInfo(name = "nombre")
    private String nombre;

    @ColumnInfo(name = "descripcion")
    private String descripcion;

    @ColumnInfo(name = "imagen")
    private String imagen;

    @NonNull
    @ColumnInfo(name = "precio_metro")
    private Double precioMetro;

    @NonNull
    @ColumnInfo(name = "precio_plazavea")
    private Double precioPlazaVea;

    @NonNull
    @ColumnInfo(name = "precio_tottus")
    private Double precioPlazaTottus;

    @NonNull
    @ColumnInfo(name = "best")
    private Integer best;

    @NonNull
    @ColumnInfo(name = "cantidad")
    private Integer cantidad;


    public CompraProducto(@NonNull String nombre, String descripcion, String imagen, @NonNull Double precioMetro, @NonNull Double precioPlazaVea, @NonNull Double precioPlazaTottus, @NonNull Integer best, @NonNull Integer cantidad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.precioMetro = precioMetro;
        this.precioPlazaVea = precioPlazaVea;
        this.precioPlazaTottus = precioPlazaTottus;
        this.best = best;
        this.cantidad = cantidad;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public long getCarrito() {
        return carrito;
    }

    public void setCarrito(@NonNull long carrito) {
        this.carrito = carrito;
    }

    @NonNull
    public String getNombre() {
        return nombre;
    }

    public void setNombre(@NonNull String nombre) {
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

    @NonNull
    public Double getPrecioMetro() {
        return precioMetro;
    }

    public void setPrecioMetro(@NonNull Double precioMetro) {
        this.precioMetro = precioMetro;
    }

    @NonNull
    public Double getPrecioPlazaVea() {
        return precioPlazaVea;
    }

    public void setPrecioPlazaVea(@NonNull Double precioPlazaVea) {
        this.precioPlazaVea = precioPlazaVea;
    }

    @NonNull
    public Double getPrecioPlazaTottus() {
        return precioPlazaTottus;
    }

    public void setPrecioPlazaTottus(@NonNull Double precioPlazaTottus) {
        this.precioPlazaTottus = precioPlazaTottus;
    }

    @NonNull
    public Integer getBest() {
        return best;
    }

    public void setBest(@NonNull Integer best) {
        this.best = best;
    }

    @NonNull
    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(@NonNull Integer cantidad) {
        this.cantidad = cantidad;
    }
}
