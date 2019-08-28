package com.example.trabajofinalcibertec.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


import com.example.trabajofinalcibertec.data.entities.Compra;
import com.example.trabajofinalcibertec.data.entities.CompraProducto;

@Database(entities = {Compra.class, CompraProducto.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract CompraDao compraDao();
    public abstract CompraProductoDao compraProductoDao();

    private static AppDatabase instance = null;
    public static AppDatabase getInstance(Context context) {

        if (instance == null) {
            instance
                    = Room.databaseBuilder(context, AppDatabase.class, "db")
                    .allowMainThreadQueries()
                    .build();
        }

        return instance;
    }
}
