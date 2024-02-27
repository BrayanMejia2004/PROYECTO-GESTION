package com.example.proyectogestion.BaseDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.proyectogestion.entidades.Docentes;

import java.util.ArrayList;

public class DbRegistroDocente extends DbGestion{
    Context context;

    public DbRegistroDocente(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertaDocente(int documento, String nombre, String apellido, String fecha, String profesion){

        long id = 0;

        try {
            DbGestion dbGestion = new DbGestion(context);
            SQLiteDatabase db = dbGestion.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("documento", documento);
            values.put("nombre", nombre);
            values.put("apellido", apellido);
            values.put("fecha", fecha);
            values.put("profesion", profesion);

            id = db.insert(TABLE_DOCENTE, null, values);

        }catch (Exception ex){
            ex.toString();
        }
        return id ;
    }
}
