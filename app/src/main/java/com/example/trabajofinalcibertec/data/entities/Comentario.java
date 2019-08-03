package com.example.trabajofinalcibertec.data.entities;

public class Comentario {
    private int id;
    private int idProducto;
    private String autor;
    private String mensaje;
    private String fecha;


    public Comentario(int id, int idProducto, String autor, String mensaje, String fecha) {
        this.id = id;
        this.idProducto = idProducto;
        this.autor = autor;
        this.mensaje = mensaje;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
