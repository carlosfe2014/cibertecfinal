package com.example.trabajofinalcibertec.database;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.trabajofinalcibertec.data.entities.CompraProducto;

import java.util.List;

@Dao
public interface CompraProductoDao {
    @Query("select * from compraproducto")
    List<CompraProducto> getAll();
}
