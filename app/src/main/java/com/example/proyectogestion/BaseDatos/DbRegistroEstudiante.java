package com.example.proyectogestion.BaseDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbRegistroEstudiante extends DbGestion{

    Context context;

    public DbRegistroEstudiante(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long instsertaEstudiante(int documento, String nombre, String apellido, String fecha, int telefono, String correo){

        long id = 0;

        try {
            DbGestion dbGestion = new DbGestion(context);
            SQLiteDatabase db = dbGestion.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("documento", documento);
            values.put("nombre", nombre);
            values.put("apellido", apellido);
            values.put("fecha", fecha);
            values.put("telefono", telefono);
            values.put("correo", correo);

            id = db.insert(TABLE_ESTUDIANTE, null, values);

        }catch (Exception ex){
            ex.toString();
        }
        return id ;
    }
}
