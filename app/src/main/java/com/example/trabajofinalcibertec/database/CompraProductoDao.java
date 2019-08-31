package com.example.trabajofinalcibertec.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


import com.example.trabajofinalcibertec.data.entities.CompraProducto;

import java.util.List;

@Dao
public interface CompraProductoDao {
    @Query("select * from compraproducto where carrito = :id")
    List<CompraProducto> getProductos(long id);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(CompraProducto producto);
}
