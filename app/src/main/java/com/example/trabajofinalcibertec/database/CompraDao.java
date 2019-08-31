package com.example.trabajofinalcibertec.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.trabajofinalcibertec.data.entities.Compra;

import java.util.List;

@Dao
public interface CompraDao {

    @Query("select * from compra where usuario = :usuario order by id DESC")
    List<Compra> getAll(String usuario);

    @Query("select * from compra where id = :id")
    Compra getCompra(long id);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(Compra compra);
}
